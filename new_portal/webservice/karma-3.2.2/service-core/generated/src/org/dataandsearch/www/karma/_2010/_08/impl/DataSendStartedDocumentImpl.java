/*
 * An XML document type.
 * Localname: dataSendStarted
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataSendStartedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataSendStarted(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataSendStartedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataSendStartedDocument
{
    
    public DataSendStartedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATASENDSTARTED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataSendStarted");
    
    
    /**
     * Gets the "dataSendStarted" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getDataSendStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATASENDSTARTED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataSendStarted" element
     */
    public void setDataSendStarted(org.dataandsearch.www.karma._2010._08.DataTransferType dataSendStarted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATASENDSTARTED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATASENDSTARTED$0);
            }
            target.set(dataSendStarted);
        }
    }
    
    /**
     * Appends and returns a new empty "dataSendStarted" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewDataSendStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATASENDSTARTED$0);
            return target;
        }
    }
}
