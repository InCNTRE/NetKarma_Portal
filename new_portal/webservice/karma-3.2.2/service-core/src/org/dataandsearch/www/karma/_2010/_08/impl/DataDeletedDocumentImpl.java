/*
 * An XML document type.
 * Localname: dataDeleted
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataDeletedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one dataDeleted(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class DataDeletedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataDeletedDocument
{
    
    public DataDeletedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATADELETED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataDeleted");
    
    
    /**
     * Gets the "dataDeleted" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType getDataDeleted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATADELETED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataDeleted" element
     */
    public void setDataDeleted(org.dataandsearch.www.karma._2010._08.DataLifeCycleType dataDeleted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().find_element_user(DATADELETED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATADELETED$0);
            }
            target.set(dataDeleted);
        }
    }
    
    /**
     * Appends and returns a new empty "dataDeleted" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType addNewDataDeleted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType)get_store().add_element_user(DATADELETED$0);
            return target;
        }
    }
}
