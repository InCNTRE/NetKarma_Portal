/*
 * XML Type:  dataLifeCycleType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataLifeCycleType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML dataLifeCycleType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class DataLifeCycleTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataLifeCycleType
{
    
    public DataLifeCycleTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACTION$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "action");
    private static final javax.xml.namespace.QName ACTOR$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "actor");
    private static final javax.xml.namespace.QName DATAOBJECT$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataObject");
    private static final javax.xml.namespace.QName TIMESTAMP$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "timestamp");
    private static final javax.xml.namespace.QName DATAROLE$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "dataRole");
    private static final javax.xml.namespace.QName ANNOTATIONS$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotations");
    
    
    /**
     * Gets the "action" element
     */
    public org.dataandsearch.www.karma._2010._08.ActionEnumType.Enum getAction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.ActionEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "action" element
     */
    public org.dataandsearch.www.karma._2010._08.ActionEnumType xgetAction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.ActionEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.ActionEnumType)get_store().find_element_user(ACTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "action" element
     */
    public void setAction(org.dataandsearch.www.karma._2010._08.ActionEnumType.Enum action)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ACTION$0);
            }
            target.setEnumValue(action);
        }
    }
    
    /**
     * Sets (as xml) the "action" element
     */
    public void xsetAction(org.dataandsearch.www.karma._2010._08.ActionEnumType action)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.ActionEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.ActionEnumType)get_store().find_element_user(ACTION$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.ActionEnumType)get_store().add_element_user(ACTION$0);
            }
            target.set(action);
        }
    }
    
    /**
     * Gets the "actor" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType getActor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(ACTOR$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "actor" element
     */
    public void setActor(org.dataandsearch.www.karma._2010._08.EntityType actor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().find_element_user(ACTOR$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(ACTOR$2);
            }
            target.set(actor);
        }
    }
    
    /**
     * Appends and returns a new empty "actor" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityType addNewActor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityType)get_store().add_element_user(ACTOR$2);
            return target;
        }
    }
    
    /**
     * Gets the "dataObject" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType getDataObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(DATAOBJECT$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "dataObject" element
     */
    public void setDataObject(org.dataandsearch.www.karma._2010._08.DataObjectType dataObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().find_element_user(DATAOBJECT$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(DATAOBJECT$4);
            }
            target.set(dataObject);
        }
    }
    
    /**
     * Appends and returns a new empty "dataObject" element
     */
    public org.dataandsearch.www.karma._2010._08.DataObjectType addNewDataObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataObjectType target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataObjectType)get_store().add_element_user(DATAOBJECT$4);
            return target;
        }
    }
    
    /**
     * Gets the "timestamp" element
     */
    public java.util.Calendar getTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMESTAMP$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "timestamp" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TIMESTAMP$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "timestamp" element
     */
    public void setTimestamp(java.util.Calendar timestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMESTAMP$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIMESTAMP$6);
            }
            target.setCalendarValue(timestamp);
        }
    }
    
    /**
     * Sets (as xml) the "timestamp" element
     */
    public void xsetTimestamp(org.apache.xmlbeans.XmlDateTime timestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TIMESTAMP$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(TIMESTAMP$6);
            }
            target.set(timestamp);
        }
    }
    
    /**
     * Gets the "dataRole" element
     */
    public java.lang.String getDataRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAROLE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "dataRole" element
     */
    public org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole xgetDataRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole)get_store().find_element_user(DATAROLE$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "dataRole" element
     */
    public boolean isSetDataRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAROLE$8) != 0;
        }
    }
    
    /**
     * Sets the "dataRole" element
     */
    public void setDataRole(java.lang.String dataRole)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATAROLE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATAROLE$8);
            }
            target.setStringValue(dataRole);
        }
    }
    
    /**
     * Sets (as xml) the "dataRole" element
     */
    public void xsetDataRole(org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole dataRole)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole target = null;
            target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole)get_store().find_element_user(DATAROLE$8, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole)get_store().add_element_user(DATAROLE$8);
            }
            target.set(dataRole);
        }
    }
    
    /**
     * Unsets the "dataRole" element
     */
    public void unsetDataRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAROLE$8, 0);
        }
    }
    
    /**
     * Gets array of all "annotations" elements
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType[] getAnnotationsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANNOTATIONS$10, targetList);
            org.dataandsearch.www.karma._2010._08.AnnotationType[] result = new org.dataandsearch.www.karma._2010._08.AnnotationType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType getAnnotationsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "annotations" element
     */
    public int sizeOfAnnotationsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANNOTATIONS$10);
        }
    }
    
    /**
     * Sets array of all "annotations" element
     */
    public void setAnnotationsArray(org.dataandsearch.www.karma._2010._08.AnnotationType[] annotationsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(annotationsArray, ANNOTATIONS$10);
        }
    }
    
    /**
     * Sets ith "annotations" element
     */
    public void setAnnotationsArray(int i, org.dataandsearch.www.karma._2010._08.AnnotationType annotations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(annotations);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType insertNewAnnotations(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().insert_element_user(ANNOTATIONS$10, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType addNewAnnotations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().add_element_user(ANNOTATIONS$10);
            return target;
        }
    }
    
    /**
     * Removes the ith "annotations" element
     */
    public void removeAnnotations(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANNOTATIONS$10, i);
        }
    }
    /**
     * An XML dataRole(@http://www.dataandsearch.org/karma/2010/08/).
     *
     * This is an atomic type that is a restriction of org.dataandsearch.www.karma._2010._08.DataLifeCycleType$DataRole.
     */
    public static class DataRoleImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements org.dataandsearch.www.karma._2010._08.DataLifeCycleType.DataRole
    {
        
        public DataRoleImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected DataRoleImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
