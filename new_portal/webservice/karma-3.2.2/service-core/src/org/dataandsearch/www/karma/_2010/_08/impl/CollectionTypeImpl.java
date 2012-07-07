/*
 * XML Type:  collectionType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.CollectionType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML collectionType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class CollectionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.CollectionType
{
    
    public CollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COLLECTIONURI$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "collectionURI");
    private static final javax.xml.namespace.QName MEMBERS$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "members");
    
    
    /**
     * Gets the "collectionURI" element
     */
    public java.lang.String getCollectionURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COLLECTIONURI$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "collectionURI" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetCollectionURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(COLLECTIONURI$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "collectionURI" element
     */
    public void setCollectionURI(java.lang.String collectionURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COLLECTIONURI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COLLECTIONURI$0);
            }
            target.setStringValue(collectionURI);
        }
    }
    
    /**
     * Sets (as xml) the "collectionURI" element
     */
    public void xsetCollectionURI(org.apache.xmlbeans.XmlAnyURI collectionURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(COLLECTIONURI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(COLLECTIONURI$0);
            }
            target.set(collectionURI);
        }
    }
    
    /**
     * Gets array of all "members" elements
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType[] getMembersArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(MEMBERS$2, targetList);
            org.dataandsearch.www.karma._2010._08.DataObjectType[] result = new org.dataandsearch.www.karma._2010._08.DataObjectType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "members" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType getMembersArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(MEMBERS$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "members" element
     */
    public int sizeOfMembersArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MEMBERS$2);
        }
    }
    
    /**
     * Sets array of all "members" element
     */
    public void setMembersArray(org.dataandsearch.www.karma._2010._08.DataObjectType[] membersArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(membersArray, MEMBERS$2);
        }
    }
    
    /**
     * Sets ith "members" element
     */
    public void setMembersArray(int i, org.dataandsearch.www.karma._2010._08.DataObjectType members)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(MEMBERS$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(members);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "members" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType insertNewMembers(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().insert_element_user(MEMBERS$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "members" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType addNewMembers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(MEMBERS$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "members" element
     */
    public void removeMembers(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MEMBERS$2, i);
        }
    }
}
