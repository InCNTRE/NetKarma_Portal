/*
 * XML Type:  abstractServiceDetailListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML abstractServiceDetailListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class AbstractServiceDetailListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType
{
    
    public AbstractServiceDetailListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTSERVICEDETAIL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "abstractServiceDetail");
    
    
    /**
     * Gets array of all "abstractServiceDetail" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail[] getAbstractServiceDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ABSTRACTSERVICEDETAIL$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail[] result = new org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "abstractServiceDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail getAbstractServiceDetailArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail)get_store().find_element_user(ABSTRACTSERVICEDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "abstractServiceDetail" element
     */
    public int sizeOfAbstractServiceDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACTSERVICEDETAIL$0);
        }
    }
    
    /**
     * Sets array of all "abstractServiceDetail" element
     */
    public void setAbstractServiceDetailArray(org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail[] abstractServiceDetailArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(abstractServiceDetailArray, ABSTRACTSERVICEDETAIL$0);
        }
    }
    
    /**
     * Sets ith "abstractServiceDetail" element
     */
    public void setAbstractServiceDetailArray(int i, org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail abstractServiceDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail)get_store().find_element_user(ABSTRACTSERVICEDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(abstractServiceDetail);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "abstractServiceDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail insertNewAbstractServiceDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail)get_store().insert_element_user(ABSTRACTSERVICEDETAIL$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "abstractServiceDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail addNewAbstractServiceDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail)get_store().add_element_user(ABSTRACTSERVICEDETAIL$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "abstractServiceDetail" element
     */
    public void removeAbstractServiceDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACTSERVICEDETAIL$0, i);
        }
    }
}
