/*
 * An XML document type.
 * Localname: findAbstractMethodRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findAbstractMethodRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindAbstractMethodRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestDocument
{
    
    public FindAbstractMethodRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDABSTRACTMETHODREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findAbstractMethodRequest");
    
    
    /**
     * Gets the "findAbstractMethodRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType getFindAbstractMethodRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType)get_store().find_element_user(FINDABSTRACTMETHODREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findAbstractMethodRequest" element
     */
    public void setFindAbstractMethodRequest(org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType findAbstractMethodRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType)get_store().find_element_user(FINDABSTRACTMETHODREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType)get_store().add_element_user(FINDABSTRACTMETHODREQUEST$0);
            }
            target.set(findAbstractMethodRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "findAbstractMethodRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType addNewFindAbstractMethodRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType)get_store().add_element_user(FINDABSTRACTMETHODREQUEST$0);
            return target;
        }
    }
}
