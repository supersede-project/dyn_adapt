#!/bin/sh
#FIXME: using java with jar raises an exception when loading Acceleo MTFL files, because not registered editor. Investigate
#classpaht execution between java and mvn
#java -Dserver.port=8091 -Dsupersede.if.properties=if.production.properties -jar target/eu.supersede.dynadapt.dm.optimizer-0.0.1-SNAPSHOT.jar --logging.file=./log/dm-optimizer.log

file="./supersede_account"
if [ -f "$file" ]
then
user=`sed '/^\#/d' $file | grep 'is.admin.user'  | tail -n 1 | cut -d "=" -f2- | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'`
pass=`sed '/^\#/d' $file | grep 'is.admin.passwd'  | tail -n 1 | cut -d "=" -f2- | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'`
else
  echo "$file not found."
fi

nohup mvn spring-boot:run -Drun.arguments="--server.port=8091,--logging.file=./log/dm-optimizer.log" -Dsupersede.if.properties=if.development.properties -Dis.admin.user=$user -Dis.admin.passwd=$pass &
