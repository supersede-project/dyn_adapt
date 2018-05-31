#!/bin/sh
kill $(lsof -i:8092 -t) 2> /dev/null
if [ $? -eq 0 ]
then
  echo "Adapter shutdown"
else
  echo "Adapter was not running" >&2
fi

