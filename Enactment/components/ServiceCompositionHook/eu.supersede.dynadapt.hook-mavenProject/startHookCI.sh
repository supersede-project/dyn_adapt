#!/bin/sh
BUILD_ID=dontKillMe nohup java -jar target/CompositionHook-maven-0.0.1-SNAPSHOT-jar-with-dependencies.jar --logging.file=./log/hook.log &
