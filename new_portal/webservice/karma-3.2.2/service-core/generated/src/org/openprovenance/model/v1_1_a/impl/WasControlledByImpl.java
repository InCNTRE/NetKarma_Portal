/*
 * XML Type:  WasControlledBy
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.WasControlledBy
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML WasControlledBy(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class WasControlledByImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.WasControlledBy
{
    
    public WasControlledByImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EFFECT$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "effect");
    private static final javax.xml.namespace.QName ROLE$2 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "role");
    private static final javax.xml.namespace.QName CAUSE$4 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "cause");
    private static final javax.xml.namespace.QName ACCOUNT$6 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "account");
    private static final javax.xml.namespace.QName STARTTIME$8 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "startTime");
    private static final javax.xml.namespace.QName ENDTIME$10 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "endTime");
    private static final javax.xml.namespace.QName ANNOTATION$12 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "annotation");
    private static final org.apache.xmlbeans.QNameSet ANNOTATION$13 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "label"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "value"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "pname"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "profile"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "type"),
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "annotation"),
    });
    private static final javax.xml.namespace.QName ID$14 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets the "effect" element
     */
    public org.openprovenance.model.v1_1_a.ProcessRef getEffect()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.ProcessRef target = null;
            target = (org.openprovenance.model.v1_1_a.ProcessRef)get_store().find_element_user(EFFECT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "effect" element
     */
    public void setEffect(org.openprovenance.model.v1_1_a.ProcessRef effect)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.ProcessRef target = null;
            target = (org.openprovenance.model.v1_1_a.ProcessRef)get_store().find_element_user(EFFECT$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.ProcessRef)get_store().add_element_user(EFFECT$0);
            }
            target.set(effect);
        }
    }
    
    /**
     * Appends and returns a new empty "effect" element
     */
    public org.openprovenance.model.v1_1_a.ProcessRef addNewEffect()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.ProcessRef target = null;
            target = (org.openprovenance.model.v1_1_a.ProcessRef)get_store().add_element_user(EFFECT$0);
            return target;
        }
    }
    
    /**
     * Gets the "role" element
     */
    public org.openprovenance.model.v1_1_a.Role getRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Role target = null;
            target = (org.openprovenance.model.v1_1_a.Role)get_store().find_element_user(ROLE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "role" element
     */
    public void setRole(org.openprovenance.model.v1_1_a.Role role)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Role target = null;
            target = (org.openprovenance.model.v1_1_a.Role)get_store().find_element_user(ROLE$2, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Role)get_store().add_element_user(ROLE$2);
            }
            target.set(role);
        }
    }
    
    /**
     * Appends and returns a new empty "role" element
     */
    public org.openprovenance.model.v1_1_a.Role addNewRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Role target = null;
            target = (org.openprovenance.model.v1_1_a.Role)get_store().add_element_user(ROLE$2);
            return target;
        }
    }
    
    /**
     * Gets the "cause" element
     */
    public org.openprovenance.model.v1_1_a.AgentRef getCause()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.AgentRef target = null;
            target = (org.openprovenance.model.v1_1_a.AgentRef)get_store().find_element_user(CAUSE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "cause" element
     */
    public void setCause(org.openprovenance.model.v1_1_a.AgentRef cause)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.AgentRef target = null;
            target = (org.openprovenance.model.v1_1_a.AgentRef)get_store().find_element_user(CAUSE$4, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.AgentRef)get_store().add_element_user(CAUSE$4);
            }
            target.set(cause);
        }
    }
    
    /**
     * Appends and returns a new empty "cause" element
     */
    public org.openprovenance.model.v1_1_a.AgentRef addNewCause()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.AgentRef target = null;
            target = (org.openprovenance.model.v1_1_a.AgentRef)get_store().add_element_user(CAUSE$4);
            return target;
        }
    }
    
    /**
     * Gets array of all "account" elements
     */
    public org.openprovenance.model.v1_1_a.AccountRef[] getAccountArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ACCOUNT$6, targetList);
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
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().find_element_user(ACCOUNT$6, i);
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
            return get_store().count_elements(ACCOUNT$6);
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
            arraySetterHelper(accountArray, ACCOUNT$6);
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
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().find_element_user(ACCOUNT$6, i);
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
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().insert_element_user(ACCOUNT$6, i);
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
            target = (org.openprovenance.model.v1_1_a.AccountRef)get_store().add_element_user(ACCOUNT$6);
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
            get_store().remove_element(ACCOUNT$6, i);
        }
    }
    
    /**
     * Gets the "startTime" element
     */
    public org.openprovenance.model.v1_1_a.OTime getStartTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OTime target = null;
            target = (org.openprovenance.model.v1_1_a.OTime)get_store().find_element_user(STARTTIME$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "startTime" element
     */
    public boolean isSetStartTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(STARTTIME$8) != 0;
        }
    }
    
    /**
     * Sets the "startTime" element
     */
    public void setStartTime(org.openprovenance.model.v1_1_a.OTime startTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OTime target = null;
            target = (org.openprovenance.model.v1_1_a.OTime)get_store().find_element_user(STARTTIME$8, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.OTime)get_store().add_element_user(STARTTIME$8);
            }
            target.set(startTime);
        }
    }
    
    /**
     * Appends and returns a new empty "startTime" element
     */
    public org.openprovenance.model.v1_1_a.OTime addNewStartTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OTime target = null;
            target = (org.openprovenance.model.v1_1_a.OTime)get_store().add_element_user(STARTTIME$8);
            return target;
        }
    }
    
    /**
     * Unsets the "startTime" element
     */
    public void unsetStartTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(STARTTIME$8, 0);
        }
    }
    
    /**
     * Gets the "endTime" element
     */
    public org.openprovenance.model.v1_1_a.OTime getEndTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OTime target = null;
            target = (org.openprovenance.model.v1_1_a.OTime)get_store().find_element_user(ENDTIME$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "endTime" element
     */
    public boolean isSetEndTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ENDTIME$10) != 0;
        }
    }
    
    /**
     * Sets the "endTime" element
     */
    public void setEndTime(org.openprovenance.model.v1_1_a.OTime endTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OTime target = null;
            target = (org.openprovenance.model.v1_1_a.OTime)get_store().find_element_user(ENDTIME$10, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.OTime)get_store().add_element_user(ENDTIME$10);
            }
            target.set(endTime);
        }
    }
    
    /**
     * Appends and returns a new empty "endTime" element
     */
    public org.openprovenance.model.v1_1_a.OTime addNewEndTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OTime target = null;
            target = (org.openprovenance.model.v1_1_a.OTime)get_store().add_element_user(ENDTIME$10);
            return target;
        }
    }
    
    /**
     * Unsets the "endTime" element
     */
    public void unsetEndTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ENDTIME$10, 0);
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
            get_store().find_all_element_users(ANNOTATION$13, targetList);
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
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().find_element_user(ANNOTATION$13, i);
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
            return get_store().count_elements(ANNOTATION$13);
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
            arraySetterHelper(annotationArray, ANNOTATION$12, ANNOTATION$13);
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
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().find_element_user(ANNOTATION$13, i);
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
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().insert_element_user(ANNOTATION$13, ANNOTATION$12, i);
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
            target = (org.openprovenance.model.v1_1_a.EmbeddedAnnotation)get_store().add_element_user(ANNOTATION$12);
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
            get_store().remove_element(ANNOTATION$13, i);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$14);
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
            target = (org.apache.xmlbeans.XmlID)get_store().find_attribute_user(ID$14);
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
            return get_store().find_attribute_user(ID$14) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$14);
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
            target = (org.apache.xmlbeans.XmlID)get_store().find_attribute_user(ID$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlID)get_store().add_attribute_user(ID$14);
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
            get_store().remove_attribute(ID$14);
        }
    }
}
