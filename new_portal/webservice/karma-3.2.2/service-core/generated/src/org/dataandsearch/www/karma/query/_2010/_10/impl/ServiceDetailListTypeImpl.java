/*
 * XML Type:  serviceDetailListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML serviceDetailListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class ServiceDetailListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType
{
    
    public ServiceDetailListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEDETAIL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceDetail");
    
    
    /**
     * Gets array of all "serviceDetail" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceDetail[] getServiceDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SERVICEDETAIL$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.ServiceDetail[] result = new org.dataandsearch.www.karma.query._2010._10.ServiceDetail[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "serviceDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceDetail getServiceDetailArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetail)get_store().find_element_user(SERVICEDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "serviceDetail" element
     */
    public int sizeOfServiceDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICEDETAIL$0);
        }
    }
    
    /**
     * Sets array of all "serviceDetail" element
     */
    public void setServiceDetailArray(org.dataandsearch.www.karma.query._2010._10.ServiceDetail[] serviceDetailArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(serviceDetailArray, SERVICEDETAIL$0);
        }
    }
    
    /**
     * Sets ith "serviceDetail" element
     */
    public void setServiceDetailArray(int i, org.dataandsearch.www.karma.query._2010._10.ServiceDetail serviceDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetail)get_store().find_element_user(SERVICEDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(serviceDetail);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "serviceDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceDetail insertNewServiceDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetail)get_store().insert_element_user(SERVICEDETAIL$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "serviceDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceDetail addNewServiceDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetail)get_store().add_element_user(SERVICEDETAIL$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "serviceDetail" element
     */
    public void removeServiceDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICEDETAIL$0, i);
        }
    }
}
