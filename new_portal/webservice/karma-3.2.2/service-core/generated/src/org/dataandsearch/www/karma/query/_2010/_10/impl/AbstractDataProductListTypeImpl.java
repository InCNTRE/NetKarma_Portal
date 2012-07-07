/*
 * XML Type:  abstractDataProductListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML abstractDataProductListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class AbstractDataProductListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType
{
    
    public AbstractDataProductListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTDATAPRODUCTDETAIL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "abstractDataProductDetail");
    
    
    /**
     * Gets array of all "abstractDataProductDetail" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail[] getAbstractDataProductDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ABSTRACTDATAPRODUCTDETAIL$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail[] result = new org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "abstractDataProductDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail getAbstractDataProductDetailArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail)get_store().find_element_user(ABSTRACTDATAPRODUCTDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "abstractDataProductDetail" element
     */
    public int sizeOfAbstractDataProductDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACTDATAPRODUCTDETAIL$0);
        }
    }
    
    /**
     * Sets array of all "abstractDataProductDetail" element
     */
    public void setAbstractDataProductDetailArray(org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail[] abstractDataProductDetailArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(abstractDataProductDetailArray, ABSTRACTDATAPRODUCTDETAIL$0);
        }
    }
    
    /**
     * Sets ith "abstractDataProductDetail" element
     */
    public void setAbstractDataProductDetailArray(int i, org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail abstractDataProductDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail)get_store().find_element_user(ABSTRACTDATAPRODUCTDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(abstractDataProductDetail);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "abstractDataProductDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail insertNewAbstractDataProductDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail)get_store().insert_element_user(ABSTRACTDATAPRODUCTDETAIL$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "abstractDataProductDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail addNewAbstractDataProductDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail)get_store().add_element_user(ABSTRACTDATAPRODUCTDETAIL$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "abstractDataProductDetail" element
     */
    public void removeAbstractDataProductDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACTDATAPRODUCTDETAIL$0, i);
        }
    }
}
