#!/bin/sh


echo -e "\nBuilding Supersede YAFMT plugins...\n"
cd  Maven/cz.zcu.yafmt/releng/cz.zcu.yafmt.configuration/ && ./installPom.sh
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


