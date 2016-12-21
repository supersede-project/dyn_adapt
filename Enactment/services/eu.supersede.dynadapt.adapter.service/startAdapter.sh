#!/bin/sh
java -Dserver.port=8090 -jar target/eu.supersede.dynadapt.adapter.service-1.0.0-SNAPSHOT.jar --logging.file=./log/adapter.log
