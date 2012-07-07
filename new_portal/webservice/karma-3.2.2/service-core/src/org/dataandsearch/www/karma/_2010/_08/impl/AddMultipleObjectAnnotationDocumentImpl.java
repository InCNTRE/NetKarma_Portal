/*
 * An XML document type.
 * Localname: addMultipleObjectAnnotation
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one addMultipleObjectAnnotation(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class AddMultipleObjectAnnotationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument
{
    
    public AddMultipleObjectAnnotationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDMULTIPLEOBJECTANNOTATION$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "addMultipleObjectAnnotation");
    
    
    /**
     * Gets the "addMultipleObjectAnnotation" element
     */
    public org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType getAddMultipleObjectAnnotation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType)get_store().find_element_user(ADDMULTIPLEOBJECTANNOTATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "addMultipleObjectAnnotation" element
     */
    public void setAddMultipleObjectAnnotation(org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType addMultipleObjectAnnotation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType)get_store().find_element_user(ADDMULTIPLEOBJECTANNOTATION$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType)get_store().add_element_user(ADDMULTIPLEOBJECTANNOTATION$0);
            }
            target.set(addMultipleObjectAnnotation);
        }
    }
    
    /**
     * Appends and returns a new empty "addMultipleObjectAnnotation" element
     */
    public org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType addNewAddMultipleObjectAnnotation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType)get_store().add_element_user(ADDMULTIPLEOBJECTANNOTATION$0);
            return target;
        }
    }
}
