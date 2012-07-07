/*
 * XML Type:  dataProductTypeListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML dataProductTypeListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class DataProductTypeListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType
{
    
    public DataProductTypeListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAPRODUCTTYPE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductType");
    
    
    /**
     * Gets array of all "dataProductType" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum[] getDataProductTypeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATAPRODUCTTYPE$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum[] result = new org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum)((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getEnumValue();
            return result;
        }
    }
    
    /**
     * Gets ith "dataProductType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum getDataProductTypeArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAPRODUCTTYPE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "dataProductType" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType[] xgetDataProductTypeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATAPRODUCTTYPE$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType[] result = new org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "dataProductType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType xgetDataProductTypeArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)get_store().find_element_user(DATAPRODUCTTYPE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)target;
        }
    }
    
    /**
     * Returns number of "dataProductType" element
     */
    public int sizeOfDataProductTypeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAPRODUCTTYPE$0);
        }
    }
    
    /**
     * Sets array of all "dataProductType" element
     */
    public void setDataProductTypeArray(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum[] dataProductTypeArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(dataProductTypeArray, DATAPRODUCTTYPE$0);
        }
    }
    
    /**
     * Sets ith "dataProductType" element
     */
    public void setDataProductTypeArray(int i, org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum dataProductType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAPRODUCTTYPE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setEnumValue(dataProductType);
        }
    }
    
    /**
     * Sets (as xml) array of all "dataProductType" element
     */
    public void xsetDataProductTypeArray(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType[]dataProductTypeArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(dataProductTypeArray, DATAPRODUCTTYPE$0);
        }
    }
    
    /**
     * Sets (as xml) ith "dataProductType" element
     */
    public void xsetDataProductTypeArray(int i, org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType dataProductType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)get_store().find_element_user(DATAPRODUCTTYPE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(dataProductType);
        }
    }
    
    /**
     * Inserts the value as the ith "dataProductType" element
     */
    public void insertDataProductType(int i, org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum dataProductType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(DATAPRODUCTTYPE$0, i);
            target.setEnumValue(dataProductType);
        }
    }
    
    /**
     * Appends the value as the last "dataProductType" element
     */
    public void addDataProductType(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum dataProductType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATAPRODUCTTYPE$0);
            target.setEnumValue(dataProductType);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "dataProductType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType insertNewDataProductType(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)get_store().insert_element_user(DATAPRODUCTTYPE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "dataProductType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType addNewDataProductType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType)get_store().add_element_user(DATAPRODUCTTYPE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "dataProductType" element
     */
    public void removeDataProductType(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAPRODUCTTYPE$0, i);
        }
    }
}
