/*
 * An XML document type.
 * Localname: receivedFault
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.ReceivedFaultDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one receivedFault(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class ReceivedFaultDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.ReceivedFaultDocument
{
    
    public ReceivedFaultDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RECEIVEDFAULT$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "receivedFault");
    
    
    /**
     * Gets the "receivedFault" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getReceivedFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(RECEIVEDFAULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "receivedFault" element
     */
    public void setReceivedFault(org.dataandsearch.www.karma._2010._08.DataTransferType receivedFault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(RECEIVEDFAULT$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(RECEIVEDFAULT$0);
            }
            target.set(receivedFault);
        }
    }
    
    /**
     * Appends and returns a new empty "receivedFault" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewReceivedFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(RECEIVEDFAULT$0);
            return target;
        }
    }
}
