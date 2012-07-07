/*
 * XML Type:  uniqueIDListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.UniqueIDListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML uniqueIDListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class UniqueIDListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.UniqueIDListType
{
    
    public UniqueIDListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueID");
    
    
    /**
     * Gets array of all "uniqueID" elements
     */
    public java.lang.String[] getUniqueIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UNIQUEID$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "uniqueID" element
     */
    public java.lang.String getUniqueIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNIQUEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "uniqueID" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetUniqueIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UNIQUEID$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "uniqueID" element
     */
    public org.apache.xmlbeans.XmlString xgetUniqueIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNIQUEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "uniqueID" element
     */
    public int sizeOfUniqueIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEID$0);
        }
    }
    
    /**
     * Sets array of all "uniqueID" element
     */
    public void setUniqueIDArray(java.lang.String[] uniqueIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uniqueIDArray, UNIQUEID$0);
        }
    }
    
    /**
     * Sets ith "uniqueID" element
     */
    public void setUniqueIDArray(int i, java.lang.String uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNIQUEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(uniqueID);
        }
    }
    
    /**
     * Sets (as xml) array of all "uniqueID" element
     */
    public void xsetUniqueIDArray(org.apache.xmlbeans.XmlString[]uniqueIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uniqueIDArray, UNIQUEID$0);
        }
    }
    
    /**
     * Sets (as xml) ith "uniqueID" element
     */
    public void xsetUniqueIDArray(int i, org.apache.xmlbeans.XmlString uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNIQUEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(uniqueID);
        }
    }
    
    /**
     * Inserts the value as the ith "uniqueID" element
     */
    public void insertUniqueID(int i, java.lang.String uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(UNIQUEID$0, i);
            target.setStringValue(uniqueID);
        }
    }
    
    /**
     * Appends the value as the last "uniqueID" element
     */
    public void addUniqueID(java.lang.String uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNIQUEID$0);
            target.setStringValue(uniqueID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "uniqueID" element
     */
    public org.apache.xmlbeans.XmlString insertNewUniqueID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(UNIQUEID$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "uniqueID" element
     */
    public org.apache.xmlbeans.XmlString addNewUniqueID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNIQUEID$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "uniqueID" element
     */
    public void removeUniqueID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEID$0, i);
        }
    }
}
