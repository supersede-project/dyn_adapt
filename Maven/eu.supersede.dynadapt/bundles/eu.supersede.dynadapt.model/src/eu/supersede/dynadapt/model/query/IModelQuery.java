/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A, Universitat Politécnica de Catalunya (UPC)
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.model.query;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.Pattern;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

public interface IModelQuery {
	public Collection<? extends IPatternMatch> query (String patternFQN, String patternModelPath) throws ViatraQueryException;
	public Collection<? extends IPatternMatch> query (String patternFQN, Resource patternResource) throws ViatraQueryException;
	public Collection<? extends IPatternMatch> query (Pattern pattern) throws ViatraQueryException;
	public Collection<Map<String, Object>> query (String patternFQN, Resource patternResource, List<String> parameters) throws ViatraQueryException;
	public Collection<Map<String, Object>> query (String patternFQN, String patternModelPath, List<String> parameters) throws ViatraQueryException;
	public Collection<Map<String, Object>> query (Pattern pattern, List<String> parameters) throws ViatraQueryException;
	public ViatraQueryMatcher queryMatcher (IQuerySpecification querySpecification)throws ViatraQueryException;
	public PatternModel loadPatternModel (URI uri);
}
