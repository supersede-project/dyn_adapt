/*******************************************************************************
 * Copyright (c) 2010, 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * - Original implementation by Christian Dietrich, retrieved from his blog at 
 *   http://christiandietrich.wordpress.com/2011/07/17/xtext-2-0-and-uml/
 * - Martin Fleck (not itemis): Added doSetup() method
 *******************************************************************************/
package eu.supersede.dynadapt.lang.uml;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

/**
 * Implementation retrieved from Christian Dietrichs blog post.
 * 
 * @see <a href="http://christiandietrich.wordpress.com/2011/07/17/xtext-2-0-and-uml/">
 * Original blog post by Christian Dietrich</a>
 */
public class UmlSupport extends AbstractGenericResourceSupport {

	@Override
	protected Module createGuiceModule() {
		return new UmlRuntimeModule();
	}
	
	/**
	 * Initializes the UML support for standalone applications.
	 */
	public static void doSetup() {
		new UmlSupport().preInvoke();
	}

}