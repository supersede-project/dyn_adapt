#!/bin/sh
#FIXME When launched with the Java Jar file, the ServiceCompositionEnactor does not work correctly raising an ArrayOutOfBounds.
#Investigate possible dependency issue
#java -Dserver.port=8090 -jar target/eu.supersede.dynadapt.adapter.service-1.0.0-SNAPSHOT.jar --logging.file=./log/adapter.log
mvn spring-boot:run -Drun.arguments="--server.port=8090,--logging.file=./log/adapter.log" -Dsupersede.if.properties=if.production.properties

