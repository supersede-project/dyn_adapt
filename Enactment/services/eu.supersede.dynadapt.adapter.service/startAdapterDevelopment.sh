#!/bin/sh
#FIXME When launched with the Java Jar file, the ServiceCompositionEnactor does not work correctly raising an ArrayOutOfBounds.
#Investigate possible dependency issue
#java -Dserver.port=8090 -jar target/eu.supersede.dynadapt.adapter.service-1.0.0-SNAPSHOT.jar --logging.file=./log/adapter.log

file="./supersede_account"
if [ -f "$file" ]
then
user=`sed '/^\#/d' $file | grep 'is.admin.user'  | tail -n 1 | cut -d "=" -f2- | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'`
pass=`sed '/^\#/d' $file | grep 'is.admin.passwd'  | tail -n 1 | cut -d "=" -f2- | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'`
else
  echo "$file not found."
fi

#mvn spring-boot:run -Drun.arguments="--server.port=8090,--logging.file=./log/adapter.log" -Dsupersede.if.properties=if.development.properties

nohup mvn spring-boot:run -Drun.arguments="--server.port=8090,--logging.file=./log/adapter.log" -Dsupersede.if.properties=if.development.properties -Dfg.admin.user=$user -Dfg.admin.passwd=$pass &


