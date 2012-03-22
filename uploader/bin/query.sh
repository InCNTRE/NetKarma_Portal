#!/bin/sh
JAVA_HOME=/usr/java/default
KARMA_CLIENT=/home/karma/karma-3.2.2/client-core

cd $KARMA_CLIENT
function usage
{
    echo "Usage: query.sh <karma configuration file> <query xml file>"
}

if [ "$2" = "" ];
then
    usage;
    exit 1
fi
for i in $(ls lib |grep jar); do
	CLASSPATH=$CLASSPATH:$KARMA_CLIENT/lib/$i
done
for j in $(ls build/lib |grep jar); do
	CLASSPATH=$CLASSPATH:$KARMA_CLIENT/build/lib/$j
done
#echo $CLASSPATH
$JAVA_HOME/bin/java -classpath $CLASSPATH edu.indiana.dsi.karma.client.messaging.Query $1 $2
