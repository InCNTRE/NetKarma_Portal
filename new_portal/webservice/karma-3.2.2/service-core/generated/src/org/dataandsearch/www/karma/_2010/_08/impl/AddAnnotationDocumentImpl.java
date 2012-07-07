/*
 * An XML document type.
 * Localname: addAnnotation
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AddAnnotationDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one addAnnotation(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class AddAnnotationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.AddAnnotationDocument
{
    
    public AddAnnotationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDANNOTATION$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "addAnnotation");
    
    
    /**
     * Gets the "addAnnotation" element
     */
    public org.dataandsearch.www.karma._2010._08.AddAnnotationType getAddAnnotation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddAnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddAnnotationType)get_store().find_element_user(ADDANNOTATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "addAnnotation" element
     */
    public void setAddAnnotation(org.dataandsearch.www.karma._2010._08.AddAnnotationType addAnnotation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddAnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddAnnotationType)get_store().find_element_user(ADDANNOTATION$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.AddAnnotationType)get_store().add_element_user(ADDANNOTATION$0);
            }
            target.set(addAnnotation);
        }
    }
    
    /**
     * Appends and returns a new empty "addAnnotation" element
     */
    public org.dataandsearch.www.karma._2010._08.AddAnnotationType addNewAddAnnotation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AddAnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AddAnnotationType)get_store().add_element_user(ADDANNOTATION$0);
            return target;
        }
    }
}
