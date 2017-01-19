#!/bin/sh
kill $(lsof -i:8091 -t) 2> /dev/null
