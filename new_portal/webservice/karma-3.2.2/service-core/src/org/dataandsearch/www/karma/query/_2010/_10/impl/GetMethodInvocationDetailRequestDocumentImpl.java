/*
 * An XML document type.
 * Localname: getMethodInvocationDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getMethodInvocationDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetMethodInvocationDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestDocument
{
    
    public GetMethodInvocationDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETMETHODINVOCATIONDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getMethodInvocationDetailRequest");
    
    
    /**
     * Gets the "getMethodInvocationDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType getGetMethodInvocationDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType)get_store().find_element_user(GETMETHODINVOCATIONDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getMethodInvocationDetailRequest" element
     */
    public void setGetMethodInvocationDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType getMethodInvocationDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType)get_store().find_element_user(GETMETHODINVOCATIONDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType)get_store().add_element_user(GETMETHODINVOCATIONDETAILREQUEST$0);
            }
            target.set(getMethodInvocationDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getMethodInvocationDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType addNewGetMethodInvocationDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestType)get_store().add_element_user(GETMETHODINVOCATIONDETAILREQUEST$0);
            return target;
        }
    }
}
