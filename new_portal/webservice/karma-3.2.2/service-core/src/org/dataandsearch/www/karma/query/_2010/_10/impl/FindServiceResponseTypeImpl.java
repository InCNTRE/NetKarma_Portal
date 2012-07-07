/*
 * XML Type:  findServiceResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findServiceResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindServiceResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType
{
    
    public FindServiceResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEURILIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueURIList");
    private static final javax.xml.namespace.QName SERVICEIDLIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceIDList");
    
    
    /**
     * Gets the "uniqueURIList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueURIListType getUniqueURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueURIListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueURIListType)get_store().find_element_user(UNIQUEURILIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "uniqueURIList" element
     */
    public boolean isSetUniqueURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEURILIST$0) != 0;
        }
    }
    
    /**
     * Sets the "uniqueURIList" element
     */
    public void setUniqueURIList(org.dataandsearch.www.karma.query._2010._10.UniqueURIListType uniqueURIList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueURIListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueURIListType)get_store().find_element_user(UNIQUEURILIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.UniqueURIListType)get_store().add_element_user(UNIQUEURILIST$0);
            }
            target.set(uniqueURIList);
        }
    }
    
    /**
     * Appends and returns a new empty "uniqueURIList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueURIListType addNewUniqueURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueURIListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueURIListType)get_store().add_element_user(UNIQUEURILIST$0);
            return target;
        }
    }
    
    /**
     * Unsets the "uniqueURIList" element
     */
    public void unsetUniqueURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEURILIST$0, 0);
        }
    }
    
    /**
     * Gets the "serviceIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceIDListType getServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICEIDLIST$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "serviceIDList" element
     */
    public boolean isSetServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICEIDLIST$2) != 0;
        }
    }
    
    /**
     * Sets the "serviceIDList" element
     */
    public void setServiceIDList(org.dataandsearch.www.karma.query._2010._10.ServiceIDListType serviceIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICEIDLIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICEIDLIST$2);
            }
            target.set(serviceIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceIDListType addNewServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICEIDLIST$2);
            return target;
        }
    }
    
    /**
     * Unsets the "serviceIDList" element
     */
    public void unsetServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICEIDLIST$2, 0);
        }
    }
}
