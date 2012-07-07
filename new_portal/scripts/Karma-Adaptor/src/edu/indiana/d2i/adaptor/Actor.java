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
# Project: Netkarma
# File:  Actor.java
# Description:  Actor type class
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import org.dataandsearch.netkarma.ActorEntityEnumSubtype;
import org.dataandsearch.netkarma.ActorEntityEnumType;
import org.dataandsearch.netkarma.ActorEnumType;

public class Actor {

	String actorId;
	ActorEnumType.Enum actorType;
	ActorEntityEnumType.Enum entityType;
	ActorEntityEnumSubtype.Enum entitySubtype;
	Annotation[] annotations;
	String[] parentIds;
	String behalfID;
	int timestep = -1;
	
	public Actor(String actorId, ActorEnumType.Enum actorType, ActorEntityEnumType.Enum entityType) {
		super();
		this.actorId = actorId;
		this.actorType = actorType;
		this.entityType = entityType;
	}
	
	public int getTimestep() {
		return timestep;
	}

	public void setTimestep(int timestep) {
		this.timestep = timestep;
	}

	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getBehalfId() {
		return behalfID;
	}
	public void setBehalfId(String behalfID) {
		this.behalfID = behalfID;
	}
	public ActorEnumType.Enum getActorType() {
		return actorType;
	}
	public void setActorType(ActorEnumType.Enum actorType) {
		this.actorType = actorType;
	}
	public ActorEntityEnumType.Enum getEntityType() {
		return entityType;
	}
	public void setEntityType(ActorEntityEnumType.Enum entityType) {
		this.entityType = entityType;
	}
	public ActorEntityEnumSubtype.Enum getEntitySubtype() {
		return entitySubtype;
	}
	public void setEntitySubtype(ActorEntityEnumSubtype.Enum entitySubtype) {
		this.entitySubtype = entitySubtype;
	}
	public Annotation[] getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Annotation[] annotations) {
		this.annotations = annotations;
	}
	public String[] getParentIds() {
		return parentIds;
	}
	public void setParentIds(String[] parentIds) {
		this.parentIds = parentIds;
	}
	
	
}
