/* A timed actor that outputs a const value at a given date.

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

package ptolemy.domains.de.lib;

import ptolemy.actor.CompositeActor;
import ptolemy.actor.Director;
import ptolemy.actor.Manager;
import ptolemy.actor.lib.Transformer;
import ptolemy.data.DateToken;
import ptolemy.data.type.BaseType;
import ptolemy.domains.de.kernel.DEDirector;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

/** A timed actor that outputs a date token that corresponds to the current
 *  model time (maintained by the local clock in the director).
 *   Such a correspondence is only given in models that synchronize to real time.
 *  In such models, the real time (date) when the model starts is recorded. An input
 *  to this actor is compared to the model start time (in model time). The difference between
 *  those dates (in millisecond resolution) is divided by the time resolution of
 *  the local clock, added to the start date of the model and then sent to the output.
 * @author Patricia Derler
 * @version $Id: EventToDate.java 72874 2015-07-26 21:01:52Z cxh $
 * @since Ptolemy II 10.0
 * @Pt.ProposedRating Red (cxh)
 * @Pt.AcceptedRating Red (cxh)
 */
public class EventToDate extends Transformer {

    /** Create a new actor in the specified container with the specified
     *  name.  The name must be unique within the container or an exception
     *  is thrown. The container argument must not be null, or a
     *  NullPointerException will be thrown.
     *
     *  @param container The container.
     *  @param name The name of this actor within the container.
     *  @exception IllegalActionException If this actor cannot be contained
     *   by the proposed container (see the setContainer() method).
     *  @exception NameDuplicationException If the name coincides with
     *   an entity already in the container.
     */
    public EventToDate(CompositeEntity container, String name)
            throws IllegalActionException, NameDuplicationException {
        super(container, name);
        output.setTypeEquals(BaseType.DATE);
    }

    /** Check weather enclosing director is a DEDirector with
     *  synchronizeToRealTime is enabled.
     *  @exception IllegalActionException Thrown if the enclosing director is not a
     *  DEDirector or the synchronizeToRealTime property is false.
     */
    @Override
    public void initialize() throws IllegalActionException {
        super.initialize();
        Director director = getDirector();
        if (director instanceof DEDirector) {
            _director = (DEDirector) director;
        }
    }

    /** Output a DateToken with a date that corresponds to the current model
     *  time.
     *  @exception IllegalActionException Not thrown here.
     */
    @Override
    public void fire() throws IllegalActionException {
        super.fire();
        for (int channel = 0; channel < input.getWidth(); channel++) {
            if (input.hasToken(channel)) {
                input.get(channel);
            }
            double modelTimeSinceStart = _director.getModelTime().getDoubleValue() -
                    _director.getModelStartTime().getDoubleValue();
            if (_manager == null) {
                    _manager = ((CompositeActor) getContainer()).getManager();
            }
            long time = (long) (modelTimeSinceStart * 1000) // The default unit of time is seconds.
                    + _manager.getRealStartTime();
            output.send(channel, new DateToken(time));
        }
    }

    private DEDirector _director;

    private Manager _manager;

}
