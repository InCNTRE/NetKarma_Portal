#!/bin/sh

PATH_TO_PROPERTIES=/Users/yuanluo/WorkZone/workspace/Karma-Service/config/properties_file.properties

umask 022

#
# You can set JAVA_HOME to point ot JDK 1.5 
# or shell will try to deterine java location using which
#

JAVA_HOME=${JAVA_HOME}

# 
# No need to modify anything after this line.
# --------------------------------------------------------------------


if [ -z "$JAVA_HOME" ] ; then
  JAVA=`/usr/bin/which java`
  if [ -z "$JAVA" ] ; then
    echo "Cannot find JAVA. Please set your PATH."
    exit 1
  fi
  JAVA_BIN=`dirname $JAVA`
  JAVA_HOME=$JAVA_BIN/..
else
  JAVA=$JAVA_HOME/bin/java
fi

echo "JAVA= $JAVA"

if [ ! "`$JAVA -version 2>&1 | egrep "\ 1\.[456789].*"`" ]; then 
    echo Required 1.4 verion of JDK: can not use $JAVA
    echo Current version is:
    $JAVA -version
    exit 1
fi 

JAVA_OPTS=""

#echo set required LOCALCLASSPATH
LOCALCLASSPATH=`/bin/sh $PWD/classpath.sh run`

MY_JAVA="$JAVA $JAVA_OPTS $JAVA_DEBUG_OPTS -cp $LOCALCLASSPATH"


#if [ -z "$1" ] ; then
#   echo Please specify test name.
#   exit 1
#fi

NAME=$1
shift


if [ "$NAME" = "karma-rabbit" ] ; then
  CMD="$MY_JAVA edu.indiana.dsi.karma.util.ServiceLauncher $PATH_TO_PROPERTIES"
  $CMD

elif [ "$NAME" = "help" ] ; then
  echo "Use the following command to launch Karma Service with rabbitMQ receiver"
  echo "./run.sh karma-rabbit"
  
else
  echo "Use the following command to see help information"
  echo "./run.sh help"
fi


