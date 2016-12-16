/* A live signal plotter applet

 @Author: Edward A. Lee and Christopher Hylands

 @Copyright (c) 1997-2014 The Regents of the University of California.
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
package ptolemy.plot.demo;

import ptolemy.plot.PlotBox;
import ptolemy.plot.PlotLiveApplet;

//////////////////////////////////////////////////////////////////////////
//// PlotLiveDemoApplet

/**
 An Applet that demonstrates the PlotLiveDemo class.

 @author Edward A. Lee, Christopher Hylands
 @version $Id: PlotLiveDemoApplet.java 69607 2014-07-30 17:07:26Z cxh $
 @since Ptolemy II 0.2
 @Pt.ProposedRating red (eal)
 @Pt.AcceptedRating red (cxh)
 */
@SuppressWarnings("serial")
public class PlotLiveDemoApplet extends PlotLiveApplet {
    /** Return a string describing this applet.
     *  @return A description of the applet.
     */
    @Override
    public String getAppletInfo() {
        return "PlotLiveDemoApplet "
                + PlotBox.PTPLOT_RELEASE
                + " : Demo of PlotLive.\n"
                + "By: Edward A. Lee\n"
                + "    Christopher Hylands\n"
                + "($Id: PlotLiveDemoApplet.java 69607 2014-07-30 17:07:26Z cxh $)";
    }

    /** Create a new Plot object to operate on.
     */
    @Override
    public PlotBox newPlot() {
        return new PlotLiveDemo();
    }
}
