/*
 * XML Type:  serviceIDListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.ServiceIDListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML serviceIDListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class ServiceIDListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.ServiceIDListType
{
    
    public ServiceIDListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceID");
    
    
    /**
     * Gets array of all "serviceID" elements
     */
    public java.lang.String[] getServiceIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SERVICEID$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "serviceID" element
     */
    public java.lang.String getServiceIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SERVICEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "serviceID" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetServiceIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SERVICEID$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "serviceID" element
     */
    public org.apache.xmlbeans.XmlString xgetServiceIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SERVICEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "serviceID" element
     */
    public int sizeOfServiceIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICEID$0);
        }
    }
    
    /**
     * Sets array of all "serviceID" element
     */
    public void setServiceIDArray(java.lang.String[] serviceIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(serviceIDArray, SERVICEID$0);
        }
    }
    
    /**
     * Sets ith "serviceID" element
     */
    public void setServiceIDArray(int i, java.lang.String serviceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SERVICEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(serviceID);
        }
    }
    
    /**
     * Sets (as xml) array of all "serviceID" element
     */
    public void xsetServiceIDArray(org.apache.xmlbeans.XmlString[]serviceIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(serviceIDArray, SERVICEID$0);
        }
    }
    
    /**
     * Sets (as xml) ith "serviceID" element
     */
    public void xsetServiceIDArray(int i, org.apache.xmlbeans.XmlString serviceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SERVICEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(serviceID);
        }
    }
    
    /**
     * Inserts the value as the ith "serviceID" element
     */
    public void insertServiceID(int i, java.lang.String serviceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(SERVICEID$0, i);
            target.setStringValue(serviceID);
        }
    }
    
    /**
     * Appends the value as the last "serviceID" element
     */
    public void addServiceID(java.lang.String serviceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SERVICEID$0);
            target.setStringValue(serviceID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "serviceID" element
     */
    public org.apache.xmlbeans.XmlString insertNewServiceID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(SERVICEID$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "serviceID" element
     */
    public org.apache.xmlbeans.XmlString addNewServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SERVICEID$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "serviceID" element
     */
    public void removeServiceID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICEID$0, i);
        }
    }
}
