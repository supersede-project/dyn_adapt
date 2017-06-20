#!/bin/sh
sh ./installDependencies.sh
mvn compile assembly:single
BUILD_ID=dontKillMe nohup java -cp target/CompositionHook-maven-0.0.1-SNAPSHOT-jar-with-dependencies.jar AdaptationService > ./log/hook.log 2>&1 &
