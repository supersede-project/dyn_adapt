#!/bin/sh
kill -9 $(lsof -i:8090 -t) 2> /dev/null
