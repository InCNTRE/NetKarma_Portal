/*
 * XML Type:  getServiceDetailRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getServiceDetailRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetServiceDetailRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType
{
    
    public GetServiceDetailRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEURILIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueURIList");
    private static final javax.xml.namespace.QName UNIQUEIDLIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueIDList");
    
    
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
     * Gets the "uniqueIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueIDListType getUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEIDLIST$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "uniqueIDList" element
     */
    public boolean isSetUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEIDLIST$2) != 0;
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
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEIDLIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEIDLIST$2);
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
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEIDLIST$2);
            return target;
        }
    }
    
    /**
     * Unsets the "uniqueIDList" element
     */
    public void unsetUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEIDLIST$2, 0);
        }
    }
}
