/*
 * An XML document type.
 * Localname: getServiceDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getServiceDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetServiceDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument
{
    
    public GetServiceDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETSERVICEDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getServiceDetailRequest");
    
    
    /**
     * Gets the "getServiceDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType getGetServiceDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType)get_store().find_element_user(GETSERVICEDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getServiceDetailRequest" element
     */
    public void setGetServiceDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType getServiceDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType)get_store().find_element_user(GETSERVICEDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType)get_store().add_element_user(GETSERVICEDETAILREQUEST$0);
            }
            target.set(getServiceDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getServiceDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType addNewGetServiceDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType)get_store().add_element_user(GETSERVICEDETAILREQUEST$0);
            return target;
        }
    }
}
