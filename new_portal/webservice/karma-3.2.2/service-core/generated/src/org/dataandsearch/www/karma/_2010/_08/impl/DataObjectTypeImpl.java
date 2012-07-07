/*
 * XML Type:  dataObjectType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataObjectType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML dataObjectType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class DataObjectTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.DataObjectType
{
    
    public DataObjectTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "file");
    private static final javax.xml.namespace.QName BLOCK$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "block");
    private static final javax.xml.namespace.QName COLLECTION$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "collection");
    private static final javax.xml.namespace.QName INSTANCEOF$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "instanceOf");
    private static final javax.xml.namespace.QName ANNOTATIONS$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotations");
    
    
    /**
     * Gets the "file" element
     */
    public org.dataandsearch.www.karma._2010._08.FileType getFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.FileType target = null;
            target = (org.dataandsearch.www.karma._2010._08.FileType)get_store().find_element_user(FILE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "file" element
     */
    public boolean isSetFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FILE$0) != 0;
        }
    }
    
    /**
     * Sets the "file" element
     */
    public void setFile(org.dataandsearch.www.karma._2010._08.FileType file)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.FileType target = null;
            target = (org.dataandsearch.www.karma._2010._08.FileType)get_store().find_element_user(FILE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.FileType)get_store().add_element_user(FILE$0);
            }
            target.set(file);
        }
    }
    
    /**
     * Appends and returns a new empty "file" element
     */
    public org.dataandsearch.www.karma._2010._08.FileType addNewFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.FileType target = null;
            target = (org.dataandsearch.www.karma._2010._08.FileType)get_store().add_element_user(FILE$0);
            return target;
        }
    }
    
    /**
     * Unsets the "file" element
     */
    public void unsetFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FILE$0, 0);
        }
    }
    
    /**
     * Gets the "block" element
     */
    public org.dataandsearch.www.karma._2010._08.BlockType getBlock()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.BlockType target = null;
            target = (org.dataandsearch.www.karma._2010._08.BlockType)get_store().find_element_user(BLOCK$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "block" element
     */
    public boolean isSetBlock()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BLOCK$2) != 0;
        }
    }
    
    /**
     * Sets the "block" element
     */
    public void setBlock(org.dataandsearch.www.karma._2010._08.BlockType block)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.BlockType target = null;
            target = (org.dataandsearch.www.karma._2010._08.BlockType)get_store().find_element_user(BLOCK$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.BlockType)get_store().add_element_user(BLOCK$2);
            }
            target.set(block);
        }
    }
    
    /**
     * Appends and returns a new empty "block" element
     */
    public org.dataandsearch.www.karma._2010._08.BlockType addNewBlock()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.BlockType target = null;
            target = (org.dataandsearch.www.karma._2010._08.BlockType)get_store().add_element_user(BLOCK$2);
            return target;
        }
    }
    
    /**
     * Unsets the "block" element
     */
    public void unsetBlock()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BLOCK$2, 0);
        }
    }
    
    /**
     * Gets the "collection" element
     */
    public org.dataandsearch.www.karma._2010._08.CollectionType getCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.CollectionType target = null;
            target = (org.dataandsearch.www.karma._2010._08.CollectionType)get_store().find_element_user(COLLECTION$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "collection" element
     */
    public boolean isSetCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COLLECTION$4) != 0;
        }
    }
    
    /**
     * Sets the "collection" element
     */
    public void setCollection(org.dataandsearch.www.karma._2010._08.CollectionType collection)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.CollectionType target = null;
            target = (org.dataandsearch.www.karma._2010._08.CollectionType)get_store().find_element_user(COLLECTION$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.CollectionType)get_store().add_element_user(COLLECTION$4);
            }
            target.set(collection);
        }
    }
    
    /**
     * Appends and returns a new empty "collection" element
     */
    public org.dataandsearch.www.karma._2010._08.CollectionType addNewCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.CollectionType target = null;
            target = (org.dataandsearch.www.karma._2010._08.CollectionType)get_store().add_element_user(COLLECTION$4);
            return target;
        }
    }
    
    /**
     * Unsets the "collection" element
     */
    public void unsetCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COLLECTION$4, 0);
        }
    }
    
    /**
     * Gets the "instanceOf" element
     */
    public org.dataandsearch.www.karma._2010._08.InstanceOfType getInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InstanceOfType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().find_element_user(INSTANCEOF$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "instanceOf" element
     */
    public boolean isSetInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INSTANCEOF$6) != 0;
        }
    }
    
    /**
     * Sets the "instanceOf" element
     */
    public void setInstanceOf(org.dataandsearch.www.karma._2010._08.InstanceOfType xinstanceOf)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InstanceOfType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().find_element_user(INSTANCEOF$6, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().add_element_user(INSTANCEOF$6);
            }
            target.set(xinstanceOf);
        }
    }
    
    /**
     * Appends and returns a new empty "instanceOf" element
     */
    public org.dataandsearch.www.karma._2010._08.InstanceOfType addNewInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InstanceOfType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().add_element_user(INSTANCEOF$6);
            return target;
        }
    }
    
    /**
     * Unsets the "instanceOf" element
     */
    public void unsetInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INSTANCEOF$6, 0);
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
            get_store().find_all_element_users(ANNOTATIONS$8, targetList);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$8, i);
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
            return get_store().count_elements(ANNOTATIONS$8);
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
            arraySetterHelper(annotationsArray, ANNOTATIONS$8);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$8, i);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().insert_element_user(ANNOTATIONS$8, i);
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
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().add_element_user(ANNOTATIONS$8);
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
            get_store().remove_element(ANNOTATIONS$8, i);
        }
    }
}
