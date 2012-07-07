/*
 * XML Type:  getDataProductDetailRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getDataProductDetailRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetDataProductDetailRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType
{
    
    public GetDataProductDetailRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAPRODUCTIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductIDList");
    
    
    /**
     * Gets the "dataProductIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductIDListType getDataProductIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductIDListType)get_store().find_element_user(DATAPRODUCTIDLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataProductIDList" element
     */
    public void setDataProductIDList(org.dataandsearch.www.karma.query._2010._10.DataProductIDListType dataProductIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductIDListType)get_store().find_element_user(DATAPRODUCTIDLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DataProductIDListType)get_store().add_element_user(DATAPRODUCTIDLIST$0);
            }
            target.set(dataProductIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "dataProductIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductIDListType addNewDataProductIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductIDListType)get_store().add_element_user(DATAPRODUCTIDLIST$0);
            return target;
        }
    }
}
