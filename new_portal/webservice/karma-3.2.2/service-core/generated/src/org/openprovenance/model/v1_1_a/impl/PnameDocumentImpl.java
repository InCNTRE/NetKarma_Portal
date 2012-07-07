/*
 * An XML document type.
 * Localname: pname
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.PnameDocument
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * A document containing one pname(@http://openprovenance.org/model/v1.1.a) element.
 *
 * This is a complex type.
 */
public class PnameDocumentImpl extends org.openprovenance.model.v1_1_a.impl.AnnotationDocumentImpl implements org.openprovenance.model.v1_1_a.PnameDocument
{
    
    public PnameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PNAME$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "pname");
    
    
    /**
     * Gets the "pname" element
     */
    public org.openprovenance.model.v1_1_a.PName getPname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.PName target = null;
            target = (org.openprovenance.model.v1_1_a.PName)get_store().find_element_user(PNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "pname" element
     */
    public void setPname(org.openprovenance.model.v1_1_a.PName pname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.PName target = null;
            target = (org.openprovenance.model.v1_1_a.PName)get_store().find_element_user(PNAME$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.PName)get_store().add_element_user(PNAME$0);
            }
            target.set(pname);
        }
    }
    
    /**
     * Appends and returns a new empty "pname" element
     */
    public org.openprovenance.model.v1_1_a.PName addNewPname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.PName target = null;
            target = (org.openprovenance.model.v1_1_a.PName)get_store().add_element_user(PNAME$0);
            return target;
        }
    }
}
