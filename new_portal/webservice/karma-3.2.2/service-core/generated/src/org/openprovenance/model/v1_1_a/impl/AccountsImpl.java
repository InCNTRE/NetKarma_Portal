/*
 * XML Type:  Accounts
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Accounts
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML Accounts(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class AccountsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.Accounts
{
    
    public AccountsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACCOUNT$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "account");
    private static final javax.xml.namespace.QName OVERLAPS$2 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "overlaps");
    
    
    /**
     * Gets array of all "account" elements
     */
    public org.openprovenance.model.v1_1_a.Account[] getAccountArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ACCOUNT$0, targetList);
            org.openprovenance.model.v1_1_a.Account[] result = new org.openprovenance.model.v1_1_a.Account[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "account" element
     */
    public org.openprovenance.model.v1_1_a.Account getAccountArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Account target = null;
            target = (org.openprovenance.model.v1_1_a.Account)get_store().find_element_user(ACCOUNT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "account" element
     */
    public int sizeOfAccountArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ACCOUNT$0);
        }
    }
    
    /**
     * Sets array of all "account" element
     */
    public void setAccountArray(org.openprovenance.model.v1_1_a.Account[] accountArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(accountArray, ACCOUNT$0);
        }
    }
    
    /**
     * Sets ith "account" element
     */
    public void setAccountArray(int i, org.openprovenance.model.v1_1_a.Account account)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Account target = null;
            target = (org.openprovenance.model.v1_1_a.Account)get_store().find_element_user(ACCOUNT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(account);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "account" element
     */
    public org.openprovenance.model.v1_1_a.Account insertNewAccount(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Account target = null;
            target = (org.openprovenance.model.v1_1_a.Account)get_store().insert_element_user(ACCOUNT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "account" element
     */
    public org.openprovenance.model.v1_1_a.Account addNewAccount()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Account target = null;
            target = (org.openprovenance.model.v1_1_a.Account)get_store().add_element_user(ACCOUNT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "account" element
     */
    public void removeAccount(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ACCOUNT$0, i);
        }
    }
    
    /**
     * Gets array of all "overlaps" elements
     */
    public org.openprovenance.model.v1_1_a.Overlaps[] getOverlapsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OVERLAPS$2, targetList);
            org.openprovenance.model.v1_1_a.Overlaps[] result = new org.openprovenance.model.v1_1_a.Overlaps[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "overlaps" element
     */
    public org.openprovenance.model.v1_1_a.Overlaps getOverlapsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Overlaps target = null;
            target = (org.openprovenance.model.v1_1_a.Overlaps)get_store().find_element_user(OVERLAPS$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "overlaps" element
     */
    public int sizeOfOverlapsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OVERLAPS$2);
        }
    }
    
    /**
     * Sets array of all "overlaps" element
     */
    public void setOverlapsArray(org.openprovenance.model.v1_1_a.Overlaps[] overlapsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(overlapsArray, OVERLAPS$2);
        }
    }
    
    /**
     * Sets ith "overlaps" element
     */
    public void setOverlapsArray(int i, org.openprovenance.model.v1_1_a.Overlaps overlaps)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Overlaps target = null;
            target = (org.openprovenance.model.v1_1_a.Overlaps)get_store().find_element_user(OVERLAPS$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(overlaps);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "overlaps" element
     */
    public org.openprovenance.model.v1_1_a.Overlaps insertNewOverlaps(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Overlaps target = null;
            target = (org.openprovenance.model.v1_1_a.Overlaps)get_store().insert_element_user(OVERLAPS$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "overlaps" element
     */
    public org.openprovenance.model.v1_1_a.Overlaps addNewOverlaps()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Overlaps target = null;
            target = (org.openprovenance.model.v1_1_a.Overlaps)get_store().add_element_user(OVERLAPS$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "overlaps" element
     */
    public void removeOverlaps(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OVERLAPS$2, i);
        }
    }
}
