/*
 * An XML document type.
 * Localname: invokingServiceStatus
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.InvokingServiceStatusDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one invokingServiceStatus(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class InvokingServiceStatusDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.InvokingServiceStatusDocument
{
    
    public InvokingServiceStatusDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INVOKINGSERVICESTATUS$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "invokingServiceStatus");
    
    
    /**
     * Gets the "invokingServiceStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationStatusType getInvokingServiceStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().find_element_user(INVOKINGSERVICESTATUS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "invokingServiceStatus" element
     */
    public void setInvokingServiceStatus(org.dataandsearch.www.karma._2010._08.InvocationStatusType invokingServiceStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().find_element_user(INVOKINGSERVICESTATUS$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().add_element_user(INVOKINGSERVICESTATUS$0);
            }
            target.set(invokingServiceStatus);
        }
    }
    
    /**
     * Appends and returns a new empty "invokingServiceStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationStatusType addNewInvokingServiceStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().add_element_user(INVOKINGSERVICESTATUS$0);
            return target;
        }
    }
}
