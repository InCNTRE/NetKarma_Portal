/*
 * XML Type:  invocationType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.InvocationType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML invocationType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class InvocationTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.InvocationType
{
    
    public InvocationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INVOKER$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "invoker");
    private static final javax.xml.namespace.QName INVOKEE$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "invokee");
    private static final javax.xml.namespace.QName INVOCATIONTIME$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "invocationTime");
    private static final javax.xml.namespace.QName PARAMS$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "params");
    private static final javax.xml.namespace.QName ANNOTATIONS$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotations");
    
    
    /**
     * Gets the "invoker" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType getInvoker()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(INVOKER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "invoker" element
     */
    public void setInvoker(org.dataandsearch.www.karma._2010._08.EntityType invoker)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(INVOKER$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(INVOKER$0);
            }
            target.set(invoker);
        }
    }
    
    /**
     * Appends and returns a new empty "invoker" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType addNewInvoker()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(INVOKER$0);
            return target;
        }
    }
    
    /**
     * Gets the "invokee" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType getInvokee()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(INVOKEE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "invokee" element
     */
    public void setInvokee(org.dataandsearch.www.karma._2010._08.EntityType invokee)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(INVOKEE$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(INVOKEE$2);
            }
            target.set(invokee);
        }
    }
    
    /**
     * Appends and returns a new empty "invokee" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType addNewInvokee()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(INVOKEE$2);
            return target;
        }
    }
    
    /**
     * Gets the "invocationTime" element
     */
    public java.util.Calendar getInvocationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INVOCATIONTIME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "invocationTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetInvocationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(INVOCATIONTIME$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "invocationTime" element
     */
    public void setInvocationTime(java.util.Calendar invocationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INVOCATIONTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INVOCATIONTIME$4);
            }
            target.setCalendarValue(invocationTime);
        }
    }
    
    /**
     * Sets (as xml) the "invocationTime" element
     */
    public void xsetInvocationTime(org.apache.xmlbeans.XmlDateTime invocationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(INVOCATIONTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(INVOCATIONTIME$4);
            }
            target.set(invocationTime);
        }
    }
    
    /**
     * Gets the "params" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType getParams()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(PARAMS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "params" element
     */
    public boolean isSetParams()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PARAMS$6) != 0;
        }
    }
    
    /**
     * Sets the "params" element
     */
    public void setParams(org.dataandsearch.www.karma._2010._08.DataObjectType params)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(PARAMS$6, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(PARAMS$6);
            }
            target.set(params);
        }
    }
    
    /**
     * Appends and returns a new empty "params" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType addNewParams()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(PARAMS$6);
            return target;
        }
    }
    
    /**
     * Unsets the "params" element
     */
    public void unsetParams()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PARAMS$6, 0);
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
            get_store().find_all_element_users(ANNOTATIONS$8, targetList);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$8, i);
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
            return get_store().count_elements(ANNOTATIONS$8);
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
            arraySetterHelper(annotationsArray, ANNOTATIONS$8);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$8, i);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().insert_element_user(ANNOTATIONS$8, i);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().add_element_user(ANNOTATIONS$8);
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
            get_store().remove_element(ANNOTATIONS$8, i);
        }
    }
}
