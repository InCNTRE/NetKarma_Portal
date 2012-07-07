/*
 * XML Type:  methodNameListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.MethodNameListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML methodNameListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class MethodNameListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.MethodNameListType
{
    
    public MethodNameListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METHODNAME$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodName");
    
    
    /**
     * Gets array of all "methodName" elements
     */
    public java.lang.String[] getMethodNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODNAME$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "methodName" element
     */
    public java.lang.String getMethodNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "methodName" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetMethodNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODNAME$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "methodName" element
     */
    public org.apache.xmlbeans.XmlString xgetMethodNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "methodName" element
     */
    public int sizeOfMethodNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODNAME$0);
        }
    }
    
    /**
     * Sets array of all "methodName" element
     */
    public void setMethodNameArray(java.lang.String[] methodNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodNameArray, METHODNAME$0);
        }
    }
    
    /**
     * Sets ith "methodName" element
     */
    public void setMethodNameArray(int i, java.lang.String methodName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(methodName);
        }
    }
    
    /**
     * Sets (as xml) array of all "methodName" element
     */
    public void xsetMethodNameArray(org.apache.xmlbeans.XmlString[]methodNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodNameArray, METHODNAME$0);
        }
    }
    
    /**
     * Sets (as xml) ith "methodName" element
     */
    public void xsetMethodNameArray(int i, org.apache.xmlbeans.XmlString methodName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(methodName);
        }
    }
    
    /**
     * Inserts the value as the ith "methodName" element
     */
    public void insertMethodName(int i, java.lang.String methodName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(METHODNAME$0, i);
            target.setStringValue(methodName);
        }
    }
    
    /**
     * Appends the value as the last "methodName" element
     */
    public void addMethodName(java.lang.String methodName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODNAME$0);
            target.setStringValue(methodName);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "methodName" element
     */
    public org.apache.xmlbeans.XmlString insertNewMethodName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(METHODNAME$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "methodName" element
     */
    public org.apache.xmlbeans.XmlString addNewMethodName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(METHODNAME$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "methodName" element
     */
    public void removeMethodName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODNAME$0, i);
        }
    }
}
