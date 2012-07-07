/*
 * An XML document type.
 * Localname: findMethodInvocationResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findMethodInvocationResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindMethodInvocationResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseDocument
{
    
    public FindMethodInvocationResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDMETHODINVOCATIONRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findMethodInvocationResponse");
    
    
    /**
     * Gets the "findMethodInvocationResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType getFindMethodInvocationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType)get_store().find_element_user(FINDMETHODINVOCATIONRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findMethodInvocationResponse" element
     */
    public void setFindMethodInvocationResponse(org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType findMethodInvocationResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType)get_store().find_element_user(FINDMETHODINVOCATIONRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType)get_store().add_element_user(FINDMETHODINVOCATIONRESPONSE$0);
            }
            target.set(findMethodInvocationResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "findMethodInvocationResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType addNewFindMethodInvocationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType)get_store().add_element_user(FINDMETHODINVOCATIONRESPONSE$0);
            return target;
        }
    }
}
