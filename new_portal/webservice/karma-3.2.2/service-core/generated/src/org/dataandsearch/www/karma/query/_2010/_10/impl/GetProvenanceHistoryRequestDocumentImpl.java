/*
 * An XML document type.
 * Localname: getProvenanceHistoryRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getProvenanceHistoryRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetProvenanceHistoryRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestDocument
{
    
    public GetProvenanceHistoryRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETPROVENANCEHISTORYREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getProvenanceHistoryRequest");
    
    
    /**
     * Gets the "getProvenanceHistoryRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType getGetProvenanceHistoryRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType)get_store().find_element_user(GETPROVENANCEHISTORYREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getProvenanceHistoryRequest" element
     */
    public void setGetProvenanceHistoryRequest(org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType getProvenanceHistoryRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType)get_store().find_element_user(GETPROVENANCEHISTORYREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType)get_store().add_element_user(GETPROVENANCEHISTORYREQUEST$0);
            }
            target.set(getProvenanceHistoryRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getProvenanceHistoryRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType addNewGetProvenanceHistoryRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType)get_store().add_element_user(GETPROVENANCEHISTORYREQUEST$0);
            return target;
        }
    }
}
