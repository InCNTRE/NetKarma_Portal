/*
 * An XML document type.
 * Localname: getAbstractServiceDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAbstractServiceDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAbstractServiceDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestDocument
{
    
    public GetAbstractServiceDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETABSTRACTSERVICEDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAbstractServiceDetailRequest");
    
    
    /**
     * Gets the "getAbstractServiceDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType getGetAbstractServiceDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType)get_store().find_element_user(GETABSTRACTSERVICEDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAbstractServiceDetailRequest" element
     */
    public void setGetAbstractServiceDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType getAbstractServiceDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType)get_store().find_element_user(GETABSTRACTSERVICEDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType)get_store().add_element_user(GETABSTRACTSERVICEDETAILREQUEST$0);
            }
            target.set(getAbstractServiceDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getAbstractServiceDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType addNewGetAbstractServiceDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType)get_store().add_element_user(GETABSTRACTSERVICEDETAILREQUEST$0);
            return target;
        }
    }
}
