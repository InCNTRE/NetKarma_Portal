/*
 * XML Type:  userInformationType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.UserInformationType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML userInformationType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class UserInformationTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.UserInformationType
{
    
    public UserInformationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName USERDN$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "userDN");
    private static final javax.xml.namespace.QName FULLNAME$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "fullName");
    private static final javax.xml.namespace.QName TYPE$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "type");
    private static final javax.xml.namespace.QName AFFILIATION$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "affiliation");
    private static final javax.xml.namespace.QName EMAIL$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "email");
    
    
    /**
     * Gets the "userDN" element
     */
    public java.lang.String getUserDN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERDN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "userDN" element
     */
    public org.apache.xmlbeans.XmlString xgetUserDN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERDN$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "userDN" element
     */
    public void setUserDN(java.lang.String userDN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERDN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USERDN$0);
            }
            target.setStringValue(userDN);
        }
    }
    
    /**
     * Sets (as xml) the "userDN" element
     */
    public void xsetUserDN(org.apache.xmlbeans.XmlString userDN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERDN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USERDN$0);
            }
            target.set(userDN);
        }
    }
    
    /**
     * Gets the "fullName" element
     */
    public java.lang.String getFullName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FULLNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "fullName" element
     */
    public org.apache.xmlbeans.XmlString xgetFullName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FULLNAME$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "fullName" element
     */
    public boolean isSetFullName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FULLNAME$2) != 0;
        }
    }
    
    /**
     * Sets the "fullName" element
     */
    public void setFullName(java.lang.String fullName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FULLNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FULLNAME$2);
            }
            target.setStringValue(fullName);
        }
    }
    
    /**
     * Sets (as xml) the "fullName" element
     */
    public void xsetFullName(org.apache.xmlbeans.XmlString fullName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FULLNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FULLNAME$2);
            }
            target.set(fullName);
        }
    }
    
    /**
     * Unsets the "fullName" element
     */
    public void unsetFullName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FULLNAME$2, 0);
        }
    }
    
    /**
     * Gets the "type" element
     */
    public org.dataandsearch.www.karma._2010._08.PersonnelEnumType.Enum getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.PersonnelEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "type" element
     */
    public org.dataandsearch.www.karma._2010._08.PersonnelEnumType xgetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.PersonnelEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.PersonnelEnumType)get_store().find_element_user(TYPE$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "type" element
     */
    public void setType(org.dataandsearch.www.karma._2010._08.PersonnelEnumType.Enum type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$4);
            }
            target.setEnumValue(type);
        }
    }
    
    /**
     * Sets (as xml) the "type" element
     */
    public void xsetType(org.dataandsearch.www.karma._2010._08.PersonnelEnumType type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.PersonnelEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.PersonnelEnumType)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.PersonnelEnumType)get_store().add_element_user(TYPE$4);
            }
            target.set(type);
        }
    }
    
    /**
     * Gets the "affiliation" element
     */
    public java.lang.String getAffiliation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AFFILIATION$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "affiliation" element
     */
    public org.apache.xmlbeans.XmlString xgetAffiliation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AFFILIATION$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "affiliation" element
     */
    public boolean isSetAffiliation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AFFILIATION$6) != 0;
        }
    }
    
    /**
     * Sets the "affiliation" element
     */
    public void setAffiliation(java.lang.String affiliation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AFFILIATION$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AFFILIATION$6);
            }
            target.setStringValue(affiliation);
        }
    }
    
    /**
     * Sets (as xml) the "affiliation" element
     */
    public void xsetAffiliation(org.apache.xmlbeans.XmlString affiliation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AFFILIATION$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AFFILIATION$6);
            }
            target.set(affiliation);
        }
    }
    
    /**
     * Unsets the "affiliation" element
     */
    public void unsetAffiliation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AFFILIATION$6, 0);
        }
    }
    
    /**
     * Gets the "email" element
     */
    public java.lang.String getEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EMAIL$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "email" element
     */
    public org.apache.xmlbeans.XmlString xgetEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EMAIL$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "email" element
     */
    public boolean isSetEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(EMAIL$8) != 0;
        }
    }
    
    /**
     * Sets the "email" element
     */
    public void setEmail(java.lang.String email)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EMAIL$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EMAIL$8);
            }
            target.setStringValue(email);
        }
    }
    
    /**
     * Sets (as xml) the "email" element
     */
    public void xsetEmail(org.apache.xmlbeans.XmlString email)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EMAIL$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EMAIL$8);
            }
            target.set(email);
        }
    }
    
    /**
     * Unsets the "email" element
     */
    public void unsetEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(EMAIL$8, 0);
        }
    }
}
