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

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MonitorList {
	
	private List<MonitorInfo> monitors;
	
	private String configSender;
	
	private String timeStamp;
	
	public MonitorList(JsonObject json) {
		
		this.monitors = new ArrayList<>();
		
		this.configSender = json.getAsJsonObject("").get("configSender").getAsString();
		this.timeStamp = json.getAsJsonObject("").get("timeStamp").getAsString();
		
		for (Entry<String, JsonElement> entry : json.entrySet()) {

			if (!entry.getKey().equals("")) 
				monitors.add(new MonitorInfo(entry.getValue().getAsJsonObject(), entry.getKey()));

		}
	}
	
	public List<MonitorInfo> getMonitors() {
		return this.monitors;
	}
	
	public String getConfigSender() {
		return this.configSender;
	}
	
	public String getTimeStamp() {
		return this.timeStamp;
	}
	
}
