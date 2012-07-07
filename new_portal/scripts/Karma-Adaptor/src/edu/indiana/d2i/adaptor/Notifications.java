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
# File:  Notifications.java
# Description:  Save a notification
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import java.util.Iterator;
import java.util.Vector;

public class Notifications {
	/**
	 * String notificationId; -- removed
	 * Vector<Actor> actors;
	 * Vector<DataBlock> dataBlocks;
	 * Vector<Annotation> annotations;
	 * 
	 * @setters : for initially setting the values of objects
	 * @getters : for getting the values of the objects
	 * @appenders : for appending any additional info w.r.t. a specific notificationId
	 * 				(this is because notification info. can be present in multiple lines) 
	 */
	
	public static final int ACTOR_TYPE = 1;
	public static final int DATABLOCK_TYPE = 2;
	public static final int ANNOTATION_TYPE = 3;
	
	private Vector<Actor> actors;
	private Vector<DataBlock> dataBlocks;
	private Vector<Annotation> annotations;
	
	/*
	public Notifications(int notificationId){
		this.notificationId = notificationId;
	}	

	public int getNotificationId(){
		return notificationId;
	}
	*/
	
	public Notifications() {
		super();
		this.actors = new Vector<Actor>();
		this.dataBlocks = new Vector<DataBlock>();
		this.annotations = new Vector<Annotation>();
	}

	public Vector<Actor> getActors() {
		return actors;
	}

	public void setActors(Vector<Actor> actors) {
		this.actors = actors;
	}

	public Vector<DataBlock> getDataBlocks() {
		return dataBlocks;
	}

	public void setDataBlocks(Vector<DataBlock> dataBlocks) {
		this.dataBlocks = dataBlocks;
	}

	public Vector<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Vector<Annotation> annotations) {
		this.annotations = annotations;
	}
	
	public Actor getActorAt(int index) {
		return actors.get(index);
	}

	public void addActor(Actor actor) {
		actors.add(actor);
	}

	public DataBlock getDataBlockAt(int index) {
		return dataBlocks.get(index);
	}

	public void addDataBlock(DataBlock dataBlock) {
		dataBlocks.add(dataBlock);
	}

	public Annotation getAnnotationAt(int index) {
		return annotations.get(index);
	}

	public void addAnnotation(Annotation annotation) {
		annotations.add(annotation);
	}
	
	public void appendActors(Vector<Actor> actors){
		Iterator<Actor> iterator = actors.iterator();
		while(iterator.hasNext()){
			this.actors.add(iterator.next());
		}
		/*for (int i = 0; i < actors.size(); i++) {
			this.actors.add(actors.get(i));
		}*/
	}
	
	public void appendDataBlocks(Vector<DataBlock> dataBlocks){
		Iterator<DataBlock> iterator = dataBlocks.iterator();
		while(iterator.hasNext()){
			this.dataBlocks.add(iterator.next());
		}
	}
	
	public void appendAnnotations(Vector<Annotation> annotations){
		Iterator<Annotation> iterator = annotations.iterator();
		while(iterator.hasNext()){
			this.annotations.add(iterator.next());
		}
	}
}
