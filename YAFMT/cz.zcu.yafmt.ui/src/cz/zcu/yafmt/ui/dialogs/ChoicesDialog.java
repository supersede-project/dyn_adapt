package cz.zcu.yafmt.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;


public class ChoicesDialog extends MessageDialog {

    private static final String[] BUTTON_LABELS = new String[] { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL };
    
    private String[] choices;
    private int selectedChoice;
    
    public ChoicesDialog(Shell shell, String title, String message, String[] choices, boolean isWarning) {
        super(shell, title, null, message, isWarning ? WARNING : QUESTION, BUTTON_LABELS, 0);
        setShellStyle(getShellStyle() | SWT.SHEET);
        
        if(choices == null)
            throw new IllegalArgumentException("Array of choices cannot be null.");
        this.choices = choices;
        this.selectedChoice = 0;
    }
   
    @Override
    protected Control createCustomArea(Composite parent) {
        Composite control = new Composite(parent, SWT.NONE);
        control.setLayout(createGridLayout());
        control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createChoicesControls(control);
        return control;
    }
    
    private Layout createGridLayout() {
        GridLayout layout = new GridLayout();
        layout.marginLeft = 64;
        return layout;
    }
        
    private void createChoicesControls(Composite parent) {
        SelectionListener listener = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                selectedChoice = (Integer) ((Button) (event.getSource())).getData();
            }
        };
        
        for(int i = 0; i < choices.length; i++) {
            Button button = new Button(parent, SWT.RADIO);
            button.setText(choices[i]);
            button.setSelection(i == 0);
            button.setData(i);
            button.addSelectionListener(listener);
        }
    }

    @Override
    public int open() {
        return (super.open() == OK) ? selectedChoice : -1; 
    }
    
    public static int openChoices(Shell shell, String title, String message, String[] choices, boolean isWarning) {
        ChoicesDialog dialog = new ChoicesDialog(shell, title, message, choices, isWarning);
        return dialog.open();
    }
    
    public static int openChoices(Shell shell, String title, String message, String[] choices) {
        ChoicesDialog dialog = new ChoicesDialog(shell, title, message, choices, false);
        return dialog.open();
    }

}
