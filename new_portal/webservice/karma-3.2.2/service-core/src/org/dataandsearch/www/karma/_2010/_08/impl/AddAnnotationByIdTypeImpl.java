/*
 * XML Type:  addAnnotationByIdType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML addAnnotationByIdType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class AddAnnotationByIdTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType
{
    
    public AddAnnotationByIdTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OBJECTID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "objectID");
    private static final javax.xml.namespace.QName ANNOTABLEOBJECTTYPE$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotableObjectType");
    private static final javax.xml.namespace.QName ANNOTATIONS$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotations");
    private static final javax.xml.namespace.QName ANNOTATINGTIMESTAMP$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotatingTimestamp");
    private static final javax.xml.namespace.QName NOTIFICATIONTIMESTAMP$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "notificationtimestamp");
    
    
    /**
     * Gets the "objectID" element
     */
    public long getObjectID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBJECTID$0, 0);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "objectID" element
     */
    public org.apache.xmlbeans.XmlLong xgetObjectID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(OBJECTID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "objectID" element
     */
    public void setObjectID(long objectID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBJECTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OBJECTID$0);
            }
            target.setLongValue(objectID);
        }
    }
    
    /**
     * Sets (as xml) the "objectID" element
     */
    public void xsetObjectID(org.apache.xmlbeans.XmlLong objectID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(OBJECTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_element_user(OBJECTID$0);
            }
            target.set(objectID);
        }
    }
    
    /**
     * Gets the "annotableObjectType" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType.Enum getAnnotableObjectType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANNOTABLEOBJECTTYPE$2, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "annotableObjectType" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType xgetAnnotableObjectType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType)get_store().find_element_user(ANNOTABLEOBJECTTYPE$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "annotableObjectType" element
     */
    public void setAnnotableObjectType(org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType.Enum annotableObjectType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANNOTABLEOBJECTTYPE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ANNOTABLEOBJECTTYPE$2);
            }
            target.setEnumValue(annotableObjectType);
        }
    }
    
    /**
     * Sets (as xml) the "annotableObjectType" element
     */
    public void xsetAnnotableObjectType(org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType annotableObjectType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType)get_store().find_element_user(ANNOTABLEOBJECTTYPE$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType)get_store().add_element_user(ANNOTABLEOBJECTTYPE$2);
            }
            target.set(annotableObjectType);
        }
    }
    
    /**
     * Gets array of all "annotations" elements
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType[] getAnnotationsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANNOTATIONS$4, targetList);
            org.dataandsearch.www.karma._2010._08.AnnotationType[] result = new org.dataandsearch.www.karma._2010._08.AnnotationType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType getAnnotationsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "annotations" element
     */
    public int sizeOfAnnotationsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANNOTATIONS$4);
        }
    }
    
    /**
     * Sets array of all "annotations" element
     */
    public void setAnnotationsArray(org.dataandsearch.www.karma._2010._08.AnnotationType[] annotationsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(annotationsArray, ANNOTATIONS$4);
        }
    }
    
    /**
     * Sets ith "annotations" element
     */
    public void setAnnotationsArray(int i, org.dataandsearch.www.karma._2010._08.AnnotationType annotations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(annotations);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType insertNewAnnotations(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().insert_element_user(ANNOTATIONS$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType addNewAnnotations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().add_element_user(ANNOTATIONS$4);
            return target;
        }
    }
    
    /**
     * Removes the ith "annotations" element
     */
    public void removeAnnotations(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANNOTATIONS$4, i);
        }
    }
    
    /**
     * Gets the "annotatingTimestamp" element
     */
    public java.util.Calendar getAnnotatingTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANNOTATINGTIMESTAMP$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "annotatingTimestamp" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetAnnotatingTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(ANNOTATINGTIMESTAMP$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "annotatingTimestamp" element
     */
    public boolean isSetAnnotatingTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANNOTATINGTIMESTAMP$6) != 0;
        }
    }
    
    /**
     * Sets the "annotatingTimestamp" element
     */
    public void setAnnotatingTimestamp(java.util.Calendar annotatingTimestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANNOTATINGTIMESTAMP$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ANNOTATINGTIMESTAMP$6);
            }
            target.setCalendarValue(annotatingTimestamp);
        }
    }
    
    /**
     * Sets (as xml) the "annotatingTimestamp" element
     */
    public void xsetAnnotatingTimestamp(org.apache.xmlbeans.XmlDateTime annotatingTimestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(ANNOTATINGTIMESTAMP$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(ANNOTATINGTIMESTAMP$6);
            }
            target.set(annotatingTimestamp);
        }
    }
    
    /**
     * Unsets the "annotatingTimestamp" element
     */
    public void unsetAnnotatingTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANNOTATINGTIMESTAMP$6, 0);
        }
    }
    
    /**
     * Gets the "notificationtimestamp" element
     */
    public java.util.Calendar getNotificationtimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOTIFICATIONTIMESTAMP$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "notificationtimestamp" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetNotificationtimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(NOTIFICATIONTIMESTAMP$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "notificationtimestamp" element
     */
    public void setNotificationtimestamp(java.util.Calendar notificationtimestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOTIFICATIONTIMESTAMP$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NOTIFICATIONTIMESTAMP$8);
            }
            target.setCalendarValue(notificationtimestamp);
        }
    }
    
    /**
     * Sets (as xml) the "notificationtimestamp" element
     */
    public void xsetNotificationtimestamp(org.apache.xmlbeans.XmlDateTime notificationtimestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(NOTIFICATIONTIMESTAMP$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(NOTIFICATIONTIMESTAMP$8);
            }
            target.set(notificationtimestamp);
        }
    }
}
