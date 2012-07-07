#!/bin/sh

function usage
{
   echo "Usage: deploy.sh <karma_client_base_dir>"

}

if [ "$1" = "" ];
then
    usage;
    exit 1
fi
KARMA_CLIENT=$1
cd $KARMA_CLIENT
mkdir bin
for i in $(ls etc/templates/core|grep template); do
script=bin/$i
script=`echo $script|sed 's/.template/.sh/g'`
echo "#!/bin/sh
JAVA_HOME=
KARMA_CLIENT=$KARMA_CLIENT
" > $script
cat etc/templates/core/$i >> $script
chmod 744 $script
done

