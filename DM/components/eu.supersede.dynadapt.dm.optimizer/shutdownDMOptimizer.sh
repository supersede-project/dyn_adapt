#!/bin/sh
kill $(lsof -i:8091 -t) 2> /dev/null
if [ $? -eq 0 ]
then
  echo "Optimizer shutdown"
else
  echo "Optimizer was not running" >&2
fi
