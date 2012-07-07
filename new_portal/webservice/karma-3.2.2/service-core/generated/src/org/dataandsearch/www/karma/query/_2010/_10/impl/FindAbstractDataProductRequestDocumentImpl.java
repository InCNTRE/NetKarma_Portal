/*
 * An XML document type.
 * Localname: findAbstractDataProductRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findAbstractDataProductRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindAbstractDataProductRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestDocument
{
    
    public FindAbstractDataProductRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDABSTRACTDATAPRODUCTREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findAbstractDataProductRequest");
    
    
    /**
     * Gets the "findAbstractDataProductRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType getFindAbstractDataProductRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType)get_store().find_element_user(FINDABSTRACTDATAPRODUCTREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findAbstractDataProductRequest" element
     */
    public void setFindAbstractDataProductRequest(org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType findAbstractDataProductRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType)get_store().find_element_user(FINDABSTRACTDATAPRODUCTREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType)get_store().add_element_user(FINDABSTRACTDATAPRODUCTREQUEST$0);
            }
            target.set(findAbstractDataProductRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "findAbstractDataProductRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType addNewFindAbstractDataProductRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType)get_store().add_element_user(FINDABSTRACTDATAPRODUCTREQUEST$0);
            return target;
        }
    }
}
