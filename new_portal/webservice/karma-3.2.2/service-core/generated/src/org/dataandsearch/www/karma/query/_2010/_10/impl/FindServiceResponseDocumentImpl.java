/*
 * An XML document type.
 * Localname: findServiceResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindServiceResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findServiceResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindServiceResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindServiceResponseDocument
{
    
    public FindServiceResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDSERVICERESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findServiceResponse");
    
    
    /**
     * Gets the "findServiceResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType getFindServiceResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType)get_store().find_element_user(FINDSERVICERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findServiceResponse" element
     */
    public void setFindServiceResponse(org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType findServiceResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType)get_store().find_element_user(FINDSERVICERESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType)get_store().add_element_user(FINDSERVICERESPONSE$0);
            }
            target.set(findServiceResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "findServiceResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType addNewFindServiceResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType)get_store().add_element_user(FINDSERVICERESPONSE$0);
            return target;
        }
    }
}
