/*
@Copyright (c) 2010-2014 The Regents of the University of California.
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

                                                PT_COPYRIGHT_VERSION_2
                                                COPYRIGHTENDKEY


 */
package ptdb.common.dto;

/**
 *
 * A task request to save/update the model in the database.
 *
 * <p>It is used as a data transfer object that hold the model as XMLDBModel
 * object with its getter and setter methods.</p>
 *
 * @author Yousef Alsaeed
 * @version $Id: SaveModelTask.java 70398 2014-10-22 23:44:32Z cxh $
 * @since Ptolemy II 10.0
 * @Pt.ProposedRating Red (yalsaeed)
 * @Pt.AcceptedRating Red (yalsaeed)
 *
 */
public class SaveModelTask extends Task {

    /**
     * Default nullary constructor.
     * <p>Should be removed once the code using it
     * is fixed to use the constructor with the XMLDBModel parameter.</p>
     */
    public SaveModelTask() {
        //FIXME: Remove this method as soon as the code pointing to it is modified.
    }

    /**
     * Construct an instance of this class and set the model to be saved in the
     * database.
     * @param xmlDBModel the model to be saved in the database.
     */
    public SaveModelTask(XMLDBModel xmlDBModel) {
        _xmlDBModel = xmlDBModel;
    }

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    /**
     * Return the model to be saved in the database.
     * @return The model to be saved in the database.
     *
     * @see #setXMLDBModel
     */
    public XMLDBModel getXMLDBModel() {
        return _xmlDBModel;

    }

    /**
     * Set the model to be saved in the database.
     * @param xmlDBModel the model to be saved to the database.
     *
     * @see #getXMLDBModel
     */
    public void setXMLDBModel(XMLDBModel xmlDBModel) {
        _xmlDBModel = xmlDBModel;
    }

    ///////////////////////////////////////////////////////////////////
    ////                         private variables                 ////

    /** The model in XMLDBModel object format. */
    private XMLDBModel _xmlDBModel;

}
