/*
 * An XML document type.
 * Localname: getMethodInvocationDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getMethodInvocationDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetMethodInvocationDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseDocument
{
    
    public GetMethodInvocationDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETMETHODINVOCATIONDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getMethodInvocationDetailResponse");
    
    
    /**
     * Gets the "getMethodInvocationDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType getGetMethodInvocationDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType)get_store().find_element_user(GETMETHODINVOCATIONDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getMethodInvocationDetailResponse" element
     */
    public void setGetMethodInvocationDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType getMethodInvocationDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType)get_store().find_element_user(GETMETHODINVOCATIONDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType)get_store().add_element_user(GETMETHODINVOCATIONDETAILRESPONSE$0);
            }
            target.set(getMethodInvocationDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getMethodInvocationDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType addNewGetMethodInvocationDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType)get_store().add_element_user(GETMETHODINVOCATIONDETAILRESPONSE$0);
            return target;
        }
    }
}
