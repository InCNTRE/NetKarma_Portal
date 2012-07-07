/*
 * An XML document type.
 * Localname: getAbstractMethodDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAbstractMethodDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAbstractMethodDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseDocument
{
    
    public GetAbstractMethodDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETABSTRACTMETHODDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAbstractMethodDetailResponse");
    
    
    /**
     * Gets the "getAbstractMethodDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType getGetAbstractMethodDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType)get_store().find_element_user(GETABSTRACTMETHODDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAbstractMethodDetailResponse" element
     */
    public void setGetAbstractMethodDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType getAbstractMethodDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType)get_store().find_element_user(GETABSTRACTMETHODDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType)get_store().add_element_user(GETABSTRACTMETHODDETAILRESPONSE$0);
            }
            target.set(getAbstractMethodDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getAbstractMethodDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType addNewGetAbstractMethodDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType)get_store().add_element_user(GETABSTRACTMETHODDETAILRESPONSE$0);
            return target;
        }
    }
}
