/*
 * XML Type:  getDataProductDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getDataProductDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetDataProductDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType
{
    
    public GetDataProductDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAPRODUCTDETAILLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductDetailList");
    
    
    /**
     * Gets the "dataProductDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType getDataProductDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType)get_store().find_element_user(DATAPRODUCTDETAILLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataProductDetailList" element
     */
    public void setDataProductDetailList(org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType dataProductDetailList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType)get_store().find_element_user(DATAPRODUCTDETAILLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType)get_store().add_element_user(DATAPRODUCTDETAILLIST$0);
            }
            target.set(dataProductDetailList);
        }
    }
    
    /**
     * Appends and returns a new empty "dataProductDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType addNewDataProductDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType)get_store().add_element_user(DATAPRODUCTDETAILLIST$0);
            return target;
        }
    }
}
