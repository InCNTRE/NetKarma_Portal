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
import org.dataandsearch.www.karma._2010._08.AuthorshipEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
import org.dataandsearch.www.karma._2010._08.InstanceOfType;
import org.dataandsearch.www.karma._2010._08.MethodInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.UserInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType;

import edu.indiana.dsi.karma.ingest.Annotation;
import edu.indiana.dsi.karma.ingest.EntityObject;
import edu.indiana.dsi.karma.ingest.EntityObject.EntitySubtypeEnum;
import edu.indiana.dsi.karma.ingest.EntityObject.InstanceOf;
import edu.indiana.dsi.karma.ingest.EntityObject.UserBehalf;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 * 
 */
public class EntityFactory {
	private static Logger log = Logger.getLogger(EntityFactory.class);

	public static abstract class AbstractEntityObject implements EntityObject {

		protected EntitySubtypeEnum entitySubtype;

		/**
		 * A Factory that generates UserBehalf objects
		 * 
		 * 
		 * @author Yiming Sun
		 * @author Devarshi Ghoshal
		 * 
		 */
		public static class UserBehalfFactory {

			/**
			 * Simple implementation of UserBehalf interface
			 * 
			 * @author Yiming Sun
			 * @author Devarshi Ghoshal
			 * 
			 */
			public static class UserBehalfImpl implements UserBehalf {
				protected String userDN;
				protected AuthorshipTypeEnum authorshipType;
				/**
				 * Constructor
				 * 
				 * @param userDN
				 *            DN of the user
				 */
				UserBehalfImpl(String userDN) {
					this(userDN, null);

				}
				
				UserBehalfImpl(String userDN, AuthorshipTypeEnum authorshipType) {
					this.userDN = userDN;
					this.authorshipType = authorshipType;

				}

				/**
				 * @see edu.indiana.dsi.karma.ingest.EntityObject.UserBehalf#getUserDN()
				 */
				@Override
				public String getUserDN() {
					return userDN;
				}
				
				@Override
				public AuthorshipTypeEnum getAuthorshipType() {
					// TODO Auto-generated method stub
					return authorshipType;
				}

			}

			static UserBehalf convertFromXmlBeansUserBehalf(
					org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf xmlUserBehalf) {

				String userDN2 = xmlUserBehalf.getUserDN();
				AuthorshipTypeEnum authorshipType = AuthorshipTypeEnum.convertFromXmlBeansAuthorshipType(xmlUserBehalf.getAuthorship());

				UserBehalf userBehalf = new UserBehalfImpl(userDN2, authorshipType);
				return userBehalf;
			}

			public static UserBehalf createUserBehalf(String userDN, AuthorshipTypeEnum authorshipType) {
				UserBehalf userBehalf = new UserBehalfImpl(userDN);
				return userBehalf;
			}

		}

		public static class InstanceOfFactory {
			public static class InstanceOfImpl implements InstanceOf {
				
				protected String instanceOfId;
				protected String versionNum;
				protected Calendar creationTime;
				
				InstanceOfImpl(String instanceOfId){
					this(instanceOfId,null);
				}
				
				InstanceOfImpl(String instanceOfId, String versionNum){					
					this(instanceOfId,versionNum, null);
				}
				
				InstanceOfImpl(String instanceOfId, String versionNum, Calendar creationTime){					
					this.instanceOfId = instanceOfId;
					this.versionNum = versionNum;
					this.creationTime = creationTime;
				}

				@Override
				public String getInstanceOfId() {
					// TODO Auto-generated method stub
					return instanceOfId;
				}

				@Override
				public String getVersion() {
					// TODO Auto-generated method stub
					return versionNum;
				}

				@Override
				public Calendar getCreationTime() {
					// TODO Auto-generated method stub
					return creationTime;
				}				
			}
			static InstanceOf convertFromXmlBeansInstanceOf(InstanceOfType instanceOfType) {					
				
				String instanceOfId = instanceOfType.getInstanceOfID();
				String versionNum = null;
				if(instanceOfType.isSetVersion()){
					versionNum = instanceOfType.getVersion();
				}
				Calendar creationTime = null;
				if(instanceOfType.isSetCreationTime()){
					creationTime = instanceOfType.getCreationTime();
				}
				
				InstanceOf instanceOf = new InstanceOfImpl(instanceOfId, versionNum, creationTime);
				return instanceOf;
			}

			public static InstanceOf createInstanceOf(String instanceOfId, String versionNum, Calendar creationTime) {
				InstanceOf instanceOf = new InstanceOfImpl(instanceOfId, versionNum, creationTime);
				return instanceOf;
			}
		}

		/**
		 * @see edu.indiana.dsi.karma.ingest.EntityObject#getAnnotations()
		 */
		public abstract List<Annotation> getAnnotations();

		/**
		 * 
		 * @see edu.indiana.dsi.karma.ingest.EntityObject#setAnnotations(java.util.List)
		 */
		public abstract void setAnnotations(List<Annotation> annotationList);

		/**
		 * @see edu.indiana.dsi.karma.ingest.EntityObject#getEntityCategory()
		 */
		@Override
		public abstract EntityCategoryEnum getEntityCategory();

		/**
		 * @see edu.indiana.dsi.karma.ingest.EntityObject#getEntitySubtype()
		 */
		@Override
		public EntitySubtypeEnum getEntitySubtype() {
			return entitySubtype;
		}

		public abstract UserBehalf getUserBehalf();
		
		public abstract InstanceOf getInstanceOf();

	}

	public static class MethodEntity extends ServiceEntity {
		protected String methodID;

		static MethodEntity convertFromEntityType(EntityType entityType) {
			MethodInformationType methodInformation = entityType
					.getMethodInformation();
			List<Annotation> annotationList = AnnotationFactory
					.convert(methodInformation.getAnnotationsArray());

			EntitySubtypeEnum subType = null;
			if (entityType.isSetSubtype()) {
				subType = EntitySubtypeEnum
						.convertFromXmlBeansEntityEnumSubtype(entityType
								.getSubtype());
			}

			String methodID = methodInformation.getMethodID();
			String serviceID = methodInformation.getServiceID();
			String workflowID = methodInformation.getWorkflowID();
			String workflowNodeID = null;
			if (methodInformation.isSetWorkflowNodeID()) {
				workflowNodeID = methodInformation.getWorkflowNodeID();
			}
			int timestep = -1;
			if (methodInformation.isSetTimestep()) {
				timestep = methodInformation.getTimestep();
			}
			UserBehalf userBehalf = null;
			if (methodInformation.isSetUserBehalf()) {
				userBehalf = UserBehalfFactory
						.convertFromXmlBeansUserBehalf(methodInformation
								.getUserBehalf());
			}

			MethodEntity methodEntity = null;
			if(methodInformation.isSetInstanceOf()){
				InstanceOf instanceOf =  InstanceOfFactory.convertFromXmlBeansInstanceOf(methodInformation.getInstanceOf());
			
				methodEntity = new MethodEntity(methodID, subType,
					serviceID, workflowID, workflowNodeID, timestep, userBehalf, instanceOf);
			}
			else{
				methodEntity = new MethodEntity(methodID, subType,
					serviceID, workflowID, workflowNodeID, timestep, userBehalf);					
			}
			methodEntity.setAnnotations(annotationList);
			return methodEntity;
		}

		MethodEntity(MethodEntity methodEntity) {
			super(methodEntity);
			this.methodID = methodEntity.getMethodID();
		}

		MethodEntity(String methodID, EntitySubtypeEnum subtype,
				String serviceID) {
			this(methodID, subtype, serviceID, null, null, -1);
		}

		MethodEntity(String methodID, EntitySubtypeEnum subtype,
				String serviceID, String workflowID, String workflowNodeID,
				int timestep) {
			this(methodID, subtype, serviceID, workflowID, workflowNodeID,
					timestep, null);
		}

		MethodEntity(String methodID, EntitySubtypeEnum subtype,
				String serviceID, String workflowID, String workflowNodeID,
				int timestep, UserBehalf userBehalf) {
			this(methodID, subtype, serviceID, workflowID, workflowNodeID,
					timestep, userBehalf, null);
		}

		MethodEntity(String methodID, EntitySubtypeEnum subtype,
				String serviceID, String workflowID, String workflowNodeID,
				int timestep, UserBehalf userBehalf, InstanceOf instanceOf) {
			super(serviceID, subtype, workflowID, workflowNodeID, timestep,
					userBehalf, instanceOf);
			this.methodID = methodID;
		}

		public String getMethodID() {
			return methodID;
		}

		@Override
		public EntityCategoryEnum getEntityCategory() {
			return EntityCategoryEnum.METHOD;
		}

	}

	public static class ServiceEntity extends WorkflowEntity {
		protected String serviceID;

		static ServiceEntity convertFromEntityType(EntityType entityType) {
			ServiceInformationType serviceInformation = entityType
					.getServiceInformation();
			List<Annotation> annotationList = AnnotationFactory
					.convert(serviceInformation.getAnnotationsArray());

			EntitySubtypeEnum subType = null;
			if (entityType.isSetSubtype()) {
				subType = EntitySubtypeEnum
						.convertFromXmlBeansEntityEnumSubtype(entityType
								.getSubtype());
			}

			String serviceID = serviceInformation.getServiceID();
			String workflowID = serviceInformation.getWorkflowID();
			String workflowNodeID = null;
			if (serviceInformation.isSetWorkflowNodeID()) {
				workflowNodeID = serviceInformation.getWorkflowNodeID();
			}
			int timestep = -1;
			if (serviceInformation.isSetTimestep()) {
				timestep = serviceInformation.getTimestep();
			}
			UserBehalf userBehalf = null;
			if (serviceInformation.isSetUserBehalf()) {
				userBehalf = UserBehalfFactory
						.convertFromXmlBeansUserBehalf(serviceInformation
								.getUserBehalf());
			}
			
			ServiceEntity serviceEntity = null;
			if(serviceInformation.isSetInstanceOf()){
				InstanceOf instanceOf = InstanceOfFactory.convertFromXmlBeansInstanceOf(serviceInformation.getInstanceOf());

				serviceEntity = new ServiceEntity(serviceID, subType,
					workflowID, workflowNodeID, timestep, userBehalf, instanceOf);
			}
			else{
				serviceEntity = new ServiceEntity(serviceID, subType,
						workflowID, workflowNodeID, timestep, userBehalf);
			}
			serviceEntity.setAnnotations(annotationList);
			return serviceEntity;

		}

		ServiceEntity(ServiceEntity serviceEntity) {
			super(serviceEntity);
			this.serviceID = serviceEntity.getServiceID();
		}

		ServiceEntity(String serviceID, EntitySubtypeEnum subtype) {
			this(serviceID, subtype, null, null, -1);
		}

		ServiceEntity(String serviceID, EntitySubtypeEnum subtype,
				String workflowID, String workflowNodeID, int timestep) {
			this(serviceID, subtype, workflowID, workflowNodeID, timestep, null);
		}
		
		ServiceEntity(String serviceID, EntitySubtypeEnum subtype,
				String workflowID, String workflowNodeID, int timestep, UserBehalf userBehalf) {
			this(serviceID, subtype, workflowID, workflowNodeID, timestep, userBehalf, null);
		}

		ServiceEntity(String serviceID, EntitySubtypeEnum subtype,
				String workflowID, String workflowNodeID, int timestep,
				UserBehalf userBehalf, InstanceOf instanceOf) {
			super(workflowID, subtype, workflowNodeID, timestep, userBehalf, instanceOf);
			this.serviceID = serviceID;
		}

		public String getServiceID() {
			return serviceID;
		}

		@Override
		public EntityCategoryEnum getEntityCategory() {
			return EntityCategoryEnum.SERVICE;
		}

	}

	public static class WorkflowEntity extends AbstractEntityObject {

		protected String workflowID;
		protected String workflowNodeID;
		protected int timestep;
		protected UserBehalf userBehalf;
		protected List<Annotation> annotationList;
		protected InstanceOf instanceOf;
		
		static WorkflowEntity convertFromEntityType(EntityType entityType) {
			WorkflowInformationType workflowInformation = entityType
					.getWorkflowInformation();
			List<Annotation> annotationList = AnnotationFactory
					.convert(workflowInformation.getAnnotationsArray());

			EntitySubtypeEnum subType = null;
			if (entityType.isSetSubtype()) {
				subType = EntitySubtypeEnum
						.convertFromXmlBeansEntityEnumSubtype(entityType
								.getSubtype());
			}

			String workflowID = workflowInformation.getWorkflowID();
			String workflowNodeID = null;
			if (workflowInformation.isSetWorkflowNodeID()) {
				workflowNodeID = workflowInformation.getWorkflowNodeID();
			}
			int timestep = -1;
			if (workflowInformation.isSetTimestep()) {
				timestep = workflowInformation.getTimestep();
			}
			UserBehalf userBehalf = null;
			if (workflowInformation.isSetUserBehalf()) {
				userBehalf = UserBehalfFactory
						.convertFromXmlBeansUserBehalf(workflowInformation
								.getUserBehalf());
			}
			
			WorkflowEntity workflowEntity = null;
			if(workflowInformation.isSetInstanceOf()){
				InstanceOf instanceOf = InstanceOfFactory.convertFromXmlBeansInstanceOf(workflowInformation.getInstanceOf());

				workflowEntity = new WorkflowEntity(workflowID,
					subType, workflowNodeID, timestep, userBehalf, instanceOf);
			}
			else{
				workflowEntity = new WorkflowEntity(workflowID,
						subType, workflowNodeID, timestep, userBehalf);
			}
			workflowEntity.setAnnotations(annotationList);
			return workflowEntity;
		}

		WorkflowEntity(WorkflowEntity workflowEntity) {
			this(workflowEntity.getWorkflowID(), workflowEntity.getEntitySubtype(), 
					workflowEntity.getWorkflowNodeID(), workflowEntity.getTimestep(), 
					workflowEntity.getUserBehalf(), workflowEntity.getInstanceOf());
			setAnnotations(workflowEntity.getAnnotations());
		}

		WorkflowEntity(String workflowID, EntitySubtypeEnum subtype) {
			this(workflowID, subtype, null, -1);
		}

		WorkflowEntity(String workflowID, EntitySubtypeEnum subtype,
				String workflowNodeID, int timestep) {
			this(workflowID, subtype, workflowNodeID, timestep, null);
		}
		
		WorkflowEntity(String workflowID, EntitySubtypeEnum subtype,
				String workflowNodeID, int timestep, UserBehalf userBehalf) {
			this(workflowID, subtype, workflowNodeID, timestep, userBehalf, null);
		}

		WorkflowEntity(String workflowID, EntitySubtypeEnum subtype,
				String workflowNodeID, int timestep, UserBehalf userBehalf,
				InstanceOf instanceOf) {
			this.workflowID = workflowID;
			this.entitySubtype = subtype;
			this.workflowNodeID = workflowNodeID;
			this.timestep = timestep;
			this.userBehalf = userBehalf;
			this.instanceOf = instanceOf;
		}

		public String getWorkflowID() {
			return workflowID;
		}

		public String getWorkflowNodeID() {
			return workflowNodeID;
		}

		public void setWorkflowNodeID(String workflowNodeID) {
			this.workflowNodeID = workflowNodeID;
		}

		public int getTimestep() {
			return timestep;
		}

		public void setTimestep(int timestep) {
			this.timestep = timestep;
		}

		@Override
		public EntityCategoryEnum getEntityCategory() {
			return EntityCategoryEnum.WORKFLOW;
		}

		/**
		 * @see edu.indiana.dsi.ingest.db.AbstractEntityObject#getUserBehalf()
		 */
		@Override
		public UserBehalf getUserBehalf() {
			return userBehalf;
		}

		public void setUserBehalf(UserBehalf userBehalf) {
			this.userBehalf = userBehalf;
		}

		/**
		 * @see edu.indiana.dsi.ingest.db.AbstractEntityObject#getAnnotations()
		 */
		@Override
		public List<Annotation> getAnnotations() {
			return annotationList;
		}

		/**
		 * @see edu.indiana.dsi.ingest.db.AbstractEntityObject#setAnnotations(java.util.List)
		 */
		@Override
		public void setAnnotations(List<Annotation> annotationList) {
			this.annotationList = annotationList;
		}

		@Override
		public InstanceOf getInstanceOf() {
			// TODO Auto-generated method stub
			return instanceOf;
		}

	}

	public static class UserEntity extends AbstractEntityObject {
		protected String userDN;
		protected String fullName;
		protected String affiliation;
		protected String email;

		static UserEntity convertFromEntityType(EntityType entityType) {
			UserInformationType userInformation = entityType
					.getUserInformation();
			// List<Annotation> annotationList =
			// AnnotationImpl.convert(entityType.getAnnotationsArray());

			String userDN = userInformation.getUserDN();
			String fullName = null;
			if (userInformation.isSetFullName()) {
				fullName = userInformation.getFullName();
			}
			String affiliation = null;
			if (userInformation.isSetAffiliation()) {
				affiliation = userInformation.getAffiliation();
			}
			String email = null;
			if (userInformation.isSetEmail()) {
				email = userInformation.getEmail();
			}

			UserEntity userEntity = new UserEntity(userDN, fullName,
					affiliation, email);
			// userEntity.setAnnotations(annotationList);
			return userEntity;
		}

		UserEntity(UserEntity userEntity) {
			this(userEntity.getUserDN(), userEntity.getFullName(), userEntity
					.getAffiliation(), userEntity.getEmail());
			setAnnotations(userEntity.getAnnotations());
		}

		UserEntity(String userDN) {
			this(userDN, null, null, null);
		}

		UserEntity(String userDN, String fullName, String affiliation,
				String email) {
			this.userDN = userDN;
			this.fullName = fullName;
			this.affiliation = affiliation;
			this.email = email;
		}

		public String getUserDN() {
			return userDN;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getAffiliation() {
			return affiliation;
		}

		public void setAffiliation(String affiliation) {
			this.affiliation = affiliation;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @see edu.indiana.dsi.ingest.db.AbstractEntityObject#getEntityCategory()
		 */
		@Override
		public EntityCategoryEnum getEntityCategory() {
			return EntityCategoryEnum.USER;
		}

		/**
		 * 
		 * @see edu.indiana.dsi.ingest.db.AbstractEntityObject#getUserBehalf()
		 */
		@Override
		public UserBehalf getUserBehalf() {
			return null;
		}

		@Override
		public List<Annotation> getAnnotations() {
			return null;
		}

		@Override
		public void setAnnotations(List<Annotation> annotationList) {
			throw new UnsupportedOperationException(
					"User entity does not have annotations");
		}

		@Override
		public InstanceOf getInstanceOf() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static EntityObject convertFromXmlBeansEntityType(
			EntityType entityType) {
		EntityObject entityObject = null;

		if (entityType.isSetUserInformation()) {
			entityObject = UserEntity.convertFromEntityType(entityType);
		} else if (entityType.isSetWorkflowInformation()) {
			if (log.isTraceEnabled())
				log.trace("workflow information set");
			entityObject = WorkflowEntity.convertFromEntityType(entityType);
		} else if (entityType.isSetServiceInformation()) {
			if (log.isTraceEnabled())
				log.trace("service information set");
			entityObject = ServiceEntity.convertFromEntityType(entityType);
		} else if (entityType.isSetMethodInformation()) {
			if (log.isTraceEnabled())
				log.trace("method information set");
			entityObject = MethodEntity.convertFromEntityType(entityType);
		}

		return entityObject;
	}

	public static MethodEntity createMethodEntity(MethodEntity methodEntity) {
		return new MethodEntity(methodEntity);
	}

	public static MethodEntity createMethodEntity(String methodID,
			EntitySubtypeEnum subtype, String serviceID) {
		return new MethodEntity(methodID, subtype, serviceID);
	}

	public static MethodEntity createMethodEntity(String methodID,
			EntitySubtypeEnum subtype, String serviceID, String workflowID,
			String workflowNodeID, int timestep) {
		return new MethodEntity(methodID, subtype, serviceID, workflowID,
				workflowNodeID, timestep);
	}

	public static MethodEntity createMethodEntity(String methodID,
			EntitySubtypeEnum subtype, String serviceID, String workflowID,
			String workflowNodeID, int timestep, UserBehalf userBehalf) {
		return new MethodEntity(methodID, subtype, serviceID, workflowID,
				workflowNodeID, timestep, userBehalf);
	}

	public static ServiceEntity createServiceEntity(ServiceEntity serviceEntity) {
		return new ServiceEntity(serviceEntity);
	}

	public static ServiceEntity createServiceEntity(String serviceID,
			EntitySubtypeEnum subtype) {
		return new ServiceEntity(serviceID, subtype);
	}

	public static ServiceEntity createServiceEntity(String serviceID,
			EntitySubtypeEnum subtype, String workflowID,
			String workflowNodeID, int timestep) {
		return new ServiceEntity(serviceID, subtype, workflowID,
				workflowNodeID, timestep);
	}

	public static ServiceEntity createServiceEntity(String serviceID,
			EntitySubtypeEnum subtype, String workflowID,
			String workflowNodeID, int timestep, UserBehalf userBehalf) {
		return new ServiceEntity(serviceID, subtype, workflowID,
				workflowNodeID, timestep, userBehalf);
	}

	public static WorkflowEntity createWorkflowEntity(
			WorkflowEntity workflowEntity) {
		return new WorkflowEntity(workflowEntity);
	}

	public static WorkflowEntity createWorkflowEntity(String workflowID,
			EntitySubtypeEnum subtype) {
		return new WorkflowEntity(workflowID, subtype);
	}

	public static WorkflowEntity createWorkflowEntity(String workflowID,
			EntitySubtypeEnum subtype, String workflowNodeID, int timestep) {
		return new WorkflowEntity(workflowID, subtype, workflowNodeID, timestep);
	}

	public static WorkflowEntity createWorkflowEntity(String workflowID,
			EntitySubtypeEnum subtype, String workflowNodeID, int timestep,
			UserBehalf userBehalf) {
		return new WorkflowEntity(workflowID, subtype, workflowNodeID,
				timestep, userBehalf);
	}

	public static UserEntity createUserEntity(UserEntity userEntity) {
		return new UserEntity(userEntity);
	}

	public static UserEntity createUserEntity(String userDN) {
		return new UserEntity(userDN);
	}

	public static UserEntity createUserEntity(String userDN, String fullName,
			String affiliation, String email) {
		return new UserEntity(userDN, fullName, affiliation, email);
	}

}
