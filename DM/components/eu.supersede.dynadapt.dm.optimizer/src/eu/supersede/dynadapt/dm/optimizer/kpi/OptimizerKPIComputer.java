package eu.supersede.dynadapt.dm.optimizer.kpi;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OptimizerKPIComputer {
	private final Logger log = LogManager.getLogger(this.getClass());

	private Date initialProcessingTime = null;
	private Date finalProcessingTime = null;
	
	public Date getInitialProcessingTime() {
		return initialProcessingTime;
	}

	public Date getFinalProcessingTime() {
		return finalProcessingTime;
	}

	public void stopComputingKPI() {
		finalProcessingTime = Calendar.getInstance().getTime();
	}

	public void reportComputedKPI() {
		if (initialProcessingTime != null && finalProcessingTime != null){
			long processTime = finalProcessingTime.getTime() - initialProcessingTime.getTime();
			log.info("Decision-Making KPI: Optimization Time: " + processTime + " miliseconds");
		}else{
			
		}
	}

	public void startComputingKPI() {
		initialProcessingTime = Calendar.getInstance().getTime();
	}
	
	public void resetComputedKPI() {
		initialProcessingTime = null;
		finalProcessingTime = null;
	}

}
