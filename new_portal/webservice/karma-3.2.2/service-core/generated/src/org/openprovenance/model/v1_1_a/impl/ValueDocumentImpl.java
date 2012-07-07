/*
 * An XML document type.
 * Localname: value
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.ValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * A document containing one value(@http://openprovenance.org/model/v1.1.a) element.
 *
 * This is a complex type.
 */
public class ValueDocumentImpl extends org.openprovenance.model.v1_1_a.impl.AnnotationDocumentImpl implements org.openprovenance.model.v1_1_a.ValueDocument
{
    
    public ValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VALUE$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "value");
    
    
    /**
     * Gets the "value" element
     */
    public org.openprovenance.model.v1_1_a.Value getValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Value target = null;
            target = (org.openprovenance.model.v1_1_a.Value)get_store().find_element_user(VALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "value" element
     */
    public void setValue(org.openprovenance.model.v1_1_a.Value value)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Value target = null;
            target = (org.openprovenance.model.v1_1_a.Value)get_store().find_element_user(VALUE$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Value)get_store().add_element_user(VALUE$0);
            }
            target.set(value);
        }
    }
    
    /**
     * Appends and returns a new empty "value" element
     */
    public org.openprovenance.model.v1_1_a.Value addNewValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Value target = null;
            target = (org.openprovenance.model.v1_1_a.Value)get_store().add_element_user(VALUE$0);
            return target;
        }
    }
}
