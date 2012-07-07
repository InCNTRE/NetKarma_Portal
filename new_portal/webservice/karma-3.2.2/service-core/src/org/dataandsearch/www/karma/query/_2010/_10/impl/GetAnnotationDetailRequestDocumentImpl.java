/*
 * An XML document type.
 * Localname: getAnnotationDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAnnotationDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAnnotationDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestDocument
{
    
    public GetAnnotationDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETANNOTATIONDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAnnotationDetailRequest");
    
    
    /**
     * Gets the "getAnnotationDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType getGetAnnotationDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType)get_store().find_element_user(GETANNOTATIONDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAnnotationDetailRequest" element
     */
    public void setGetAnnotationDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType getAnnotationDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType)get_store().find_element_user(GETANNOTATIONDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType)get_store().add_element_user(GETANNOTATIONDETAILREQUEST$0);
            }
            target.set(getAnnotationDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getAnnotationDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType addNewGetAnnotationDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType)get_store().add_element_user(GETANNOTATIONDETAILREQUEST$0);
            return target;
        }
    }
}
