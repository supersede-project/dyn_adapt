/** A variable InequalityTerm.

 Copyright (c) 1997-2014 The Regents of the University of California.
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
package ptolemy.graph.test;

import ptolemy.graph.GraphActionException;
import ptolemy.graph.InequalityTerm;

///////////////////////////////////////////////////////////////////
//// TestVariable

/**
 A variable InequalityTerm.
 This class is for testing inequality related classes.
 The value of this InequalityTerm is a String.
 This term has name, which is used for printing test result.

 @author Yuhong Xiong
 @version $Id: TestVariable.java 70398 2014-10-22 23:44:32Z cxh $
 @since Ptolemy II 0.2
 @Pt.ProposedRating Red (cxh)
 @Pt.AcceptedRating Red (cxh)
 */
public class TestVariable implements InequalityTerm {
    /** Construct a variable InequalityTerm with a null initial value.
     */
    public TestVariable() {
    }

    /** Construct a variable InequalityTerm with the specified
     *  initial value.
     *  @param value A String
     */
    public TestVariable(String value) {
        _value = value;
    }

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    /** Disallow the value of this term to be set.
     */
    public void fixValue() {
        _valueFixed = true;
    }

    /** Return the string value.
     *  @return A String
     */
    @Override
    public Object getAssociatedObject() {
        return _value;
    }

    /** Return the information of this term. The information is a
     *  String of the form: <i>name</i>(variable)_<i>value</i>.
     *  @return A String
     */
    public String getInfo() {
        return _name + "(variable)_" + getValue();
    }

    /** Return the String value of this term.
     *  @return a String
     *  @see #setValue(Object)
     */
    @Override
    public Object getValue() {
        return _value;
    }

    /** Return an array of size one. The element of the array is
     *  the this reference.
     *  @return an array of InequalityTerms
     */
    @Override
    public InequalityTerm[] getVariables() {
        if (isSettable()) {
            InequalityTerm[] variable = new InequalityTerm[1];
            variable[0] = this;
            return variable;
        } else {
            return new InequalityTerm[0];
        }
    }

    /** Set the value of this variable to the specified String.
     *  @param e a String
     *  @exception GraphActionException not thrown
     */
    @Override
    public void initialize(Object e) throws GraphActionException {
        if (isSettable()) {
            _value = (String) e;
        } else {
            throw new GraphActionException("TestVariable.initialize: "
                    + "This term is not settable.");
        }
    }

    /** Return true.
     *  @return true
     */
    @Override
    public boolean isSettable() {
        return !_valueFixed;
    }

    /** Check whether the current value of this term is acceptable,
     *  and return true if it is.  In this class, a value is always
     *  acceptable.
     *  @return True.
     */
    @Override
    public boolean isValueAcceptable() {
        return true;
    }

    /** Set the name of this variable. If the specified String is null,
     *  Set the name to an empty String.
     *  @param name The name of this variable.
     */
    public void setName(String name) {
        if (name != null) {
            _name = name;
        } else {
            _name = "";
        }
    }

    /** Set the value of this variable to the specified String.
     *  @param e a String
     *  @exception GraphActionException not thrown
     *  @see #getValue()
     */
    @Override
    public void setValue(Object e) throws GraphActionException {
        if (isSettable()) {
            _value = (String) e;
        } else {
            throw new GraphActionException("TestVariable.isSettable: "
                    + "value is not settable.");
        }
    }

    /** Override the base class to describe the variable.
     *  @return A string describing the variable.
     */
    @Override
    public String toString() {
        return getClass().getName() + getInfo();
    }

    /** Allow the value of this term to be changed.
     */
    public void unfixValue() {
        _valueFixed = false;
    }

    ///////////////////////////////////////////////////////////////////
    ////                         private methods                   ////
    private String _name = "";

    private String _value = null;

    private boolean _valueFixed = false;
}
