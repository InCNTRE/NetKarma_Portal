/*
 * An XML document type.
 * Localname: sendingFault
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.SendingFaultDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one sendingFault(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class SendingFaultDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.SendingFaultDocument
{
    
    public SendingFaultDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SENDINGFAULT$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "sendingFault");
    
    
    /**
     * Gets the "sendingFault" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getSendingFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(SENDINGFAULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "sendingFault" element
     */
    public void setSendingFault(org.dataandsearch.www.karma._2010._08.DataTransferType sendingFault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(SENDINGFAULT$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(SENDINGFAULT$0);
            }
            target.set(sendingFault);
        }
    }
    
    /**
     * Appends and returns a new empty "sendingFault" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewSendingFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(SENDINGFAULT$0);
            return target;
        }
    }
}
