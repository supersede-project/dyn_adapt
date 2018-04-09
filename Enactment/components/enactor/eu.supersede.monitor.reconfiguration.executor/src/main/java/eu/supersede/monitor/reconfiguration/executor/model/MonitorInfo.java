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
package eu.supersede.monitor.reconfiguration.executor.model;

import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import eu.supersede.integration.api.monitoring.manager.types.Method;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorConfiguration;

public class MonitorInfo {
	
	private String monitorType;
	private String monitorTool;
	private MonitorConfiguration configuration;
	private Operation operation;
	
	public MonitorInfo(JsonObject json, String type) {
		this.configuration = new MonitorConfiguration();
		this.monitorType = type;
		feedConfiguration(json);
		checkOperation();
	}
	
	private void checkOperation() {
		if (configuration.getId() == null) this.operation = Operation.CREATE;
		else {
			this.operation = Operation.UPDATE;
			//FIXME not supported
			//this.operation = Operation.DELETE;
		}
	}

	private void feedConfiguration(JsonObject json) {
		for (Entry<String, JsonElement> e : json.entrySet()) {
			//Monitor
			if (e.getKey().equals("kafkaEndpoint")) configuration.setKafkaEndpoint(e.getValue().getAsString()); 
			else if (e.getKey().equals("kafkaTopic")) configuration.setKafkaTopic(e.getValue().getAsString()); 
			else if (e.getKey().equals("timeSlot")) configuration.setTimeSlot(e.getValue().getAsString()); 
			else if (e.getKey().equals("state")) configuration.setState(e.getValue().getAsString()); 
			else if (e.getKey().equals("id")) configuration.setId(Integer.valueOf(e.getValue().getAsString()));
			else if (e.getKey().equals("toolName")) this.monitorTool = e.getValue().getAsString();
			//SocialNetworks
			else if (e.getKey().equals("keywordExpression")) configuration.setKeywordExpression(e.getValue().getAsString()); 
			//GooglePlay
			else if (e.getKey().equals("packageName")) configuration.setPackageName(e.getValue().getAsString()); 
			//AppStore
			else if (e.getKey().equals("appId")) configuration.setAppId(e.getValue().getAsString()); 
			//HttpMonitor
			else if (e.getKey().equals("url")) configuration.setUrl(e.getValue().getAsString()); 
			else if (e.getKey().equals("method")) configuration.setMethod(Method.valueOf(e.getValue().getAsString()));

		}
	}
	
	public MonitorConfiguration getConfiguration() {
		return configuration;
	}
	
	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}
	
	public String getMonitorTool() {
		return monitorTool;
	}

	public void setMonitorTool(String monitorTool) {
		this.monitorTool = monitorTool;
	}
	
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	
}
