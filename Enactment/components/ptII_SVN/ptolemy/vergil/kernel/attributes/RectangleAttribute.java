/* An attribute with a reference to a rectangle.

 Copyright (c) 2003-2014 The Regents of the University of California.
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
package ptolemy.vergil.kernel.attributes;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import ptolemy.data.DoubleToken;
import ptolemy.data.expr.Parameter;
import ptolemy.data.type.BaseType;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;
import ptolemy.kernel.util.Workspace;

///////////////////////////////////////////////////////////////////
//// RectangleAttribute

/**
 <p>
 This is an attribute that is rendered as a rectangle.
 </p>
 @author Edward A. Lee
 @version $Id: RectangleAttribute.java 73211 2015-08-23 18:13:51Z eal $
 @since Ptolemy II 4.0
 @Pt.ProposedRating Yellow (eal)
 @Pt.AcceptedRating Red (cxh)
 */
public class RectangleAttribute extends FilledShapeAttribute {
    /** Construct an attribute with the given name contained by the
     *  specified container. The container argument must not be null, or a
     *  NullPointerException will be thrown.  This attribute will use the
     *  workspace of the container for synchronization and version counts.
     *  If the name argument is null, then the name is set to the empty
     *  string. Increment the version of the workspace.
     *  @param container The container.
     *  @param name The name of this attribute.
     *  @exception IllegalActionException If the attribute is not of an
     *   acceptable class for the container, or if the name contains a period.
     *  @exception NameDuplicationException If the name coincides with
     *   an attribute already in the container.
     */
    public RectangleAttribute(NamedObj container, String name)
            throws IllegalActionException, NameDuplicationException {
        super(container, name);

        rounding = new Parameter(this, "rounding");
        rounding.setTypeEquals(BaseType.DOUBLE);
        rounding.setExpression("0.0");
    }

    ///////////////////////////////////////////////////////////////////
    ////                         parameters                        ////

    /** The amount of rounding of the corners.
     *  This is a double that defaults to 0.0, which indicates no rounding.
     */
    public Parameter rounding;

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    /** React to a changes in the attributes by changing
     *  the icon.
     *  @param attribute The attribute that changed.
     *  @exception IllegalActionException If the change is not acceptable
     *   to this container (should not be thrown).
     */
    @Override
    public void attributeChanged(Attribute attribute)
            throws IllegalActionException {
        if (attribute == rounding) {
            // Make sure that the new rounding value is valid.
            double roundingValue = ((DoubleToken) rounding.getToken())
                    .doubleValue();

            if (roundingValue < 0.0) {
                throw new IllegalActionException(this,
                        "Invalid rounding value. Required to be non-negative.");
            }

            if (roundingValue != _roundingValue) {
                _roundingValue = roundingValue;
                _icon.setShape(_newShape());
            }
        } else {
            super.attributeChanged(attribute);
        }
    }

    /** Clone the object into the specified workspace. The new object is
     *  <i>not</i> added to the directory of that workspace (you must do this
     *  yourself if you want it there).
     *  The result is an object with no container.
     *  @param workspace The workspace for the cloned object.
     *  @exception CloneNotSupportedException Not thrown in this base class
     *  @return The new Attribute.
     */
    @Override
    public Object clone(Workspace workspace) throws CloneNotSupportedException {
        RectangleAttribute newObject = (RectangleAttribute) super
                .clone(workspace);

        // The cloned icon ends up referring to the clonee's shape.
        // We need to fix that here. Do not use the _newShape() method
        // of the clone, however, because it may refer to parameters that
        // have not been created yet. Instead, use this object to generate
        // the new shape for the clone.
        newObject._icon.setShape(_newShape());
        return newObject;
    }

    ///////////////////////////////////////////////////////////////////
    ////                         protected methods                 ////

    /** Return the a new rectangle given a new width and height.
     *  @return A new shape.
     */
    @Override
    protected Shape _newShape() {
        double roundingValue = 0.0;

        try {
            if (rounding != null && rounding.getToken() != null) {
                roundingValue = ((DoubleToken) rounding.getToken())
                        .doubleValue();
            }
        } catch (IllegalActionException ex) {
            // Ignore and use default.
        }

        double x = 0.0;
        double y = 0.0;
        double width = _widthValue;
        double height = _heightValue;

        /* Let Diva's notion of centering handle this.
        if (_centeredValue) {
            x = -width * 0.5;
            y = -height * 0.5;
        }
        */

        if (roundingValue == 0.0) {
            return new Rectangle2D.Double(x, y, width, height);
        } else {
            return new RoundRectangle2D.Double(x, y, width, height,
                    roundingValue, roundingValue);
        }
    }

    ///////////////////////////////////////////////////////////////////
    ////                        protected members                  ////

    /** Most recent value of the rounding parameter. */
    protected double _roundingValue = 0.0;
}
