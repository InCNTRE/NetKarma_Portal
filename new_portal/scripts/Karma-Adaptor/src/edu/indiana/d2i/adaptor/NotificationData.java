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
# File:  NotificationData.java
# Description:  Stores the notification related data
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import java.util.Calendar;

import org.dataandsearch.netkarma.NotificationEnumType.Enum;

public class NotificationData {

	Notifications notification;
	Calendar notificationTime;
	Enum notificationType;
	
	public NotificationData(Notifications notification, 
			Enum notificationType, Calendar notificationTime){
		this.notification = notification;
		this.notificationType = notificationType;
		this.notificationTime = notificationTime;
	}
	
	public void saveActor(Actor[] actors){
		for (int i = 0; i < actors.length; i++) {
			notification.addActor(actors[i]);
		}		
	}
	
	public void saveDataBlock(DataBlock[] dataBlocks){
		for (int i = 0; i < dataBlocks.length; i++) {
			notification.addDataBlock(dataBlocks[i]);
		}		
	}
	
	public void saveAnnotation(Annotation[] annotations){
		for (int i = 0; i < annotations.length; i++) {
			notification.addAnnotation(annotations[i]);
		}		
	}

	public Notifications getNotification() {
		return notification;
	}

	public Calendar getNotificationTime() {
		return notificationTime;
	}

	public Enum getNotificationType() {
		return notificationType;
	}
}
