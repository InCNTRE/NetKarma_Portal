/*
 * XML Type:  getAbstractMethodDetailRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getAbstractMethodDetailRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetAbstractMethodDetailRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType
{
    
    public GetAbstractMethodDetailRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueIDList");
    
    
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
}
