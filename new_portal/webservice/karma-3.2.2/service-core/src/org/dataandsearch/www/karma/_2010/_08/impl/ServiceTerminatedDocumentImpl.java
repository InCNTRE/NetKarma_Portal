/*
 * An XML document type.
 * Localname: serviceTerminated
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.ServiceTerminatedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one serviceTerminated(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class ServiceTerminatedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.ServiceTerminatedDocument
{
    
    public ServiceTerminatedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICETERMINATED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "serviceTerminated");
    
    
    /**
     * Gets the "serviceTerminated" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType getServiceTerminated()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(SERVICETERMINATED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "serviceTerminated" element
     */
    public void setServiceTerminated(org.dataandsearch.www.karma._2010._08.EntityLifeCycleType serviceTerminated)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(SERVICETERMINATED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(SERVICETERMINATED$0);
            }
            target.set(serviceTerminated);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceTerminated" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType addNewServiceTerminated()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(SERVICETERMINATED$0);
            return target;
        }
    }
}
