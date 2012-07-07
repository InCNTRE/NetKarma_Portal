/*
 * An XML document type.
 * Localname: findAbstractServiceRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findAbstractServiceRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindAbstractServiceRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestDocument
{
    
    public FindAbstractServiceRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDABSTRACTSERVICEREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findAbstractServiceRequest");
    
    
    /**
     * Gets the "findAbstractServiceRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType getFindAbstractServiceRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType)get_store().find_element_user(FINDABSTRACTSERVICEREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findAbstractServiceRequest" element
     */
    public void setFindAbstractServiceRequest(org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType findAbstractServiceRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType)get_store().find_element_user(FINDABSTRACTSERVICEREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType)get_store().add_element_user(FINDABSTRACTSERVICEREQUEST$0);
            }
            target.set(findAbstractServiceRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "findAbstractServiceRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType addNewFindAbstractServiceRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType)get_store().add_element_user(FINDABSTRACTSERVICEREQUEST$0);
            return target;
        }
    }
}
