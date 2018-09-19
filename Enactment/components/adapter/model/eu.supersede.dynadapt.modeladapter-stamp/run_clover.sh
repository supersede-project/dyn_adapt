#!/bin/sh
mvn -f pom_clover.xml clean clover:setup test clover:aggregate clover:clover

#See results at ./target/site/clover/index.html
