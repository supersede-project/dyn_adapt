#!/bin/bash

echo -e "\nBuilding Supersede YAFMT plugins...\n"
cd  Maven/cz.zcu.yafmt/releng/cz.zcu.yafmt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

echo -e "\nBuilding Supersede dynamic adaptation plugins...\n"
cd ../../Maven/eu.supersede.dynadapt/releng/eu.supersede.dynadapt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

echo -e "\nBuilding Supersede dynamic adaptation adapter...\n"
cd ../../Enactment/services/eu.supersede.dynadapt.adapter.service/ && mvn eclipse:eclipse && mvn clean package

