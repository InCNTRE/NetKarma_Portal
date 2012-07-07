/*
 * XML Type:  clientDetailListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.ClientDetailListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML clientDetailListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class ClientDetailListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.ClientDetailListType
{
    
    public ClientDetailListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CLIENTDETAIL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "clientDetail");
    
    
    /**
     * Gets array of all "clientDetail" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.ClientDetail[] getClientDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CLIENTDETAIL$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.ClientDetail[] result = new org.dataandsearch.www.karma.query._2010._10.ClientDetail[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "clientDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ClientDetail getClientDetailArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ClientDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ClientDetail)get_store().find_element_user(CLIENTDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "clientDetail" element
     */
    public int sizeOfClientDetailArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CLIENTDETAIL$0);
        }
    }
    
    /**
     * Sets array of all "clientDetail" element
     */
    public void setClientDetailArray(org.dataandsearch.www.karma.query._2010._10.ClientDetail[] clientDetailArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(clientDetailArray, CLIENTDETAIL$0);
        }
    }
    
    /**
     * Sets ith "clientDetail" element
     */
    public void setClientDetailArray(int i, org.dataandsearch.www.karma.query._2010._10.ClientDetail clientDetail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ClientDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ClientDetail)get_store().find_element_user(CLIENTDETAIL$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(clientDetail);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "clientDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ClientDetail insertNewClientDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ClientDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ClientDetail)get_store().insert_element_user(CLIENTDETAIL$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "clientDetail" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ClientDetail addNewClientDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ClientDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ClientDetail)get_store().add_element_user(CLIENTDETAIL$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "clientDetail" element
     */
    public void removeClientDetail(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CLIENTDETAIL$0, i);
        }
    }
}
