
import ptolemy.moml.MoMLSimpleApplication2;

public class MoMLThreadSupersede implements Runnable {
	
	private String adaptation;
	private String ptolemyRecorder;
	private MoMLSimpleApplication2 runPtolemy=null;
	
	MoMLThreadSupersede (String adaptation, String ptolemyRecorder)
	{
		this.adaptation=adaptation;
		this.ptolemyRecorder=adaptation;
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
		if(this.runPtolemy!=null)
		{
			this.runPtolemy.stopModelExecution();
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
