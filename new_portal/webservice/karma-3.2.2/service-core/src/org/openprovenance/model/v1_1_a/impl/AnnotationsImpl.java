/*
 * XML Type:  Annotations
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Annotations
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML Annotations(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class AnnotationsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.Annotations
{
    
    public AnnotationsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANNOTATION$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "annotation");
    
    
    /**
     * Gets array of all "annotation" elements
     */
    public org.openprovenance.model.v1_1_a.Annotation[] getAnnotationArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANNOTATION$0, targetList);
            org.openprovenance.model.v1_1_a.Annotation[] result = new org.openprovenance.model.v1_1_a.Annotation[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "annotation" element
     */
    public org.openprovenance.model.v1_1_a.Annotation getAnnotationArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Annotation target = null;
            target = (org.openprovenance.model.v1_1_a.Annotation)get_store().find_element_user(ANNOTATION$0, i);
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
            return get_store().count_elements(ANNOTATION$0);
        }
    }
    
    /**
     * Sets array of all "annotation" element
     */
    public void setAnnotationArray(org.openprovenance.model.v1_1_a.Annotation[] annotationArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(annotationArray, ANNOTATION$0);
        }
    }
    
    /**
     * Sets ith "annotation" element
     */
    public void setAnnotationArray(int i, org.openprovenance.model.v1_1_a.Annotation annotation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Annotation target = null;
            target = (org.openprovenance.model.v1_1_a.Annotation)get_store().find_element_user(ANNOTATION$0, i);
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
    public org.openprovenance.model.v1_1_a.Annotation insertNewAnnotation(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Annotation target = null;
            target = (org.openprovenance.model.v1_1_a.Annotation)get_store().insert_element_user(ANNOTATION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotation" element
     */
    public org.openprovenance.model.v1_1_a.Annotation addNewAnnotation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Annotation target = null;
            target = (org.openprovenance.model.v1_1_a.Annotation)get_store().add_element_user(ANNOTATION$0);
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
            get_store().remove_element(ANNOTATION$0, i);
        }
    }
}
