/*
 * XML Type:  findAbstractServiceResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findAbstractServiceResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindAbstractServiceResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType
{
    
    public FindAbstractServiceResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueIDList");
    private static final javax.xml.namespace.QName SERVICENAMELIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceNameList");
    
    
    /**
     * Gets the "uniqueIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueIDListType getUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEIDLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "uniqueIDList" element
     */
    public void setUniqueIDList(org.dataandsearch.www.karma.query._2010._10.UniqueIDListType uniqueIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEIDLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEIDLIST$0);
            }
            target.set(uniqueIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "uniqueIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueIDListType addNewUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEIDLIST$0);
            return target;
        }
    }
    
    /**
     * Gets the "serviceNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceIDListType getServiceNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICENAMELIST$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "serviceNameList" element
     */
    public void setServiceNameList(org.dataandsearch.www.karma.query._2010._10.ServiceIDListType serviceNameList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICENAMELIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICENAMELIST$2);
            }
            target.set(serviceNameList);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceIDListType addNewServiceNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICENAMELIST$2);
            return target;
        }
    }
}
