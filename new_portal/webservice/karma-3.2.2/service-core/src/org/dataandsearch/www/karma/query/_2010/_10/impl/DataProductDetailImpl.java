/*
 * XML Type:  dataProductDetail
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductDetail
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML dataProductDetail(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class DataProductDetailImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.DataProductDetail
{
    
    public DataProductDetailImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILEURI$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "fileURI");
    private static final javax.xml.namespace.QName OWNER$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "owner");
    private static final javax.xml.namespace.QName CREATIONDATE$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "creationDate");
    private static final javax.xml.namespace.QName SIZE$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "size");
    private static final javax.xml.namespace.QName MD5$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "md5");
    private static final javax.xml.namespace.QName FILENAME$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "fileName");
    private static final javax.xml.namespace.QName BLOCKCONTENT$12 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "blockContent");
    private static final javax.xml.namespace.QName COLLECTIONURI$14 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "collectionURI");
    private static final javax.xml.namespace.QName MEMBERSHIP$16 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "membership");
    private static final javax.xml.namespace.QName ID$18 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets the "fileURI" element
     */
    public java.lang.String getFileURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FILEURI$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "fileURI" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetFileURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(FILEURI$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "fileURI" element
     */
    public boolean isSetFileURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FILEURI$0) != 0;
        }
    }
    
    /**
     * Sets the "fileURI" element
     */
    public void setFileURI(java.lang.String fileURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FILEURI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FILEURI$0);
            }
            target.setStringValue(fileURI);
        }
    }
    
    /**
     * Sets (as xml) the "fileURI" element
     */
    public void xsetFileURI(org.apache.xmlbeans.XmlAnyURI fileURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(FILEURI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(FILEURI$0);
            }
            target.set(fileURI);
        }
    }
    
    /**
     * Unsets the "fileURI" element
     */
    public void unsetFileURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FILEURI$0, 0);
        }
    }
    
    /**
     * Gets the "owner" element
     */
    public java.lang.String getOwner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OWNER$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "owner" element
     */
    public org.apache.xmlbeans.XmlString xgetOwner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OWNER$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "owner" element
     */
    public boolean isSetOwner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OWNER$2) != 0;
        }
    }
    
    /**
     * Sets the "owner" element
     */
    public void setOwner(java.lang.String owner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OWNER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OWNER$2);
            }
            target.setStringValue(owner);
        }
    }
    
    /**
     * Sets (as xml) the "owner" element
     */
    public void xsetOwner(org.apache.xmlbeans.XmlString owner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OWNER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(OWNER$2);
            }
            target.set(owner);
        }
    }
    
    /**
     * Unsets the "owner" element
     */
    public void unsetOwner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OWNER$2, 0);
        }
    }
    
    /**
     * Gets the "creationDate" element
     */
    public java.util.Calendar getCreationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATIONDATE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "creationDate" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetCreationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATIONDATE$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "creationDate" element
     */
    public boolean isSetCreationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CREATIONDATE$4) != 0;
        }
    }
    
    /**
     * Sets the "creationDate" element
     */
    public void setCreationDate(java.util.Calendar creationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATIONDATE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATIONDATE$4);
            }
            target.setCalendarValue(creationDate);
        }
    }
    
    /**
     * Sets (as xml) the "creationDate" element
     */
    public void xsetCreationDate(org.apache.xmlbeans.XmlDateTime creationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATIONDATE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(CREATIONDATE$4);
            }
            target.set(creationDate);
        }
    }
    
    /**
     * Unsets the "creationDate" element
     */
    public void unsetCreationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CREATIONDATE$4, 0);
        }
    }
    
    /**
     * Gets the "size" element
     */
    public long getSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIZE$6, 0);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "size" element
     */
    public org.apache.xmlbeans.XmlLong xgetSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(SIZE$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "size" element
     */
    public boolean isSetSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SIZE$6) != 0;
        }
    }
    
    /**
     * Sets the "size" element
     */
    public void setSize(long size)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIZE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIZE$6);
            }
            target.setLongValue(size);
        }
    }
    
    /**
     * Sets (as xml) the "size" element
     */
    public void xsetSize(org.apache.xmlbeans.XmlLong size)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(SIZE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_element_user(SIZE$6);
            }
            target.set(size);
        }
    }
    
    /**
     * Unsets the "size" element
     */
    public void unsetSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SIZE$6, 0);
        }
    }
    
    /**
     * Gets the "md5" element
     */
    public java.lang.String getMd5()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MD5$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "md5" element
     */
    public org.apache.xmlbeans.XmlString xgetMd5()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MD5$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "md5" element
     */
    public boolean isSetMd5()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MD5$8) != 0;
        }
    }
    
    /**
     * Sets the "md5" element
     */
    public void setMd5(java.lang.String md5)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MD5$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MD5$8);
            }
            target.setStringValue(md5);
        }
    }
    
    /**
     * Sets (as xml) the "md5" element
     */
    public void xsetMd5(org.apache.xmlbeans.XmlString md5)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MD5$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MD5$8);
            }
            target.set(md5);
        }
    }
    
    /**
     * Unsets the "md5" element
     */
    public void unsetMd5()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MD5$8, 0);
        }
    }
    
    /**
     * Gets the "fileName" element
     */
    public java.lang.String getFileName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FILENAME$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "fileName" element
     */
    public org.apache.xmlbeans.XmlString xgetFileName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FILENAME$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "fileName" element
     */
    public boolean isSetFileName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FILENAME$10) != 0;
        }
    }
    
    /**
     * Sets the "fileName" element
     */
    public void setFileName(java.lang.String fileName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FILENAME$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FILENAME$10);
            }
            target.setStringValue(fileName);
        }
    }
    
    /**
     * Sets (as xml) the "fileName" element
     */
    public void xsetFileName(org.apache.xmlbeans.XmlString fileName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FILENAME$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FILENAME$10);
            }
            target.set(fileName);
        }
    }
    
    /**
     * Unsets the "fileName" element
     */
    public void unsetFileName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FILENAME$10, 0);
        }
    }
    
    /**
     * Gets the "blockContent" element
     */
    public java.lang.String getBlockContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BLOCKCONTENT$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "blockContent" element
     */
    public org.apache.xmlbeans.XmlString xgetBlockContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BLOCKCONTENT$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "blockContent" element
     */
    public boolean isSetBlockContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BLOCKCONTENT$12) != 0;
        }
    }
    
    /**
     * Sets the "blockContent" element
     */
    public void setBlockContent(java.lang.String blockContent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BLOCKCONTENT$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BLOCKCONTENT$12);
            }
            target.setStringValue(blockContent);
        }
    }
    
    /**
     * Sets (as xml) the "blockContent" element
     */
    public void xsetBlockContent(org.apache.xmlbeans.XmlString blockContent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BLOCKCONTENT$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BLOCKCONTENT$12);
            }
            target.set(blockContent);
        }
    }
    
    /**
     * Unsets the "blockContent" element
     */
    public void unsetBlockContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BLOCKCONTENT$12, 0);
        }
    }
    
    /**
     * Gets the "collectionURI" element
     */
    public java.lang.String getCollectionURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COLLECTIONURI$14, 0);
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
    public org.apache.xmlbeans.XmlString xgetCollectionURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COLLECTIONURI$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "collectionURI" element
     */
    public boolean isSetCollectionURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COLLECTIONURI$14) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COLLECTIONURI$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COLLECTIONURI$14);
            }
            target.setStringValue(collectionURI);
        }
    }
    
    /**
     * Sets (as xml) the "collectionURI" element
     */
    public void xsetCollectionURI(org.apache.xmlbeans.XmlString collectionURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COLLECTIONURI$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COLLECTIONURI$14);
            }
            target.set(collectionURI);
        }
    }
    
    /**
     * Unsets the "collectionURI" element
     */
    public void unsetCollectionURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COLLECTIONURI$14, 0);
        }
    }
    
    /**
     * Gets array of all "membership" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.MembershipDetail[] getMembershipArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(MEMBERSHIP$16, targetList);
            org.dataandsearch.www.karma.query._2010._10.MembershipDetail[] result = new org.dataandsearch.www.karma.query._2010._10.MembershipDetail[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "membership" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MembershipDetail getMembershipArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MembershipDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MembershipDetail)get_store().find_element_user(MEMBERSHIP$16, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "membership" element
     */
    public int sizeOfMembershipArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MEMBERSHIP$16);
        }
    }
    
    /**
     * Sets array of all "membership" element
     */
    public void setMembershipArray(org.dataandsearch.www.karma.query._2010._10.MembershipDetail[] membershipArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(membershipArray, MEMBERSHIP$16);
        }
    }
    
    /**
     * Sets ith "membership" element
     */
    public void setMembershipArray(int i, org.dataandsearch.www.karma.query._2010._10.MembershipDetail membership)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MembershipDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MembershipDetail)get_store().find_element_user(MEMBERSHIP$16, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(membership);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "membership" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MembershipDetail insertNewMembership(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MembershipDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MembershipDetail)get_store().insert_element_user(MEMBERSHIP$16, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "membership" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MembershipDetail addNewMembership()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MembershipDetail target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MembershipDetail)get_store().add_element_user(MEMBERSHIP$16);
            return target;
        }
    }
    
    /**
     * Removes the ith "membership" element
     */
    public void removeMembership(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MEMBERSHIP$16, i);
        }
    }
    
    /**
     * Gets the "id" attribute
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$18);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" attribute
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$18);
            return target;
        }
    }
    
    /**
     * Sets the "id" attribute
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$18);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$18);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" attribute
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$18);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$18);
            }
            target.set(id);
        }
    }
}
