/*
 * An XML document type.
 * Localname: findDataProductResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findDataProductResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindDataProductResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseDocument
{
    
    public FindDataProductResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDDATAPRODUCTRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findDataProductResponse");
    
    
    /**
     * Gets the "findDataProductResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType getFindDataProductResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType)get_store().find_element_user(FINDDATAPRODUCTRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findDataProductResponse" element
     */
    public void setFindDataProductResponse(org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType findDataProductResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType)get_store().find_element_user(FINDDATAPRODUCTRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType)get_store().add_element_user(FINDDATAPRODUCTRESPONSE$0);
            }
            target.set(findDataProductResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "findDataProductResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType addNewFindDataProductResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType)get_store().add_element_user(FINDDATAPRODUCTRESPONSE$0);
            return target;
        }
    }
}
