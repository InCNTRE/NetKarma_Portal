/*
 * XML Type:  dataTransferStatusType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataTransferStatusType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML dataTransferStatusType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class DataTransferStatusTypeImpl extends org.dataandsearch.www.karma._2010._08.impl.DataTransferTypeImpl implements org.dataandsearch.www.karma._2010._08.DataTransferStatusType
{
    
    public DataTransferStatusTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName STATUSTIME$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "statusTime");
    private static final javax.xml.namespace.QName STATUS$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "status");
    
    
    /**
     * Gets the "statusTime" element
     */
    public java.util.Calendar getStatusTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATUSTIME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "statusTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetStatusTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(STATUSTIME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "statusTime" element
     */
    public void setStatusTime(java.util.Calendar statusTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATUSTIME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STATUSTIME$0);
            }
            target.setCalendarValue(statusTime);
        }
    }
    
    /**
     * Sets (as xml) the "statusTime" element
     */
    public void xsetStatusTime(org.apache.xmlbeans.XmlDateTime statusTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(STATUSTIME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(STATUSTIME$0);
            }
            target.set(statusTime);
        }
    }
    
    /**
     * Gets the "status" element
     */
    public org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum getStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATUS$2, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "status" element
     */
    public org.dataandsearch.www.karma._2010._08.StatusEnumType xgetStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.StatusEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().find_element_user(STATUS$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "status" element
     */
    public void setStatus(org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum status)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATUS$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STATUS$2);
            }
            target.setEnumValue(status);
        }
    }
    
    /**
     * Sets (as xml) the "status" element
     */
    public void xsetStatus(org.dataandsearch.www.karma._2010._08.StatusEnumType status)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.StatusEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().find_element_user(STATUS$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().add_element_user(STATUS$2);
            }
            target.set(status);
        }
    }
}
