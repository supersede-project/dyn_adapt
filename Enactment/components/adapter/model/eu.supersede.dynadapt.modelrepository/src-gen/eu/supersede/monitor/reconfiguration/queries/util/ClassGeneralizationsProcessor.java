/*******************************************************************************
 * Copyright (c) 2016 UPC
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
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
/**
 * Generated from platform:/resource/eu.supersede.monitor.reconfiguration.poc.uml.query/src/queries/monitoring_reconfiguration_queries.vql
 */
package eu.supersede.monitor.reconfiguration.queries.util;

import org.eclipse.uml2.uml.Element;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

import eu.supersede.monitor.reconfiguration.queries.ClassGeneralizationsMatch;

/**
 * A match processor tailored for the queries.classGeneralizations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClassGeneralizationsProcessor implements IMatchProcessor<ClassGeneralizationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pClass the value of pattern parameter class in the currently processed match
   * @param pGeneralizationTarget the value of pattern parameter generalizationTarget in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget);
  
  @Override
  public void process(final ClassGeneralizationsMatch match) {
    process(match.getValueOfClass(), match.getGeneralizationTarget());
  }
}
