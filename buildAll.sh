#!/bin/bash

echo -e "\nBuilding Supersede Service Composition Enactor ...\n"
cd Enactment/components/enactor/eu.supersede.dynadapt.serviceCompositionEnactor/ && mvn clean install && cp target/ServiceCompositionEnactor-0.0.1-SNAPSHOT.jar ../eu.supersede.dynadapt.enactor.EnactorFactory/lib/

echo -e "\nBuilding Supersede YAFMT plugins...\n"
cd  ../../../../Maven/cz.zcu.yafmt/releng/cz.zcu.yafmt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

echo -e "\nBuilding Supersede dynamic adaptation plugins...\n"
cd ../../Maven/eu.supersede.dynadapt/releng/eu.supersede.dynadapt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

echo -e "\nBuilding Supersede dynamic adaptation adapter...\n"
cd ../../Enactment/services/eu.supersede.dynadapt.adapter.service/ && mkdir -p logs && mvn eclipse:eclipse && mvn clean package

echo -e "\nBuilding Supersede dynamic adaptation optimizer...\n"
cd ../../../DM/components/eu.supersede.dynadapt.dm.optimizer/ && ./installGPLibDependency.sh && mvn clean package -Dmaven.test.skip=true

echo -e "\nBuilding Supersede dynamic adaptation model repository...\n"
cd ../../../Enactment/components/adapter/model/eu.supersede.dynadapt.modelrepository.manager && mvn clean install -Dmaven.test.skip=true
cd ../eu.supersede.dynadapt.modelrepository.manager.service && gradle build -x test
