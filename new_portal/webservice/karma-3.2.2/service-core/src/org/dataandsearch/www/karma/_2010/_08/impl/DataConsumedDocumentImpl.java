/*
 * An XML document type.
 * Localname: dataConsumed
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataConsumedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataConsumed(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataConsumedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataConsumedDocument
{
    
    public DataConsumedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATACONSUMED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataConsumed");
    
    
    /**
     * Gets the "dataConsumed" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType getDataConsumed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATACONSUMED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataConsumed" element
     */
    public void setDataConsumed(org.dataandsearch.www.karma._2010._08.DataLifeCycleType dataConsumed)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATACONSUMED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATACONSUMED$0);
            }
            target.set(dataConsumed);
        }
    }
    
    /**
     * Appends and returns a new empty "dataConsumed" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType addNewDataConsumed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATACONSUMED$0);
            return target;
        }
    }
}
