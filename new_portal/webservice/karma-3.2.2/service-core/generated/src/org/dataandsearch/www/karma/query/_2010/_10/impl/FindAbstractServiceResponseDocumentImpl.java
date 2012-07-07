/*
 * An XML document type.
 * Localname: findAbstractServiceResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findAbstractServiceResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindAbstractServiceResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseDocument
{
    
    public FindAbstractServiceResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDABSTRACTSERVICERESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findAbstractServiceResponse");
    
    
    /**
     * Gets the "findAbstractServiceResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType getFindAbstractServiceResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType)get_store().find_element_user(FINDABSTRACTSERVICERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findAbstractServiceResponse" element
     */
    public void setFindAbstractServiceResponse(org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType findAbstractServiceResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType)get_store().find_element_user(FINDABSTRACTSERVICERESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType)get_store().add_element_user(FINDABSTRACTSERVICERESPONSE$0);
            }
            target.set(findAbstractServiceResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "findAbstractServiceResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType addNewFindAbstractServiceResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType)get_store().add_element_user(FINDABSTRACTSERVICERESPONSE$0);
            return target;
        }
    }
}
