/*
 * XML Type:  getAbstractDataProductDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getAbstractDataProductDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetAbstractDataProductDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType
{
    
    public GetAbstractDataProductDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTDATAPRODUCTLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "abstractDataProductList");
    
    
    /**
     * Gets the "abstractDataProductList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType getAbstractDataProductList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType)get_store().find_element_user(ABSTRACTDATAPRODUCTLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "abstractDataProductList" element
     */
    public void setAbstractDataProductList(org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType abstractDataProductList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType)get_store().find_element_user(ABSTRACTDATAPRODUCTLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType)get_store().add_element_user(ABSTRACTDATAPRODUCTLIST$0);
            }
            target.set(abstractDataProductList);
        }
    }
    
    /**
     * Appends and returns a new empty "abstractDataProductList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType addNewAbstractDataProductList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType)get_store().add_element_user(ABSTRACTDATAPRODUCTLIST$0);
            return target;
        }
    }
}
