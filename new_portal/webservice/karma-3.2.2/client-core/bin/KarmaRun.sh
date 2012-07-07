#!/bin/sh
JAVA_HOME=
KARMA_CLIENT=.

cd $KARMA_CLIENT

for i in $(ls lib |grep jar); do
	CLASSPATH=$CLASSPATH:$KARMA_CLIENT/lib/$i
done
for j in $(ls build/lib |grep jar); do
	CLASSPATH=$CLASSPATH:$KARMA_CLIENT/build/lib/$j
done
echo $CLASSPATH

while [ "$*" != "" ]
do
  args=$args' '$1
  shift
done
java -classpath $CLASSPATH $args
