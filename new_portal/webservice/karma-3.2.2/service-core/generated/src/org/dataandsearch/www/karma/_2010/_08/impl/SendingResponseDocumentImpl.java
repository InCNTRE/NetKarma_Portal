/*
 * An XML document type.
 * Localname: sendingResponse
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.SendingResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one sendingResponse(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class SendingResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.SendingResponseDocument
{
    
    public SendingResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SENDINGRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "sendingResponse");
    
    
    /**
     * Gets the "sendingResponse" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getSendingResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(SENDINGRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "sendingResponse" element
     */
    public void setSendingResponse(org.dataandsearch.www.karma._2010._08.DataTransferType sendingResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(SENDINGRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(SENDINGRESPONSE$0);
            }
            target.set(sendingResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "sendingResponse" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewSendingResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(SENDINGRESPONSE$0);
            return target;
        }
    }
}
