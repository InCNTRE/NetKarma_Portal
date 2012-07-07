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
# Project: Karma-Service-core
# File:  Annotation.java
# Description:  interface for internal representation of provenance
#    annotation
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
 * @author Devarshi Ghoshal
 *
 */
public interface Annotation {
    public static enum AnnotationDefinitionScopeEnum {
        OPM_ANNOTATION,
        KARMA_ANNOTATION,
        EXTERNAL_SOURCE;
    }
    
    public String getProperty();
    public String getValue();
    public AnnotationDefinitionScopeEnum getScope();
    

}

