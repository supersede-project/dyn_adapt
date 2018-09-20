#!/bin/bash
set -e # Any subsequent(*) commands which fail will cause the shell script to exit immediately
mvn -f pom-for-stamp.xml clean package
time mvn -f pom_descartes.xml org.pitest:pitest-maven:mutationCoverage -DmutationEngine=descartes > `date '+%Y%m%d%H%M'`_descartes.log

#This will output an html report to target/pit-reports/<YYYYMMDDHHMI>.
