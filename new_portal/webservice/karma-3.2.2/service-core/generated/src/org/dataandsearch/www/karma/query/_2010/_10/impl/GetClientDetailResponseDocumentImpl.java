/*
 * An XML document type.
 * Localname: getClientDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getClientDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetClientDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseDocument
{
    
    public GetClientDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETCLIENTDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getClientDetailResponse");
    
    
    /**
     * Gets the "getClientDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType getGetClientDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType)get_store().find_element_user(GETCLIENTDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getClientDetailResponse" element
     */
    public void setGetClientDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType getClientDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType)get_store().find_element_user(GETCLIENTDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType)get_store().add_element_user(GETCLIENTDETAILRESPONSE$0);
            }
            target.set(getClientDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getClientDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType addNewGetClientDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType)get_store().add_element_user(GETCLIENTDETAILRESPONSE$0);
            return target;
        }
    }
}
