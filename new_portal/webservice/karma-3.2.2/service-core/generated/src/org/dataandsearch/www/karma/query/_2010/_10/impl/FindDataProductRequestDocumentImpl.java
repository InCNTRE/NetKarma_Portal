/*
 * An XML document type.
 * Localname: findDataProductRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findDataProductRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindDataProductRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestDocument
{
    
    public FindDataProductRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDDATAPRODUCTREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findDataProductRequest");
    
    
    /**
     * Gets the "findDataProductRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType getFindDataProductRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType)get_store().find_element_user(FINDDATAPRODUCTREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findDataProductRequest" element
     */
    public void setFindDataProductRequest(org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType findDataProductRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType)get_store().find_element_user(FINDDATAPRODUCTREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType)get_store().add_element_user(FINDDATAPRODUCTREQUEST$0);
            }
            target.set(findDataProductRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "findDataProductRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType addNewFindDataProductRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType)get_store().add_element_user(FINDDATAPRODUCTREQUEST$0);
            return target;
        }
    }
}
