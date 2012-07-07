/*
 * An XML document type.
 * Localname: getDataProductDetailRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getDataProductDetailRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetDataProductDetailRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestDocument
{
    
    public GetDataProductDetailRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETDATAPRODUCTDETAILREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getDataProductDetailRequest");
    
    
    /**
     * Gets the "getDataProductDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType getGetDataProductDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType)get_store().find_element_user(GETDATAPRODUCTDETAILREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getDataProductDetailRequest" element
     */
    public void setGetDataProductDetailRequest(org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType getDataProductDetailRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType)get_store().find_element_user(GETDATAPRODUCTDETAILREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType)get_store().add_element_user(GETDATAPRODUCTDETAILREQUEST$0);
            }
            target.set(getDataProductDetailRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getDataProductDetailRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType addNewGetDataProductDetailRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType)get_store().add_element_user(GETDATAPRODUCTDETAILREQUEST$0);
            return target;
        }
    }
}
