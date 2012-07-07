#
# Copyright 2007 The Trustees of Indiana University
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# -----------------------------------------------------------------
#
# Project:  Karma-adaptor
# File:  provenance_collector.sh
# Description:  shell-script to demo provenance-collection for GENI 
# exp.
# -----------------------------------------------------------------
# 


#!/bin/bash

if [ $# -lt 1 ]; then
        echo "Usage: $0 -l <logfile> [-r <rulefile>]"
        echo "<rulefile> is optional, to be used when using custom rulefile"
        exit 2
fi

export CFG_FILE="$(dirname $0)/adaptor_stdenvs.cfg"

if [ ! -f "${CFG_FILE}" ]; then
  print -u2 "Configuration file ${CFG_FILE} does not exist!"
  exit 2
fi

. ${CFG_FILE}

export curdir=`pwd`

while getopts l:r: o
do 	case "$o" in
	l) export logfile="$OPTARG";;
	r) export rulefile="$OPTARG";;
	[?]) echo "Usage: $0 -l <logfile> [-r <rulefile>]"
         echo "<rulefile> is optional, to be used when using custom rulefile"
         exit 2;;
    esac
done

if [ -z "$rulefile" ]; then
	java edu.indiana.d2i.adaptor.client.KarmaAdaptor $logfile
else
	java edu.indiana.d2i.adaptor.client.KarmaAdaptor $logfile $rulefile
fi

exit 0



