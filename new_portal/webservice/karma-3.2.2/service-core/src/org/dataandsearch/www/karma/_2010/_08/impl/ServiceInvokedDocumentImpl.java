/*
 * An XML document type.
 * Localname: serviceInvoked
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one serviceInvoked(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class ServiceInvokedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument
{
    
    public ServiceInvokedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEINVOKED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "serviceInvoked");
    
    
    /**
     * Gets the "serviceInvoked" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType getServiceInvoked()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(SERVICEINVOKED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "serviceInvoked" element
     */
    public void setServiceInvoked(org.dataandsearch.www.karma._2010._08.InvocationType serviceInvoked)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(SERVICEINVOKED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(SERVICEINVOKED$0);
            }
            target.set(serviceInvoked);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceInvoked" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType addNewServiceInvoked()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(SERVICEINVOKED$0);
            return target;
        }
    }
}
