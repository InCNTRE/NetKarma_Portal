/*
 * An XML document type.
 * Localname: getAbstractDataProductDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAbstractDataProductDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAbstractDataProductDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseDocument
{
    
    public GetAbstractDataProductDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETABSTRACTDATAPRODUCTDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAbstractDataProductDetailResponse");
    
    
    /**
     * Gets the "getAbstractDataProductDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType getGetAbstractDataProductDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType)get_store().find_element_user(GETABSTRACTDATAPRODUCTDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAbstractDataProductDetailResponse" element
     */
    public void setGetAbstractDataProductDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType getAbstractDataProductDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType)get_store().find_element_user(GETABSTRACTDATAPRODUCTDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType)get_store().add_element_user(GETABSTRACTDATAPRODUCTDETAILRESPONSE$0);
            }
            target.set(getAbstractDataProductDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getAbstractDataProductDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType addNewGetAbstractDataProductDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType)get_store().add_element_user(GETABSTRACTDATAPRODUCTDETAILRESPONSE$0);
            return target;
        }
    }
}
