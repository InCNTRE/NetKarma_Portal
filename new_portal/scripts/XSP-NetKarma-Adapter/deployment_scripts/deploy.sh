#! /bin/bash

user=$1
hostfile="hostfile.txt"
sliceinfo_file="slice.info"
xsp_adapter_jar="netkarma-xsp-adapter.jar"
netkarma_wrapper="netkarma-wrapper.sh"
config_dir="config"
adapter_properties="xsp-adapter.properties"

while read node
do
  scp $sliceinfo_file $user@$node:
  scp $xsp_adapter_tar $user@$node:
  scp $xsp_adapter_tar $user@$node:
  scp $netkarma_wrapper $user@$node:
  ssh $user@$node "mkdir config"
  scp $config_dir/$adapter_properties $user@$node:config/
done < $hostfile
