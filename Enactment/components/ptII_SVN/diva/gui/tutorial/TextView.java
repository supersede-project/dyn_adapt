/*
 * $Id: TextView.java 70398 2014-10-22 23:44:32Z cxh $
 *
 @Copyright (c) 1998-2014 The Regents of the University of California.
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
package diva.gui.tutorial;

import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import diva.gui.AbstractView;

/**
 * A simple MDI text editor view.  FIXME
 *
 * @author Michael Shilman
 * @version $Id: TextView.java 70398 2014-10-22 23:44:32Z cxh $
 */
public class TextView extends AbstractView {
    private JEditorPane _editorPane;

    private JScrollPane _scrollPane;

    public TextView(TextDocument doc) {
        super(doc);
    }

    public TextDocument getTextDocument() {
        return (TextDocument) getDocument();
    }

    @Override
    public JComponent getComponent() {
        if (_scrollPane == null) {
            TextDocument td = (TextDocument) getDocument();
            _editorPane = new JEditorPane();
            _editorPane.setText(td.getText());

            // Get notified every time text is changed in the component to update
            // our text document.  The "Document" here is a
            // javax.swing.text.Document.  Don't get confused!
            _editorPane.getDocument().addDocumentListener(
                    new DocumentListener() {
                        @Override
                        public void changedUpdate(DocumentEvent e) {
                            getTextDocument().setText(_editorPane.getText());
                        }

                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            getTextDocument().setText(_editorPane.getText());
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            getTextDocument().setText(_editorPane.getText());
                        }
                    });
            _scrollPane = new JScrollPane(_editorPane);
        }

        return _scrollPane;
    }

    @Override
    public String getTitle() {
        return getDocument().getTitle();
    }

    @Override
    public String getShortTitle() {
        return getTitle();
    }
}
