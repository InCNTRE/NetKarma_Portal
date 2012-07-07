
#!/bin/sh
CLASSES=/home/karma/karma-3.2.2/service-core/build/classes:/home/karma/karma-3.2.2/service-core/lib/axiom-api-1.2.7.jar:/home/karma/karma-3.2.2/service-core/lib/axiom-dom-1.2.7.jar:/home/karma/karma-3.2.2/service-core/lib/axiom-impl-1.2.7.jar:/home/karma/karma-3.2.2/service-core/lib/axis2-adb-1.4.jar:/home/karma/karma-3.2.2/service-core/lib/axis2-adb-codegen-1.4.jar:/home/karma/karma-3.2.2/service-core/lib/axis2-codegen-1.4.jar:/home/karma/karma-3.2.2/service-core/lib/axis2-kernel-1.4.jar:/home/karma/karma-3.2.2/service-core/lib/axis2-xmlbeans-1.4.jar:/home/karma/karma-3.2.2/service-core/lib/backport-util-concurrent-3.1.jar:/home/karma/karma-3.2.2/service-core/lib/commons-cli-1.1.jar:/home/karma/karma-3.2.2/service-core/lib/commons-io-1.2.jar:/home/karma/karma-3.2.2/service-core/lib/commons-logging-1.1.1.jar:/home/karma/karma-3.2.2/service-core/lib/junit.jar:/home/karma/karma-3.2.2/service-core/lib/log4j-1.2.15.jar:/home/karma/karma-3.2.2/service-core/lib/mysql-connector-java-5.1.7-bin.jar:/home/karma/karma-3.2.2/service-core/lib/neethi-2.0.4.jar:/home/karma/karma-3.2.2/service-core/lib/rabbitmq-client.jar:/home/karma/karma-3.2.2/service-core/lib/rabbitmq-client-tests.jar:/home/karma/karma-3.2.2/service-core/lib/wsdl4j-1.6.2.jar:/home/karma/karma-3.2.2/service-core/lib/xmlbeans-2.3.0.jar:/home/karma/karma-3.2.2/service-core/lib/XmlSchema-1.4.2.jar:/home/karma/karma-3.2.2/service-core/build/karma-messaging.jar:/home/karma/karma-3.2.2/service-core/build/karma-types.jar


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

