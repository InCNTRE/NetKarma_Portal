/*
 * XML Type:  methodInvocationDetailListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML methodInvocationDetailListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class MethodInvocationDetailListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType
{
    
    public MethodInvocationDetailListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METHODINVOCATIONDETAIL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodInvocationDetail");
    
    
    /**
     * Gets array of all "methodInvocationDetail" elements
     */
    public java.lang.String[] getMethodInvocationDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODINVOCATIONDETAIL$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "methodInvocationDetail" element
     */
    public java.lang.String getMethodInvocationDetailArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODINVOCATIONDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "methodInvocationDetail" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetMethodInvocationDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METHODINVOCATIONDETAIL$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "methodInvocationDetail" element
     */
    public org.apache.xmlbeans.XmlString xgetMethodInvocationDetailArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODINVOCATIONDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "methodInvocationDetail" element
     */
    public int sizeOfMethodInvocationDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODINVOCATIONDETAIL$0);
        }
    }
    
    /**
     * Sets array of all "methodInvocationDetail" element
     */
    public void setMethodInvocationDetailArray(java.lang.String[] methodInvocationDetailArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodInvocationDetailArray, METHODINVOCATIONDETAIL$0);
        }
    }
    
    /**
     * Sets ith "methodInvocationDetail" element
     */
    public void setMethodInvocationDetailArray(int i, java.lang.String methodInvocationDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODINVOCATIONDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(methodInvocationDetail);
        }
    }
    
    /**
     * Sets (as xml) array of all "methodInvocationDetail" element
     */
    public void xsetMethodInvocationDetailArray(org.apache.xmlbeans.XmlString[]methodInvocationDetailArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodInvocationDetailArray, METHODINVOCATIONDETAIL$0);
        }
    }
    
    /**
     * Sets (as xml) ith "methodInvocationDetail" element
     */
    public void xsetMethodInvocationDetailArray(int i, org.apache.xmlbeans.XmlString methodInvocationDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODINVOCATIONDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(methodInvocationDetail);
        }
    }
    
    /**
     * Inserts the value as the ith "methodInvocationDetail" element
     */
    public void insertMethodInvocationDetail(int i, java.lang.String methodInvocationDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(METHODINVOCATIONDETAIL$0, i);
            target.setStringValue(methodInvocationDetail);
        }
    }
    
    /**
     * Appends the value as the last "methodInvocationDetail" element
     */
    public void addMethodInvocationDetail(java.lang.String methodInvocationDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODINVOCATIONDETAIL$0);
            target.setStringValue(methodInvocationDetail);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "methodInvocationDetail" element
     */
    public org.apache.xmlbeans.XmlString insertNewMethodInvocationDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(METHODINVOCATIONDETAIL$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "methodInvocationDetail" element
     */
    public org.apache.xmlbeans.XmlString addNewMethodInvocationDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(METHODINVOCATIONDETAIL$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "methodInvocationDetail" element
     */
    public void removeMethodInvocationDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODINVOCATIONDETAIL$0, i);
        }
    }
}
