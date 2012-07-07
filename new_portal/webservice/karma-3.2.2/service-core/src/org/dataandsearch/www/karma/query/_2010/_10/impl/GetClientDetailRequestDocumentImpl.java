/*
 * An XML document type.
 * Localname: getClientDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getClientDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetClientDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestDocument
{
    
    public GetClientDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETCLIENTDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getClientDetailRequest");
    
    
    /**
     * Gets the "getClientDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType getGetClientDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType)get_store().find_element_user(GETCLIENTDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getClientDetailRequest" element
     */
    public void setGetClientDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType getClientDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType)get_store().find_element_user(GETCLIENTDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType)get_store().add_element_user(GETCLIENTDETAILREQUEST$0);
            }
            target.set(getClientDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getClientDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType addNewGetClientDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType)get_store().add_element_user(GETCLIENTDETAILREQUEST$0);
            return target;
        }
    }
}
