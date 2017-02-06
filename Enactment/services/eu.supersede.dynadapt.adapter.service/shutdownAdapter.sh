#!/bin/sh
kill $(lsof -i:8090 -t) 2> /dev/null
