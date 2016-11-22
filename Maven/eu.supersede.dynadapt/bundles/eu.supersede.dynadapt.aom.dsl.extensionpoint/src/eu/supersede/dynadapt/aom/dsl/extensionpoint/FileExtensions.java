/*******************************************************************************
 * Copyright (c) 2014-2016 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 * Jesús Gorroñogoitia (Atos Spain S.A.) - Adapted to Supersede project
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 * Adapted in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.aom.dsl.extensionpoint;

import java.util.List;

import com.google.common.collect.Lists;

public class FileExtensions {
	public static List<String> getAllExtensions() {
		return Lists.newArrayList(
				"uml",
				"aspect", "vql", 
				"yafm");
	}
	
	public static String getUMLExtension() {
		return "uml";
	}
	
	public static String getAdaptationExtension() {
		return "aspect";
	}
	
	public static String getPatternExtension() {
		return "vql";
	}
	
	public static String getFeatureExtension() {
		return "yafm";
	}
	
	public static List<String> getUMLExtensions() {
		return Lists.newArrayList("uml");
	}
	
	public static List<String> getAdaptationExtensions() {
		return Lists.newArrayList("aspect");
	}
	
	public static List<String> getPatternExtensions() {
		return Lists.newArrayList("vql");
	}
	
	public static List<String> getFeatureExtensions() {
		return Lists.newArrayList("yafm");
	}
	
	protected static String getFileExtension(String fileName) {
		if(fileName == null)
			return null;
		String[] fileNameSegments = fileName.split("\\.");
		if(fileNameSegments == null || fileNameSegments.length == 0)
			return fileName;
		return fileNameSegments[fileNameSegments.length - 1];
	}
	
	public static boolean isUMLModel(String fileName) {
		if(fileName == null)
			return false;
		return getUMLExtensions().contains(getFileExtension(fileName));
	}
	
	public static boolean isAdaptationModel(String fileName) {
		if(fileName == null)
			return false;
		return getAdaptationExtensions().contains(getFileExtension(fileName));
	}
	
	public static boolean isPatternModel(String fileName) {
		if(fileName == null)
			return false;
		return getPatternExtensions().contains(getFileExtension(fileName));
	}
	
	public static boolean isFeatureModel(String fileName) {
		if(fileName == null)
			return false;
		return getFeatureExtensions().contains(getFileExtension(fileName));
	}
}
