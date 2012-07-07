/*
 * An XML document type.
 * Localname: addRelationshipAnnotationById
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one addRelationshipAnnotationById(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class AddRelationshipAnnotationByIdDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdDocument
{
    
    public AddRelationshipAnnotationByIdDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRELATIONSHIPANNOTATIONBYID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "addRelationshipAnnotationById");
    
    
    /**
     * Gets the "addRelationshipAnnotationById" element
     */
    public org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType getAddRelationshipAnnotationById()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType)get_store().find_element_user(ADDRELATIONSHIPANNOTATIONBYID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "addRelationshipAnnotationById" element
     */
    public void setAddRelationshipAnnotationById(org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType addRelationshipAnnotationById)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType)get_store().find_element_user(ADDRELATIONSHIPANNOTATIONBYID$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType)get_store().add_element_user(ADDRELATIONSHIPANNOTATIONBYID$0);
            }
            target.set(addRelationshipAnnotationById);
        }
    }
    
    /**
     * Appends and returns a new empty "addRelationshipAnnotationById" element
     */
    public org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType addNewAddRelationshipAnnotationById()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType)get_store().add_element_user(ADDRELATIONSHIPANNOTATIONBYID$0);
            return target;
        }
    }
}
