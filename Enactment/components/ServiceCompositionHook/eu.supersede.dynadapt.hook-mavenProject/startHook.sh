#!/bin/sh
sh ./installDependencies.sh
mvn compile assembly:single
java -cp target/CompositionHook-maven-0.0.1-SNAPSHOT-jar-with-dependencies.jar AdaptationService --logging.file=./log/hook.log
