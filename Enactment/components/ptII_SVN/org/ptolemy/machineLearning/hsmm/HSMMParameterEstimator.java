/* Parameter Estimation for Explicit-Duration Hidden Markov Models.

Copyright (c) 1998-2015 The Regents of the University of California.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.

PT_COPYRIGHT_VERSION_2
COPYRIGHTENDKEY

 */
package org.ptolemy.machineLearning.hsmm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.ptolemy.machineLearning.hmm.ParameterEstimator;

import ptolemy.actor.TypedIOPort;
import ptolemy.data.ArrayToken;
import ptolemy.data.BooleanToken;
import ptolemy.data.DoubleMatrixToken;
import ptolemy.data.DoubleToken;
import ptolemy.data.IntToken;
import ptolemy.data.expr.Parameter;
import ptolemy.data.expr.SingletonParameter;
import ptolemy.data.type.ArrayType;
import ptolemy.data.type.BaseType;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.Workspace;

///////////////////////////////////////////////////////////////////
////ExpectationMaximization

/**
<p> This actor implements the Expectation-Maximization(EM) algorithm for
parameter estimation in a family of graphical stochastic models, known as
the Hidden Semi-Markov Model family.
<p> In addition to estimating the parameters of a hidden markov model,


 <p>
 <b>References</b>
 <p>[1]
 Jordan, Michael I., et al. <i>An introduction to variational methods for graphical
 models</i>, Springer Netherlands, 1998.
 <p>[2]
 Bilmes, Jeff A. <i>A gentle tutorial of the EM algorithm and its application
 to parameter estimation for Gaussian mixture and hidden Markov models.</i>
 International Computer Science Institute 4.510 (1998): 126.

@see org.ptolemy.machineLearning.hmm.ParameterEstimator


 @author Ilge Akkaya
 @version $Id: HSMMParameterEstimator.java 72874 2015-07-26 21:01:52Z cxh $
 @since Ptolemy II 10.0
 @Pt.ProposedRating Red (ilgea)
 @Pt.AcceptedRating
 */
public abstract class HSMMParameterEstimator extends ParameterEstimator {

    /** Construct an actor with the given container and name.
     *  @param container The container.
     *  @param name The name of this actor
     *  @exception IllegalActionException If the actor cannot be contained
     *   by the proposed container.
     *  @exception NameDuplicationException If the container already has an
     *   actor with this name.
     */
    public HSMMParameterEstimator(CompositeEntity container, String name)
            throws NameDuplicationException, IllegalActionException {
        super(container, name);
        clusterAssignments = new TypedIOPort(this, "clusterAssignments", false,
                true);
        clusterAssignments.setTypeEquals(new ArrayType(BaseType.DOUBLE));
        new SingletonParameter(clusterAssignments, "_hide")
        .setToken(BooleanToken.TRUE);

        maxStateDuration = new Parameter(this, "maxStateDuration");
        maxStateDuration.setTypeEquals(BaseType.INT);
        maxStateDuration.setExpression("100");
        _maxDuration = 100;

        priorDurationDistribution = new Parameter(this,"priorDurationDistribution");
        priorDurationDistribution.setExpression("repeat(maxStateDuration, 1.0/maxStateDuration)");
        priorDurationDistribution.setTypeEquals(new ArrayType(BaseType.DOUBLE));

        durationProbabilities = new Parameter(this, "durationProbabilities");
        durationProbabilities.setTypeEquals(BaseType.DOUBLE_MATRIX);

        durationEstimates = new TypedIOPort(this, "durationEstimates", false,
                true);
        durationEstimates.setTypeEquals(BaseType.DOUBLE_MATRIX);
        new SingletonParameter(durationEstimates, "_showName")
        .setToken(BooleanToken.TRUE);

        durationPriorEstimates = new TypedIOPort(this,
                "durationPriorEstimates", false, true);
        durationPriorEstimates.setTypeEquals(new ArrayType(BaseType.DOUBLE));
        new SingletonParameter(durationPriorEstimates, "_showName")
        .setToken(BooleanToken.TRUE);

        _initializeArrays();

    }

    @Override
    public void attributeChanged(Attribute attribute)
            throws IllegalActionException {
        if (attribute == maxStateDuration) {
            _maxDuration = ((IntToken) maxStateDuration.getToken()).intValue();
            DoubleMatrixToken m =((DoubleMatrixToken) durationProbabilities
                    .getToken());
            if (m==null) {
                _D0 = new double[_nStates][_maxDuration];
                for ( int i = 0 ; i < _maxDuration; i++) {
                    for (int  j=0; j < _nStates; j++) {
                        _D0[j][i] = 1.0/_maxDuration;
                    }
                }
            }
        } else if (attribute == durationProbabilities) {
            DoubleMatrixToken m =((DoubleMatrixToken) durationProbabilities
                    .getToken());
            if (m==null) {
                _D0 = new double[_nStates][_maxDuration];
                for ( int i = 0 ; i < _maxDuration; i++) {
                    for (int  j=0; j < _nStates; j++) {
                        _D0[j][i] = 1.0/_maxDuration;
                    }
                }
            } else {
                _D0 = m.doubleMatrix();
            }

        }  else if (attribute == priorDurationDistribution) {
            int nDurations = ((ArrayToken) priorDurationDistribution.getToken())
                    .length();
            _durationPriors = new double[nDurations];
            _dPriors0 = new double[nDurations];
            for (int j = 0; j < nDurations; j++) {
                _durationPriors[j] = ((DoubleToken) ((ArrayToken) priorDurationDistribution
                        .getToken()).getElement(j)).doubleValue();
                _dPriors0[j] = _durationPriors[j];
            }
        } else {
            super.attributeChanged(attribute);
        }
    }

    ///////////////////////////////////////////////////////////////////
    ////                         public variables                  ////

    /** The user-provided initial guess on the prior probability distribution.*/
    public Parameter priorDurationDistribution;

    /** The user-provided initial guess on the prior probability distribution.*/
    public Parameter durationProbabilities;

    /** DurationEstimates. */
    public TypedIOPort durationEstimates;

    /** Duration Prior estimates.
     */
    public TypedIOPort durationPriorEstimates;

    /** Hidden-State Assignments. */
    public TypedIOPort clusterAssignments;

    /** Maximum Duration. */
    public Parameter maxStateDuration;


    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////
    @Override
    public Object clone(Workspace workspace) throws CloneNotSupportedException {
        HSMMParameterEstimator newObject = (HSMMParameterEstimator) super
                .clone(workspace);
        newObject._D0 = new double[_nStates][_maxDuration];
        newObject._durationPriors = new double[_maxDuration];
        newObject._priors = new double[_nStates];
        newObject._dPriors0 = null;
        newObject._D = null;
        newObject._likelihoodHistory =null;
        return newObject;
    }

    @Override
    public void preinitialize() throws IllegalActionException {
        super.preinitialize();

        for (int i = 0; i < _maxDuration; i++) {
            ArrayToken dT = (ArrayToken) priorDurationDistribution.getToken();
            _durationPriors[i] = ((DoubleToken) (dT).getElement(i))
                    .doubleValue();
        }
        _maxDuration = ((IntToken) maxStateDuration.getToken()).intValue();
        DoubleMatrixToken m =((DoubleMatrixToken) durationProbabilities
                .getToken());
        if (m==null) {
            _D0 = new double[_nStates][_maxDuration];
            for ( int i = 0 ; i < _maxDuration; i++) {
                for (int  j=0; j < _nStates; j++) {
                    _D0[j][i] = 1.0/_maxDuration;
                }
            }
        }
    }

    @Override
    public void fire() throws IllegalActionException {


        super.fire();
        _durationPriors = new double[_maxDuration];
        for (int i = 0; i < _maxDuration; i++) {
            _durationPriors[i] = ((DoubleToken) ((ArrayToken) priorDurationDistribution
                    .getToken()).getElement(i)).doubleValue();
        }

    }

    @Override
    protected boolean _EMParameterEstimation() {

        boolean success = false;
        _likelihood = -Double.MAX_VALUE;
        _initializeEMParameters();

        for (int iterations = 0; iterations < _nIterations; iterations++) {

            _iterateEM();
            success = _checkForConvergence(iterations);
            // randomization not allowed and convergence was not achieved
            if (!_randomize && !success) {
                break;
            }
            _updateEstimates();
            //record likelihood
            if (likelihood != likelihood) {
                break;
            } else {
                _likelihoodHistory.add(likelihood);
                if (Math.abs(_likelihood - likelihood) < _likelihoodThreshold) {
                    break;
                }
            }
            // check for non-increasing likelihood or NaN
            //            if (iterations > 5) {
            //                if ((likelihood - _likelihood) < _likelihoodThreshold || likelihood!=likelihood) {
            //                    break;
            //                }
            //            }

            _likelihood = likelihood;
        }

        return success;
    }

    @Override
    protected abstract double emissionProbability(double[] y, int hiddenState);

    /**
     * Return the duration probability of duration y at hidden state.
     * @param y The duration index
     * @param hiddenState The hidden state index
     * @return p(y|hiddenState)
     */
    protected abstract double durationProbability(int y, int hiddenState);

    @Override
    protected void _initializeArrays() throws IllegalActionException {
        _likelihood = -Double.MAX_VALUE / 10.0;
        _nStates = ((IntToken) nStates.getToken()).intValue();
        _transitionMatrix = new double[_nStates][_nStates];
        _A0 = new double[_nStates][_nStates];
        _priors = new double[_nStates];
        _likelihoodHistory = new LinkedList<Double>();
    }

    @Override
    protected abstract void _initializeEMParameters();

    @Override
    protected abstract void _iterateEM();

    @Override
    protected abstract boolean _checkForConvergence(int i);

    @Override
    protected abstract void _updateEstimates();

    /** Java implementation of the Baum-Welch algorithm (Alpha-Beta Recursion) for parameter estimation
     * and cluster assignment. This method uses normalized alpha values for computing the conditional
     * probabilities of input sequences, to ensure numerical stability. Set nCategories to zero for
     * continuous distribution types
     * @param y Observation array
     * @param A transition probability matrix
     * @param prior State priors
     * @param nCategories Number of categories in multinomial distribution
     * @return a Map of parameter estimates
     */
    protected HashMap HSMMAlphaBetaRecursion(double[][] y, double[][] A,
            double[] prior, int[] nCategories) {

        boolean multinomial = nCategories != null;

        int nStates = _nStates;
        int nObservations = y.length;
        int obsDimension = _obsDimension;

        double[][][] alphas = new double[nObservations][nStates][_maxDuration];
        double[][][] betas = new double[nObservations][nStates][_maxDuration];
        double[][] gamma = new double[nObservations][nStates];
        double[][][] smoothedAlpha = new double[nObservations][nStates][_maxDuration];

        double[][] A_hat = new double[nStates][nStates];
        double[][] mu_hat = new double[nStates][obsDimension];
        double[][][] s_hat = new double[nStates][obsDimension][obsDimension];
        double[] pi_hat = new double[nStates];

        double[][] bStar = new double[nObservations][nStates];

        double[][] epsilon = new double[nObservations][nStates];
        double[][] S = new double[nObservations][nStates];

        double[][] epsilonStar = new double[nObservations][nStates];
        double[][] sStar = new double[nObservations][nStates];

        double[][] smoothedGamma = new double[nObservations][nStates];
        double[][] D_hat = new double[nStates][_maxDuration];

        // for categorical distributions. will have nStates entries. Each entry j will be
        // a vector of length nCategories[j], j>0, j\in Z.
        double[][] eta_hat = new double[nStates][_etaDimension];

        double r = 0;
        double logLikelihood = 0.0;

        double[] alphaNormalizers = new double[nObservations];
        // INITIALIZATION



        // initialize alphas
        for (int m = 0; m < nStates; m++) {
            for (int d = 0; d < _maxDuration; d++) {
                alphas[0][m][d] = prior[m] * durationProbability(d, m);
                alphaNormalizers[0] += alphas[0][m][d];
            }
        }

        for (int m = 0; m < nStates; m++) {
            for (int d = 0; d < _maxDuration; d++) {
                alphas[0][m][d] /= alphaNormalizers[0];
            }
        }

        for (int m = 0; m < nStates; m++) {
            for (int d = 0; d < _maxDuration; d++) {
                gamma[0][m] += alphas[0][m][d];
            }
        }

        // initialize r
        for (int ii = 0; ii < nStates; ii++) {
            r += gamma[0][ii] * emissionProbability(y[0], ii);
        }
        //initialize bStar
        for (int m = 0; m < nStates; m++) {
            bStar[0][m] = emissionProbability(y[0], m) / r;
        }
        //initialize E
        for (int m = 0; m < nStates; m++) {
            epsilon[0][m] = alphas[0][m][0] * bStar[0][m];
        }
        // initialize S
        for (int m = 0; m < nStates; m++) {
            for (int n = 0; n < nStates; n++) {
                S[0][m] += epsilon[0][n] * A[n][m];
            }
        }
        // initialize likelihood
        logLikelihood = Math.log(r);

        // FORWARD RECURSION
        for (int t = 1; t < y.length; t++) {
            for (int m = 0; m < nStates; m++) {
                for (int d = 0; d < _maxDuration - 1; d++) {
                    // compute S, bStar
                    alphas[t][m][d] = S[t - 1][m] * durationProbability(d, m)
                            + bStar[t - 1][m] * alphas[t - 1][m][d + 1];
                    alphaNormalizers[t] += alphas[t][m][d];
                }
            }
            for (int m = 0; m < nStates; m++) {
                for (int d = 0; d < _maxDuration - 1; d++) {
                    alphas[t][m][d] /= alphaNormalizers[t];
                }
            }
            for (int m = 0; m < nStates; m++) {
                //compute gammas
                gamma[t][m] = 0;
                for (int d = 0; d < _maxDuration; d++) {
                    gamma[t][m] += alphas[t][m][d];
                }
            }

            r = 0;
            for (int ii = 0; ii < nStates; ii++) {
                r += gamma[t][ii] * emissionProbability(y[t], ii);
            }
            for (int m = 0; m < nStates; m++) {
                bStar[t][m] = emissionProbability(y[t], m) / r;
            }
            //Compute epsilon
            for (int m = 0; m < nStates; m++) {
                epsilon[t][m] = alphas[t][m][0] * bStar[t][m];
            }
            for (int m = 0; m < nStates; m++) {
                S[t][m] = 0;
                for (int n = 0; n < nStates; n++) {
                    S[t][m] += epsilon[t][n] * A[n][m];
                }
            }
            logLikelihood += Math.log(r);
        }


        // Backward INITIALIZATION
        // initialize beta
        int endIndex = y.length - 1;
        for (int m = 0; m < nStates; m++) {
            for (int d = 0; d < _maxDuration; d++) {
                betas[endIndex][m][d] = bStar[endIndex][m];
            }
        }
        //        for (int m = 0; m < nStates; m++) {
        //            for (int d=0; d< _maxDuration; d++) {
        //                betas[endIndex][m][d] /= betaNormalizers[endIndex];
        //            }
        //        }
        for (int m = 0; m < nStates; m++) {
            for (int d = 0; d < _maxDuration; d++) {
                epsilonStar[endIndex][m] += durationProbability(d, m)
                        * betas[endIndex][m][d];
            }
        }
        for (int m = 0; m < nStates; m++) {
            for (int n = 0; n < nStates; n++) {
                sStar[endIndex][m] += A[m][n] * epsilonStar[endIndex][n];
            }
        }

        for (int m = 0; m < nStates; m++) {
            for (int d = 0; d < _maxDuration; d++) {
                smoothedAlpha[endIndex][m][d] = alphas[endIndex][m][d]
                        * betas[endIndex][m][d];
                smoothedGamma[endIndex][m] += smoothedAlpha[endIndex][m][d];
            }
            smoothedGamma[endIndex][m] *= bStar[endIndex][m];
        }

        // BACKWARD RECURSION
        for (int t = y.length - 2; t >= 0; t--) {
            for (int m = 0; m < nStates; m++) {
                for (int d = 0; d < _maxDuration; d++) {
                    if (d == 0) {
                        betas[t][m][d] = sStar[t + 1][m] * bStar[t][m];
                    } else {
                        betas[t][m][d] = betas[t + 1][m][d - 1] * bStar[t][m];
                    }
                }
            }

            for (int m = 0; m < nStates; m++) {
                for (int d = 0; d < _maxDuration; d++) {
                    epsilonStar[t][m] += durationProbability(d, m)
                            * betas[t][m][d];
                }
            }
            for (int m = 0; m < nStates; m++) {
                for (int n = 0; n < nStates; n++) {
                    sStar[t][m] += A[m][n] * epsilonStar[t][n];
                }
            }
            for (int m = 0; m < nStates; m++) {
                smoothedGamma[t][m] += smoothedGamma[t + 1][m] + epsilon[t][m]
                        * sStar[t + 1][m] - S[t][m] * epsilonStar[t + 1][m];
                // numerical correction
                if (smoothedGamma[t][m] < 0) {
                    smoothedGamma[t][m] = 0;
                }
            }

            // transition probability matrix estimate
            if (t > 0) {
                for (int m = 0; m < nStates; m++) {
                    for (int n = 0; n < nStates; n++) {
                        A_hat[m][n] += epsilon[t - 1][m] * epsilonStar[t][n];
                    }
                    for (int d = 0; d < _maxDuration; d++) {
                        D_hat[m][d] += S[t - 1][m] * betas[t][m][d];
                    }
                }
            }
        }

        for (int m = 0; m < nStates; m++) {
            for (int n = 0; n < nStates; n++) {
                A_hat[m][n] *= A[m][n];
            }
            for (int d = 0; d < _maxDuration; d++) {
                D_hat[m][d] *= durationProbability(d, m);
            }
        }

        // normalize A
        double[] rowsum = new double[nStates];
        double[] obsSums = new double[nStates];
        for (int m = 0; m < nStates; m++) {
            rowsum[m] = 0;
            for (int n = 0; n < nStates; n++) {
                rowsum[m] += A_hat[m][n];
            }
            for (int j = 0; j < nStates; j++) {
                A_hat[m][j] /= rowsum[m];
            }
            for (int d = 0; d < _maxDuration; d++) {
                obsSums[m] += D_hat[m][d];
            }
            for (int d = 0; d < _maxDuration; d++) {
                D_hat[m][d] /= obsSums[m];
            }
        }

        double[] gammasum = new double[nStates];

        // estimate pi
        double piSum = 0;
        for (int m = 0; m < nStates; m++) {
            pi_hat[m] = smoothedGamma[0][m];
            piSum += pi_hat[m];
        }
        for (int m = 0; m < nStates; m++) {
            pi_hat[m] /= piSum;
        }

        for (int j = 0; j < nStates; j++) {
            for (int a = 0 ; a < obsDimension; a++) {
                gammasum[j] = 0.0;
                for (int t = 0; t < y.length; t++) {
                    mu_hat[j][a] += smoothedGamma[t][j] * y[t][a];
                    gammasum[j] += smoothedGamma[t][j];
                }
            }
            for (int a = 0 ; a < obsDimension; a++) {
                mu_hat[j][a] = mu_hat[j][a] / gammasum[j];
            }

            for (int t = 0; t < y.length; t++) {
                for (int a = 0 ; a < obsDimension; a++) {
                    for (int b = 0 ; b < obsDimension; b++) {
                        s_hat[j][a][b] += (smoothedGamma[t][j] * (y[t][a] - mu_hat[j][a])*(y[t][b] - mu_hat[j][b]));
                    }
                }
            }
            for (int a = 0 ; a < obsDimension; a++) {
                for (int b = 0 ; b < obsDimension; b++) {
                    if (gammasum[j] != 0.0) {
                        s_hat[j][a][b] = (s_hat[j][a][b] / gammasum[j]);
                    } else {
                        s_hat[j][a][b] = s_hat[j][a][b];
                    }
                }
            }

        }


        if (multinomial) {
            for (int t= 0; t< y.length; t++) {
                for (int m = 0; m < nStates; m++) {
                    int count = 0;
                    for ( int j = 0; j < obsDimension; j++) {
                        for (int k = 0; k < nCategories[j]; k++ ) {
                            eta_hat[m][count++] += smoothedGamma[t][m] * ( y[t][j] == k ? 1:0);
                        }
                    }
                }
            }

            for (int m = 0; m < nStates; m++) {
                int count = 0;
                for (int z = 0; z < obsDimension; z++) {
                    for (int d = 0 ; d < nCategories[z]; d++) {
                        eta_hat[m][count++] /= gammasum[m]; //normalize for gammas
                    }
                }
            }
        }
        // labels for the multinomial setting

        // do hidden state sequence estimation to compute the log-likelihood, given the current
        // parameter estimates
        int[] clusterAssignments = new int[y.length];
        for (int t = 0; t < y.length; t++) {
            int maxState = 0;
            for (int j = 1; j < nStates; j++) {
                if (smoothedGamma[t][j] > smoothedGamma[t][maxState]) {
                    maxState = j;
                }
            }
            clusterAssignments[t] = maxState;
        }
        // the duration priors will be computed by \pi * D_hat
        double[] durationPriorEstimates = new double[_maxDuration];
        double normalizer = 0;
        for (int i = 0; i < _maxDuration; i++) {
            for (int j = 0; j < _nStates; j++) {
                durationPriorEstimates[i] += pi_hat[j] * D_hat[j][i];
            }
            normalizer += durationPriorEstimates[i];
        }
        // make sure the priors sum to one. avoid numerical errors
        for (int i = 0; i < _maxDuration; i++) {
            durationPriorEstimates[i] /= normalizer;
        }
        HashMap estimates = new HashMap();

        estimates.put("mu_hat", mu_hat);
        estimates.put("s_hat", s_hat);
        estimates.put("gamma", smoothedGamma); //this will not be needed for most of the distributions.
        estimates.put("A_hat", A_hat);
        estimates.put("pi_hat", pi_hat);
        estimates.put("likelihood", logLikelihood);
        estimates.put("D_hat", D_hat);
        estimates.put("pi_d_hat", durationPriorEstimates);
        estimates.put("clusterAssignments", clusterAssignments);
        if (multinomial) {
            estimates.put("eta_hat",eta_hat);
        }
        return estimates;
    }

    /** Duration priors - an nStates-by-nDurations matrix. */
    protected double[] _durationPriors;

    /** new duration distribution. */
    protected double[][] D_new = null;
    /** initial duration distribution. */
    protected double[][] _D0 = null;
    /** current duration distribution. */
    protected double[][] _D = null;

    /** The user defined duration priors. Note that while _durationPriors
     * gets updated on Baum-Welch Iterations, this array stays set at the
     * initial user setting such that if the algorithm fails to converge,
     * the value of _durationPriors is rolled back to _dPriors0. */
    protected double[] _dPriors0 = null;
    /** maximum duration ( in time steps). */
    protected int _maxDuration;

    /** Total number of categories among all observation dimensions. */
    protected int _etaDimension;

    /** Likelihood history over iterations. Used for debugging at the moment. */
    protected List<Double> _likelihoodHistory;
}
