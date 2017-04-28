#!/bin/sh
#FIXME: using java with jar raises an exception when loading Acceleo MTFL files, because not registered editor. Investigate
#classpaht execution between java and mvn
#java -Dserver.port=8091 -jar target/eu.supersede.dynadapt.dm.optimizer-0.0.1-SNAPSHOT.jar --logging.file=./log/dm-optimizer.log
mvn spring-boot:run -Drun.arguments="--server.port=8091,--logging.file=./log/dm-optimizer.log"
