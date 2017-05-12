#!/bin/sh

echo -e "\nBuilding Supersede Service Composition Enactor ...\n"
cd Enactment/components/enactor/eu.supersede.dynadapt.serviceCompositionEnactor/ && ./installDependencies.sh && mvn clean install && cp target/ServiceCompositionEnactor-0.0.1-SNAPSHOT.jar ../eu.supersede.dynadapt.enactor.EnactorFactory/lib/

if [ $? -eq 0 ] 
then
  echo "Supersede Service Composition Enactor compiled"
else
  echo "There are problems compiling Supersede Service Composition Enactor" >&2
  exit 1
fi

echo -e "\nBuilding Supersede YAFMT plugins...\n"
cd  ../../../../Maven/cz.zcu.yafmt/releng/cz.zcu.yafmt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

if [ $? -eq 0 ] 
then
  echo "YAFMT compiled"
else
  echo "There are problems compiling YAFMT" >&2
  exit 1
fi

echo -e "\nBuilding Supersede dynamic adaptation plugins...\n"
cd ../../Maven/eu.supersede.dynadapt/releng/eu.supersede.dynadapt.configuration/ && ./installPom.sh
cd ../../ && mvn clean install

if [ $? -eq 0 ] 
then
  echo "Supersede dynamic adaptation plugins compiled"
else
  echo "There are problems compiling Supersede dynamic adaptation plugins" >&2
  exit 1
fi

echo -e "\nBuilding Supersede dynamic adaptation adapter...\n"
cd ../../Enactment/services/eu.supersede.dynadapt.adapter.service/ && mkdir -p logs && mvn eclipse:eclipse && mvn clean package

if [ $? -eq 0 ] 
then
  echo "Supersede dynamic adaptation adapter compiled"
else
  echo "There are problems compiling Supersede dynamic adaptation adapter" >&2
  exit 1
fi

echo -e "\nBuilding Supersede dynamic adaptation optimizer...\n"
cd ../../../DM/components/eu.supersede.dynadapt.dm.optimizer/ && ./installGPLibDependency.sh && mvn clean package -Dmaven.test.skip=true

if [ $? -eq 0 ] 
then
  echo "Supersede dynamic adaptation optimizer compiled"
else
  echo "There are problems compiling Supersede dynamic adaptation optimizer" >&2
  exit 1
fi

echo -e "\nBuilding Supersede dynamic adaptation model repository...\n"
cd ../../../Enactment/components/adapter/model/eu.supersede.dynadapt.modelrepository.manager && mvn clean install

if [ $? -eq 0 ] 
then
  echo "Supersede dynamic adaptation model repository manager compiled"
else
  echo "There are problems compiling Supersede dynamic adaptation model repository manager" >&2
  exit 1
fi

cd ../eu.supersede.dynadapt.modelrepository.manager.service && gradle build

if [ $? -eq 0 ] 
then
  echo "Supersede dynamic adaptation model repository manager service compiled"
else
  echo "There are problems compiling Supersede dynamic adaptation model repository manager service" >&2
  exit 1
fi
