/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Quim Motger (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.monitor.reconfiguration.executor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import eu.supersede.integration.api.monitoring.orchestrator.proxies.MonitoringOrchestratorProxy;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorConfiguration;
import eu.supersede.monitor.reconfiguration.executor.model.MonitorInfo;
import eu.supersede.monitor.reconfiguration.executor.model.MonitorList;
import eu.supersede.monitor.reconfiguration.executor.IMonitorReconfigExecutor;
import eu.supersede.monitor.reconfiguration.executor.MonitorReconfigExecutor;

public class MonitorReconfigExecutor implements IMonitorReconfigExecutor {
	
	private final static Logger log = LogManager.getLogger(MonitorReconfigExecutor.class);
	
	@Override
	public void executeMonitorReconfiguration(JsonObject inputJson) throws Exception {
		log.debug("Started monitor reconfiguration executor");
		MonitorList monitorList = new MonitorList(inputJson);
		log.debug("Parsed update JSON object with " + monitorList.getMonitors().size() + " reconfigurations");
		for (MonitorInfo monitor : monitorList.getMonitors()) {
			monitor.getConfiguration().setTimeStamp(monitorList.getTimeStamp());
			monitor.getConfiguration().setConfigSender(monitorList.getConfigSender());
			monitor.getConfiguration().setState("active");
			log.debug("Generating a reconfiguration for " + monitor.getMonitorType() + " monitor with " + monitor.getMonitorTool() + " tool");
			MonitoringOrchestratorProxy<?, ?> proxy = new MonitoringOrchestratorProxy<Object, Object>();
			switch (monitor.getOperation()) {
				case CREATE:
					log.debug("Create new configuration");
					proxy.createMonitorConfigurationForMonitorToolAndMonitorType(monitor.getConfiguration(), monitor.getMonitorTool(), monitor.getMonitorType());
					break;
				case UPDATE:
					log.debug("Update configuration");
					proxy.updateMonitorConfigurationForMonitorToolAndMonitorType(monitor.getConfiguration(), monitor.getMonitorTool(), monitor.getMonitorType());
					break;
				case DELETE:
					throw new Exception("Not supported operation at executor");
				default:
					throw new Exception("Not supported operation at executor");
			}
		}
	}
	
}
