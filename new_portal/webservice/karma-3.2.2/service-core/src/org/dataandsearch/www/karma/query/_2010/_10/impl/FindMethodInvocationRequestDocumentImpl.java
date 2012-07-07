/*
 * An XML document type.
 * Localname: findMethodInvocationRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findMethodInvocationRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindMethodInvocationRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestDocument
{
    
    public FindMethodInvocationRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDMETHODINVOCATIONREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findMethodInvocationRequest");
    
    
    /**
     * Gets the "findMethodInvocationRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType getFindMethodInvocationRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType)get_store().find_element_user(FINDMETHODINVOCATIONREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findMethodInvocationRequest" element
     */
    public void setFindMethodInvocationRequest(org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType findMethodInvocationRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType)get_store().find_element_user(FINDMETHODINVOCATIONREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType)get_store().add_element_user(FINDMETHODINVOCATIONREQUEST$0);
            }
            target.set(findMethodInvocationRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "findMethodInvocationRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType addNewFindMethodInvocationRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType)get_store().add_element_user(FINDMETHODINVOCATIONREQUEST$0);
            return target;
        }
    }
}
