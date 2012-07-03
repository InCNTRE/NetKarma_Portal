#! /bin/bash

if [ $# -ne 4 ]; then
  echo "usage: $0 <username> <slice.info> <xsp.log> <iperf.log>"
  exit -1
fi

user=$1
slicefile=$2
logfile=$3
iperflog=$4

echo "Starting Provenance Data processing at " `date +"%Y-%m-%d %T"`

java -jar netkarma-xsp-adapter.jar "$user" "$slicefile" "$logfile" "$iperflog"

echo "Provenance Data processing ended at " `date +"%Y-%m-%d %T"`
