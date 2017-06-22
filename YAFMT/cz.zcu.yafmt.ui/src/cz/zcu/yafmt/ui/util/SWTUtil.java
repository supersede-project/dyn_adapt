package cz.zcu.yafmt.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class SWTUtil {

    public static void enableAntialiasing(Control control) {
        // Remove current paint listeners
        Listener[] listeners = control.getListeners(SWT.Paint);
        for(Listener listener: listeners)
            control.removeListener(SWT.Paint, listener);

        // Our listener must be the first one.
        control.addListener(SWT.Paint, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.gc.setAntialias(SWT.ON);
                event.gc.setTextAntialias(SWT.ON);
            }
        });

        // Put original listeners back.
        for(Listener listener: listeners)
            control.addListener(SWT.Paint, listener);
    }

}
