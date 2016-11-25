/* An actor that writes the value of string tokens to a file, one per line.

 @Copyright (c) 2015 The Regents of the University of California.
 All rights reserved.

 Permission is hereby granted, without written agreement and without
 license or royalty fees, to use, copy, modify, and distribute this
 software and its documentation for any purpose, provided that the
 above copyright notice and the following two paragraphs appear in all
 copies of this software.

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

 PT_COPYRIGHT_VERSION 2
 COPYRIGHTENDKEY
 */
package ptolemy.actor.lib.mbed;

import ptolemy.actor.lib.Sink;
import ptolemy.data.BooleanToken;
import ptolemy.data.IntToken;
import ptolemy.data.expr.Parameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.Workspace;
import ptolemy.vergil.icon.EditorIcon;
import ptolemy.vergil.kernel.attributes.RectangleAttribute;

///////////////////////////////////////////////////////////////////
//// GPIOWriter

/**
 Read true or false values and write to the GPIO port of an embedded
 platform.

 <p>If this is run as a model, the model will write to a file with the
 name of the GPIO port</p>

 <p> The port is specified by the <i>BoardPortName</i> attribute using
 any form acceptable to the platform or a file name.</p>

 @author Kevin Albers
 @version $Id: GPIOWriter.java 72988 2015-08-06 22:35:27Z cxh $
 @since Ptolemy II 11.0
 @Pt.ProposedRating red (robert.bui)
 @Pt.AcceptedRating red (robert.bui)
 */
public class GPIOWriter extends Sink {
    /** Construct an actor with the given container and name.
     *  @param container The container.
     *  @param name The name of this actor.
     *  @exception IllegalActionException If the actor cannot be contained
     *   by the proposed container.
     *  @exception NameDuplicationException If the container already has an
     *   actor with this name.
     */
    public GPIOWriter(CompositeEntity container, String name)
            throws IllegalActionException, NameDuplicationException {
        super(container, name);

        BoardPortNumber = new Parameter(this, "BoardPortNumber");

        _GPIOIcon = new EditorIcon(this, "_icon");
        _GPIOState = new RectangleAttribute(_GPIOIcon, "_led_");
        _GPIOState.width.setToken("75.0");
        _GPIOState.height.setToken("39.0");
        _GPIOState.centered.setToken("true");
        _GPIOState.fillColor.setToken("{0.0, 0.0, 0.0, 1.0}");

    }

    ///////////////////////////////////////////////////////////////////
    ////                     ports and parameters                  ////


    /** This is the GPIO port to write to. This only serves a
     *  purpose for code generation.
     */
    public Parameter BoardPortNumber;

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    /** Clone the actor into the specified workspace.
     *  @param workspace The workspace for the new object.
     *  @return A new actor.
     *  @exception CloneNotSupportedException If a derived class contains
     *   an attribute that cannot be cloned.
     */
    @Override
    public Object clone(Workspace workspace) throws CloneNotSupportedException {
        GPIOWriter newObject = (GPIOWriter) super.clone(workspace);
        newObject._GPIOIcon = (EditorIcon)newObject.getAttribute("_icon");
        newObject._GPIOState = (RectangleAttribute)newObject.getAttribute("_led_");

        return newObject;
    }

    /** Change the color of the actor depending on if true or false
     *  was sent to the actor.
     *  @exception IllegalActionException If the file cannot be opened
     *   or created.
     */
    @Override
    public boolean postfire() throws IllegalActionException {
        if (input.hasToken(0)) {
            if (((BooleanToken) input.get(0)).booleanValue() == true)

                if (((IntToken)BoardPortNumber.getToken()).intValue() == 0) {
                    _GPIOState.fillColor.setToken("{1.0, 0.0, 0.0, 1.0}");
                }
                else if (((IntToken) BoardPortNumber.getToken()).intValue() == 1) {
                    _GPIOState.fillColor.setToken("{0.0, 1.0, 0.0, 1.0}");
                }
                else {
                    _GPIOState.fillColor.setToken("{0.0, 0.0, 1.0, 1.0}");
                }
            else
                _GPIOState.fillColor.setToken("{0.0, 0.0, 0.0, 1.0}");
        }
        return super.postfire();
    }

    ///////////////////////////////////////////////////////////////////
    ////                         private members                   ////

    private RectangleAttribute _GPIOState;

    private EditorIcon _GPIOIcon;
}
