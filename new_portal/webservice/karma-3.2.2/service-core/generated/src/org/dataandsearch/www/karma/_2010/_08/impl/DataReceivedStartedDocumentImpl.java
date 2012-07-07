/*
 * An XML document type.
 * Localname: dataReceivedStarted
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataReceivedStarted(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataReceivedStartedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument
{
    
    public DataReceivedStartedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATARECEIVEDSTARTED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataReceivedStarted");
    
    
    /**
     * Gets the "dataReceivedStarted" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getDataReceivedStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATARECEIVEDSTARTED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataReceivedStarted" element
     */
    public void setDataReceivedStarted(org.dataandsearch.www.karma._2010._08.DataTransferType dataReceivedStarted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATARECEIVEDSTARTED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATARECEIVEDSTARTED$0);
            }
            target.set(dataReceivedStarted);
        }
    }
    
    /**
     * Appends and returns a new empty "dataReceivedStarted" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewDataReceivedStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATARECEIVEDSTARTED$0);
            return target;
        }
    }
}
