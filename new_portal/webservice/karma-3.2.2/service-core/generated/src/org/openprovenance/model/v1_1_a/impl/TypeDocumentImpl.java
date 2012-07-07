/*
 * An XML document type.
 * Localname: type
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.TypeDocument
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * A document containing one type(@http://openprovenance.org/model/v1.1.a) element.
 *
 * This is a complex type.
 */
public class TypeDocumentImpl extends org.openprovenance.model.v1_1_a.impl.AnnotationDocumentImpl implements org.openprovenance.model.v1_1_a.TypeDocument
{
    
    public TypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TYPE$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "type");
    
    
    /**
     * Gets the "type" element
     */
    public org.openprovenance.model.v1_1_a.Type getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Type target = null;
            target = (org.openprovenance.model.v1_1_a.Type)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "type" element
     */
    public void setType(org.openprovenance.model.v1_1_a.Type type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Type target = null;
            target = (org.openprovenance.model.v1_1_a.Type)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Type)get_store().add_element_user(TYPE$0);
            }
            target.set(type);
        }
    }
    
    /**
     * Appends and returns a new empty "type" element
     */
    public org.openprovenance.model.v1_1_a.Type addNewType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Type target = null;
            target = (org.openprovenance.model.v1_1_a.Type)get_store().add_element_user(TYPE$0);
            return target;
        }
    }
}
