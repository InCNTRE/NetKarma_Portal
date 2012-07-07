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

import java.util.List;

import org.dataandsearch.www.karma._2010._08.EntityEnumType;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 * 
 */
public interface AnnotableObject {

	public static enum EntityCategoryEnum {
		WORKFLOW, SERVICE, METHOD;

		public static EntityCategoryEnum convertFromXmlBeansEntityEnumType(
				EntityEnumType.Enum entityType) {
			switch (entityType.intValue()) {
			case EntityEnumType.INT_WORKFLOW:
				return EntityCategoryEnum.WORKFLOW;
			case EntityEnumType.INT_SERVICE:
				return EntityCategoryEnum.SERVICE;
			case EntityEnumType.INT_METHOD:
				return EntityCategoryEnum.METHOD;
			}
			return null;
		}
	}

	public static enum AnnotableObjectCategoryEnum {
		ENTITY, FILE, REGISTRY_ENTITY;
	}

	public AnnotableObjectCategoryEnum getAnnotableObjectCategory();
}
