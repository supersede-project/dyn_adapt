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

import ptolemy.kernel.util.IllegalActionException;
import ptolemy.math.DoubleArrayMath;
import ptolemy.math.DoubleMatrixMath;

/**
 * BarrierMethod.
 * Convex Optimization P.583, 11.3.The Barrier method
 * This class solves min(BarrierFunction B = f0(x)-(1/t)sum(log(-fi(x)))) using Newton decrement.
 *
 * @author Shuhei Emoto
 * @version $Id: BarrierMethod.java 73399 2015-09-10 23:11:08Z syuuhei_emoto@ihi.co.jp $
 * @since Ptolemy II 11.0
 * @Pt.ProposedRating Red (shuhei)
 * @Pt.AcceptedRating
 */
public class BarrierMethod  {

    ///////////////////////////////////////////////////////////////////
    //public methods

    /**
     * Optimize the problem specified by inputed Objective function.
     * @param objective : the class which defines the objective (cost and constraints) functions.
     * @return : if this method finish successfully, return 0("CONVERGED")
     * @exception IllegalActionException
     */
    public int optimize(ObjectiveFunction objective) throws IllegalActionException {

        int returnVal = FAILED_MAX_ITERATION_LIMIT;
        ////////////////////////////////////////////////////
        //Phase I: Search for a feasible initial point.
        //To reduce computational complexity,
        //we at first search feasible points using approximated objective function.
        for (int count=0; count<5; count++) {
            ApproximatedObjectiveFunction approxObjective = new ApproximatedObjectiveFunction(objective);
            ObjectiveFunctionForPhaseI objectivePh1 = new ObjectiveFunctionForPhaseI(approxObjective);
            //calculate at (X, 0)
            objectivePh1.calcFuncInternal(objectivePh1.currentX);
            //check X0 feasibility and set initial s
            if (!objectivePh1.setInitialValue(_tolerance)) {
                objectivePh1.calcFuncInternal(objectivePh1.currentX);
                returnVal = optimizationOfGivenPhase(objectivePh1, 1, _maxIterationNum, 1.0);
            } else {
                //given starting point is already feasible
                returnVal = CONVERGED;
            }
            objective.calcFuncInternal(approxObjective.currentX);
            if (objective.checkFeasibility()) break;
        }
        ////////////////////////////////////////////
        //Phase I using real objective function.
        objective.iterationCounter = 0;
        ObjectiveFunctionForPhaseI objectivePh1 = new ObjectiveFunctionForPhaseI(objective);
        //calculate at (X, 0)
        objectivePh1.calcFuncInternal(objectivePh1.currentX);
        //check X0 feasibility and set initial s
        if (!objectivePh1.setInitialValue(_tolerance)) {
            objectivePh1.calcFuncInternal(objectivePh1.currentX);
            returnVal = optimizationOfGivenPhase(objectivePh1, 1, _maxIterationNum, 100.0);
        } else {
            //given starting point is already feasible
            returnVal = CONVERGED;
        }
        if (_flagDebugPrint) {
            System.out.print("Phase1: "+objective.iterationCounter);
            if (returnVal != CONVERGED) {
                System.out.print(" Terminated by criteria No."+returnVal);
            }
            System.out.println();
        }
        if (!objective.checkFeasibility()) {
            if (_flagDebugPrint) {
                System.out.print("fiResults: ");
                for (int i=0; i<objective.fiResults.length; i++) {
                    System.out.print(objective.fiResults[i]+", ");
                }
                System.out.println();
            }
            /////////////////////////////////////////////////////
            //If we couldn't find feasible points,
            //we treat constraints as soft constraints and optimize given problem as possible.
            objective.iterationCounter = 0;
            ObjectiveFunctionWithSoftConstraints objectiveSoftConst = new ObjectiveFunctionWithSoftConstraints(objective);
            objectiveSoftConst.calcFuncInternal(objectiveSoftConst.currentX);
            int returnVal_soft = optimizationOfGivenPhase(objectiveSoftConst, 2, _maxIterationNum, 1.0E-50);
            if (_flagDebugPrint) {
                System.out.print("Phase2WithSoft" + ": " + objectiveSoftConst.iterationCounter);
                if (returnVal_soft != CONVERGED) {
                    System.out.print(" Terminated by criteria No."+returnVal_soft);
                }
                System.out.println();
            }
            objective.calcFuncInternal(objectiveSoftConst.currentX);
            return returnVal;  //return with error code
            /////////////////////////////////////////////////////
        }
        /////////////////////////////////////////////////////

        /////////////////////////////////////////////////////
        //Phase II: optimize objective.current_point
        objective.iterationCounter = 0;
        returnVal = optimizationOfGivenPhase(objective, 2, _maxIterationNum, 1.0E-50);
        if (_flagDebugPrint) {
            System.out.print("Phase2: "+objective.iterationCounter);
            if (returnVal != CONVERGED) {
                System.out.print(" Terminated by criteria No."+returnVal);
            }
            System.out.println();
        }
        if (returnVal != CONVERGED) {
            objective.iterationCounter = 0;
            ApproximatedObjectiveFunction approxObjective = new ApproximatedObjectiveFunction(objective);
            approxObjective.calcFuncInternal(approxObjective.currentX);
            returnVal = optimizationOfGivenPhase(approxObjective, 2, _maxIterationNum, 1.0E-50);
            objective.calcFuncInternal(approxObjective.currentX);
            if (_flagDebugPrint) {
                System.out.print("Phase2_Ext: "+approxObjective.iterationCounter);
                if (returnVal != CONVERGED) {
                    System.out.print(" Terminated by criteria No."+returnVal);
                }
                System.out.println();
            }
        }
        /////////////////////////////////////////////////////

        return returnVal;
    }

    /**
     * set alpha proportion during line search.
     * @param alpha : setting value
     */
    public void setAlpha(double alpha) {
        _alpha = alpha;
    }
    /**
     * set beta proportion during line search
     * @param beta : setting value
     */
    public void setBeta(double beta) {
        _beta = beta;
    }
    /**
     * set the maximum iteration number in the optimization
     * @param maxIterationNum : maximum iteration number
     */
    public void setMaxIterationNum(int maxIterationNum) {
        _maxIterationNum = maxIterationNum;
    }
    /**
     * set the proportion which increase t (inverse of gap in the Barrier function).
     * @param mu : setting value
     */
    public void setMu(double mu) {
        _mu = mu;
    }
    /**
     * set tolerance value which defines the optimization accuracy.
     * @param tolerance : tolerance
     */
    public void setTolerance(double tolerance) {
        _tolerance = tolerance;
    }

    ///////////////////////////////////////////////////////////////////
    //public variables
    ///////////////////////////////////////////////////////////////////
    public static final int CONVERGED = 0;
    public static final int FAILED_MAX_ITERATION_LIMIT = 1;
    public static final int FAILED_IMPOSSIBLE_TO_REMAIN_WITHIN_FEASIBLE = 2;
    public static final int TERMINATED_BY_USER = 3;

    ///////////////////////////////////////////////////////////////////
    //private methods
    ///////////////////////////////////////////////////////////////////
    /**
     * calculate the total cost of barrier function.
     * Br = t*f0(x)-sum(log(-fi(x))
     * @param objective : data set of current results of cost function and constraints.
     * @param t : the weight parameter of the barrier function
     * @return : total cost of barrier function
     */
    private double calculateBarrierFunction(ObjectiveFunction objective, double t) {
        //B = t*f0(x)-sum(log(-fi(x))
        double brCost = objective.f0Result * t;
        for (int i=0; i<objective.fiResults.length; i++) {
            brCost -= Math.log(-(objective.fiResults[i])); //all fiResults must be negative.
        }
        return brCost;
    }

    /**
     * calculate Gbr = t*g0 + SUM(-1/fi(x) * gi)
     * @param objective :  date set of gradients, and results of the cost function and constraints.
     * @param t : a parameter (gap) of Barrier Function.
     * @return double matrix which is a gradient of Barrier Function (B = t*f0(x)-SUM(log(-fi(x)))
     */
    private double[] calculateGradientOfBarrierFunction(ObjectiveFunction objective, double t, double[][] scaleMatrix) {
        // get reference to the results and gradients of the cost function and constraints.
//        double[] gradF0X = DoubleMatrixMath.multiply(objective.f0Gradient, scaleMatrix);
        double[] fiX = objective.fiResults;

        double[] gradient = new double[objective.f0Gradient.length];
        // calculate t*scaleMatrix*gradF0 (scaleMatrix is diagonal)
        for (int i=0; i<gradient.length; i++) {
            gradient[i] = t*scaleMatrix[i][i]*objective.f0Gradient[i];
        }
        for (int i = 0; i < fiX.length; i++) {  //sum((1/-fiX) * scaleMatrix * gradFiX)
            for (int col=0; col<gradient.length; col++) {
                gradient[col] += (scaleMatrix[col][col]*objective.fiGradients[i][col] /(-fiX[i]));
            }
        }
        return gradient;
    }

    /**
     * calculate Hbr = t*H0 + SUM(-1/fi(x) * Hi) + SUM(1/fi(x)^2 * gi*giT)
     * @param objective: date set of Hessians, gradients, and results of the cost function and constraints.
     * @param t: a parameter (gap) of Barrier Function.
     * @return double matrix which is a Hessian of Barrier Function (B = t*f0(x)-SUM(log(-fi(x)))
     */
    private double[][] calculateHessianOfBarrierFunction(ObjectiveFunction objective, double t, double[][] scaleMatrix) {
        // get reference to the results of constraints.
        double[] fiX = objective.fiResults;

        //////////////////////////////////////////////////////////////////////
        // Hessians of f0-fi are estimated in objective.calcFuncInternal().
        // If the function is not convex, corresponding hessian is converged to zero-matrix.
        double[][] HessSum = DoubleMatrixMath.multiply(objective.f0Hessian, t);
        HessSum = DoubleMatrixMath.multiply(HessSum, scaleMatrix);
        HessSum = DoubleMatrixMath.multiply(scaleMatrix, HessSum);
        for (int i = 0; i < fiX.length; i++) {
            double[][] HessFiX = DoubleMatrixMath.multiply(objective.fiHessians[i], -1.0/(fiX[i]));
            // HessSum += scaleM * HessFix * scaleM
            for (int row=0; row<HessFiX.length; row++) {
                for (int col=0; col<HessFiX[0].length; col++) {
                    HessSum[row][col] += scaleMatrix[row][row]*HessFiX[row][col]*scaleMatrix[col][col];
                }
            }
        }

        double[][] GradSum = new double[HessSum.length][HessSum[0].length];
        for (int i = 0; i < fiX.length; i++) {
            // calculate gi*giT *(1/fi)*(1/fi)
            double[] gi = DoubleMatrixMath.multiply(objective.fiGradients[i], scaleMatrix);
            for (int row=0; row<gi.length; row++) {
                for (int col=0; col<row; col++) {
                    double add_val = (gi[row]/fiX[i])*(gi[col]/fiX[i]);
                    GradSum[row][col] += add_val;
                    GradSum[col][row] += add_val;
                }
                GradSum[row][row] += (gi[row]/fiX[i])*(gi[row]/fiX[i]); //Element at diagonal
            }
        }
        return DoubleMatrixMath.add(HessSum, GradSum);
    }

    /**
     * TODO: This function should be defined in DoubleMatrixMath.
     * Return a matrix that is the decomposition of input matrix.
     * Input matrix A is decomposed into the matrix product of L x Lt.
     * @param A input matrix which is decomposed.
     * @param L output matrix (Lower triangular matrix)
     */
    private static boolean choleskyDecomposition(double[][] A, double[][] L, double tolerance) {
        for (int row = 0; row < L.length; row++) {
            for (int col = 0; col < L[0].length; col++) {
                L[row][col] = 0;
            }
        }
        ///////////////////////////////////////////////////////////
        //Implementation of modified cholesky decomposition
        double[] d = new double[A.length]; //singular values
        if (A[0][0] == 0) {
            L[0][0] = tolerance;
        } else {
            L[0][0] = A[0][0];
        }
        d[0] = 1.0/L[0][0];
        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j <= i; ++j) {
                double lld = A[i][j];
                for (int k = 0; k < j; ++k) {
                    lld -= L[i][k]*L[j][k]*d[k];
                }
                L[i][j] = lld;
            }
            if (L[i][i]>tolerance) {
                d[i] = 1.0/L[i][i];
            } else if (L[i][i]<-tolerance) {
                return false;
            } else {
                d[i] = 1.0/tolerance;
            }
        }
        ///////////////////////////////////////////////////////////
        for (int col = 0; col < L[0].length; col++) {
            if (d[col] > 0) {
                double scale = Math.sqrt(d[col]);
                for (int row = 0; row <L.length; row++) {
                    L[row][col] *= scale;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     *  compute inner loop of Barrier method.
     * @param objective : data set of the cost function, constraints function, etc.
     * @param phase : flag of phase (phase 1 or 2)
     * @param t : the parameter (gap) of the barrier function.
     * @return return code
     */
    private int innerLoop(ObjectiveFunction objective, int phase, double t, int maxInnerLoopIterationNum) {
        for (;;) {
            /////////////////////////////////////////////////
            // check exit condition
            // terminated by user
            if (objective.stopRequested) {
                return TERMINATED_BY_USER;
            }
            // iteration limit condition
            if (objective.iterationCounter > _maxIterationNum) {
                if (_flagDebugPrint) System.out.println("maxIt:"+ _maxIterationNum+" current:"+objective.iterationCounter);
                return FAILED_MAX_ITERATION_LIMIT;
            }
            //check the feasibility of current point
            if (!objective.checkFeasibility()) {
                return FAILED_IMPOSSIBLE_TO_REMAIN_WITHIN_FEASIBLE;
            }
            //If the current point satisfies constraints, finish phase1.
            if (phase == 1) {
                if (((ObjectiveFunctionForPhaseI)objective).checkPhaseICriteria()) {
                    return CONVERGED;
                }
                //In current implementation, Phase1 is forced to finish within a half of maxIterationNum.
                //If some of the constraints are non-negative, they will be relaxed.
                if (objective.iterationCounter > maxInnerLoopIterationNum) {
                    if (_flagDebugPrint) System.out.println("maxInnerIterationNum:"+ (maxInnerLoopIterationNum)+" current:"+objective.iterationCounter);
                    return FAILED_MAX_ITERATION_LIMIT;
                }
            }
            /////////////////////////////////////////////////


            ////////////////////////////////////////////////////////////////////
            // calculation of hessian and gradient used in Newton-method.

            // calculate the Hessian of Barrier Function without scaling.
            double[][] hessBr = calculateHessianOfBarrierFunction(objective, t, DoubleMatrixMath.identity(objective.f0Hessian.length));
            // calculate a scale matrix which makes diagonals of hessBr 1.0
            double[][] scaleMatrix = new double[hessBr.length][hessBr[0].length];
            for (int i=0; i<scaleMatrix.length; i++) {
                if (hessBr[i][i]<= 0) continue;
                scaleMatrix[i][i] = 1.0/Math.sqrt(hessBr[i][i]);
            }
            // recalculate the Hessian of Barrier Function
            hessBr = calculateHessianOfBarrierFunction(objective, t, scaleMatrix);
            // calculate the Gradient of Barrier Function
            double[] gBr = calculateGradientOfBarrierFunction(objective, t, scaleMatrix);

            double[] unscaledGBr = new double[gBr.length];
            for (int i=0; i<unscaledGBr.length; i++) {
                unscaledGBr[i] = gBr[i]/scaleMatrix[i][i];
            }
            ////////////////////////////////////////////////////////////////////

            ////////////////////////////////////////////////////////////////////
            // check exit condition
            double gradXNorm = Math.sqrt(DoubleArrayMath.dotProduct(unscaledGBr, unscaledGBr));
            if (gradXNorm < (_tolerance*_tolerance)) {
                return _INNER_LOOP_FINISH; //exit from inner loop
            }
            ////////////////////////////////////////////////////////////////////

            ////////////////////////////////////////////////////////////////////
            // solving hessBr*dx = -gBr
            double[] dx = solveEquaitionWithCholeskyDecomposition(hessBr, gBr);
            ////////////////////////////////////////////////////////////////////

            ////////////////////////////////////////////////////////////////////
            // check exit condition: check the Newton decrement
            double[] step_H = DoubleMatrixMath.multiply(hessBr, dx);
            double lambda = DoubleArrayMath.dotProduct(step_H, dx);
            if ((lambda>0.0)&&(lambda/4.0 <= _tolerance*_tolerance)) {
                return _INNER_LOOP_FINISH; //exit from inner loop
            }
            ////////////////////////////////////////////////////////////////////

            // scaling the solution of the Newton method.
            dx = DoubleMatrixMath.multiply(dx, scaleMatrix);

            ////////////////////////////////////////////////////////////////////
            // line search and update
            double stepSize = 1.0;
            ////////////////////////////////////////////////////////
            // To reduce the number of evaluation (firing of ptolemy model),
            // at first we search the stepSize which satisfies all constraints using approximated objective functions.
            // Approximated function calculates the new constraints using current gradients of Fi.
            for (int i=0; i<objective.fiResults.length; i++) {
                //calculate approximated Fi. (dfi = grad*dx*s)
                double elementP = DoubleArrayMath.dotProduct(objective.fiGradients[i], dx);
                //find maximum s which satisfies P*s + Fi < 0
                if (Math.abs(elementP)<1.0E-50) continue;
                double approxSize = -objective.fiResults[i]/elementP;
                approxSize *= 0.9; //considering approximation error.
                if (approxSize>0) {
                    if (stepSize>approxSize) stepSize=approxSize;
                }
            }
            ////////////////////////////////////////////////////////

            //calculate the current cost of Barrier Function.
            double F0X = calculateBarrierFunction(objective, t);
            double[] previosX = objective.getCurrentPoint(); //copy the previous value.
            double approxDeltaBr = DoubleArrayMath.dotProduct(unscaledGBr, dx); //liner approximation of update of cost.

            ////////////////////////////////////////////////////////
            // backtracking line search with actual objective function
            double[] X1 = new double[dx.length];
            for (int searchIt=0; searchIt<_maxIterationInLineSearch; searchIt++) {
                // x + s*step
                for (int row=0; row<dx.length; row++) {
                    X1[row] = previosX[row] + dx[row]*stepSize;
                }
                objective.calcFuncInternal(X1);
                if (objective.checkFeasibility()) {
                    double currentCost = calculateBarrierFunction(objective, t);
                    double approximatedCost = F0X + _alpha  * stepSize * approxDeltaBr;
                    if ((_flagDebugPrint)&&((objective.iterationCounter>50)&&(phase == 2))) {
                        System.out.println(objective.iterationCounter+" f0:"+objective.f0Result+"\t currentCost:"+currentCost+"\t meanDiff:"+_meanDiffOfCost);
                    }
                    if (phase==1) {
                        //If there is no solution which satisfies all constraints,
                        //phase 1 will repeat at the same cost and not finish.
                        //TODO: It needs the method to check the feasibility of given optimization problem.
                        _meanDiffOfCost = Math.abs(currentCost-_previousCost)+0.5*_meanDiffOfCost;
                        _previousCost = currentCost;
                        if ((searchIt>1)&&(_meanDiffOfCost/Math.abs(currentCost) < 1.0E-5)) {
                            return FAILED_IMPOSSIBLE_TO_REMAIN_WITHIN_FEASIBLE;
                        }
                    }
                    if (currentCost <= approximatedCost) {
                        break;
                    }
                }
                stepSize = _beta * stepSize;
                if (stepSize<1.0E-5) {
                    if (_flagDebugPrint) System.out.println("Step s = "+stepSize + ", "+ objective.iterationCounter + ", " + searchIt + ", " + phase);
                }
                if (stepSize<_MIN_STEP_SIZE) {
                    return FAILED_IMPOSSIBLE_TO_REMAIN_WITHIN_FEASIBLE;
                }
            }
            ////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
        }
    }

    /**
     * Find the maximum value in array.
     * @param array : input array
     * @return maximum value
     */
//    private double maxValue(double[] array) {
//        return maxValue(array, 0, array.length);
//    }
//    private double maxValue(double[] array, int from_id, int check_num) {
//        double ret = array[from_id];
//        for(int i=from_id; i<from_id+check_num; i++) {
//            if(ret<array[i]) ret = array[i];
//        }
//        return ret;
//    }
    
    /**
     * Compute phase1 or 2 of Barrier method. Which phase will be executed is defined by argument "phase".
     * @param objective : Objective Function class which defines objective functions.
     * @param phase : input param. If 1, phase 1 is executed. If 2, phase 2 is executed.
     * @return : if this method finish successfully, return 0("CONVERGED")
     * @exception IllegalActionException
     */
    private int optimizationOfGivenPhase(ObjectiveFunction objective, int phase, int maxIterationNum, double initialT) throws IllegalActionException {
        //set the parameter which defines the gap of constraints. t will increase through the iteration.
        double t = initialT;

        for (int outerIt = 0; ; outerIt++) {
            if (outerIt>maxIterationNum) {
                if (_flagDebugPrint) System.out.println("maxIt:"+ (maxIterationNum)+" outerIt:"+outerIt);
                return FAILED_MAX_ITERATION_LIMIT;
            }

            // optimize at current t
            int retVal = innerLoop(objective, phase, t, maxIterationNum);
            if (retVal != _INNER_LOOP_FINISH) return retVal; // terminated by user input or max iteration limit.
            // increase t
            t *= _mu;
            //exit condition of outer loop
            if ((phase==2)&&(1.0/t < _tolerance)) {
                return CONVERGED;
            }
        }
    }

    /**
     * Calculate step vector of Newton decrement solving the KKT system
     * without constraint:
     * H.v  = -g, <br>
     * (H: hessian matrix,  g: gradient vector)
     * This method returns the vector v which satisfies an equation above.
     */
    private double[] solveEquaitionWithCholeskyDecomposition(double[][] H, double[] g) {
        // Decompose H = L.LT
        double [][] L = new double[H.length][H.length];
        choleskyDecomposition(H, L, 1.0E-50);

        // Solve y (L.y =  -g)
        double[] y = new double[L.length];
        double[] sumVals = new double[L.length];
        for (int i = 0; i < L.length; i++) {
            if (L[i][i]==0.0) {
                y[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                sumVals[j] = L[i][j] * y[j];
            }
            double sum = sumVector(sumVals, i);
            y[i] = (-g[i] - sum)/ L[i][i];
        }

        // Solve LT.V = y
        double[] V = new double[L.length];
        for (int i = L.length-1; i > -1; i--) {
            if (L[i][i]==0.0) {
                V[i] = 0;
                continue;
            }
            for (int j = L.length-1; j > i; j--) {
                sumVals[L.length-1-j] = L[j][i] * V[j];
            }
            double sum = sumVector(sumVals, L.length-1-i);
            V[i] = (y[i] - sum)/ L[i][i];
        }
        return V;
    }
    /**
     * return summation of vector whose size is "size"
     * this function changes argument v to zero vector.
     * @param v
     * @param size
     * @return summation of v
     */
    private double sumVector(double[] v, int size) {
        double sum = 0;
        for (int i=0; i<size; i++) {
            double maxValue = 0;
            int maxIndex = -1;
            for (int it=0; it<size; it++) {
                if (Math.abs(maxValue)<Math.abs(v[it])) {
                    maxValue = v[it];
                    maxIndex = it;
                }
            }
            if (maxValue==0.0) break;
            sum += maxValue;
            v[maxIndex] = 0.0;
        }
        return sum;
    }

    ///////////////////////////////////////////////////////////////////
    // private variables

    private static final double _MIN_STEP_SIZE = 1.0E-20;
    private static final int _INNER_LOOP_FINISH = -1;
    private double _alpha = 0.05;
    private double _beta = 0.5;
    private boolean _flagDebugPrint = false;
    private int _maxIterationNum = 50;
    private int _maxIterationInLineSearch = 250;
    private double _mu = 10.0;
    private double _tolerance = 1.0E-5;
    private double _meanDiffOfCost = 0;
    private double _previousCost = 0;
}
