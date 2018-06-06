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
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;

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
	public void executeMonitorReconfiguration(JsonObject inputJson, Model model) throws Exception {
		log.debug("Started monitor reconfiguration executor");
		MonitorList monitorList = new MonitorList(inputJson);
		log.debug("Parsed update JSON object with " + monitorList.getMonitors().size() + " reconfigurations");
		for (MonitorInfo monitor : monitorList.getMonitors()) {
			monitor.getConfiguration().setTimeStamp(monitorList.getTimeStamp());
			monitor.getConfiguration().setConfigSender(monitorList.getConfigSender());
			monitor.getConfiguration().setState("active");
			log.debug("Generating a reconfiguration for " + monitor.getMonitorType() + " monitor with " + monitor.getMonitorTool() + " tool");
			
			String user = "orchestrator";
			String password = "ZDUF?BS4%6w#@?7r";
			MonitoringOrchestratorProxy<?, ?> proxy = new MonitoringOrchestratorProxy<Object, Object>(user, password);
			MonitorConfiguration mc;
			switch (monitor.getOperation()) {
				case CREATE:
					log.debug("Create new configuration");
					mc = proxy.createMonitorConfigurationForMonitorToolAndMonitorType(monitor.getConfiguration(), monitor.getMonitorTool(), monitor.getMonitorType());
					//TODO update MonitorConfiguration Id in base model
					if (mc == null)
						throw new Exception("MonitorConfiguration " + monitor.getConfiguration() + " could not be updated");
					Integer id = mc.getMonitorManagerId();		
					log.debug("Injecting new monitor configuration id: " + id + " into base model");
					updateMonitorConfigurationId (id, monitor.getConfiguration(), model);
					break;
				case UPDATE:
					log.debug("Update monitor configuration for monitor id = " + monitor.getConfiguration().getId());
					mc = proxy.updateMonitorConfigurationForMonitorToolAndMonitorType(monitor.getConfiguration(), monitor.getMonitorTool(), monitor.getMonitorType());
//					if (mc == null)
//						throw new Exception("MonitorConfiguration with id " + monitor.getConfiguration().getId() + " could not be updated");
					break;
				case DELETE:
					throw new Exception("Not supported operation at executor");
				default:
					throw new Exception("Not supported operation at executor");
			}
		}
	}

	private void updateMonitorConfigurationId(Integer id, MonitorConfiguration configuration, Model model) {
		//Find InstanceSpecification HttpMonitorConfiguration and slot for defining feature id
		if (model == null) return;
		for (Element element:model.getOwnedElements()){
			if (element instanceof InstanceSpecificationImpl){
				//Detect correct instance by detecting if its classifier generalization is AMonitorConfiguration 
				if (hasClassifierGeneralization ((InstanceSpecificationImpl) element, "AMonitorConfiguration")){
					//Get Slot for defining feature Id
					for (Slot slot: ((InstanceSpecificationImpl) element).getSlots()){
						StructuralFeature df = slot.getDefiningFeature();
						if (df == null) continue;
						if (df.getName()!=null && df.getName().equalsIgnoreCase("id")){
							EList<ValueSpecification> values = slot.getValues();
							if (!values.isEmpty()){
								ValueSpecification value = values.get(0);
								if (value instanceof LiteralString){
									LiteralString ls = (LiteralString)value;
									((LiteralString) value).setValue(id.toString());
								}
							}
						}
					}
				}
			}
		}
		
	}

	private boolean hasClassifierGeneralization(InstanceSpecificationImpl element, String name) {
		boolean result = false;
		for (Classifier classifier: element.getClassifiers()){
			for (Generalization generalization: classifier.getGeneralizations()){
				if (generalization.getGeneral().getName().equals(name)){
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
}
