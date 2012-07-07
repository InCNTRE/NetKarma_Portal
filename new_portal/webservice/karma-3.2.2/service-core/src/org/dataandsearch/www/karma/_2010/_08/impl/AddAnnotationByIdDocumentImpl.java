/*
 * An XML document type.
 * Localname: addAnnotationById
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one addAnnotationById(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class AddAnnotationByIdDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument
{
    
    public AddAnnotationByIdDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDANNOTATIONBYID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "addAnnotationById");
    
    
    /**
     * Gets the "addAnnotationById" element
     */
    public org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType getAddAnnotationById()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType)get_store().find_element_user(ADDANNOTATIONBYID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "addAnnotationById" element
     */
    public void setAddAnnotationById(org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType addAnnotationById)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType)get_store().find_element_user(ADDANNOTATIONBYID$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType)get_store().add_element_user(ADDANNOTATIONBYID$0);
            }
            target.set(addAnnotationById);
        }
    }
    
    /**
     * Appends and returns a new empty "addAnnotationById" element
     */
    public org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType addNewAddAnnotationById()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType)get_store().add_element_user(ADDANNOTATIONBYID$0);
            return target;
        }
    }
}
