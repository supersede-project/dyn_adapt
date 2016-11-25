/* Parameter Estimation for Graphical Models.

Copyright (c) 1998-2014 The Regents of the University of California.
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
package org.ptolemy.machineLearning.hmmAOM;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ptolemy.actor.TypedIOPort;
import ptolemy.data.ArrayToken;
import ptolemy.data.DoubleMatrixToken;
import ptolemy.data.DoubleToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
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
<p>This actor implements a parameter estimator for Hidden Markov Models with Gaussian
Emissions. The base class ParameterEstimator performs the parameter estimation and
the HMMGaussianEstimator class contains density-specific methods for Gaussian emission
calculations and produces the relevant estimates at its output ports.</p>
<p>
The output ports for a Gaussian HMM model are the <i>mean</i> and the <i>standardDeviation</i>
vectors of the possible hidden states in addition to the HMM parameters independent
from the emission density: <i>transitionMatrix</i> .
T
he <i>mean</i>  is a double array output containing the mean estimates and
<i>sigma</i> is a double array output containing standard deviation estimates of
each mixture component. If the <i>modelType</i> is HMM, then an additional output,
<i>transitionMatrix</i> is provided, which is an estimate of the transition matrix
governing the Markovian process representing the hidden state evolution.
If the <i>modelType</i> is MM, this port outputs a double array with the prior
probability estimates of the mixture components.
</p>
<p>
The user-defined parameters are initial guesses for the model parameters, given by
<i>m0</i>, the mean vector guess, <i>s0</i>, the standard deviation vector guess,
<i>prior</i>, the prior state distribution guess, <i>A0</i>, the transition
matrix guess ( only for HMM). <i>iterations</i> is the number of EM iterations
allowed until convergence.
If, during iteration, the conditional log-likelihood of the observed
sequence given the parameter estimates converges to a value within <i>likelihoodThreshold</i>,
the parameter estimation stops iterating and delivers the parameter estimates.

 @author Ilge Akkaya
 @version $Id: HMMGaussianEstimator.java 71121 2014-12-30 15:50:43Z cxh $
 @since Ptolemy II 10.0
 @Pt.ProposedRating Red (ilgea)
 @Pt.AcceptedRating
 */
public class HMMGaussianEstimator extends ParameterEstimator {
    /** Construct an actor with the given container and name.
     *  @param container The container.
     *  @param name The name of this actor
     *  @exception IllegalActionException If the actor cannot be contained
     *   by the proposed container.
     *  @exception NameDuplicationException If the container already has an
     *   actor with this name.
     */
    public HMMGaussianEstimator(CompositeEntity container, String name)
            throws NameDuplicationException, IllegalActionException {
        super(container, name);

        mean = new TypedIOPort(this, "mean", false, true);
        mean.setTypeEquals(new ArrayType(BaseType.DOUBLE));

        standardDeviation = new TypedIOPort(this, "standardDeviation", false,
                true);
        standardDeviation.setTypeEquals(new ArrayType(BaseType.DOUBLE));

        meanVectorGuess = new Parameter(this, "meanVectorGuess");
        meanVectorGuess.setExpression("{0.0, 4.0}");
        meanVectorGuess.setTypeEquals(new ArrayType(BaseType.DOUBLE));

        standardDeviationGuess = new Parameter(this, "standardDeviationGuess");
        standardDeviationGuess.setExpression("{1.0, 1.0}");
        standardDeviationGuess.setTypeEquals(new ArrayType(BaseType.DOUBLE));

    }

    @Override
    public void attributeChanged(Attribute attribute)
            throws IllegalActionException {
        if (attribute == meanVectorGuess) {
            int nS = ((ArrayToken) meanVectorGuess.getToken()).length();
            _mu0 = new double[nS];
            for (int i = 0; i < nS; i++) {
                _mu0[i] = ((DoubleToken) ((ArrayToken) meanVectorGuess
                        .getToken()).getElement(i)).doubleValue();
            }
        } else if (attribute == standardDeviationGuess) {
            int nS = ((ArrayToken) standardDeviationGuess.getToken()).length();
            _sigma0 = new double[nS];
            for (int i = 0; i < nS; i++) {
                _sigma0[i] = ((DoubleToken) ((ArrayToken) standardDeviationGuess
                        .getToken()).getElement(i)).doubleValue();
            }
        } else {
            super.attributeChanged(attribute);
        }
    }

    ///////////////////////////////////////////////////////////////////
    ////                         public variables                  ////

    public TypedIOPort mean;

    public TypedIOPort standardDeviation;

    public Parameter meanVectorGuess;

    public Parameter standardDeviationGuess;

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    @Override
    public Object clone(Workspace workspace) throws CloneNotSupportedException {
        HMMGaussianEstimator newObject = (HMMGaussianEstimator) super
                .clone(workspace);
        newObject._sigma0 = new double[_nStates];
        newObject._mu0 = new double[_nStates];
        return newObject;
    }

    @Override
    public void fire() throws IllegalActionException {
        super.fire();

        if ((_nStates != _sigma0.length)
                || (_nStates != _transitionMatrix.length)
                || (_nStates != _priors.length) || (_nStates != _mu0.length)) {
            throw new IllegalActionException(this,
                    "Parameter guess vectors must have equal lengths.");
        }

        Iterator a = (_observedTokens.keySet()).iterator();
        String rec = (String) a.next();
        List tokenS = _observedTokens.get(rec);
        if (tokenS.size() >= _batchSize) {
            _observations = new double[tokenS.size()];
            for (int i = 0; i < _observations.length; i++) {
                _observations[i] = (Double) tokenS.get(i);
            }
            _observedTokens.put(rec.toString(), new LinkedList<Double>()); // clear list

            _EMParameterEstimation();
            Token[] mTokens = new Token[_nStates];
            Token[] sTokens = new Token[_nStates];
            Token[] pTokens = new Token[_nStates];

            for (int i = 0; i < _nStates; i++) {
                mTokens[i] = new DoubleToken(m_new[i]);
                sTokens[i] = new DoubleToken(s_new[i]);
                pTokens[i] = new DoubleToken(prior_new[i]);
            }
            mean.send(0, new ArrayToken(mTokens));
            standardDeviation.send(0, new ArrayToken(sTokens));
            transitionMatrix.send(0, new DoubleMatrixToken(A_new));
            priorEstimates.send(0, new ArrayToken(pTokens));
            // broadcast best-effort parameter estimates
        }
    }

    @Override
    protected double emissionProbability(double y, int hiddenState) {

        double s = _sigma[hiddenState];
        double m = _mu[hiddenState];

        return 1.0 / (Math.sqrt(2 * Math.PI) * s)
                * Math.exp(-0.5 * Math.pow((y - m) / s, 2));
    }

    @Override
    protected boolean _checkForConvergence(int iterations) {

        if ((m_new[0] != m_new[0]) || (s_new[0] != s_new[0])
                || (A_new[0] != A_new[0]) || (prior_new[0] != prior_new[0])) {
            // if no convergence in 10 iterations, issue warning message.
            if ((iterations >= _nIterations - 1)) {
                // return the guess parameters
                m_new = _mu0;
                s_new = _sigma0;
                A_new = _A0;
                prior_new = _priors;
                System.out
                .println("Expectation Maximization failed to converge");
                return false;
            } else if (_randomize) {
                // randomize means
                double minO = _observations[0];
                double maxO = _observations[0];
                for (int t = 0; t < _observations.length; t++) {
                    if (_observations[t] < minO) {
                        minO = _observations[t];
                    }
                    if (_observations[t] > maxO) {
                        maxO = _observations[t];
                    }
                }
                double L = maxO - minO;
                // make new random guess
                for (int i = 0; i < _nStates; i++) {
                    m_new[i] = L / _nStates * Math.random() + L * i / _nStates
                            + minO;
                    s_new[i] = Math.abs((maxO - minO) * Math.random())
                            / _nStates;
                    for (int j = 0; j < _nStates; j++) {
                        //A_new[i][j] = 1.0/nStates;
                    }
                }
                A_new = _A0;
                // sort arrays
                Arrays.sort(m_new);
                prior_new = _priors;
            }
        }
        return true;
    }

    @Override
    protected void _initializeEMParameters() {

        // set the initial values of parameters
        _sigma = _sigma0;
        _mu = _mu0;
        _transitionMatrix = _A0;
        _priorIn = _priors;

        A_new = new double[_nStates][_nStates];
        m_new = new double[_nStates];
        s_new = new double[_nStates];
        prior_new = new double[_nStates];
    }

    @Override
    protected void _iterateEM() {

        newEstimates = HMMAlphaBetaRecursion(_observations, _transitionMatrix,
                _priorIn, 0);
        m_new = (double[]) newEstimates.get("mu_hat");
        s_new = (double[]) newEstimates.get("s_hat");
        A_new = (double[][]) newEstimates.get("A_hat");
        prior_new = (double[]) newEstimates.get("pi_hat");
        likelihood = (Double) (newEstimates.get("likelihood"));
    }

    @Override
    protected void _updateEstimates() {
        _transitionMatrix = A_new;
        _sigma = s_new;
        _mu = m_new;
        _priorIn = _priors; // set to the original priors
    }

    private double[] _mu;
    private double[] _mu0;
    private double[] _sigma;
    private double[] _sigma0;

    // EM Specific Parameters
    private double[][] A_new;
    private double[] m_new;
    private double[] s_new;
    private double[] prior_new;

}
