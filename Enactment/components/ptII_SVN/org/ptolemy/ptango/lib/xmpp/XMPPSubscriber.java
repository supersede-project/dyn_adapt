/* An interface for actors that subscribe to an XMPP XEP-0060 node

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

package org.ptolemy.ptango.lib.xmpp;

import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

///////////////////////////////////////////////////////////////////
//// XMPPSubscriber

/** An interface for actors that subscribe to an XMPP XEP-0060 node.
 *
 *  @see XMPPGateway
 *  @author Marten Lohstroh
 *  @version $Id: XMPPSubscriber.java 69607 2014-07-30 17:07:26Z cxh $
 *  @since Ptolemy II 10.0
 *  @Pt.ProposedRating Red (marten)
 *  @Pt.AcceptedRating Red (marten)
 */
public interface XMPPSubscriber extends ItemEventListener<Item> {

    // FIXME: getSubId should be getSubscriberID.  Ditto with setSubId.

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////

    /** Get the nodeId to subscribe to.
     *  @return A string representing the node to subscribe to.
     */
    public String getNodeId();

    /** Get the subscriber ID.
     *  @return The subscriber ID.
     *  @see #setSubId(String)
     */
    public String getSubId();

    /** Register the gateway to the subscriber, so that if
     *  the subscription changes, it can notify the gateway.
     * @param gateway The attribute responsible for managing the XMPP session.
     */
    public void setGateway(XMPPGateway gateway);

    /** Set the subscription id returned by
     *  SmackPubSubAccess.subscribeToNode(). // FIXME out-dated
     *  @param subId A string identifying this subscriber.
     *  @see #getSubId()
     */
    public void setSubId(String subId);
}
