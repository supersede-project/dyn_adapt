/* A adapter class for ptolemy.actor.lib.CurrentMicrostep

 Copyright (c) 2006-2014 The Regents of the University of California.
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
package ptolemy.cg.adapter.generic.program.procedural.c.adapters.ptolemy.actor.lib;

import ptolemy.cg.kernel.generic.program.NamedProgramCodeGeneratorAdapter;

//////////////////////////////////////////////////////////////////////////
//// CurrentTime

/**
 A adapter class for CurrentMicrostep.

 @author William Lucas
@version $Id: CurrentMicrostep.java 70398 2014-10-22 23:44:32Z cxh $
@since Ptolemy II 10.0
 */
public class CurrentMicrostep extends NamedProgramCodeGeneratorAdapter {
    /**
     *  Construct a CurrentMicrostep adapter.
     *  @param actor The given ptolemy.actor.lib.CurrentMicrostep actor.
     */
    public CurrentMicrostep(ptolemy.actor.lib.CurrentMicrostep actor) {
        super(actor);
    }

    /** Return the name of the port that is the time source.
     *  @return The string "trigger".
     */
    @Override
    public String getTimeSourcePortName() {
        return "trigger";
    }
}
