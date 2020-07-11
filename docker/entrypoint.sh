#!/bin/bash
set -x

# Run tomcat if the first argument is run otherwise try to run whatever the argument is a command
if [ "$1" = 'run' ]; then
  echo "run tomcat"
  exec catalina.sh "$@"
else
  exec "$@"
fi