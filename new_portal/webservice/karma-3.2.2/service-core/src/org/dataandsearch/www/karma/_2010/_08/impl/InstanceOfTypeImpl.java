/*
 * XML Type:  instanceOfType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.InstanceOfType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML instanceOfType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class InstanceOfTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.InstanceOfType
{
    
    public InstanceOfTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INSTANCEOFID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "instanceOfID");
    private static final javax.xml.namespace.QName VERSION$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "version");
    private static final javax.xml.namespace.QName CREATIONTIME$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "creationTime");
    
    
    /**
     * Gets the "instanceOfID" element
     */
    public java.lang.String getInstanceOfID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INSTANCEOFID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "instanceOfID" element
     */
    public org.apache.xmlbeans.XmlString xgetInstanceOfID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INSTANCEOFID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "instanceOfID" element
     */
    public void setInstanceOfID(java.lang.String instanceOfID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INSTANCEOFID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INSTANCEOFID$0);
            }
            target.setStringValue(instanceOfID);
        }
    }
    
    /**
     * Sets (as xml) the "instanceOfID" element
     */
    public void xsetInstanceOfID(org.apache.xmlbeans.XmlString instanceOfID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INSTANCEOFID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INSTANCEOFID$0);
            }
            target.set(instanceOfID);
        }
    }
    
    /**
     * Gets the "version" element
     */
    public java.lang.String getVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "version" element
     */
    public org.apache.xmlbeans.XmlString xgetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VERSION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "version" element
     */
    public boolean isSetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VERSION$2) != 0;
        }
    }
    
    /**
     * Sets the "version" element
     */
    public void setVersion(java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VERSION$2);
            }
            target.setStringValue(version);
        }
    }
    
    /**
     * Sets (as xml) the "version" element
     */
    public void xsetVersion(org.apache.xmlbeans.XmlString version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VERSION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VERSION$2);
            }
            target.set(version);
        }
    }
    
    /**
     * Unsets the "version" element
     */
    public void unsetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VERSION$2, 0);
        }
    }
    
    /**
     * Gets the "creationTime" element
     */
    public java.util.Calendar getCreationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATIONTIME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "creationTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetCreationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATIONTIME$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "creationTime" element
     */
    public boolean isSetCreationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CREATIONTIME$4) != 0;
        }
    }
    
    /**
     * Sets the "creationTime" element
     */
    public void setCreationTime(java.util.Calendar creationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATIONTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATIONTIME$4);
            }
            target.setCalendarValue(creationTime);
        }
    }
    
    /**
     * Sets (as xml) the "creationTime" element
     */
    public void xsetCreationTime(org.apache.xmlbeans.XmlDateTime creationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATIONTIME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(CREATIONTIME$4);
            }
            target.set(creationTime);
        }
    }
    
    /**
     * Unsets the "creationTime" element
     */
    public void unsetCreationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CREATIONTIME$4, 0);
        }
    }
}
