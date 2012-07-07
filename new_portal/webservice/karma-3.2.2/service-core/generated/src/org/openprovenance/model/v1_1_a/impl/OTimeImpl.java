/*
 * XML Type:  OTime
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.OTime
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML OTime(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class OTimeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.OTime
{
    
    public OTimeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NOEARLIERTHAN$0 = 
        new javax.xml.namespace.QName("", "noEarlierThan");
    private static final javax.xml.namespace.QName NOLATERTHAN$2 = 
        new javax.xml.namespace.QName("", "noLaterThan");
    private static final javax.xml.namespace.QName EXACTLYAT$4 = 
        new javax.xml.namespace.QName("", "exactlyAt");
    
    
    /**
     * Gets the "noEarlierThan" attribute
     */
    public java.util.Calendar getNoEarlierThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NOEARLIERTHAN$0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "noEarlierThan" attribute
     */
    public org.apache.xmlbeans.XmlDateTime xgetNoEarlierThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(NOEARLIERTHAN$0);
            return target;
        }
    }
    
    /**
     * True if has "noEarlierThan" attribute
     */
    public boolean isSetNoEarlierThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(NOEARLIERTHAN$0) != null;
        }
    }
    
    /**
     * Sets the "noEarlierThan" attribute
     */
    public void setNoEarlierThan(java.util.Calendar noEarlierThan)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NOEARLIERTHAN$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NOEARLIERTHAN$0);
            }
            target.setCalendarValue(noEarlierThan);
        }
    }
    
    /**
     * Sets (as xml) the "noEarlierThan" attribute
     */
    public void xsetNoEarlierThan(org.apache.xmlbeans.XmlDateTime noEarlierThan)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(NOEARLIERTHAN$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_attribute_user(NOEARLIERTHAN$0);
            }
            target.set(noEarlierThan);
        }
    }
    
    /**
     * Unsets the "noEarlierThan" attribute
     */
    public void unsetNoEarlierThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(NOEARLIERTHAN$0);
        }
    }
    
    /**
     * Gets the "noLaterThan" attribute
     */
    public java.util.Calendar getNoLaterThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NOLATERTHAN$2);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "noLaterThan" attribute
     */
    public org.apache.xmlbeans.XmlDateTime xgetNoLaterThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(NOLATERTHAN$2);
            return target;
        }
    }
    
    /**
     * True if has "noLaterThan" attribute
     */
    public boolean isSetNoLaterThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(NOLATERTHAN$2) != null;
        }
    }
    
    /**
     * Sets the "noLaterThan" attribute
     */
    public void setNoLaterThan(java.util.Calendar noLaterThan)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NOLATERTHAN$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NOLATERTHAN$2);
            }
            target.setCalendarValue(noLaterThan);
        }
    }
    
    /**
     * Sets (as xml) the "noLaterThan" attribute
     */
    public void xsetNoLaterThan(org.apache.xmlbeans.XmlDateTime noLaterThan)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(NOLATERTHAN$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_attribute_user(NOLATERTHAN$2);
            }
            target.set(noLaterThan);
        }
    }
    
    /**
     * Unsets the "noLaterThan" attribute
     */
    public void unsetNoLaterThan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(NOLATERTHAN$2);
        }
    }
    
    /**
     * Gets the "exactlyAt" attribute
     */
    public java.util.Calendar getExactlyAt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXACTLYAT$4);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "exactlyAt" attribute
     */
    public org.apache.xmlbeans.XmlDateTime xgetExactlyAt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(EXACTLYAT$4);
            return target;
        }
    }
    
    /**
     * True if has "exactlyAt" attribute
     */
    public boolean isSetExactlyAt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(EXACTLYAT$4) != null;
        }
    }
    
    /**
     * Sets the "exactlyAt" attribute
     */
    public void setExactlyAt(java.util.Calendar exactlyAt)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXACTLYAT$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXACTLYAT$4);
            }
            target.setCalendarValue(exactlyAt);
        }
    }
    
    /**
     * Sets (as xml) the "exactlyAt" attribute
     */
    public void xsetExactlyAt(org.apache.xmlbeans.XmlDateTime exactlyAt)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(EXACTLYAT$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_attribute_user(EXACTLYAT$4);
            }
            target.set(exactlyAt);
        }
    }
    
    /**
     * Unsets the "exactlyAt" attribute
     */
    public void unsetExactlyAt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(EXACTLYAT$4);
        }
    }
}
