
import ptolemy.moml.MoMLSimpleApplication2;

public class MoMLThreadSupersede implements Runnable {
	
	private String adaptation;
	private String ptolemyRecorder;
	private MoMLSimpleApplication2 runPtolemy=null;
	private boolean stopped=false;
	
	MoMLThreadSupersede (String adaptation, String ptolemyRecorder)
	{
		this.adaptation=adaptation;
		this.ptolemyRecorder=adaptation;
	}
	public boolean hasBeenStopped()
	{		
		return stopped;
	}
	public String getOutputFromRecorder()
	{
		
		while(this.runPtolemy.getFinalResult()==null)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
			
		return this.runPtolemy.getFinalResult();
				
	}
	
	public void stopModelExecution()
	{
		if(runPtolemy!=null && !stopped)
		{			
			runPtolemy.stopModelExecution();
			stopped=true;
		}
	}
	
	public void resumeModelExecution()
	{
		if(runPtolemy!=null && stopped)
		{
			runPtolemy.resumeModelExecution();
			stopped=false;
		}
	}

	@Override
	public void run() {	
		
		try {
			
			this.runPtolemy=new MoMLSimpleApplication2();
			if(this.runPtolemy!=null)
			{
				this.runPtolemy.MoMLSimpleApplicationExecute(this.adaptation,this.ptolemyRecorder);
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
