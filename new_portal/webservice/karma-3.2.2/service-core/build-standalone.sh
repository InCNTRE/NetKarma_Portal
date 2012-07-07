#!/bin/sh

SRC_JAVA=./src
BUILD=$(pwd)/build
LIB=$(pwd)/lib
CLASSES=$BUILD/classes
BIN=$(pwd)/bin
RETVAL=0
prog="build.sh"

###################################################################

build() {
	ant	karma.messaging
	mkdir bin

for i in $(ls $LIB |grep ".jar"); do
        CLASSES=$CLASSES:$LIB/$i
done

for i in $(ls $BUILD |grep ".jar"); do
        CLASSES=$CLASSES:$BUILD/$i
done

echo "
#!/bin/sh
CLASSES=$CLASSES
" > ./bin/KarmaServer.sh

echo '
function usage
{
        echo 
        echo "#########################################"
        echo "#            KarmaServer.sh             #"
        echo "#########################################"
        echo
        echo "$ KarmaServer.sh <properties_file>"
		echo
}

if [ "$1" = "" ];
then
    usage;
    exit 1
fi

CP=:$CLASSPATH:$CLASSES:.
java -classpath $CP  edu.indiana.dsi.karma.util.ServiceLauncher $1
' >> ./bin/KarmaServer.sh
chmod 755 ./bin/KarmaServer.sh



	
	
	return $RETVAL
}
###################################################################
clean(){
	rm -rf $BIN
	ant clean
	return $RETVAL
}
###################################################################
case "$1" in
  clean)
        clean
        ;;
  *)
        clean
        build
        RETVAL=$?
        ;;
esac

exit $RETVAL
