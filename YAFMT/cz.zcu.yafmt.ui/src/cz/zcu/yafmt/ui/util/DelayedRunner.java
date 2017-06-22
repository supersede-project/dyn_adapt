package cz.zcu.yafmt.ui.util;

import org.eclipse.swt.widgets.Display;

public class DelayedRunner {
    
    private Thread thread = null;           
    
    public boolean isActive() {
        return (thread != null) && thread.isAlive();
    }
    
    public void run(final long timeout, final Runnable code) {
        if(!isActive()) {
            thread = new InternalThread(timeout, code);
            thread.start();
        }
    }
    
    private static class InternalThread extends Thread {

        private long timeout;
        private Runnable code;
        
        public InternalThread(long timeout, Runnable code) {
            this.timeout = timeout;
            this.code = code;
        }

        @Override
        public void run() {
            
            try {
                Thread.sleep(timeout);
                Display display = Display.getDefault();
                if(!display.isDisposed())
                    display.syncExec(code);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
    }

}
