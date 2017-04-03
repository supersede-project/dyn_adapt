#!/bin/bash

echo -e "\nBuilding Supersede YAFMT plugins...\n"
cd  Maven/cz.zcu.yafmt/releng/cz.zcu.yafmt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

echo -e "\nBuilding Supersede dynamic adaptation plugins...\n"
cd ../../Maven/eu.supersede.dynadapt/releng/eu.supersede.dynadapt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

echo -e "\nBuilding Supersede dynamic adaptation adapter...\n"
cd ../../Enactment/services/eu.supersede.dynadapt.adapter.service/ && mkdir logs && mvn eclipse:eclipse && mvn clean package

echo -e "\nBuilding Supersede dynamic adaptation optimizer...\n"
cd ../../../DM/components/eu.supersede.dynadapt.dm.optimizer/ && installGPLibDependency.sh && mvn clean && mvn package

echo -e "\nBuilding Supersede dynamic adaptation model repository...\n"
cd ../../../Enactment/components/adapter/model/eu.supersede.dynadapt.modelrepository.manager && mvn clean install
cd ../eu.supersede.dynadapt.modelrepository.manager.service && gradle build
