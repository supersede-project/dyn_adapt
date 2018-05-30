#!/bin/sh
#FIXME When launched with the Java Jar file, the ServiceCompositionEnactor does not work correctly raising an ArrayOutOfBounds.
#Investigate possible dependency issue

file="./supersede_account"
if [ -f "$file" ]
then
user=`sed '/^\#/d' $file | grep 'is.admin.user'  | tail -n 1 | cut -d "=" -f2- | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'`
pass=`sed '/^\#/d' $file | grep 'is.admin.passwd'  | tail -n 1 | cut -d "=" -f2- | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'`
else
  echo "$file not found."
fi

nohup mvn spring-boot:run -Drun.arguments="--server.port=8092,--logging.file=./log/adapter.log" -Dsupersede.if.properties=if.production.properties -Dfg.admin.user=$user -Dfg.admin.passwd=$pass &

