/*
 * An XML document type.
 * Localname: dataProduced
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataProducedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataProduced(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataProducedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataProducedDocument
{
    
    public DataProducedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAPRODUCED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataProduced");
    
    
    /**
     * Gets the "dataProduced" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType getDataProduced()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATAPRODUCED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataProduced" element
     */
    public void setDataProduced(org.dataandsearch.www.karma._2010._08.DataLifeCycleType dataProduced)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATAPRODUCED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATAPRODUCED$0);
            }
            target.set(dataProduced);
        }
    }
    
    /**
     * Appends and returns a new empty "dataProduced" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType addNewDataProduced()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATAPRODUCED$0);
            return target;
        }
    }
}
