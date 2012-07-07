/*
 * XML Type:  Annotation
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Annotation
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML Annotation(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class AnnotationImpl extends org.openprovenance.model.v1_1_a.impl.EmbeddedAnnotationImpl implements org.openprovenance.model.v1_1_a.Annotation
{
    
    public AnnotationImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTERNALSUBJECT$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "externalSubject");
    private static final javax.xml.namespace.QName LOCALSUBJECT$2 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "localSubject");
    
    
    /**
     * Gets the "externalSubject" element
     */
    public java.lang.String getExternalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSUBJECT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "externalSubject" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetExternalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(EXTERNALSUBJECT$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "externalSubject" element
     */
    public boolean isSetExternalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(EXTERNALSUBJECT$0) != 0;
        }
    }
    
    /**
     * Sets the "externalSubject" element
     */
    public void setExternalSubject(java.lang.String externalSubject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSUBJECT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALSUBJECT$0);
            }
            target.setStringValue(externalSubject);
        }
    }
    
    /**
     * Sets (as xml) the "externalSubject" element
     */
    public void xsetExternalSubject(org.apache.xmlbeans.XmlAnyURI externalSubject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(EXTERNALSUBJECT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(EXTERNALSUBJECT$0);
            }
            target.set(externalSubject);
        }
    }
    
    /**
     * Unsets the "externalSubject" element
     */
    public void unsetExternalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(EXTERNALSUBJECT$0, 0);
        }
    }
    
    /**
     * Gets the "localSubject" element
     */
    public java.lang.String getLocalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOCALSUBJECT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "localSubject" element
     */
    public org.apache.xmlbeans.XmlIDREF xgetLocalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlIDREF target = null;
            target = (org.apache.xmlbeans.XmlIDREF)get_store().find_element_user(LOCALSUBJECT$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "localSubject" element
     */
    public boolean isSetLocalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LOCALSUBJECT$2) != 0;
        }
    }
    
    /**
     * Sets the "localSubject" element
     */
    public void setLocalSubject(java.lang.String localSubject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOCALSUBJECT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOCALSUBJECT$2);
            }
            target.setStringValue(localSubject);
        }
    }
    
    /**
     * Sets (as xml) the "localSubject" element
     */
    public void xsetLocalSubject(org.apache.xmlbeans.XmlIDREF localSubject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlIDREF target = null;
            target = (org.apache.xmlbeans.XmlIDREF)get_store().find_element_user(LOCALSUBJECT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlIDREF)get_store().add_element_user(LOCALSUBJECT$2);
            }
            target.set(localSubject);
        }
    }
    
    /**
     * Unsets the "localSubject" element
     */
    public void unsetLocalSubject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LOCALSUBJECT$2, 0);
        }
    }
}
