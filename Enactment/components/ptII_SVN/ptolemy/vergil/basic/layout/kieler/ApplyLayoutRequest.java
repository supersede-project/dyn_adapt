/*

Copyright (c) 2011-2014 The Regents of the University of California.
All rights reserved.

Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA LIABLE TO ANY PARTY
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
package ptolemy.vergil.basic.layout.kieler;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import ptolemy.data.DoubleToken;
import ptolemy.data.expr.Parameter;
import ptolemy.domains.modal.kernel.Transition;
import ptolemy.kernel.Relation;
import ptolemy.kernel.undo.UndoStackAttribute;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.ChangeRequest;
import ptolemy.kernel.util.Locatable;
import ptolemy.kernel.util.NamedObj;
import ptolemy.vergil.actor.LayoutHint;

/**
 * A change request specialized for application of automatically computed layout.
 * This is used to set new locations for graph elements and to set layout hints
 * for connection routing.
 *
 * @author Miro Spoenemann (<a href="mailto:msp@informatik.uni-kiel.de">msp</a>)
 * @version $Id: ApplyLayoutRequest.java 73620 2015-10-06 23:41:38Z uru@informatik.uni-kiel.de $
 * @since Ptolemy II 10.0
 * @Pt.ProposedRating Red (msp)
 * @Pt.AcceptedRating Red (msp)
 */
public class ApplyLayoutRequest extends ChangeRequest {

    /**
     * Create a request for applying layout.
     *
     * @param source The source object, which is typically the parent composite actor.
     */
    public ApplyLayoutRequest(Object source) {
        super(source, "KIELER Automatic Layout", true);
    }

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    /**
     * Add a new location change to the request.
     *
     * @param locatable The locatable that will be changed
     * @param x The new x coordinate
     * @param y The new y coordinate
     */
    public void addLocation(Locatable locatable, double x, double y) {
        _locationEntries.add(new LocationEntry(locatable, x, y));
    }

    /**
     * Add a new connection routing change to the request.
     *
     * @param relation The relation that owns the connection.
     * @param head The head object of the connection.
     * @param tail The tail object of the connection.
     * @param bendPoints The new bend points.
     */
    public void addConnection(Relation relation, NamedObj head, NamedObj tail,
            double[] bendPoints) {
        _connectionEntries.add(new ConnectionEntry(relation, head, tail,
                bendPoints));
    }
    
    /**
     * Add a new connection routing change to the request.
     *
     * @param relation The relation that owns the connection.
     * @param head The head object of the connection.
     * @param tail The tail object of the connection.
     * @param bendPoints The new bend points.
     * @param labelLocation The location of a label, may be null
     */
    public void addConnection(Relation relation, NamedObj head, NamedObj tail,
            double[] bendPoints, Point2D.Double labelLocation) {
        _connectionEntries.add(new ConnectionEntry(relation, head, tail,
                bendPoints, labelLocation));
    }

    /**
     * Add a new transition curve change to the request.
     *
     * @param transition The transition that is represented by the curve.
     * @param exitAngle The new value for the exit angle.
     */
    public void addCurve(Transition transition, double exitAngle) {
        _curveEntries.add(new CurveEntry(transition, exitAngle));
    }

    ///////////////////////////////////////////////////////////////////
    ////                         protected methods                 ////

    /**
     * Execute the request. This sets the previously configured locations and connections.
     */
    @Override
    protected void _execute() throws Exception {
        NamedObj source = (NamedObj) getSource();
        UndoLayoutAction undoLayoutAction = new UndoLayoutAction(source);

        // Process locations.
        for (LocationEntry entry : _locationEntries) {
            double[] oldLoc = entry._locatable.getLocation();
            undoLayoutAction.addLocation(new LocationEntry(entry._locatable,
                    oldLoc[0], oldLoc[1]));
            entry._locatable.setLocation(new double[] { entry._x, entry._y });
        }

        // Process connection routings.
        for (ConnectionEntry entry : _connectionEntries) {
            Attribute attribute = entry._relation.getAttribute("_layoutHint");
            if (attribute == null) {
                attribute = new LayoutHint(entry._relation, "_layoutHint");
            }
            if (attribute instanceof LayoutHint) {
                LayoutHint layoutHint = (LayoutHint) attribute;
                layoutHint.setLayoutHintItem(entry._head, entry._tail,
                        entry._bendPoints, entry._labelLocation);
                undoLayoutAction.removeConnection(layoutHint);
            }
        }

        // Process transition curves.
        for (CurveEntry entry : _curveEntries) {
            Parameter exitAngleParam = entry._transition.exitAngle;
            DoubleToken token = DoubleToken.convert(exitAngleParam.getToken());
            undoLayoutAction.addCurve(new CurveEntry(entry._transition, token
                    .doubleValue()));
            exitAngleParam.setExpression(Double.toString(entry._exitAngle));
            
            Attribute attribute = entry._transition.getAttribute("_layoutHint");
            if (attribute != null) {
                // FIXME undo from arcs to splines does not work
                // the interpretation of bendpoints as splines is only performed
                // when the parameter 'useSplines' is set. We would have to change
                // the parameter in the undo action as well to make it work.
                // LayoutHint layoutHint = (LayoutHint) attribute;
                // undoLayoutAction.addConnection(entry._transition, layoutHint);
                entry._transition.removeAttribute(attribute);
            }
        }

        UndoStackAttribute undoInfo = UndoStackAttribute.getUndoInfo(source);
        undoInfo.push(undoLayoutAction);
    }

    ///////////////////////////////////////////////////////////////////
    ////                         private variables                 ////

    /** The configured locations that will be changed. */
    private List<LocationEntry> _locationEntries = new LinkedList<LocationEntry>();
    /** The configured connection routings that will be changed. */
    private List<ConnectionEntry> _connectionEntries = new LinkedList<ConnectionEntry>();
    /** The configures curves that will be changed. */
    private List<CurveEntry> _curveEntries = new LinkedList<CurveEntry>();

    ///////////////////////////////////////////////////////////////////
    ////                         inner classes                     ////

    /**
     * An entry that contains data for changing a location.
     */
    static class LocationEntry {
        Locatable _locatable;
        double _x;
        double _y;

        LocationEntry(Locatable locatable, double x, double y) {
            this._locatable = locatable;
            this._x = x;
            this._y = y;
        }
    }

    /**
     * An entry that contains data for changing a connection using bend points.
     */
    static class ConnectionEntry {
        Relation _relation;
        NamedObj _head;
        NamedObj _tail;
        double[] _bendPoints;
        Point2D.Double _labelLocation;

        ConnectionEntry(Relation relation, NamedObj head, NamedObj tail,
                double[] bendPoints, Point2D.Double labelLocation) {
            this._relation = relation;
            this._head = head;
            this._tail = tail;
            this._bendPoints = bendPoints;
            this._labelLocation = labelLocation;
        }
        
        ConnectionEntry(Relation relation, NamedObj head, NamedObj tail,
                double[] bendPoints) {
            this(relation, head, tail, bendPoints, null);
        }
    }

    /**
     * An entry that contains data for changing a curve using angular values.
     */
    static class CurveEntry {
        Transition _transition;
        double _exitAngle;

        CurveEntry(Transition transition, double exitAngle) {
            this._transition = transition;
            this._exitAngle = exitAngle;
        }
    }

}
