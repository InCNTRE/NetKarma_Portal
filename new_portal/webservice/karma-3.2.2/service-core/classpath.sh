#!/bin/sh
#
# This script sets required LOCALCLASSPATH and by default CLASSPATH 
# It must be run by source its content to modify current environment
#


LOCALCLASSPATH=.
LOCALCLASSPATH=`echo build/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
LOCALCLASSPATH=`echo lib/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/xpp3/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/xbeans/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/mylead/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/myleadtmp/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/myleadserver/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/wsnt/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/mylead_notification/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/min_lms/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/jdbc/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/namelist/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/damn/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/lms/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/lead-security/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/xutil/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/axis2/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/catalog/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/hasthi/*.jar | tr ' ' ':'`:$LOCALCLASSPATH
#LOCALCLASSPATH=`echo lib/drs/*.jar | tr ' ' ':'`:$LOCALCLASSPATH

LOCALCLASSPATH=build/classes:$LOCALCLASSPATH
CLASSPATH=$LOCALCLASSPATH
export CLASSPATH
echo $CLASSPATH

