#!/bin/bash
set -e # Any subsequent(*) commands which fail will cause the shell script to exit immediately

#Configuration
DATE=`date '+%Y%m%d%H%M'`
RESULTS_DIR=/home/stamp/Git/descartes-usecases-output/atos/supersede/modeladapter/pit/$DATE/
OUT=./target/pit-reports/$DATE/*
LOG=$DATE"_pit.log"
mkdir -p $RESULTS_DIR

#PIT Execution

nohup time mvn -f pom_pit.xml org.pitest:pitest-maven:mutationCoverage | tee -a $LOG &
pid=$!
((pid--)) #Decremented to capture mvn command pid, otherwise it captures tee command pid
wait $pid

#Collecting results
#This will output an html report to target/pit-reports/<YYYYMMDDHHMI>.
mv $OUT $RESULTS_DIR
mv $LOG $RESULTS_DIR
