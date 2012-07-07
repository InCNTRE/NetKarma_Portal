/*
 * XML Type:  findDataProductResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findDataProductResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindDataProductResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType
{
    
    public FindDataProductResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEBLOCKIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueBlockIDList");
    private static final javax.xml.namespace.QName UNIQUEFILEURILIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueFileURIList");
    
    
    /**
     * Gets the "uniqueBlockIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueIDListType getUniqueBlockIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEBLOCKIDLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "uniqueBlockIDList" element
     */
    public boolean isSetUniqueBlockIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEBLOCKIDLIST$0) != 0;
        }
    }
    
    /**
     * Sets the "uniqueBlockIDList" element
     */
    public void setUniqueBlockIDList(org.dataandsearch.www.karma.query._2010._10.UniqueIDListType uniqueBlockIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEBLOCKIDLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEBLOCKIDLIST$0);
            }
            target.set(uniqueBlockIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "uniqueBlockIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueIDListType addNewUniqueBlockIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEBLOCKIDLIST$0);
            return target;
        }
    }
    
    /**
     * Unsets the "uniqueBlockIDList" element
     */
    public void unsetUniqueBlockIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEBLOCKIDLIST$0, 0);
        }
    }
    
    /**
     * Gets the "uniqueFileURIList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueFileListType getUniqueFileURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueFileListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueFileListType)get_store().find_element_user(UNIQUEFILEURILIST$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "uniqueFileURIList" element
     */
    public boolean isSetUniqueFileURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEFILEURILIST$2) != 0;
        }
    }
    
    /**
     * Sets the "uniqueFileURIList" element
     */
    public void setUniqueFileURIList(org.dataandsearch.www.karma.query._2010._10.UniqueFileListType uniqueFileURIList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueFileListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueFileListType)get_store().find_element_user(UNIQUEFILEURILIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.UniqueFileListType)get_store().add_element_user(UNIQUEFILEURILIST$2);
            }
            target.set(uniqueFileURIList);
        }
    }
    
    /**
     * Appends and returns a new empty "uniqueFileURIList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueFileListType addNewUniqueFileURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueFileListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueFileListType)get_store().add_element_user(UNIQUEFILEURILIST$2);
            return target;
        }
    }
    
    /**
     * Unsets the "uniqueFileURIList" element
     */
    public void unsetUniqueFileURIList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEFILEURILIST$2, 0);
        }
    }
}
