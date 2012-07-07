/*
 * XML Type:  dataProductNameListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductNameListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML dataProductNameListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class DataProductNameListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.DataProductNameListType
{
    
    public DataProductNameListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAPRODUCTNAME$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductName");
    
    
    /**
     * Gets array of all "dataProductName" elements
     */
    public java.lang.String[] getDataProductNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATAPRODUCTNAME$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "dataProductName" element
     */
    public java.lang.String getDataProductNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAPRODUCTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "dataProductName" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetDataProductNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATAPRODUCTNAME$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "dataProductName" element
     */
    public org.apache.xmlbeans.XmlString xgetDataProductNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATAPRODUCTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "dataProductName" element
     */
    public int sizeOfDataProductNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAPRODUCTNAME$0);
        }
    }
    
    /**
     * Sets array of all "dataProductName" element
     */
    public void setDataProductNameArray(java.lang.String[] dataProductNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(dataProductNameArray, DATAPRODUCTNAME$0);
        }
    }
    
    /**
     * Sets ith "dataProductName" element
     */
    public void setDataProductNameArray(int i, java.lang.String dataProductName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAPRODUCTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(dataProductName);
        }
    }
    
    /**
     * Sets (as xml) array of all "dataProductName" element
     */
    public void xsetDataProductNameArray(org.apache.xmlbeans.XmlString[]dataProductNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(dataProductNameArray, DATAPRODUCTNAME$0);
        }
    }
    
    /**
     * Sets (as xml) ith "dataProductName" element
     */
    public void xsetDataProductNameArray(int i, org.apache.xmlbeans.XmlString dataProductName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATAPRODUCTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(dataProductName);
        }
    }
    
    /**
     * Inserts the value as the ith "dataProductName" element
     */
    public void insertDataProductName(int i, java.lang.String dataProductName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(DATAPRODUCTNAME$0, i);
            target.setStringValue(dataProductName);
        }
    }
    
    /**
     * Appends the value as the last "dataProductName" element
     */
    public void addDataProductName(java.lang.String dataProductName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATAPRODUCTNAME$0);
            target.setStringValue(dataProductName);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "dataProductName" element
     */
    public org.apache.xmlbeans.XmlString insertNewDataProductName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(DATAPRODUCTNAME$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "dataProductName" element
     */
    public org.apache.xmlbeans.XmlString addNewDataProductName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DATAPRODUCTNAME$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "dataProductName" element
     */
    public void removeDataProductName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAPRODUCTNAME$0, i);
        }
    }
}
