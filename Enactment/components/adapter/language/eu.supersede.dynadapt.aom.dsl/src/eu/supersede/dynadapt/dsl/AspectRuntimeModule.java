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
/*
 * generated by Xtext
 */
package eu.supersede.dynadapt.dsl;

import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;

import com.google.inject.Binder;


/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class AspectRuntimeModule extends eu.supersede.dynadapt.dsl.AbstractAspectRuntimeModule {
//	@Override
//	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
//		return GMLImportUriGlobalScopeProvider.class;
//	}
//	
//	@Override
//	public Class<? extends XtextResourceSet> bindXtextResourceSet() {
//		return ARTISTResourceSet.class;
//	}
	
//	@Override
//	public Class<? extends Manager> bindIContainer$Manager() {
//		return super.bindIContainer$Manager();
//	}
//	
//	@Override
//	public Class<? extends Provider> bindIAllContainersState$Provider() {
//		return super.bindIAllContainersState$Provider();
//	}
	
//	@Override
//	public Class<? extends IValueConverterService> bindIValueConverterService() {
//		return ARTISTCommonConverters.class;
//	}
	
//	@Override
//	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
//		return ARTISTQualifiedNameProvider.class;
//	}
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return AspectImportUriGlobalScopeProvider.class;
	}
	
	@Override
	public void configureSerializerIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(SerializerScopeProviderBinding.class).to(bindIScopeProvider());
	}
	
//	@Override
//	public Class<? extends ILinkingService> bindILinkingService() {
//		return ARTISTLinkingService.class;
//	}
//	
//	@Override
//	public Class<? extends ILinker> bindILinker() {
//		return super.bindILinker();
//	}
	
//	@Override
//	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
//		return ImportUriGlobalScopeProvider.class;
//	}
}
