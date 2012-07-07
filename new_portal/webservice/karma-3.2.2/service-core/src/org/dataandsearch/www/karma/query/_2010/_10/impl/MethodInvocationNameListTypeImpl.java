/*
 * XML Type:  methodInvocationNameListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML methodInvocationNameListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class MethodInvocationNameListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType
{
    
    public MethodInvocationNameListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METHODINVOCATIONNAME$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodInvocationName");
    
    
    /**
     * Gets array of all "methodInvocationName" elements
     */
    public java.lang.String[] getMethodInvocationNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODINVOCATIONNAME$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "methodInvocationName" element
     */
    public java.lang.String getMethodInvocationNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODINVOCATIONNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "methodInvocationName" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetMethodInvocationNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODINVOCATIONNAME$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "methodInvocationName" element
     */
    public org.apache.xmlbeans.XmlString xgetMethodInvocationNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODINVOCATIONNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "methodInvocationName" element
     */
    public int sizeOfMethodInvocationNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODINVOCATIONNAME$0);
        }
    }
    
    /**
     * Sets array of all "methodInvocationName" element
     */
    public void setMethodInvocationNameArray(java.lang.String[] methodInvocationNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodInvocationNameArray, METHODINVOCATIONNAME$0);
        }
    }
    
    /**
     * Sets ith "methodInvocationName" element
     */
    public void setMethodInvocationNameArray(int i, java.lang.String methodInvocationName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODINVOCATIONNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(methodInvocationName);
        }
    }
    
    /**
     * Sets (as xml) array of all "methodInvocationName" element
     */
    public void xsetMethodInvocationNameArray(org.apache.xmlbeans.XmlString[]methodInvocationNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodInvocationNameArray, METHODINVOCATIONNAME$0);
        }
    }
    
    /**
     * Sets (as xml) ith "methodInvocationName" element
     */
    public void xsetMethodInvocationNameArray(int i, org.apache.xmlbeans.XmlString methodInvocationName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODINVOCATIONNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(methodInvocationName);
        }
    }
    
    /**
     * Inserts the value as the ith "methodInvocationName" element
     */
    public void insertMethodInvocationName(int i, java.lang.String methodInvocationName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(METHODINVOCATIONNAME$0, i);
            target.setStringValue(methodInvocationName);
        }
    }
    
    /**
     * Appends the value as the last "methodInvocationName" element
     */
    public void addMethodInvocationName(java.lang.String methodInvocationName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODINVOCATIONNAME$0);
            target.setStringValue(methodInvocationName);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "methodInvocationName" element
     */
    public org.apache.xmlbeans.XmlString insertNewMethodInvocationName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(METHODINVOCATIONNAME$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "methodInvocationName" element
     */
    public org.apache.xmlbeans.XmlString addNewMethodInvocationName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(METHODINVOCATIONNAME$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "methodInvocationName" element
     */
    public void removeMethodInvocationName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODINVOCATIONNAME$0, i);
        }
    }
}
