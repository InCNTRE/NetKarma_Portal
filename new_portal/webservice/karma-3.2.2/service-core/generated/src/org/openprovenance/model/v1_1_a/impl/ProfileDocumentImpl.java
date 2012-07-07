/*
 * An XML document type.
 * Localname: profile
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.ProfileDocument
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * A document containing one profile(@http://openprovenance.org/model/v1.1.a) element.
 *
 * This is a complex type.
 */
public class ProfileDocumentImpl extends org.openprovenance.model.v1_1_a.impl.AnnotationDocumentImpl implements org.openprovenance.model.v1_1_a.ProfileDocument
{
    
    public ProfileDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROFILE$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "profile");
    
    
    /**
     * Gets the "profile" element
     */
    public org.openprovenance.model.v1_1_a.Profile getProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Profile target = null;
            target = (org.openprovenance.model.v1_1_a.Profile)get_store().find_element_user(PROFILE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "profile" element
     */
    public void setProfile(org.openprovenance.model.v1_1_a.Profile profile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Profile target = null;
            target = (org.openprovenance.model.v1_1_a.Profile)get_store().find_element_user(PROFILE$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Profile)get_store().add_element_user(PROFILE$0);
            }
            target.set(profile);
        }
    }
    
    /**
     * Appends and returns a new empty "profile" element
     */
    public org.openprovenance.model.v1_1_a.Profile addNewProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Profile target = null;
            target = (org.openprovenance.model.v1_1_a.Profile)get_store().add_element_user(PROFILE$0);
            return target;
        }
    }
}
