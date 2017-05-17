package eu.supersede.dynadapt.adapter.kpi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AdapterKPIComputer {
	private final Logger log = LogManager.getLogger(this.getClass());

	private Date initialProcessingTime = null;
	private Date finalProcessingTime = null;
	private List<Long> processingTimeSeries = new ArrayList<Long>();
	private String name;
	
	public AdapterKPIComputer (String name){
		this.name = name;
	}
	
	public void stopComputingKPI() {
		finalProcessingTime = Calendar.getInstance().getTime();
		long processTime = finalProcessingTime.getTime() - initialProcessingTime.getTime();
		if (initialProcessingTime != null && finalProcessingTime != null){
			processingTimeSeries.add(processTime);
		}
	}

	public void reportComputedKPI() {
		log.info(name + ": " + processingTimeSeries.get(processingTimeSeries.size()-1) + " miliseconds");
	}
	
	public void reportComputedKPITimeSeries() {
		StringBuffer values = new StringBuffer();
		for (Long value: processingTimeSeries)
			values.append(value + ", ");
		log.info(name + ". Timeseries: Number of runs: "  + processingTimeSeries.size() + " Values: [" + values +  "] miliseconds");
	}

	public void startComputingKPI() {
		initialProcessingTime = Calendar.getInstance().getTime();
	}
	
	public void resetComputedKPI() {
		initialProcessingTime = null;
		finalProcessingTime = null;
	}

}
