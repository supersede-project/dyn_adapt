#!/bin/bash
set -e # Any subsequent(*) commands which fail will cause the shell script to exit immediately
mvn -f pom-for-stamp.xml clean package

#Configuration
RESULTS_DIR=/home/yosu/Projects/STAMP/Git/dspot-usecases-output/atos/supersede
DSPOT_JAR_NAME=dspot-1.1.1-SNAPSHOT-jar-with-dependencies.jar
DSPOT_JAR=/home/yosu/Projects/STAMP/Git/dspot/dspot/target/$DSPOT_JAR_NAME
DSPOT_OUT=./dspot-out
TIMEOUT=30000

#Selectors: PitMutantScoreSelector | ExecutedMutantSelector | CloverCoverageSelector | JacocoCoverageSelector | TakeAllSelector | ChangeDetectorSelector
DSPOT_SELECTOR=JacocoCoverageSelector
#Amplifiers: StringLiteralAmplifier,NumberLiteralAmplifier,CharLiteralAmplifier,BooleanLiteralAmplifier,AllLiteralAmplifiers,MethodAdd,MethodRemove,TestDataMutator (deprecated),MethodGeneratorAmplifier,ReturnValueAmplifier,ReplacementAmplifier,NullifierAmplifier
DSPOT_AMPLIFIERS=MethodAdd:StatementAdd:TestDataMutator
DSPOT_ITERACTIONS=1
TARGET_TEST=eu.supersede.dynadapt.modeladapter.test.ModelAdapterTest

DSPOT_OPTS="-i $DSPOT_ITERACTIONS -t $TARGET_TEST -a $DSPOT_AMPLIFIERS -s $DSPOT_SELECTOR --timeOut $TIMEOUT --verbose"

echo "DSpot configuration: " $DSPOT_OPTS
DSPOT_PROPERTIES="./dspot.properties"

RESULTS_DIR=$RESULTS_DIR/$DSPOT_SELECTOR/$DSPOT_AMPLIFIERS/`date '+%Y%m%d%H%M'`
mkdir -p $RESULTS_DIR
filename=$RESULTS_DIR/dspot.log

echo "Starting DSpot: reporting in file" + $filename
echo "Started DSpot: `date`" > $filename
echo "DSpot CMI configuration: " $DSPOT_OPTS >> $filename
echo "DSpot properties file: " $DSPOT_PROPERTIES >> $filename

nohup time java -jar $DSPOT_JAR -p $DSPOT_PROPERTIES $DSPOT_OPTS | tee -a $filename &
pid_dpot=$!
((pid_dpot--)) #Decremented to capture mvn command pid, otherwise it captures tee command pid

wait $pid_dpot

#copy DSpot results
cp -r $DSPOT_OUT $RESULTS_DIR

echo "Ended DSpot: `date`" >> $filename
