#!/bin/sh
java -Dserver.port=8091 -jar target/eu.supersede.dynadapt.dm.optimizer-0.0.1-SNAPSHOT.war --logging.file=./log/dm-optimizer.log
