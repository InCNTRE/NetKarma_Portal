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
# File:  EntityFactory.java
# Description:  A factory class that generates EntityObjects.
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest.db;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.dataandsearch.www.karma._2010._08.AddAnnotationType;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType;
import org.dataandsearch.www.karma._2010._08.AnnotableEntityType;
import org.dataandsearch.www.karma._2010._08.AnnotableFileType;
import org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
import org.dataandsearch.www.karma._2010._08.MethodInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.UserInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType;

import edu.indiana.dsi.karma.ingest.AnnotableObject;
import edu.indiana.dsi.karma.ingest.AnnotableObject.EntityCategoryEnum;
import edu.indiana.dsi.karma.ingest.Annotation;
import edu.indiana.dsi.karma.ingest.EntityObject;
import edu.indiana.dsi.karma.ingest.AnnotableObject.AnnotableObjectCategoryEnum;
import edu.indiana.dsi.karma.ingest.EntityObject.EntitySubtypeEnum;
import edu.indiana.dsi.karma.ingest.EntityObject.UserBehalf;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 *
 */
public class AnnotableObjectFactory {
    private static Logger log = Logger.getLogger(AnnotableObjectFactory.class);
    
    public static abstract class AbstractAnnotableObject implements AnnotableObject {
        /**
         * @see edu.indiana.dsi.karma.ingest.AnnotableObject#getObjectId()
         */ 
        @Override
        public abstract AnnotableObjectCategoryEnum getAnnotableObjectCategory();
    }

    public static class AnnotableEntity extends AbstractAnnotableObject {

        protected String entityID;
        protected String contextEntityID;
        protected EntityCategoryEnum entityCategory;
        
        static AnnotableEntity convertFromEntityType(AnnotableEntityType entityType) {
        	String entityId = entityType.getEntityID();
            
            String contextEntityId = null;
            if (entityType.isSetContextEntityID()) {
            	contextEntityId = entityType.getContextEntityID();
            }
            
            EntityCategoryEnum entityCategory = EntityCategoryEnum.convertFromXmlBeansEntityEnumType(entityType.getType());

            AnnotableEntity annotableEntity = new AnnotableEntity(entityId, contextEntityId, entityCategory);
            return annotableEntity;
        }
        
        static AnnotableEntity[] convertFromEntityType(AnnotableEntityType[] entityType) {
        	AnnotableEntity[] annotableEntity = new AnnotableEntity[entityType.length];
        	for (int i = 0; i < entityType.length; i++) {
        		String entityId = entityType[i].getEntityID();
                
                String contextEntityId = null;
                if (entityType[i].isSetContextEntityID()) {
                	contextEntityId = entityType[i].getContextEntityID();
                }
                
                EntityCategoryEnum entityCategory = EntityCategoryEnum.convertFromXmlBeansEntityEnumType(entityType[i].getType());

                annotableEntity[i] = new AnnotableEntity(entityId, contextEntityId, entityCategory);
			}
        	
            return annotableEntity;
        }
        
        AnnotableEntity(AnnotableEntity annotableEntity){
        	this(annotableEntity.getEntityID(), annotableEntity.getContextEntityID(), annotableEntity.getEntityCategory());
        }
        
        AnnotableEntity(String entityID, EntityCategoryEnum entityCategory) {
            this(entityID, null, entityCategory);
        }
        
        AnnotableEntity(String entityID, String contextEntityID, EntityCategoryEnum entityCategory) {
            this.entityID = entityID;
            this.contextEntityID = contextEntityID;
            this.entityCategory = entityCategory;
        }
        
        public String getContextEntityID() {
            return contextEntityID;
        }
        
        public String getEntityID() {
            return entityID;
        }               
        
        public EntityCategoryEnum getEntityCategory() {
            return entityCategory;
        }
        
		@Override
		public AnnotableObjectCategoryEnum getAnnotableObjectCategory() {
			// TODO Auto-generated method stub
			return AnnotableObjectCategoryEnum.ENTITY;
		}

    }
    
    public static class AnnotableFile extends AbstractAnnotableObject {

        protected String fileID;
        protected String ownerDN;
        protected Calendar createDate;
        
        static AnnotableFile convertFromFileType(AnnotableFileType fileType) {
        	String fileID = fileType.getFileURI();
            
            String ownerDN = null;
            if (fileType.isSetOwnerDN()) {
            	ownerDN = fileType.getOwnerDN();
            }
            
            Calendar createDate = null;
            if (fileType.isSetCreateDate()) {
            	createDate = fileType.getCreateDate();
            }
            
            AnnotableFile annotableFile = new AnnotableFile(fileID, ownerDN, createDate);
            return annotableFile;
        }
        
        static AnnotableFile[] convertFromFileType(AnnotableFileType[] fileType) {
        	AnnotableFile[] annotableFile = new AnnotableFile[fileType.length];
        	for (int i = 0; i < fileType.length; i++) {
        		String fileID = fileType[i].getFileURI();
                
                String ownerDN = null;
                if (fileType[i].isSetOwnerDN()) {
                	ownerDN = fileType[i].getOwnerDN();
                }
                
                Calendar createDate = null;
                if (fileType[i].isSetCreateDate()) {
                	createDate = fileType[i].getCreateDate();
                }
                
                annotableFile[i] = new AnnotableFile(fileID, ownerDN, createDate);
			}
        	
            return annotableFile;
        }
        
        AnnotableFile(AnnotableFile annotableFile){
        	this(annotableFile.getFileID(), annotableFile.getOwnerDN(), annotableFile.getCreateDate());
        }
        
        AnnotableFile(String fileID) {
            this(fileID, null, null);
        }
        
        AnnotableFile(String fileID, String ownerDN, Calendar createDate) {
            this.fileID = fileID;
            this.ownerDN = ownerDN;
            this.createDate = createDate;
        }

        public String getFileID() {
            return fileID;
        }
        
        public String getOwnerDN() {
            return ownerDN;
        }
        
        public Calendar getCreateDate() {
            return createDate;
        }
        
		@Override
		public AnnotableObjectCategoryEnum getAnnotableObjectCategory() {
			// TODO Auto-generated method stub
			return AnnotableObjectCategoryEnum.FILE;
		}

    }

    public static AnnotableObject convertFromXmlBeansAnnotableType(AddAnnotationType objectType) {
    	AnnotableObject annotableObject = null;
        
        if (objectType.isSetAnnotableEntity()) {
        	if (log.isTraceEnabled()) log.trace("annotableEntity information set");
        	annotableObject = AnnotableEntity.convertFromEntityType(objectType.getAnnotableEntity());
        } else if (objectType.isSetAnnotableFile()) {
            if (log.isTraceEnabled()) log.trace("annotableFile information set");
            annotableObject = AnnotableFile.convertFromFileType(objectType.getAnnotableFile());
        }
        
        return annotableObject;
    }
    
    public static AnnotableObject[] convertFromXmlBeansAnnotableType(AddMultipleObjectAnnotationType objectType) {
    	AnnotableObject[] annotableObject = null;
    	
        if (objectType.getAnnotableObjectType().equals(AnnotableObjectEnumType.ENTITY)){
        	if (log.isTraceEnabled()) log.trace("annotableEntity information set");
        	annotableObject = AnnotableEntity.convertFromEntityType(objectType.getAnnotableEntityArray());
        } else if (objectType.getAnnotableObjectType().equals(AnnotableObjectEnumType.FILE)) {
            if (log.isTraceEnabled()) log.trace("annotableFile information set");
            annotableObject = AnnotableFile.convertFromFileType(objectType.getAnnotableFileArray());
        }
        
        return annotableObject;
    }
    
    public static AnnotableEntity createAnnotableEntity(AnnotableEntity annotableEntity) {
        return new AnnotableEntity(annotableEntity);
    }
    
    public static AnnotableEntity createAnnotableEntity(String entityID, EntityCategoryEnum entityCategory) {
        return new AnnotableEntity(entityID, entityCategory);
    }
    
    public static AnnotableEntity createAnnotableEntity(String entityID, String contextEntityID, EntityCategoryEnum entityCategory) {
        return new AnnotableEntity(entityID, contextEntityID, entityCategory);
    }

    public static AnnotableFile createAnnotableFile(AnnotableFile annotableFile) {
        return new AnnotableFile(annotableFile);
    }
    
    public static AnnotableFile createAnnotableFile(String fileID) {
        return new AnnotableFile(fileID);
    }
    
    public static AnnotableFile createAnnotableFile(String fileID, String ownerDN, Calendar createDate) {
        return new AnnotableFile(fileID, ownerDN, createDate);
    }
}

