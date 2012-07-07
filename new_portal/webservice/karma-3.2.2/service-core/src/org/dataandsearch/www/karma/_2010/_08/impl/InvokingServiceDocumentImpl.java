/*
 * An XML document type.
 * Localname: invokingService
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.InvokingServiceDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one invokingService(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class InvokingServiceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.InvokingServiceDocument
{
    
    public InvokingServiceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INVOKINGSERVICE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "invokingService");
    
    
    /**
     * Gets the "invokingService" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType getInvokingService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(INVOKINGSERVICE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "invokingService" element
     */
    public void setInvokingService(org.dataandsearch.www.karma._2010._08.InvocationType invokingService)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(INVOKINGSERVICE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(INVOKINGSERVICE$0);
            }
            target.set(invokingService);
        }
    }
    
    /**
     * Appends and returns a new empty "invokingService" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType addNewInvokingService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(INVOKINGSERVICE$0);
            return target;
        }
    }
}
