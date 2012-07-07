/*
 * XML Type:  annotableEntityType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AnnotableEntityType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML annotableEntityType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class AnnotableEntityTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.AnnotableEntityType
{
    
    public AnnotableEntityTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENTITYID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "entityID");
    private static final javax.xml.namespace.QName CONTEXTENTITYID$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "contextEntityID");
    private static final javax.xml.namespace.QName TYPE$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "type");
    
    
    /**
     * Gets the "entityID" element
     */
    public java.lang.String getEntityID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENTITYID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "entityID" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetEntityID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(ENTITYID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "entityID" element
     */
    public void setEntityID(java.lang.String entityID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENTITYID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENTITYID$0);
            }
            target.setStringValue(entityID);
        }
    }
    
    /**
     * Sets (as xml) the "entityID" element
     */
    public void xsetEntityID(org.apache.xmlbeans.XmlAnyURI entityID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(ENTITYID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(ENTITYID$0);
            }
            target.set(entityID);
        }
    }
    
    /**
     * Gets the "contextEntityID" element
     */
    public java.lang.String getContextEntityID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTEXTENTITYID$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "contextEntityID" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetContextEntityID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(CONTEXTENTITYID$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "contextEntityID" element
     */
    public boolean isSetContextEntityID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTEXTENTITYID$2) != 0;
        }
    }
    
    /**
     * Sets the "contextEntityID" element
     */
    public void setContextEntityID(java.lang.String contextEntityID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTEXTENTITYID$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTEXTENTITYID$2);
            }
            target.setStringValue(contextEntityID);
        }
    }
    
    /**
     * Sets (as xml) the "contextEntityID" element
     */
    public void xsetContextEntityID(org.apache.xmlbeans.XmlAnyURI contextEntityID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(CONTEXTENTITYID$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(CONTEXTENTITYID$2);
            }
            target.set(contextEntityID);
        }
    }
    
    /**
     * Unsets the "contextEntityID" element
     */
    public void unsetContextEntityID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTEXTENTITYID$2, 0);
        }
    }
    
    /**
     * Gets the "type" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "type" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityEnumType xgetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityEnumType)get_store().find_element_user(TYPE$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "type" element
     */
    public void setType(org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$4);
            }
            target.setEnumValue(type);
        }
    }
    
    /**
     * Sets (as xml) the "type" element
     */
    public void xsetType(org.dataandsearch.www.karma._2010._08.EntityEnumType type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityEnumType)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityEnumType)get_store().add_element_user(TYPE$4);
            }
            target.set(type);
        }
    }
}
