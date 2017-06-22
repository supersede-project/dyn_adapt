#!/bin/sh
REPOSITORY=/opt/jenkins/apps/jenkins/jenkins_home/jobs/DynamicAdaptation/workspace
SPRING_APPLICATION_JSON='{"server.port":8090}' $REPOSITORY/Enactment/services/eu.supersede.dynadapt.adapter.service/target/eu.supersede.dynadapt.adapter.service-1.0.0-SNAPSHOT.jar
