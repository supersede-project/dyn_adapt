#!/bin/bash

# copying the Hook for the Tomcat that is running in the ASCR for the validation purposes
yes | cp -rf /home/user/workspace_eclipseOxygenEE/CompositionHook-Tomcat /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components

# copying the Enactor related files

yes | cp -rf /home/user/workspace_RCP/eu.supersede.dynadapt.serviceCompositionEnactor/lib /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/enactor/eu.supersede.dynadapt.serviceCompositionEnactor/lib

yes | cp -rf /home/user/workspace_RCP/eu.supersede.dynadapt.serviceCompositionEnactor/repository /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/enactor/eu.supersede.dynadapt.serviceCompositionEnactor/repository

yes | cp -rf /home/user/workspace_RCP/eu.supersede.dynadapt.serviceCompositionEnactor/src /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/enactor/eu.supersede.dynadapt.serviceCompositionEnactor/src

# copying the updated .jar files to the repo
cp /home/user/workspace_RCP/ptII/ptolemy/vergil/vergil.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/vergil.jar

cp /home/user/workspace_RCP/ptII/lib/diva.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/diva.jar

cp /home/user/workspace_RCP/ptII/ptolemy/ptsupport.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/ptsupport.jar

cp /home/user/workspace_RCP/ptII/ptolemy/domains/domains.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/domains.jar

cp /home/user/workspace_RCP/ptII/ptolemy/actor/lib/jjs/jjs.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/jjs.jar

cp /home/user/workspace_RCP/ptII/srdjan/supersede/extension/ptolemy-supersede.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/ptolemy-supersede.jar 

cp /home/user/workspace_RCP/ptII/ptolemy/domains/de/de.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/de.jar

cp /home/user/workspace_RCP/ptII/ptolemy/actor/lib/conversions/json/json.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/conversions-json.jar

cp /home/user/workspace_RCP/ptII/org/json/json.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org-json.jar

cp /home/user/soft/eclipse_RCP/plugins/org.eclipse.emf.ecore.xmi_2.12.0.v20160420-0247.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.emf.ecore.xmi_2.12.0.v20160420-0247.jar

cp /home/user/soft/eclipse_RCP/plugins/org.eclipse.uml2.uml_5.2.2.v20161114-0827.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.uml2.uml_5.2.2.v20161114-0827.jar

cp /home/user/workspace_RCP/eu.supersede.dynadapt.enactor-mavenProject/lib/org.eclipse.emf.gwt.common-2.9.0.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.emf.gwt.common-2.9.0.jar

cp /home/user/workspace_RCP/eu.supersede.dynadapt.enactor-mavenProject/lib/org.eclipse.emf.gwt.ecore-2.9.0.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.emf.gwt.ecore-2.9.0.jar

cp /home/user/soft/eclipse_RCP/plugins/com.google.gwt.servlet_2.0.4.v20100709-0658.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/com.google.gwt.servlet_2.0.4.v20100709-0658.jar

cp /home/user/workspace_RCP/eu.supersede.dynadapt.enactor-mavenProject/lib/org.apache.servicemix.bundles.gwt-user-2.4.0_1.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.apache.servicemix.bundles.gwt-user-2.4.0_1.jar

cp /home/user/soft/eclipse_RCP/plugins/org.eclipse.uml2.types_2.0.0.v20161114-0827.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.uml2.types_2.0.0.v20161114-0827.jar

cp /home/user/soft/eclipse_RCP/plugins/org.eclipse.emf.common_2.12.0.v20160420-0247.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.emf.common_2.12.0.v20160420-0247.jar 


cp /home/user/soft/eclipse_RCP/plugins/org.eclipse.emf.ecore_2.12.0.v20160420-0247.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.emf.ecore_2.12.0.v20160420-0247.jar

cp /home/user/soft/eclipse_RCP/plugins/org.eclipse.uml2.common_2.1.0.v20161114-0827.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.uml2.common_2.1.0.v20161114-0827.jar

cp /home/user/soft/eclipse_RCP/plugins/org.eclipse.emf.mapping.ecore2xml_2.9.0.v20160526-0356.jar /home/user/SUPERSEDE/Repo-develop-brunch/Enactment/components/required-JARS/org.eclipse.emf.mapping.ecore2xml_2.9.0.v20160526-0356.jar




