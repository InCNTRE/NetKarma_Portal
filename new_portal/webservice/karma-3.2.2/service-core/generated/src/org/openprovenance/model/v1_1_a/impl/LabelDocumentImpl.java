/*
 * An XML document type.
 * Localname: label
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.LabelDocument
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * A document containing one label(@http://openprovenance.org/model/v1.1.a) element.
 *
 * This is a complex type.
 */
public class LabelDocumentImpl extends org.openprovenance.model.v1_1_a.impl.AnnotationDocumentImpl implements org.openprovenance.model.v1_1_a.LabelDocument
{
    
    public LabelDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LABEL$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "label");
    
    
    /**
     * Gets the "label" element
     */
    public org.openprovenance.model.v1_1_a.Label getLabel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Label target = null;
            target = (org.openprovenance.model.v1_1_a.Label)get_store().find_element_user(LABEL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "label" element
     */
    public void setLabel(org.openprovenance.model.v1_1_a.Label label)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Label target = null;
            target = (org.openprovenance.model.v1_1_a.Label)get_store().find_element_user(LABEL$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Label)get_store().add_element_user(LABEL$0);
            }
            target.set(label);
        }
    }
    
    /**
     * Appends and returns a new empty "label" element
     */
    public org.openprovenance.model.v1_1_a.Label addNewLabel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Label target = null;
            target = (org.openprovenance.model.v1_1_a.Label)get_store().add_element_user(LABEL$0);
            return target;
        }
    }
}
