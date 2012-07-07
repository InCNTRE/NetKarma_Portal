/*
 * XML Type:  clientNameListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.ClientNameListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML clientNameListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class ClientNameListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.ClientNameListType
{
    
    public ClientNameListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CLIENTNAME$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "clientName");
    
    
    /**
     * Gets array of all "clientName" elements
     */
    public java.lang.String[] getClientNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CLIENTNAME$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "clientName" element
     */
    public java.lang.String getClientNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CLIENTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "clientName" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetClientNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CLIENTNAME$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "clientName" element
     */
    public org.apache.xmlbeans.XmlString xgetClientNameArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CLIENTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "clientName" element
     */
    public int sizeOfClientNameArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CLIENTNAME$0);
        }
    }
    
    /**
     * Sets array of all "clientName" element
     */
    public void setClientNameArray(java.lang.String[] clientNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(clientNameArray, CLIENTNAME$0);
        }
    }
    
    /**
     * Sets ith "clientName" element
     */
    public void setClientNameArray(int i, java.lang.String clientName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CLIENTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(clientName);
        }
    }
    
    /**
     * Sets (as xml) array of all "clientName" element
     */
    public void xsetClientNameArray(org.apache.xmlbeans.XmlString[]clientNameArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(clientNameArray, CLIENTNAME$0);
        }
    }
    
    /**
     * Sets (as xml) ith "clientName" element
     */
    public void xsetClientNameArray(int i, org.apache.xmlbeans.XmlString clientName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CLIENTNAME$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(clientName);
        }
    }
    
    /**
     * Inserts the value as the ith "clientName" element
     */
    public void insertClientName(int i, java.lang.String clientName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(CLIENTNAME$0, i);
            target.setStringValue(clientName);
        }
    }
    
    /**
     * Appends the value as the last "clientName" element
     */
    public void addClientName(java.lang.String clientName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CLIENTNAME$0);
            target.setStringValue(clientName);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "clientName" element
     */
    public org.apache.xmlbeans.XmlString insertNewClientName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(CLIENTNAME$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "clientName" element
     */
    public org.apache.xmlbeans.XmlString addNewClientName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CLIENTNAME$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "clientName" element
     */
    public void removeClientName(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CLIENTNAME$0, i);
        }
    }
}
