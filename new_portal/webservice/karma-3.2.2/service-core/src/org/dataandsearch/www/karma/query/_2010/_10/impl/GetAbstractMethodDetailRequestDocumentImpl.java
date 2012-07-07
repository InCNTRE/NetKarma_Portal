/*
 * An XML document type.
 * Localname: getAbstractMethodDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAbstractMethodDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAbstractMethodDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestDocument
{
    
    public GetAbstractMethodDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETABSTRACTMETHODDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAbstractMethodDetailRequest");
    
    
    /**
     * Gets the "getAbstractMethodDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType getGetAbstractMethodDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType)get_store().find_element_user(GETABSTRACTMETHODDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAbstractMethodDetailRequest" element
     */
    public void setGetAbstractMethodDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType getAbstractMethodDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType)get_store().find_element_user(GETABSTRACTMETHODDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType)get_store().add_element_user(GETABSTRACTMETHODDETAILREQUEST$0);
            }
            target.set(getAbstractMethodDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getAbstractMethodDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType addNewGetAbstractMethodDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestType)get_store().add_element_user(GETABSTRACTMETHODDETAILREQUEST$0);
            return target;
        }
    }
}
