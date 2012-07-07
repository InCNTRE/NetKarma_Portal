/*
 * XML Type:  methodInformationType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.MethodInformationType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML methodInformationType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class MethodInformationTypeImpl extends org.dataandsearch.www.karma._2010._08.impl.ServiceInformationTypeImpl implements org.dataandsearch.www.karma._2010._08.MethodInformationType
{
    
    public MethodInformationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METHODID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "methodID");
    
    
    /**
     * Gets the "methodID" element
     */
    public java.lang.String getMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "methodID" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(METHODID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "methodID" element
     */
    public void setMethodID(java.lang.String methodID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODID$0);
            }
            target.setStringValue(methodID);
        }
    }
    
    /**
     * Sets (as xml) the "methodID" element
     */
    public void xsetMethodID(org.apache.xmlbeans.XmlAnyURI methodID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(METHODID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(METHODID$0);
            }
            target.set(methodID);
        }
    }
}
