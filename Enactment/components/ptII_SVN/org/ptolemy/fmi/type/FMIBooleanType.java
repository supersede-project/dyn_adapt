/* An Functional Mock-up Interface Boolean Type.

 Copyright (c) 2012-2014 The Regents of the University of California.
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
package org.ptolemy.fmi.type;

import org.w3c.dom.Element;

///////////////////////////////////////////////////////////////////
//// FMIBooleanType

/**
 * An Functional Mock-up Interface type that represents a Boolean.
 *
 * <p>FMI documentation may be found at
 * <a href="http://www.modelisar.com/fmi.html">http://www.modelisar.com/fmi.html</a>.
 * </p>
 *
 * @author Christopher Brooks
@version $Id: FMIBooleanType.java 70398 2014-10-22 23:44:32Z cxh $
@since Ptolemy II 10.0
 * @version $Id: FMIBooleanType.java 70398 2014-10-22 23:44:32Z cxh $
 * @Pt.ProposedRating Red (cxh)
 * @Pt.AcceptedRating Red (cxh)
 */
public class FMIBooleanType extends FMIType {

    /** Construct a Boolean FMU variable.
     *  @param name The name of this variable.
     *  @param description A description of this variable.
     *  @param element The XML element whose attributes are used to
     *  set the fields of this object.
     */
    public FMIBooleanType(String name, String description, Element element) {
        super(name, description, element);
        if (element.hasAttribute("start")) {
            start = Boolean.valueOf(element.getAttribute("start"));
        }
    }

    /** Return the string value of the base element.
     *  @return The string value.
     */
    @Override
    public String toString() {
        return Boolean.toString(start);
    }

    /** The starting value of this boolean. */
    public boolean start;
}
