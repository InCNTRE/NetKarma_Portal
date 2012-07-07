/*
 * An XML document type.
 * Localname: findAbstractDataProductResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findAbstractDataProductResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindAbstractDataProductResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseDocument
{
    
    public FindAbstractDataProductResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDABSTRACTDATAPRODUCTRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findAbstractDataProductResponse");
    
    
    /**
     * Gets the "findAbstractDataProductResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType getFindAbstractDataProductResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType)get_store().find_element_user(FINDABSTRACTDATAPRODUCTRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findAbstractDataProductResponse" element
     */
    public void setFindAbstractDataProductResponse(org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType findAbstractDataProductResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType)get_store().find_element_user(FINDABSTRACTDATAPRODUCTRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType)get_store().add_element_user(FINDABSTRACTDATAPRODUCTRESPONSE$0);
            }
            target.set(findAbstractDataProductResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "findAbstractDataProductResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType addNewFindAbstractDataProductResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType)get_store().add_element_user(FINDABSTRACTDATAPRODUCTRESPONSE$0);
            return target;
        }
    }
}
