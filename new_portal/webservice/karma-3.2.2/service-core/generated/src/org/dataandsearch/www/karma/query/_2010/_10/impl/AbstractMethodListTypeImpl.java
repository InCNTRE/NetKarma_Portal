/*
 * XML Type:  abstractMethodListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML abstractMethodListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class AbstractMethodListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType
{
    
    public AbstractMethodListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTMETHOD$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "abstractMethod");
    
    
    /**
     * Gets array of all "abstractMethod" elements
     */
    public java.lang.String[] getAbstractMethodArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ABSTRACTMETHOD$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "abstractMethod" element
     */
    public java.lang.String getAbstractMethodArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABSTRACTMETHOD$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "abstractMethod" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetAbstractMethodArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ABSTRACTMETHOD$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "abstractMethod" element
     */
    public org.apache.xmlbeans.XmlString xgetAbstractMethodArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABSTRACTMETHOD$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "abstractMethod" element
     */
    public int sizeOfAbstractMethodArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACTMETHOD$0);
        }
    }
    
    /**
     * Sets array of all "abstractMethod" element
     */
    public void setAbstractMethodArray(java.lang.String[] abstractMethodArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(abstractMethodArray, ABSTRACTMETHOD$0);
        }
    }
    
    /**
     * Sets ith "abstractMethod" element
     */
    public void setAbstractMethodArray(int i, java.lang.String abstractMethod)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABSTRACTMETHOD$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(abstractMethod);
        }
    }
    
    /**
     * Sets (as xml) array of all "abstractMethod" element
     */
    public void xsetAbstractMethodArray(org.apache.xmlbeans.XmlString[]abstractMethodArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(abstractMethodArray, ABSTRACTMETHOD$0);
        }
    }
    
    /**
     * Sets (as xml) ith "abstractMethod" element
     */
    public void xsetAbstractMethodArray(int i, org.apache.xmlbeans.XmlString abstractMethod)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABSTRACTMETHOD$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(abstractMethod);
        }
    }
    
    /**
     * Inserts the value as the ith "abstractMethod" element
     */
    public void insertAbstractMethod(int i, java.lang.String abstractMethod)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(ABSTRACTMETHOD$0, i);
            target.setStringValue(abstractMethod);
        }
    }
    
    /**
     * Appends the value as the last "abstractMethod" element
     */
    public void addAbstractMethod(java.lang.String abstractMethod)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABSTRACTMETHOD$0);
            target.setStringValue(abstractMethod);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "abstractMethod" element
     */
    public org.apache.xmlbeans.XmlString insertNewAbstractMethod(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(ABSTRACTMETHOD$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "abstractMethod" element
     */
    public org.apache.xmlbeans.XmlString addNewAbstractMethod()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABSTRACTMETHOD$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "abstractMethod" element
     */
    public void removeAbstractMethod(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACTMETHOD$0, i);
        }
    }
}
