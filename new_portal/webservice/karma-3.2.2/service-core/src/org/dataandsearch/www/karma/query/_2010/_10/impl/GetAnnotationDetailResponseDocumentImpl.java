/*
 * An XML document type.
 * Localname: getAnnotationDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAnnotationDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAnnotationDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseDocument
{
    
    public GetAnnotationDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETANNOTATIONDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAnnotationDetailResponse");
    
    
    /**
     * Gets the "getAnnotationDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType getGetAnnotationDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType)get_store().find_element_user(GETANNOTATIONDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAnnotationDetailResponse" element
     */
    public void setGetAnnotationDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType getAnnotationDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType)get_store().find_element_user(GETANNOTATIONDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType)get_store().add_element_user(GETANNOTATIONDETAILRESPONSE$0);
            }
            target.set(getAnnotationDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getAnnotationDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType addNewGetAnnotationDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType)get_store().add_element_user(GETANNOTATIONDETAILRESPONSE$0);
            return target;
        }
    }
}
