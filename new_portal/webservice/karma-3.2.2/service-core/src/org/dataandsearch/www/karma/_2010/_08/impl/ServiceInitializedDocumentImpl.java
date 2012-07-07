/*
 * An XML document type.
 * Localname: serviceInitialized
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.ServiceInitializedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one serviceInitialized(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class ServiceInitializedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.ServiceInitializedDocument
{
    
    public ServiceInitializedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEINITIALIZED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "serviceInitialized");
    
    
    /**
     * Gets the "serviceInitialized" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType getServiceInitialized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(SERVICEINITIALIZED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "serviceInitialized" element
     */
    public void setServiceInitialized(org.dataandsearch.www.karma._2010._08.EntityLifeCycleType serviceInitialized)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(SERVICEINITIALIZED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(SERVICEINITIALIZED$0);
            }
            target.set(serviceInitialized);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceInitialized" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType addNewServiceInitialized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(SERVICEINITIALIZED$0);
            return target;
        }
    }
}
