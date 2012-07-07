/*
 * An XML document type.
 * Localname: getServiceDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getServiceDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetServiceDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument
{
    
    public GetServiceDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETSERVICEDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getServiceDetailResponse");
    
    
    /**
     * Gets the "getServiceDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType getGetServiceDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType)get_store().find_element_user(GETSERVICEDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getServiceDetailResponse" element
     */
    public void setGetServiceDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType getServiceDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType)get_store().find_element_user(GETSERVICEDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType)get_store().add_element_user(GETSERVICEDETAILRESPONSE$0);
            }
            target.set(getServiceDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getServiceDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType addNewGetServiceDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType)get_store().add_element_user(GETSERVICEDETAILRESPONSE$0);
            return target;
        }
    }
}
