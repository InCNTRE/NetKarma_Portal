/*
 * An XML document type.
 * Localname: findServiceRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindServiceRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one findServiceRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class FindServiceRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindServiceRequestDocument
{
    
    public FindServiceRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FINDSERVICEREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "findServiceRequest");
    
    
    /**
     * Gets the "findServiceRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType getFindServiceRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType)get_store().find_element_user(FINDSERVICEREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "findServiceRequest" element
     */
    public void setFindServiceRequest(org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType findServiceRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType)get_store().find_element_user(FINDSERVICEREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType)get_store().add_element_user(FINDSERVICEREQUEST$0);
            }
            target.set(findServiceRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "findServiceRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType addNewFindServiceRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType)get_store().add_element_user(FINDSERVICEREQUEST$0);
            return target;
        }
    }
}
