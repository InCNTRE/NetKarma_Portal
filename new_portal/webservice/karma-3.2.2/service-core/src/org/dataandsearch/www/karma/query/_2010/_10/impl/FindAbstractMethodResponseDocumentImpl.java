/*
 * An XML document type.
 * Localname: findAbstractMethodResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findAbstractMethodResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindAbstractMethodResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseDocument
{
    
    public FindAbstractMethodResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDABSTRACTMETHODRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findAbstractMethodResponse");
    
    
    /**
     * Gets the "findAbstractMethodResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType getFindAbstractMethodResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType)get_store().find_element_user(FINDABSTRACTMETHODRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findAbstractMethodResponse" element
     */
    public void setFindAbstractMethodResponse(org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType findAbstractMethodResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType)get_store().find_element_user(FINDABSTRACTMETHODRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType)get_store().add_element_user(FINDABSTRACTMETHODRESPONSE$0);
            }
            target.set(findAbstractMethodResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "findAbstractMethodResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType addNewFindAbstractMethodResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType)get_store().add_element_user(FINDABSTRACTMETHODRESPONSE$0);
            return target;
        }
    }
}
