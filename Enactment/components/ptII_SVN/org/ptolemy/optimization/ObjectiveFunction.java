/*
 Copyright (c) 2015 The Regents of the University of California.
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

package org.ptolemy.optimization;

import ptolemy.math.DoubleMatrixMath;

/**
 * The class which defines the objective function and constraint functions.
 * In the Composite Optimizer actor, this class is declared and method "calcFunction" is implemented.
 * BarrierMethod calls method "calcFuncInternal" during optimization.
 *
@author Shuhei Emoto
@version $Id: ObjectiveFunction.java 72854 2015-07-26 14:27:14Z cxh $
@since Ptolemy II 11.0
@Pt.ProposedRating Red (shuhei)
@Pt.AcceptedRating
 */
abstract class ObjectiveFunction {
    /**
     * Constructor of ObjectiveFunction.
     * In the constructor, double arrays for fi_results, gradients,
     * and hessians are allocated.
     */
    public ObjectiveFunction(int dimensionX, int numOfConstraints) {
        fiResults = new double[numOfConstraints];
        f0Gradient = new double[dimensionX];
        _f0GradientPrevious = new double[dimensionX];
        fiGradients = new double[numOfConstraints][dimensionX];
        _fiGradientsPrevious = new double[numOfConstraints][dimensionX];
        f0Hessian = new double[dimensionX][dimensionX];
        fiHessians = new double[numOfConstraints][dimensionX][dimensionX];
        currentX = new double[dimensionX];
        _previousX = new double[dimensionX];
        _fiRelax = new double[numOfConstraints];
        iterationCounter = 0;
        stopRequested = false;
        quasiNewtonMethod = true;

        for (int i=0; i<dimensionX; i++) {
            currentX[i] = 0.0;
        }
        for (int i=0; i<dimensionX; i++) {
            f0Hessian[i][i] = 1;
        }

        for (int i=0; i<numOfConstraints; i++) {
            for (int it=0; it<dimensionX; it++) {
                fiHessians[i][it][it] = 1;
            }
        }
    }


    /**
     * Objective function and constraint functions.
     * In this function, all results(f0_result, fi_results)
     * and gradients(f0_gradient, fi_gradients) must be updated.
     * @param x : input variables
     * @return If calculation was terminated by user input, return "false".
     */
    abstract public boolean calcFunction(double[] x);

    /**
     * Objective function called by a solver.
     * @param x : input variables
     */
    public void calcFuncInternal(double[] x) {
        if (stopRequested) return;
        for (int i=0; i<fiGradients.length; i++) {
            for (int it=0; it<fiGradients[i].length; it++) {
                _fiGradientsPrevious[i][it] = fiGradients[i][it];
            }
        }
        for (int i=0; i<f0Gradient.length; i++) {
            _f0GradientPrevious[i] = f0Gradient[i];
            _previousX[i] = currentX[i];
            currentX[i] = x[i];
        }

        if (!calcFunction(x)) stopRequested = true;
        for (int i=0; i<fiResults.length; i++) {
            fiResults[i] += _fiRelax[i];
        }

        if (iterationCounter==0) {
            //Copy all previous values
            for (int i=0; i<fiGradients.length; i++) {
                for (int it=0; it<fiGradients[i].length; it++) {
                    _fiGradientsPrevious[i][it] = fiGradients[i][it];
                }
            }
            for (int i=0; i<f0Gradient.length; i++) {
                _f0GradientPrevious[i] = f0Gradient[i];
                _previousX[i] = currentX[i];
            }
        }
        if (quasiNewtonMethod) updateHessian();
        iterationCounter++;
    }

    /**
     * check feasibility of current point
     * @return : true if all of constraints are negative
     */
    public boolean checkFeasibility() {
        boolean areAllNegative = true;
        for (int j = 0; areAllNegative && j < fiResults.length; j++) {
            areAllNegative = (fiResults[j] < 0.0);
        }
        return areAllNegative;
    }

    /**
     * get current point
     * @return : current point X
     */
    public double[] getCurrentPoint() {
        double[] ret = new double[currentX.length];
        for (int i=0; i<ret.length; i++) {
            ret[i] = currentX[i];
        }
        return ret;
    }

    /*
     * Public Variables
     */
    public double f0Result;            //Results of objective function.
    public double[] fiResults;   //Results of constraint functions. An array length is m, the number of constraints.
    public double[] f0Gradient;        //Gradient of result of f0. An array length is n, the number of variables of objective function.
    public double[][] fiGradients;     //Gradients of constraints. The number of col is n.
    public double[][] f0Hessian;       //Hessian of f0. Lengths of array is [n][n]
    public double[][][] fiHessians;    //Hessians of constraints. Lengths of array is [m][n][n].
    public double[] currentX;
    public int iterationCounter;
    public boolean stopRequested;
    public boolean quasiNewtonMethod;


    /*
     * Protected method
     */
    /**
     * Clear Matrix
     * @param matrix : matrix which is to be zero-matrix.
     */
    protected void clearMatrix(double[][] matrix) {
        for (int row=0; row<matrix.length; row++) {
            for (int col=0; col<matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
    }

    /*
     * Private Methods
     */
    private void printVector(double[] array, String label) {
        System.out.print(label);
        for (int col=0; col<array.length; col++) {
            System.out.print(array[col]+ "\t");
        }
        System.out.println();
    }
    /**
     * Update estimates of Hessian.
     * This function is based on quasi-Newton method BFGS.
     */
    private boolean updateHessian() {
        //
        //Hessian of f0
        double[] dg0 = new double[f0Gradient.length];
        for (int it=0; it<dg0.length; it++) {
            dg0[it] = f0Gradient[it] - _f0GradientPrevious[it];
        }
        double[] dx = new double[_previousX.length];
        for (int it=0; it<dx.length; it++) {
            dx[it] = currentX[it] - _previousX[it];
        }
        boolean is_hessian_calculated = updateHessianByBFGS(f0Hessian, dg0, dx);
        if (!is_hessian_calculated) {
            //TODO: We should store previous values and update when dx and dg have grown lager.
        }

        //Hessian of fi
        for (int i=0; i<fiHessians.length; i++) {
            double[] dgi = new double[fiGradients[i].length];
            for (int it=0; it<dgi.length; it++) {
                dgi[it] = fiGradients[i][it] - _fiGradientsPrevious[i][it];
            }
            is_hessian_calculated = is_hessian_calculated & updateHessianByBFGS(fiHessians[i], dgi, dx);
            if (!is_hessian_calculated) {
                //TODO: We should store previous values and update when dx and dg have grown lager.
            }
        }
        return is_hessian_calculated; //if at least one of the hessians are not calculated, return false.
    }

    /**
     * implementation of quasi-newton method(BFGS)
     * @param est_hessian_current : estimated hessian matrix which is updated in this function.
     * @param dg : change of gradient
     * @param dx : change of searching point X
     * @return : if updating finished successfully, return ture.
     */
    private boolean updateHessianByBFGS(double[][] est_hessian_current, double[] dg, double[] dx) {
        // Hk+1 = Hk + y*yT/(yT*s) - Hk*s(Hk*s)T/(sT*Hk*s)
        //   y = gk+1 - gk
        //   s = xk+1 - xk
        double dgTdx = 0;
        for (int i=0; i<dx.length; i++) {
            dgTdx += dx[i]*dg[i];
        }
        if (dgTdx<-1.0E-15) {
            //If hessian is not positive-definite, hessian must converge to zero-matrix.
            for (int row=0; row<est_hessian_current.length; row++) {
                for (int col=0; col<est_hessian_current[0].length; col++) {
                    est_hessian_current[row][col] *= 0.1;
                }
            }
        }
        if (dgTdx<1.0E-10) {
            return false;
        }
        double[][] dgdgT_dgTdx= new double[dx.length][dx.length];
        for (int i=0; i<dgdgT_dgTdx.length; i++) {
            for (int j=0; j<dgdgT_dgTdx[0].length; j++) {
                dgdgT_dgTdx[i][j] = dg[i]*dg[j]/dgTdx;
            }
        }
        double[] Hdx = DoubleMatrixMath.multiply(dx, est_hessian_current);
        double dxTHdx = 0;
        for (int i=0; i<dx.length; i++) {
            dxTHdx += dx[i]*Hdx[i];
        }
        if (Math.abs(dxTHdx)<1.0E-10) return false;
        double[][] HdxHdxT_dxTHdx = new double[dx.length][dx.length];
        for (int i=0; i<HdxHdxT_dxTHdx.length; i++) {
            for (int j=0; j<HdxHdxT_dxTHdx[0].length; j++) {
                HdxHdxT_dxTHdx[i][j] = Hdx[i]*Hdx[j]/dxTHdx;
            }
        }
        for (int i=0; i<est_hessian_current.length; i++) {
            for (int j=0; j<est_hessian_current[0].length; j++) {
                est_hessian_current[i][j] = est_hessian_current[i][j] + dgdgT_dgTdx[i][j] - HdxHdxT_dxTHdx[i][j];
            }
        }
        return true;
    }

    private double[] _f0GradientPrevious; //The previous value of f0Gradient
    private double[][] _fiGradientsPrevious; //The previous value of fiGradients
    private double[] _previousX;        //The previous value of currentX
    private double[] _fiRelax; //If there is no feasible point, constraints are relaxed using this value. Default value is 0.
}

/**
 * The objective function class which is used in Phase 1 of the interior point method.
 * In the interior point method, a starting point X must be a feasible point that satisfies all
 * constraints. To find the feasible point, the interior point method calculate Phase 1
 * using this class.
 * @author shuhei emoto
 */
class ObjectiveFunctionForPhaseI extends ObjectiveFunction{
    public ObjectiveFunctionForPhaseI(ObjectiveFunction a_source) {
        super(a_source.currentX.length+1, a_source.fiResults.length);
        _source = a_source;

        for (int i=0; i<_source.currentX.length; i++) {
            currentX[i] = _source.currentX[i];
        }
        currentX[currentX.length-1] = 0;
    }

    @Override
    public boolean calcFunction(double[] x) {
        return false;
    }
    /**
     * Objective function called in Phase I. (Searching for feasible initial point)
     * @param x : input variables
     * @param s : extended input variables
     */
    public void calcFuncInternal(double[] x) {
        if (_source.stopRequested) {
            stopRequested = true;
            return;
        }
        setCurrentPoint(x);
        double[] input_x = new double[x.length-1];
        for (int i=0; i<input_x.length; i++) {
            input_x[i] = x[i];
        }
        _source.calcFuncInternal(input_x);
        iterationCounter = _source.iterationCounter;
        //objective function: f(x,s) = s
        f0Result = x[x.length-1];
        for (int col=0; col<f0Gradient.length-1; col++) {
            f0Gradient[col] = 0;
        }
        f0Gradient[f0Gradient.length-1] = 1;
        for (int row=0; row<f0Hessian.length; row++) {
            for (int col=0; col<f0Hessian[0].length; col++) {
                f0Hessian[row][col] = 0;
            }
        }
        // Inequality constraints: fi(x, s) = fi(x)-s
        for (int i=0; i<fiResults.length; i++) {
            fiResults[i] = _source.fiResults[i]-x[x.length-1];
            for (int it=0; it<_source.fiGradients[i].length; it++) {
                fiGradients[i][it] = _source.fiGradients[i][it];
            }
            fiGradients[i][fiGradients[i].length-1] = -1;
            clearMatrix(fiHessians[i]);
            for (int row=0; row<_source.fiHessians[i].length; row++) {
                for (int col=0; col<_source.fiHessians[i][row].length; col++) {
                    fiHessians[i][row][col] = _source.fiHessians[i][row][col];
                }
            }
        }
    }

    /**
     * check the termination criteria in phase I
     * @return : true if all of constraints are negative and Phase I should finish.
     */
    public boolean checkPhaseICriteria() {
        boolean areAllNegative = true;
        for (int j = 0; areAllNegative && j < fiResults.length; j++) {
            areAllNegative = (fiResults[j]+currentX[currentX.length-1] < -(1.0E-10));
        }
        return areAllNegative;
    }
    /**
     * set current searching point X
     * @param x : current point which is to be set.
     */
    public void setCurrentPoint(double[] x) {
        for (int i=0; i<currentX.length; i++) {
            currentX[i] = x[i];
            if (i<currentX.length-1) {
                _source.currentX[i] = x[i];
            }
        }
    }

    /**
     * set initial residual value s
     * @param tolerance : the value which defines margin from constraints.
     * @return true if initial value is already feasible.
     */
    public boolean setInitialValue(double tolerance) {
        if (fiResults.length == 0) return true;
        double maxValue = fiResults[0];
        for (int i=1; i<fiResults.length; i++) {
            if (maxValue<fiResults[i]) maxValue = fiResults[i];
        }
        currentX[currentX.length-1] = maxValue+tolerance;
        //check X0 feasibility
        return currentX[currentX.length-1] < 0;
    }

    /*
     * Private variables
     */
    private ObjectiveFunction _source;
}
