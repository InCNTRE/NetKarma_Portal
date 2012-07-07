/*
 * An XML document type.
 * Localname: dataSendFinished
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataSendFinished(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataSendFinishedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument
{
    
    public DataSendFinishedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATASENDFINISHED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataSendFinished");
    
    
    /**
     * Gets the "dataSendFinished" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType getDataSendFinished()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATASENDFINISHED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataSendFinished" element
     */
    public void setDataSendFinished(org.dataandsearch.www.karma._2010._08.DataTransferType dataSendFinished)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().find_element_user(DATASENDFINISHED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATASENDFINISHED$0);
            }
            target.set(dataSendFinished);
        }
    }
    
    /**
     * Appends and returns a new empty "dataSendFinished" element
     */
    public org.dataandsearch.www.karma._2010._08.DataTransferType addNewDataSendFinished()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataTransferType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataTransferType)get_store().add_element_user(DATASENDFINISHED$0);
            return target;
        }
    }
}
