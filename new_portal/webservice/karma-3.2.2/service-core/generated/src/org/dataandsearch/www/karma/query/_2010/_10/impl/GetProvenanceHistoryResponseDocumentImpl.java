/*
 * An XML document type.
 * Localname: getProvenanceHistoryResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getProvenanceHistoryResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetProvenanceHistoryResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseDocument
{
    
    public GetProvenanceHistoryResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETPROVENANCEHISTORYRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getProvenanceHistoryResponse");
    
    
    /**
     * Gets the "getProvenanceHistoryResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType getGetProvenanceHistoryResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType)get_store().find_element_user(GETPROVENANCEHISTORYRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getProvenanceHistoryResponse" element
     */
    public void setGetProvenanceHistoryResponse(org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType getProvenanceHistoryResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType)get_store().find_element_user(GETPROVENANCEHISTORYRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType)get_store().add_element_user(GETPROVENANCEHISTORYRESPONSE$0);
            }
            target.set(getProvenanceHistoryResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getProvenanceHistoryResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType addNewGetProvenanceHistoryResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType)get_store().add_element_user(GETPROVENANCEHISTORYRESPONSE$0);
            return target;
        }
    }
}
