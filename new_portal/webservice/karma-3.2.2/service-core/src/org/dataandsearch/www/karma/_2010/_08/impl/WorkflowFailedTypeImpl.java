/*
 * XML Type:  workflowFailedType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.WorkflowFailedType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML workflowFailedType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class WorkflowFailedTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.WorkflowFailedType
{
    
    public WorkflowFailedTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOW$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflow");
    private static final javax.xml.namespace.QName FAILUREMESSAGE$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "failureMessage");
    private static final javax.xml.namespace.QName FAILEDTIME$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "failedTime");
    
    
    /**
     * Gets the "workflow" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType getWorkflow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(WORKFLOW$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "workflow" element
     */
    public void setWorkflow(org.dataandsearch.www.karma._2010._08.EntityType workflow)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(WORKFLOW$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(WORKFLOW$0);
            }
            target.set(workflow);
        }
    }
    
    /**
     * Appends and returns a new empty "workflow" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType addNewWorkflow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(WORKFLOW$0);
            return target;
        }
    }
    
    /**
     * Gets the "failureMessage" element
     */
    public java.lang.String getFailureMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILUREMESSAGE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "failureMessage" element
     */
    public org.apache.xmlbeans.XmlString xgetFailureMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAILUREMESSAGE$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "failureMessage" element
     */
    public void setFailureMessage(java.lang.String failureMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILUREMESSAGE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAILUREMESSAGE$2);
            }
            target.setStringValue(failureMessage);
        }
    }
    
    /**
     * Sets (as xml) the "failureMessage" element
     */
    public void xsetFailureMessage(org.apache.xmlbeans.XmlString failureMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAILUREMESSAGE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FAILUREMESSAGE$2);
            }
            target.set(failureMessage);
        }
    }
    
    /**
     * Gets the "failedTime" element
     */
    public java.util.Calendar getFailedTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILEDTIME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "failedTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetFailedTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(FAILEDTIME$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "failedTime" element
     */
    public void setFailedTime(java.util.Calendar failedTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAILEDTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAILEDTIME$4);
            }
            target.setCalendarValue(failedTime);
        }
    }
    
    /**
     * Sets (as xml) the "failedTime" element
     */
    public void xsetFailedTime(org.apache.xmlbeans.XmlDateTime failedTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(FAILEDTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(FAILEDTIME$4);
            }
            target.set(failedTime);
        }
    }
}
