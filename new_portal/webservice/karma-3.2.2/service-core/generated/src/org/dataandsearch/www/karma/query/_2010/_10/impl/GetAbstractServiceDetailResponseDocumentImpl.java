/*
 * An XML document type.
 * Localname: getAbstractServiceDetailResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getAbstractServiceDetailResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetAbstractServiceDetailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseDocument
{
    
    public GetAbstractServiceDetailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETABSTRACTSERVICEDETAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getAbstractServiceDetailResponse");
    
    
    /**
     * Gets the "getAbstractServiceDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType getGetAbstractServiceDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType)get_store().find_element_user(GETABSTRACTSERVICEDETAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAbstractServiceDetailResponse" element
     */
    public void setGetAbstractServiceDetailResponse(org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType getAbstractServiceDetailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType)get_store().find_element_user(GETABSTRACTSERVICEDETAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType)get_store().add_element_user(GETABSTRACTSERVICEDETAILRESPONSE$0);
            }
            target.set(getAbstractServiceDetailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getAbstractServiceDetailResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType addNewGetAbstractServiceDetailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType)get_store().add_element_user(GETABSTRACTSERVICEDETAILRESPONSE$0);
            return target;
        }
    }
}
