/*
 * XML Type:  dataProductIDListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductIDListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML dataProductIDListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class DataProductIDListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.DataProductIDListType
{
    
    public DataProductIDListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAPRODUCTID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductID");
    
    
    /**
     * Gets array of all "dataProductID" elements
     */
    public java.lang.String[] getDataProductIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATAPRODUCTID$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "dataProductID" element
     */
    public java.lang.String getDataProductIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAPRODUCTID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "dataProductID" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetDataProductIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATAPRODUCTID$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "dataProductID" element
     */
    public org.apache.xmlbeans.XmlString xgetDataProductIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATAPRODUCTID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "dataProductID" element
     */
    public int sizeOfDataProductIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAPRODUCTID$0);
        }
    }
    
    /**
     * Sets array of all "dataProductID" element
     */
    public void setDataProductIDArray(java.lang.String[] dataProductIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(dataProductIDArray, DATAPRODUCTID$0);
        }
    }
    
    /**
     * Sets ith "dataProductID" element
     */
    public void setDataProductIDArray(int i, java.lang.String dataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAPRODUCTID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(dataProductID);
        }
    }
    
    /**
     * Sets (as xml) array of all "dataProductID" element
     */
    public void xsetDataProductIDArray(org.apache.xmlbeans.XmlString[]dataProductIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(dataProductIDArray, DATAPRODUCTID$0);
        }
    }
    
    /**
     * Sets (as xml) ith "dataProductID" element
     */
    public void xsetDataProductIDArray(int i, org.apache.xmlbeans.XmlString dataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATAPRODUCTID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(dataProductID);
        }
    }
    
    /**
     * Inserts the value as the ith "dataProductID" element
     */
    public void insertDataProductID(int i, java.lang.String dataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(DATAPRODUCTID$0, i);
            target.setStringValue(dataProductID);
        }
    }
    
    /**
     * Appends the value as the last "dataProductID" element
     */
    public void addDataProductID(java.lang.String dataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATAPRODUCTID$0);
            target.setStringValue(dataProductID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "dataProductID" element
     */
    public org.apache.xmlbeans.XmlString insertNewDataProductID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(DATAPRODUCTID$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "dataProductID" element
     */
    public org.apache.xmlbeans.XmlString addNewDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DATAPRODUCTID$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "dataProductID" element
     */
    public void removeDataProductID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAPRODUCTID$0, i);
        }
    }
}
