/*
 * An XML document type.
 * Localname: dataReceivedFinished
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataReceivedFinished(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataReceivedFinishedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument
{
    
    public DataReceivedFinishedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATARECEIVEDFINISHED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataReceivedFinished");
    
    
    /**
     * Gets the "dataReceivedFinished" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getDataReceivedFinished()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATARECEIVEDFINISHED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataReceivedFinished" element
     */
    public void setDataReceivedFinished(org.dataandsearch.www.karma._2010._08.DataTransferType dataReceivedFinished)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATARECEIVEDFINISHED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATARECEIVEDFINISHED$0);
            }
            target.set(dataReceivedFinished);
        }
    }
    
    /**
     * Appends and returns a new empty "dataReceivedFinished" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewDataReceivedFinished()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATARECEIVEDFINISHED$0);
            return target;
        }
    }
}
