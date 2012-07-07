/*
 * An XML document type.
 * Localname: dataUpdated
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataUpdatedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataUpdated(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataUpdatedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataUpdatedDocument
{
    
    public DataUpdatedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAUPDATED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataUpdated");
    
    
    /**
     * Gets the "dataUpdated" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType getDataUpdated()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATAUPDATED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataUpdated" element
     */
    public void setDataUpdated(org.dataandsearch.www.karma._2010._08.DataLifeCycleType dataUpdated)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATAUPDATED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATAUPDATED$0);
            }
            target.set(dataUpdated);
        }
    }
    
    /**
     * Appends and returns a new empty "dataUpdated" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType addNewDataUpdated()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATAUPDATED$0);
            return target;
        }
    }
}
