/*
 * XML Type:  dataTransferType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataTransferType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML dataTransferType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class DataTransferTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataTransferType
{
    
    public DataTransferTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SENDER$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "sender");
    private static final javax.xml.namespace.QName RECEIVER$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "receiver");
    private static final javax.xml.namespace.QName TRANSFERTIME$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "transferTime");
    private static final javax.xml.namespace.QName FAULT$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "fault");
    private static final javax.xml.namespace.QName RESULT$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "result");
    private static final javax.xml.namespace.QName ANNOTATIONS$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotations");
    
    
    /**
     * Gets the "sender" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType getSender()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(SENDER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "sender" element
     */
    public void setSender(org.dataandsearch.www.karma._2010._08.EntityType sender)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(SENDER$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(SENDER$0);
            }
            target.set(sender);
        }
    }
    
    /**
     * Appends and returns a new empty "sender" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType addNewSender()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(SENDER$0);
            return target;
        }
    }
    
    /**
     * Gets the "receiver" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType getReceiver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(RECEIVER$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "receiver" element
     */
    public void setReceiver(org.dataandsearch.www.karma._2010._08.EntityType receiver)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(RECEIVER$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(RECEIVER$2);
            }
            target.set(receiver);
        }
    }
    
    /**
     * Appends and returns a new empty "receiver" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType addNewReceiver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(RECEIVER$2);
            return target;
        }
    }
    
    /**
     * Gets the "transferTime" element
     */
    public java.util.Calendar getTransferTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TRANSFERTIME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "transferTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetTransferTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TRANSFERTIME$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "transferTime" element
     */
    public void setTransferTime(java.util.Calendar transferTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TRANSFERTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TRANSFERTIME$4);
            }
            target.setCalendarValue(transferTime);
        }
    }
    
    /**
     * Sets (as xml) the "transferTime" element
     */
    public void xsetTransferTime(org.apache.xmlbeans.XmlDateTime transferTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TRANSFERTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(TRANSFERTIME$4);
            }
            target.set(transferTime);
        }
    }
    
    /**
     * Gets the "fault" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType getFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(FAULT$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "fault" element
     */
    public boolean isSetFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FAULT$6) != 0;
        }
    }
    
    /**
     * Sets the "fault" element
     */
    public void setFault(org.dataandsearch.www.karma._2010._08.DataObjectType fault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(FAULT$6, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(FAULT$6);
            }
            target.set(fault);
        }
    }
    
    /**
     * Appends and returns a new empty "fault" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType addNewFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(FAULT$6);
            return target;
        }
    }
    
    /**
     * Unsets the "fault" element
     */
    public void unsetFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FAULT$6, 0);
        }
    }
    
    /**
     * Gets the "result" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType getResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(RESULT$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "result" element
     */
    public boolean isSetResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESULT$8) != 0;
        }
    }
    
    /**
     * Sets the "result" element
     */
    public void setResult(org.dataandsearch.www.karma._2010._08.DataObjectType result)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(RESULT$8, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(RESULT$8);
            }
            target.set(result);
        }
    }
    
    /**
     * Appends and returns a new empty "result" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType addNewResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(RESULT$8);
            return target;
        }
    }
    
    /**
     * Unsets the "result" element
     */
    public void unsetResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESULT$8, 0);
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
            get_store().find_all_element_users(ANNOTATIONS$10, targetList);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$10, i);
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
            return get_store().count_elements(ANNOTATIONS$10);
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
            arraySetterHelper(annotationsArray, ANNOTATIONS$10);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$10, i);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().insert_element_user(ANNOTATIONS$10, i);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().add_element_user(ANNOTATIONS$10);
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
            get_store().remove_element(ANNOTATIONS$10, i);
        }
    }
}
