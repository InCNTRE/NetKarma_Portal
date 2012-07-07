/*
 * An XML document type.
 * Localname: unknown
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.UnknownDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one unknown(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class UnknownDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.UnknownDocument
{
    
    public UnknownDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNKNOWN$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "unknown");
    
    
    /**
     * Gets the "unknown" element
     */
    public org.apache.xmlbeans.XmlObject getUnknown()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(UNKNOWN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "unknown" element
     */
    public void setUnknown(org.apache.xmlbeans.XmlObject unknown)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(UNKNOWN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(UNKNOWN$0);
            }
            target.set(unknown);
        }
    }
    
    /**
     * Appends and returns a new empty "unknown" element
     */
    public org.apache.xmlbeans.XmlObject addNewUnknown()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(UNKNOWN$0);
            return target;
        }
    }
}
