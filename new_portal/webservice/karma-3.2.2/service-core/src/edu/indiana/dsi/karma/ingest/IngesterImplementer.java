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
# File:  IngesterImplementer.java
# Description:  
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


import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType;
import org.dataandsearch.www.karma._2010._08.AnnotableRelationshipEnumType;

import edu.indiana.dsi.karma.ingest.IngesterConstants.DataLifeCycleEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.EntityLifeCycleEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.InvocationTypeEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingFilterType;
import edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingStatus;
import edu.indiana.dsi.karma.ingest.NotificationSummary.InvocationDataEnum;
import edu.indiana.dsi.karma.ingest.NotificationSummary.NotificationTypeEnum;
import edu.indiana.dsi.karma.ingest.NotificationSummary.StatusEnum;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 * @author You-Wei Cheah
 *
 */
public interface IngesterImplementer<K, V> {
    

    public interface StoredRawNotification<K, V> {
        public K getInternalID();
        public V getNotification();
        public NotificationTypeEnum getNotificationType();
    }


    public void storeDataLifeCycle(NotificationSummary notificationSummary, EntityObject entity, DataObject dataObject, Calendar time, DataLifeCycleEnum stage, String dataRole, List<Annotation> annotationList) throws IngestException;

    /**
     * Store different information contained in an invocation response notification
     * @param notificationType type of the notification that called this method
     * @param invoker Entity initiates the invocation
     * @param invokee Entity being invoked
     * @param invocationType type of the invocation
     * @param time time the response generated
     * @param dataType type of the response, whether it is RESULT or FAULT
     * @param response the response data object
     * @param annotationList List of annotations
     * @throws IngestException thrown if failed to store all information
     */
    public void storeInvocationResponse(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar time, InvocationDataEnum dataType, DataObject response, List<Annotation> annotationList) throws IngestException;
    
    
    /**
     * 
     * @param notificationSummary
     * @param invoker
     * @param invokee
     * @param invocationType
     * @param transferStartTime
     * @param dataType
     * @param response
     * @param transferStatus
     * @param statusTime
     * @param transferAnnotationList
     * @throws IngestException
     */
    public void storeInvocationResponseTransferStatus(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar transferStartTime, InvocationDataEnum dataType, DataObject response, StatusEnum transferStatus, Calendar statusTime, List<Annotation> transferAnnotationList) throws IngestException;


    public void storeEntityLifeCycle(NotificationSummary notificationSummary, EntityObject entity, Calendar time, EntityLifeCycleEnum stage) throws IngestException;
    
//  Edit by You-Wei Cheah (10/10/2011) Removed params from invocationType
    public void storeInvocationStatus(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar invocationTime, StatusEnum status, Calendar statusTime, List<Annotation> annotationList) throws IngestException;    
    public void storeInvocation(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar time, List<Annotation> annotationList) throws IngestException;
    
    public void storeAddedAnnotation(NotificationSummary notificationSummary, AnnotableObject annotableObject, Calendar notificationTime, Calendar annotatingTime, List<Annotation> annotationList) throws IngestException;
    
    public void storeAddedAnnotationById(NotificationSummary notificationSummary, long objectId,  AnnotableObjectEnumType.Enum objectCategory, Calendar notificationTime, Calendar annotatingTime, List<Annotation> annotationList) throws IngestException;
    
    public void storeAddedMultipleObjectAnnotation(NotificationSummary notificationSummary, AnnotableObject[] annotableObject, Calendar notificationTime, Calendar annotatingTime, List<Annotation> annotationList) throws IngestException;
    
    public void storeAddedRelationshipAnnotationById(NotificationSummary notificationSummary, long objectId,  AnnotableRelationshipEnumType.Enum relationshipCategory, Calendar notificationTime, Calendar annotatingTime, List<Annotation> annotationList) throws IngestException;
    
    public void storeRawNotification(NotificationTypeEnum notificationType, Calendar storeTime, XmlObject xmlObject) throws IngestException;
    public List<StoredRawNotification<K, V>> retrieveUnprocessedRawNotifications(ProcessingFilterType processingFilterType, int batchLimit) throws IngestException;
    public void markRawNotifications(List<StoredRawNotification<K, V>> list, ProcessingStatus processingStatus) throws IngestException;
    public void resetUnfinishedRawNotifications() throws IngestException;

}

