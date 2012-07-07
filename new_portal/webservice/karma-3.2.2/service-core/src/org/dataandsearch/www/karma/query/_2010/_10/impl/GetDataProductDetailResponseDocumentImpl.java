/*
 * An XML document type.
 * Localname: getDataProductDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getDataProductDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetDataProductDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseDocument
{
    
    public GetDataProductDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETDATAPRODUCTDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getDataProductDetailResponse");
    
    
    /**
     * Gets the "getDataProductDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType getGetDataProductDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType)get_store().find_element_user(GETDATAPRODUCTDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getDataProductDetailResponse" element
     */
    public void setGetDataProductDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType getDataProductDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType)get_store().find_element_user(GETDATAPRODUCTDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType)get_store().add_element_user(GETDATAPRODUCTDETAILRESPONSE$0);
            }
            target.set(getDataProductDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getDataProductDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType addNewGetDataProductDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType)get_store().add_element_user(GETDATAPRODUCTDETAILRESPONSE$0);
            return target;
        }
    }
}
