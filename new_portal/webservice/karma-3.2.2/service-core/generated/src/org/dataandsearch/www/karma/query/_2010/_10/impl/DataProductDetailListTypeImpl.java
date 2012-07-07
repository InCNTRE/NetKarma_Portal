/*
 * XML Type:  dataProductDetailListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML dataProductDetailListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class DataProductDetailListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType
{
    
    public DataProductDetailListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAPRODUCTDETAIL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductDetail");
    
    
    /**
     * Gets array of all "dataProductDetail" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductDetail[] getDataProductDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATAPRODUCTDETAIL$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.DataProductDetail[] result = new org.dataandsearch.www.karma.query._2010._10.DataProductDetail[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "dataProductDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductDetail getDataProductDetailArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetail)get_store().find_element_user(DATAPRODUCTDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "dataProductDetail" element
     */
    public int sizeOfDataProductDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAPRODUCTDETAIL$0);
        }
    }
    
    /**
     * Sets array of all "dataProductDetail" element
     */
    public void setDataProductDetailArray(org.dataandsearch.www.karma.query._2010._10.DataProductDetail[] dataProductDetailArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(dataProductDetailArray, DATAPRODUCTDETAIL$0);
        }
    }
    
    /**
     * Sets ith "dataProductDetail" element
     */
    public void setDataProductDetailArray(int i, org.dataandsearch.www.karma.query._2010._10.DataProductDetail dataProductDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetail)get_store().find_element_user(DATAPRODUCTDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(dataProductDetail);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "dataProductDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductDetail insertNewDataProductDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetail)get_store().insert_element_user(DATAPRODUCTDETAIL$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "dataProductDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductDetail addNewDataProductDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductDetail)get_store().add_element_user(DATAPRODUCTDETAIL$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "dataProductDetail" element
     */
    public void removeDataProductDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAPRODUCTDETAIL$0, i);
        }
    }
}
