/*
 * XML Type:  methodInvocationIDListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML methodInvocationIDListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class MethodInvocationIDListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType
{
    
    public MethodInvocationIDListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METHODINVOCATIONID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodInvocationID");
    
    
    /**
     * Gets array of all "methodInvocationID" elements
     */
    public java.lang.String[] getMethodInvocationIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODINVOCATIONID$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "methodInvocationID" element
     */
    public java.lang.String getMethodInvocationIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODINVOCATIONID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "methodInvocationID" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetMethodInvocationIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODINVOCATIONID$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "methodInvocationID" element
     */
    public org.apache.xmlbeans.XmlString xgetMethodInvocationIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODINVOCATIONID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "methodInvocationID" element
     */
    public int sizeOfMethodInvocationIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODINVOCATIONID$0);
        }
    }
    
    /**
     * Sets array of all "methodInvocationID" element
     */
    public void setMethodInvocationIDArray(java.lang.String[] methodInvocationIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodInvocationIDArray, METHODINVOCATIONID$0);
        }
    }
    
    /**
     * Sets ith "methodInvocationID" element
     */
    public void setMethodInvocationIDArray(int i, java.lang.String methodInvocationID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODINVOCATIONID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(methodInvocationID);
        }
    }
    
    /**
     * Sets (as xml) array of all "methodInvocationID" element
     */
    public void xsetMethodInvocationIDArray(org.apache.xmlbeans.XmlString[]methodInvocationIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodInvocationIDArray, METHODINVOCATIONID$0);
        }
    }
    
    /**
     * Sets (as xml) ith "methodInvocationID" element
     */
    public void xsetMethodInvocationIDArray(int i, org.apache.xmlbeans.XmlString methodInvocationID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODINVOCATIONID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(methodInvocationID);
        }
    }
    
    /**
     * Inserts the value as the ith "methodInvocationID" element
     */
    public void insertMethodInvocationID(int i, java.lang.String methodInvocationID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(METHODINVOCATIONID$0, i);
            target.setStringValue(methodInvocationID);
        }
    }
    
    /**
     * Appends the value as the last "methodInvocationID" element
     */
    public void addMethodInvocationID(java.lang.String methodInvocationID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODINVOCATIONID$0);
            target.setStringValue(methodInvocationID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "methodInvocationID" element
     */
    public org.apache.xmlbeans.XmlString insertNewMethodInvocationID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(METHODINVOCATIONID$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "methodInvocationID" element
     */
    public org.apache.xmlbeans.XmlString addNewMethodInvocationID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(METHODINVOCATIONID$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "methodInvocationID" element
     */
    public void removeMethodInvocationID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODINVOCATIONID$0, i);
        }
    }
}
