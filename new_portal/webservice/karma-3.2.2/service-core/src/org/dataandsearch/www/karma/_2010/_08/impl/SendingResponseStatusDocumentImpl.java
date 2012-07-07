/*
 * An XML document type.
 * Localname: sendingResponseStatus
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.SendingResponseStatusDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one sendingResponseStatus(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class SendingResponseStatusDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.SendingResponseStatusDocument
{
    
    public SendingResponseStatusDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SENDINGRESPONSESTATUS$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "sendingResponseStatus");
    
    
    /**
     * Gets the "sendingResponseStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferStatusType getSendingResponseStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferStatusType)get_store().find_element_user(SENDINGRESPONSESTATUS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "sendingResponseStatus" element
     */
    public void setSendingResponseStatus(org.dataandsearch.www.karma._2010._08.DataTransferStatusType sendingResponseStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferStatusType)get_store().find_element_user(SENDINGRESPONSESTATUS$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferStatusType)get_store().add_element_user(SENDINGRESPONSESTATUS$0);
            }
            target.set(sendingResponseStatus);
        }
    }
    
    /**
     * Appends and returns a new empty "sendingResponseStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferStatusType addNewSendingResponseStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferStatusType)get_store().add_element_user(SENDINGRESPONSESTATUS$0);
            return target;
        }
    }
}
