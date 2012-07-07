/*
#
# Copyright 2007 The Trustees of Indiana University
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or areed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# -----------------------------------------------------------------
#
# Project:  Karma Provenance Service
# File:  IngesterException.java
# Description:  handles exceptions for the provenance data ingest process 
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest;

/**
 * @author Yiming Sun
 *
 */
public class IngestException extends Exception {
    public IngestException() {
        super();
    }
    
    public IngestException(String message) {
        super(message);
    }
    
    public IngestException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public IngestException(Throwable cause) {
        super(cause);
    }
}

