/*
 * XML Type:  uniqueURIListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.UniqueURIListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML uniqueURIListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class UniqueURIListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.UniqueURIListType
{
    
    public UniqueURIListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEURI$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueURI");
    
    
    /**
     * Gets array of all "uniqueURI" elements
     */
    public java.lang.String[] getUniqueURIArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UNIQUEURI$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "uniqueURI" element
     */
    public java.lang.String getUniqueURIArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNIQUEURI$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "uniqueURI" elements
     */
    public org.apache.xmlbeans.XmlAnyURI[] xgetUniqueURIArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UNIQUEURI$0, targetList);
            org.apache.xmlbeans.XmlAnyURI[] result = new org.apache.xmlbeans.XmlAnyURI[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "uniqueURI" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetUniqueURIArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(UNIQUEURI$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlAnyURI)target;
        }
    }
    
    /**
     * Returns number of "uniqueURI" element
     */
    public int sizeOfUniqueURIArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEURI$0);
        }
    }
    
    /**
     * Sets array of all "uniqueURI" element
     */
    public void setUniqueURIArray(java.lang.String[] uniqueURIArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uniqueURIArray, UNIQUEURI$0);
        }
    }
    
    /**
     * Sets ith "uniqueURI" element
     */
    public void setUniqueURIArray(int i, java.lang.String uniqueURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNIQUEURI$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(uniqueURI);
        }
    }
    
    /**
     * Sets (as xml) array of all "uniqueURI" element
     */
    public void xsetUniqueURIArray(org.apache.xmlbeans.XmlAnyURI[]uniqueURIArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uniqueURIArray, UNIQUEURI$0);
        }
    }
    
    /**
     * Sets (as xml) ith "uniqueURI" element
     */
    public void xsetUniqueURIArray(int i, org.apache.xmlbeans.XmlAnyURI uniqueURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(UNIQUEURI$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(uniqueURI);
        }
    }
    
    /**
     * Inserts the value as the ith "uniqueURI" element
     */
    public void insertUniqueURI(int i, java.lang.String uniqueURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(UNIQUEURI$0, i);
            target.setStringValue(uniqueURI);
        }
    }
    
    /**
     * Appends the value as the last "uniqueURI" element
     */
    public void addUniqueURI(java.lang.String uniqueURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNIQUEURI$0);
            target.setStringValue(uniqueURI);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "uniqueURI" element
     */
    public org.apache.xmlbeans.XmlAnyURI insertNewUniqueURI(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(UNIQUEURI$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "uniqueURI" element
     */
    public org.apache.xmlbeans.XmlAnyURI addNewUniqueURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(UNIQUEURI$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "uniqueURI" element
     */
    public void removeUniqueURI(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEURI$0, i);
        }
    }
}
