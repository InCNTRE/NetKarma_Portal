/*
 * XML Type:  Agent
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Agent
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML Agent(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class AgentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.Agent
{
    
    public AgentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACCOUNT$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "account");
    private static final javax.xml.namespace.QName ANNOTATION$2 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "annotation");
    private static final org.apache.xmlbeans.QNameSet ANNOTATION$3 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "label"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "value"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "pname"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "profile"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "type"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "annotation"),
    });
    private static final javax.xml.namespace.QName ID$4 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets array of all "account" elements
     */
    public org.openprovenance.model.v1_1_a.AccountRef[] getAccountArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ACCOUNT$0, targetList);
            org.openprovenance.model.v1_1_a.AccountRef[] result = new org.openprovenance.model.v1_1_a.AccountRef[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "account" element
     */
    public org.openprovenance.model.v1_1_a.AccountRef getAccountArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.AccountRef target = null;
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().find_element_user(ACCOUNT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "account" element
     */
    public int sizeOfAccountArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ACCOUNT$0);
        }
    }
    
    /**
     * Sets array of all "account" element
     */
    public void setAccountArray(org.openprovenance.model.v1_1_a.AccountRef[] accountArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(accountArray, ACCOUNT$0);
        }
    }
    
    /**
     * Sets ith "account" element
     */
    public void setAccountArray(int i, org.openprovenance.model.v1_1_a.AccountRef account)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.AccountRef target = null;
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().find_element_user(ACCOUNT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(account);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "account" element
     */
    public org.openprovenance.model.v1_1_a.AccountRef insertNewAccount(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.AccountRef target = null;
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().insert_element_user(ACCOUNT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "account" element
     */
    public org.openprovenance.model.v1_1_a.AccountRef addNewAccount()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.AccountRef target = null;
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().add_element_user(ACCOUNT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "account" element
     */
    public void removeAccount(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ACCOUNT$0, i);
        }
    }
    
    /**
     * Gets array of all "annotation" elements
     */
    public org.openprovenance.model.v1_1_a.EmbeddedAnnotation[] getAnnotationArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANNOTATION$3, targetList);
            org.openprovenance.model.v1_1_a.EmbeddedAnnotation[] result = new org.openprovenance.model.v1_1_a.EmbeddedAnnotation[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "annotation" element
     */
    public org.openprovenance.model.v1_1_a.EmbeddedAnnotation getAnnotationArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.EmbeddedAnnotation target = null;
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().find_element_user(ANNOTATION$3, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "annotation" element
     */
    public int sizeOfAnnotationArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANNOTATION$3);
        }
    }
    
    /**
     * Sets array of all "annotation" element
     */
    public void setAnnotationArray(org.openprovenance.model.v1_1_a.EmbeddedAnnotation[] annotationArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(annotationArray, ANNOTATION$2, ANNOTATION$3);
        }
    }
    
    /**
     * Sets ith "annotation" element
     */
    public void setAnnotationArray(int i, org.openprovenance.model.v1_1_a.EmbeddedAnnotation annotation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.EmbeddedAnnotation target = null;
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().find_element_user(ANNOTATION$3, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(annotation);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "annotation" element
     */
    public org.openprovenance.model.v1_1_a.EmbeddedAnnotation insertNewAnnotation(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.EmbeddedAnnotation target = null;
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().insert_element_user(ANNOTATION$3, ANNOTATION$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotation" element
     */
    public org.openprovenance.model.v1_1_a.EmbeddedAnnotation addNewAnnotation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.EmbeddedAnnotation target = null;
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().add_element_user(ANNOTATION$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "annotation" element
     */
    public void removeAnnotation(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANNOTATION$3, i);
        }
    }
    
    /**
     * Gets the "id" attribute
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" attribute
     */
    public org.apache.xmlbeans.XmlID xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlID target = null;
            target = (org.apache.xmlbeans.XmlID)get_store().find_attribute_user(ID$4);
            return target;
        }
    }
    
    /**
     * True if has "id" attribute
     */
    public boolean isSetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(ID$4) != null;
        }
    }
    
    /**
     * Sets the "id" attribute
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$4);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" attribute
     */
    public void xsetId(org.apache.xmlbeans.XmlID id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlID target = null;
            target = (org.apache.xmlbeans.XmlID)get_store().find_attribute_user(ID$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlID)get_store().add_attribute_user(ID$4);
            }
            target.set(id);
        }
    }
    
    /**
     * Unsets the "id" attribute
     */
    public void unsetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(ID$4);
        }
    }
}
