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
# File:  DataObject.java
# Description:  interface definition for internal representation of
#   data objects (files, blocks, and collections)
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest;

import java.util.List;

/**
 * @author Yiming Sun
 *
 */
public interface DataObject {

    public static enum DataObjectEnum {
        FILE,
        COLLECTION,
        BLOCK;
    }
    
    public void setAnnotations(List<Annotation> annotationList);
    public List<Annotation> getAnnotations();

//    protected String parentID;
    
    public DataObjectEnum getDataObjectType();
//    public abstract int getChildrenCount();
//    public abstract void addChild(DataObject dataObject);
//    public abstract List<DataObject> getChildren();
    
//    public void setParentID(String uri) {
//        this.parentID = uri;
//    }
//    
//    public String getParentID() {
//        return parentID;
//    }

}

