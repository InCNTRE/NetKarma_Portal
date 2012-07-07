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
# File:  EntityObject.java
# Description:  interface definition for internal representation of
#   entities (users, workflows, services, and methods)
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest;

import java.util.Calendar;
import java.util.List;

import org.dataandsearch.www.karma._2010._08.AuthorshipEnumType;
import org.dataandsearch.www.karma._2010._08.EntityEnumSubtype;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 *
 */
public interface EntityObject {
    public static interface UserBehalf {
        
        public String getUserDN();
        public AuthorshipTypeEnum getAuthorshipType();
        
    }
    
    public static interface InstanceOf {    	
    	public String getInstanceOfId();
    	public String getVersion();
    	public Calendar getCreationTime();
    }
    
    public static enum EntityCategoryEnum {
        USER,
        WORKFLOW,
        SERVICE,
        METHOD;
    }
    
    public static enum EntitySubtypeEnum {
        REGULAR,
        CONTROLLER,
        PROXY;
        
        public static EntitySubtypeEnum convertFromXmlBeansEntityEnumSubtype(EntityEnumSubtype.Enum entitySubtype) {
            if (entitySubtype != null) {
                switch (entitySubtype.intValue()) {
                case EntityEnumSubtype.INT_CONTROLLER:
                    return EntitySubtypeEnum.CONTROLLER;
                case EntityEnumSubtype.INT_HUMAN_PROXY:
                    return EntitySubtypeEnum.PROXY;
                }
            }
            return EntitySubtypeEnum.REGULAR;
        }
    }

    public static enum AuthorshipTypeEnum {
        AUTHOR,
        OWNER,
        CONTRIBUTOR,
        EXECUTOR;
        
        public static AuthorshipTypeEnum convertFromXmlBeansAuthorshipType(AuthorshipEnumType.Enum authorshipType) {
            if (authorshipType != null) {
                switch (authorshipType.intValue()) {
                case AuthorshipEnumType.INT_AUTHOR:
                    return AuthorshipTypeEnum.AUTHOR;
                case AuthorshipEnumType.INT_OWNER:
                    return AuthorshipTypeEnum.OWNER;
                case AuthorshipEnumType.INT_CONTRIBUTOR:
                	return AuthorshipTypeEnum.CONTRIBUTOR;
                }
            }
            return AuthorshipTypeEnum.EXECUTOR;
        }
    }
    
    public void setAnnotations(List<Annotation> annotationList);
    public List<Annotation> getAnnotations();
    
    public EntityCategoryEnum getEntityCategory();
    public EntitySubtypeEnum getEntitySubtype();
    
    public UserBehalf getUserBehalf();
    
    public InstanceOf getInstanceOf();
}

