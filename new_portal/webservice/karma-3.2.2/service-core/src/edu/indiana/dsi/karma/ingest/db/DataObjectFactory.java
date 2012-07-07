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
# File:  DataObjectFactory.java
# Description:  Factory for data objects
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest.db;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlOptions;
import org.dataandsearch.www.karma._2010._08.CollectionType;
import org.dataandsearch.www.karma._2010._08.DataObjectType;
import org.dataandsearch.www.karma._2010._08.FileType;

import edu.indiana.dsi.karma.ingest.Annotation;
import edu.indiana.dsi.karma.ingest.DataObject;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 *
 */
public class DataObjectFactory {
    
    protected static final XmlOptions PRETTY_PRINT_OPTS = new XmlOptions().setSavePrettyPrint();

    public static DataObject convertFromXmlBeansDataObjectType(DataObjectType dataObjectBean) {
        DataObject dataObject = null;
        if (dataObjectBean != null) {
            
            List<Annotation> annotationList = AnnotationFactory.convert(dataObjectBean.getAnnotationsArray());
            
            if (dataObjectBean.isSetBlock()) {
                String xmlText = dataObjectBean.getBlock().getBlockContent().xmlText(PRETTY_PRINT_OPTS);
                BlockObject blockObject = new BlockObject(xmlText, annotationList);
                
                dataObject = blockObject;
                
            } else if (dataObjectBean.isSetFile()) {
                FileType fileType = dataObjectBean.getFile();
                FileObject fileObject = new FileObject(fileType.getFileURI(), annotationList);
                
                if (fileType.isSetCreateDate()) {
                    Calendar createDate = fileType.getCreateDate();
                    fileObject.setCreateTime(createDate.getTimeInMillis());
                }
                
                if (fileType.isSetMd5Sum()) {
                    fileObject.setMD5Sum(fileType.getMd5Sum());
                }
                
                if (fileType.isSetObjectName()) {
                    fileObject.setName(fileType.getObjectName());
                }
                
                if (fileType.isSetOwnerDN()) {
                    fileObject.setOwnerDN(fileType.getOwnerDN());
                }
                
                if (fileType.isSetSize()) {
                    fileObject.setSize(fileType.getSize());
                }
                
                dataObject = fileObject;
            } else if (dataObjectBean.isSetCollection()) {
                CollectionType collectionType = dataObjectBean.getCollection();
                
                String collectionURI = collectionType.getCollectionURI();
                
                DataObjectType[] membersArray = collectionType.getMembersArray();
            
                CollectionObject collectionObject = new CollectionObject(collectionURI, annotationList);
                for (DataObjectType member : membersArray) {
                    DataObject memberDataObject = convertFromXmlBeansDataObjectType(member);
                    collectionObject.addChild(memberDataObject);
                }
                dataObject = collectionObject;
            }
            
        }
        return dataObject;

    }


    public static abstract class AbstractDataObject implements DataObject {
        
        protected List<Annotation> annotationList;
        //protected DataObjectEnum type;
        
        protected AbstractDataObject(List<Annotation> annotationList){
            this.annotationList = annotationList;
        }
        
        /**
         * @see edu.indiana.dsi.karma.ingest.DataObject#getAnnotations()
         */
        @Override
        public List<Annotation> getAnnotations() {
            return annotationList;
        }

        /**
         * @see edu.indiana.dsi.karma.ingest.DataObject#getDataObjectType()
         */
        @Override
        public abstract DataObjectEnum getDataObjectType();
        
        /**
         * @see edu.indiana.dsi.karma.ingest.DataObject#setAnnotations(java.util.List)
         */
        @Override
        public void setAnnotations(List<Annotation> annotationList) {
            this.annotationList = annotationList;
        }



}

    public static class BlockObject extends AbstractDataObject {

//      private static final String UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE = "A BlockObject cannot have children";

      private static final Logger log = Logger.getLogger(BlockObject.class);
      private String content;
      private String md5sum;

      
      /**
       * Calculate MD5 Checksum of a String
       * @param content String whose MD5 to be calculated
       * @return MD5 checksum of the String, as a hex string
       * @throws NoSuchAlgorithmException if the JVM does not support MD5
       * 
       * @author Yiming Sun
       */
      protected String calculateMD5(String content) throws NoSuchAlgorithmException {
          MessageDigest messageDigest = MessageDigest.getInstance("MD5");
          messageDigest.update(content.getBytes());
          byte[] digest = messageDigest.digest();
          BigInteger bigInteger = new BigInteger(digest);
          String md5Sum = bigInteger.toString(16);
          return md5Sum;
      }

      BlockObject(String content, List<Annotation> annotationList) {
          super(annotationList);
          this.content = content;
          try {
              md5sum = calculateMD5(this.content);
          } catch (NoSuchAlgorithmException e) {
              md5sum = null;
              log.warn("Unable to calculate MD5 on block content", e);
          }
      }


      /**
       * @see edu.indiana.dsi.karma.ingest.DataObject#getDataObjectType()
       */
      @Override
      public DataObjectEnum getDataObjectType() {
          return DataObjectEnum.BLOCK;
      }

      public String getBlockContent() {
          return content;
      }
      
      public String getMD5() {
          return md5sum;
      }
  }

    public static class CollectionObject extends AbstractDataObject {

        private String collectionURI;
        private List<DataObject> children;
        
        CollectionObject(String collectionURI, List<Annotation> annotationList) {
            super(annotationList);
            this.collectionURI = collectionURI;
            children = new ArrayList<DataObject>();
        }

        public void addChild(DataObject dataObject) {
            children.add(dataObject);
        }

        public List<DataObject> getChildren() {
            return children;
        }

        public int getChildrenCount() {
            return children.size();
        }

        /**
         * @see edu.indiana.dsi.karma.ingest.DataObject#getDataObjectType()
         */
        @Override
        public DataObjectEnum getDataObjectType() {
            return DataObjectEnum.COLLECTION;
        }

        public String getCollectionURI() {
            return collectionURI;
        }
    }
  
    public static class FileObject extends AbstractDataObject {

        private String fileURI;
        private String ownerDN;
        private long createTime;
        private long size;
        private String md5sum;
        private String name;

        FileObject(String fileURI, List<Annotation> annotationList) {
            super(annotationList);
            this.fileURI = fileURI;
            this.ownerDN = null;
            this.createTime = -1;
            this.size = -1;
            this.md5sum = null;
            this.name = null;
            
        }


        /**
         * @see edu.indiana.dsi.karma.ingest.DataObject#getDataObjectType()
         */
        @Override
        public DataObjectEnum getDataObjectType() {
            return DataObjectEnum.FILE;
        }
        public String getFileURI() {
            return fileURI;
        }
        public void setOwnerDN(String ownerDN) {
            this.ownerDN = ownerDN;
        }
        
        public String getOwnerDN() {
            return ownerDN;
        }
        
        public void setCreateTime(long timestamp) {
            this.createTime = timestamp;
        }
        
        public long getCreateTime() {
            return createTime;
        }
        
        public void setSize(long size) {
            this.size = size;
        }
        
        public long getSize() {
            return size;
        }
        
        public void setMD5Sum(String md5sum) {
            this.md5sum = md5sum;
        }
        
        public String getMD5Sum() {
            return md5sum;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
    }

    public static BlockObject createBlockObject(String content, List<Annotation> annotationList) {
        BlockObject blockObject = new BlockObject(content, annotationList);
        return blockObject;
    }

    public static CollectionObject createCollectionObject(String collectionURI, List<Annotation> annotationList) {
        CollectionObject collectionObject = new CollectionObject(collectionURI, annotationList);
        return collectionObject;
    }
    
    public static FileObject createFileObject(String fileURI, List<Annotation> annotationList) {
        FileObject fileObject = new FileObject(fileURI, annotationList);
        return fileObject;
    }
}


