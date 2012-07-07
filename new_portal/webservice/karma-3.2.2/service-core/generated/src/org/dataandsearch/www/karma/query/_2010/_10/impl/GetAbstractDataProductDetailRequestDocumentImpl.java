/*
 * An XML document type.
 * Localname: getAbstractDataProductDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAbstractDataProductDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAbstractDataProductDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestDocument
{
    
    public GetAbstractDataProductDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETABSTRACTDATAPRODUCTDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAbstractDataProductDetailRequest");
    
    
    /**
     * Gets the "getAbstractDataProductDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType getGetAbstractDataProductDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType)get_store().find_element_user(GETABSTRACTDATAPRODUCTDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAbstractDataProductDetailRequest" element
     */
    public void setGetAbstractDataProductDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType getAbstractDataProductDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType)get_store().find_element_user(GETABSTRACTDATAPRODUCTDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType)get_store().add_element_user(GETABSTRACTDATAPRODUCTDETAILREQUEST$0);
            }
            target.set(getAbstractDataProductDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getAbstractDataProductDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType addNewGetAbstractDataProductDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType)get_store().add_element_user(GETABSTRACTDATAPRODUCTDETAILREQUEST$0);
            return target;
        }
    }
}
