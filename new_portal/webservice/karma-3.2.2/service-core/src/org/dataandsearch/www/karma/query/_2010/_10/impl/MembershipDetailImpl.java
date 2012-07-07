/*
 * XML Type:  membershipDetail
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.MembershipDetail
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML membershipDetail(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class MembershipDetailImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.MembershipDetail
{
    
    public MembershipDetailImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAOBJECTTYPE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataObjectType");
    private static final javax.xml.namespace.QName INSTANCEOF$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "instanceOf");
    private static final javax.xml.namespace.QName ID$4 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets the "dataObjectType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum getDataObjectType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAOBJECTTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "dataObjectType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType xgetDataObjectType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)get_store().find_element_user(DATAOBJECTTYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "dataObjectType" element
     */
    public void setDataObjectType(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum dataObjectType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAOBJECTTYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATAOBJECTTYPE$0);
            }
            target.setEnumValue(dataObjectType);
        }
    }
    
    /**
     * Sets (as xml) the "dataObjectType" element
     */
    public void xsetDataObjectType(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType dataObjectType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)get_store().find_element_user(DATAOBJECTTYPE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)get_store().add_element_user(DATAOBJECTTYPE$0);
            }
            target.set(dataObjectType);
        }
    }
    
    /**
     * Gets the "instanceOf" element
     */
    public java.lang.String getInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INSTANCEOF$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "instanceOf" element
     */
    public org.apache.xmlbeans.XmlString xgetInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INSTANCEOF$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "instanceOf" element
     */
    public boolean isSetInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INSTANCEOF$2) != 0;
        }
    }
    
    /**
     * Sets the "instanceOf" element
     */
    public void setInstanceOf(java.lang.String xinstanceOf)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INSTANCEOF$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INSTANCEOF$2);
            }
            target.setStringValue(xinstanceOf);
        }
    }
    
    /**
     * Sets (as xml) the "instanceOf" element
     */
    public void xsetInstanceOf(org.apache.xmlbeans.XmlString xinstanceOf)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INSTANCEOF$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INSTANCEOF$2);
            }
            target.set(xinstanceOf);
        }
    }
    
    /**
     * Unsets the "instanceOf" element
     */
    public void unsetInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INSTANCEOF$2, 0);
        }
    }
    
    /**
     * Gets the "id" attribute
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" attribute
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$4);
            return target;
        }
    }
    
    /**
     * Sets the "id" attribute
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$4);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" attribute
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$4);
            }
            target.set(id);
        }
    }
}
