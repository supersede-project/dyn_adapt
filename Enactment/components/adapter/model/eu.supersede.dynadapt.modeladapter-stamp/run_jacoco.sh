#!/bin/sh
mvn -f pom_jacoco.xml clean test

#See results at ./target/jacoco-ut/index.html
