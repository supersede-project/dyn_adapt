#!/bin/sh
kill $(lsof -i:4567 -t) 2> /dev/null
if [ $? -eq 0 ]
then
  echo "Composition Hook shutdown"
else
  echo "Composition Hook was not running" >&2
fi


