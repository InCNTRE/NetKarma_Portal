/*
 * An XML document type.
 * Localname: receivedResponse
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.ReceivedResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one receivedResponse(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class ReceivedResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.ReceivedResponseDocument
{
    
    public ReceivedResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RECEIVEDRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "receivedResponse");
    
    
    /**
     * Gets the "receivedResponse" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getReceivedResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(RECEIVEDRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "receivedResponse" element
     */
    public void setReceivedResponse(org.dataandsearch.www.karma._2010._08.DataTransferType receivedResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(RECEIVEDRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(RECEIVEDRESPONSE$0);
            }
            target.set(receivedResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "receivedResponse" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewReceivedResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(RECEIVEDRESPONSE$0);
            return target;
        }
    }
}
