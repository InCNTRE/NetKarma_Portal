/*
 * XML Type:  annotableFileType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AnnotableFileType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML annotableFileType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class AnnotableFileTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.AnnotableFileType
{
    
    public AnnotableFileTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILEURI$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "fileURI");
    private static final javax.xml.namespace.QName OWNERDN$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "ownerDN");
    private static final javax.xml.namespace.QName CREATEDATE$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "createDate");
    
    
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
     * Gets the "ownerDN" element
     */
    public java.lang.String getOwnerDN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OWNERDN$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ownerDN" element
     */
    public org.apache.xmlbeans.XmlString xgetOwnerDN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OWNERDN$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "ownerDN" element
     */
    public boolean isSetOwnerDN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OWNERDN$2) != 0;
        }
    }
    
    /**
     * Sets the "ownerDN" element
     */
    public void setOwnerDN(java.lang.String ownerDN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OWNERDN$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OWNERDN$2);
            }
            target.setStringValue(ownerDN);
        }
    }
    
    /**
     * Sets (as xml) the "ownerDN" element
     */
    public void xsetOwnerDN(org.apache.xmlbeans.XmlString ownerDN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OWNERDN$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(OWNERDN$2);
            }
            target.set(ownerDN);
        }
    }
    
    /**
     * Unsets the "ownerDN" element
     */
    public void unsetOwnerDN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OWNERDN$2, 0);
        }
    }
    
    /**
     * Gets the "createDate" element
     */
    public java.util.Calendar getCreateDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDATE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "createDate" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetCreateDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDATE$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "createDate" element
     */
    public boolean isSetCreateDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CREATEDATE$4) != 0;
        }
    }
    
    /**
     * Sets the "createDate" element
     */
    public void setCreateDate(java.util.Calendar createDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDATE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATEDATE$4);
            }
            target.setCalendarValue(createDate);
        }
    }
    
    /**
     * Sets (as xml) the "createDate" element
     */
    public void xsetCreateDate(org.apache.xmlbeans.XmlDateTime createDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDATE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(CREATEDATE$4);
            }
            target.set(createDate);
        }
    }
    
    /**
     * Unsets the "createDate" element
     */
    public void unsetCreateDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CREATEDATE$4, 0);
        }
    }
}
