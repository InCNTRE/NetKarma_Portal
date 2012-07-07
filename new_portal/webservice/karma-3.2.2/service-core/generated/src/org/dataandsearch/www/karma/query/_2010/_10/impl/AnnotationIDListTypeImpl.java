/*
 * XML Type:  annotationIDListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML annotationIDListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class AnnotationIDListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType
{
    
    public AnnotationIDListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RELATIONSHIPID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "relationshipID");
    private static final javax.xml.namespace.QName CAUSE$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "cause");
    private static final javax.xml.namespace.QName EFFECT$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "effect");
    private static final javax.xml.namespace.QName OBJECTID$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "objectID");
    private static final javax.xml.namespace.QName UNIQUEID$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueID");
    
    
    /**
     * Gets array of all "relationshipID" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum[] getRelationshipIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RELATIONSHIPID$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum[] result = new org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = (org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum)((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getEnumValue();
            return result;
        }
    }
    
    /**
     * Gets ith "relationshipID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum getRelationshipIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATIONSHIPID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "relationshipID" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType[] xgetRelationshipIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RELATIONSHIPID$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType[] result = new org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "relationshipID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType xgetRelationshipIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType)get_store().find_element_user(RELATIONSHIPID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType)target;
        }
    }
    
    /**
     * Returns number of "relationshipID" element
     */
    public int sizeOfRelationshipIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RELATIONSHIPID$0);
        }
    }
    
    /**
     * Sets array of all "relationshipID" element
     */
    public void setRelationshipIDArray(org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum[] relationshipIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(relationshipIDArray, RELATIONSHIPID$0);
        }
    }
    
    /**
     * Sets ith "relationshipID" element
     */
    public void setRelationshipIDArray(int i, org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum relationshipID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RELATIONSHIPID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setEnumValue(relationshipID);
        }
    }
    
    /**
     * Sets (as xml) array of all "relationshipID" element
     */
    public void xsetRelationshipIDArray(org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType[]relationshipIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(relationshipIDArray, RELATIONSHIPID$0);
        }
    }
    
    /**
     * Sets (as xml) ith "relationshipID" element
     */
    public void xsetRelationshipIDArray(int i, org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType relationshipID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType)get_store().find_element_user(RELATIONSHIPID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(relationshipID);
        }
    }
    
    /**
     * Inserts the value as the ith "relationshipID" element
     */
    public void insertRelationshipID(int i, org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum relationshipID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(RELATIONSHIPID$0, i);
            target.setEnumValue(relationshipID);
        }
    }
    
    /**
     * Appends the value as the last "relationshipID" element
     */
    public void addRelationshipID(org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType.Enum relationshipID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RELATIONSHIPID$0);
            target.setEnumValue(relationshipID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "relationshipID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType insertNewRelationshipID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType)get_store().insert_element_user(RELATIONSHIPID$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "relationshipID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType addNewRelationshipID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType)get_store().add_element_user(RELATIONSHIPID$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "relationshipID" element
     */
    public void removeRelationshipID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RELATIONSHIPID$0, i);
        }
    }
    
    /**
     * Gets array of all "cause" elements
     */
    public java.lang.String[] getCauseArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CAUSE$2, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "cause" element
     */
    public java.lang.String getCauseArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CAUSE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "cause" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetCauseArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CAUSE$2, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "cause" element
     */
    public org.apache.xmlbeans.XmlString xgetCauseArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CAUSE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "cause" element
     */
    public int sizeOfCauseArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CAUSE$2);
        }
    }
    
    /**
     * Sets array of all "cause" element
     */
    public void setCauseArray(java.lang.String[] causeArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(causeArray, CAUSE$2);
        }
    }
    
    /**
     * Sets ith "cause" element
     */
    public void setCauseArray(int i, java.lang.String cause)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CAUSE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(cause);
        }
    }
    
    /**
     * Sets (as xml) array of all "cause" element
     */
    public void xsetCauseArray(org.apache.xmlbeans.XmlString[]causeArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(causeArray, CAUSE$2);
        }
    }
    
    /**
     * Sets (as xml) ith "cause" element
     */
    public void xsetCauseArray(int i, org.apache.xmlbeans.XmlString cause)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CAUSE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(cause);
        }
    }
    
    /**
     * Inserts the value as the ith "cause" element
     */
    public void insertCause(int i, java.lang.String cause)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(CAUSE$2, i);
            target.setStringValue(cause);
        }
    }
    
    /**
     * Appends the value as the last "cause" element
     */
    public void addCause(java.lang.String cause)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CAUSE$2);
            target.setStringValue(cause);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "cause" element
     */
    public org.apache.xmlbeans.XmlString insertNewCause(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(CAUSE$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "cause" element
     */
    public org.apache.xmlbeans.XmlString addNewCause()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CAUSE$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "cause" element
     */
    public void removeCause(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CAUSE$2, i);
        }
    }
    
    /**
     * Gets array of all "effect" elements
     */
    public java.lang.String[] getEffectArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(EFFECT$4, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "effect" element
     */
    public java.lang.String getEffectArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EFFECT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "effect" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetEffectArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(EFFECT$4, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "effect" element
     */
    public org.apache.xmlbeans.XmlString xgetEffectArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EFFECT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "effect" element
     */
    public int sizeOfEffectArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(EFFECT$4);
        }
    }
    
    /**
     * Sets array of all "effect" element
     */
    public void setEffectArray(java.lang.String[] effectArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(effectArray, EFFECT$4);
        }
    }
    
    /**
     * Sets ith "effect" element
     */
    public void setEffectArray(int i, java.lang.String effect)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EFFECT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(effect);
        }
    }
    
    /**
     * Sets (as xml) array of all "effect" element
     */
    public void xsetEffectArray(org.apache.xmlbeans.XmlString[]effectArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(effectArray, EFFECT$4);
        }
    }
    
    /**
     * Sets (as xml) ith "effect" element
     */
    public void xsetEffectArray(int i, org.apache.xmlbeans.XmlString effect)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EFFECT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(effect);
        }
    }
    
    /**
     * Inserts the value as the ith "effect" element
     */
    public void insertEffect(int i, java.lang.String effect)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(EFFECT$4, i);
            target.setStringValue(effect);
        }
    }
    
    /**
     * Appends the value as the last "effect" element
     */
    public void addEffect(java.lang.String effect)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EFFECT$4);
            target.setStringValue(effect);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "effect" element
     */
    public org.apache.xmlbeans.XmlString insertNewEffect(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(EFFECT$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "effect" element
     */
    public org.apache.xmlbeans.XmlString addNewEffect()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EFFECT$4);
            return target;
        }
    }
    
    /**
     * Removes the ith "effect" element
     */
    public void removeEffect(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(EFFECT$4, i);
        }
    }
    
    /**
     * Gets array of all "objectID" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum[] getObjectIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OBJECTID$6, targetList);
            org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum[] result = new org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = (org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum)((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getEnumValue();
            return result;
        }
    }
    
    /**
     * Gets ith "objectID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum getObjectIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBJECTID$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "objectID" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.ObjectEnumType[] xgetObjectIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OBJECTID$6, targetList);
            org.dataandsearch.www.karma.query._2010._10.ObjectEnumType[] result = new org.dataandsearch.www.karma.query._2010._10.ObjectEnumType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "objectID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ObjectEnumType xgetObjectIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ObjectEnumType)get_store().find_element_user(OBJECTID$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.dataandsearch.www.karma.query._2010._10.ObjectEnumType)target;
        }
    }
    
    /**
     * Returns number of "objectID" element
     */
    public int sizeOfObjectIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OBJECTID$6);
        }
    }
    
    /**
     * Sets array of all "objectID" element
     */
    public void setObjectIDArray(org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum[] objectIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(objectIDArray, OBJECTID$6);
        }
    }
    
    /**
     * Sets ith "objectID" element
     */
    public void setObjectIDArray(int i, org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum objectID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBJECTID$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setEnumValue(objectID);
        }
    }
    
    /**
     * Sets (as xml) array of all "objectID" element
     */
    public void xsetObjectIDArray(org.dataandsearch.www.karma.query._2010._10.ObjectEnumType[]objectIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(objectIDArray, OBJECTID$6);
        }
    }
    
    /**
     * Sets (as xml) ith "objectID" element
     */
    public void xsetObjectIDArray(int i, org.dataandsearch.www.karma.query._2010._10.ObjectEnumType objectID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ObjectEnumType)get_store().find_element_user(OBJECTID$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(objectID);
        }
    }
    
    /**
     * Inserts the value as the ith "objectID" element
     */
    public void insertObjectID(int i, org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum objectID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(OBJECTID$6, i);
            target.setEnumValue(objectID);
        }
    }
    
    /**
     * Appends the value as the last "objectID" element
     */
    public void addObjectID(org.dataandsearch.www.karma.query._2010._10.ObjectEnumType.Enum objectID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OBJECTID$6);
            target.setEnumValue(objectID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "objectID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ObjectEnumType insertNewObjectID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ObjectEnumType)get_store().insert_element_user(OBJECTID$6, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "objectID" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ObjectEnumType addNewObjectID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ObjectEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ObjectEnumType)get_store().add_element_user(OBJECTID$6);
            return target;
        }
    }
    
    /**
     * Removes the ith "objectID" element
     */
    public void removeObjectID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OBJECTID$6, i);
        }
    }
    
    /**
     * Gets array of all "uniqueID" elements
     */
    public java.lang.String[] getUniqueIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UNIQUEID$8, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "uniqueID" element
     */
    public java.lang.String getUniqueIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNIQUEID$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "uniqueID" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetUniqueIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UNIQUEID$8, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "uniqueID" element
     */
    public org.apache.xmlbeans.XmlString xgetUniqueIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNIQUEID$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "uniqueID" element
     */
    public int sizeOfUniqueIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEID$8);
        }
    }
    
    /**
     * Sets array of all "uniqueID" element
     */
    public void setUniqueIDArray(java.lang.String[] uniqueIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uniqueIDArray, UNIQUEID$8);
        }
    }
    
    /**
     * Sets ith "uniqueID" element
     */
    public void setUniqueIDArray(int i, java.lang.String uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNIQUEID$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(uniqueID);
        }
    }
    
    /**
     * Sets (as xml) array of all "uniqueID" element
     */
    public void xsetUniqueIDArray(org.apache.xmlbeans.XmlString[]uniqueIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uniqueIDArray, UNIQUEID$8);
        }
    }
    
    /**
     * Sets (as xml) ith "uniqueID" element
     */
    public void xsetUniqueIDArray(int i, org.apache.xmlbeans.XmlString uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNIQUEID$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(uniqueID);
        }
    }
    
    /**
     * Inserts the value as the ith "uniqueID" element
     */
    public void insertUniqueID(int i, java.lang.String uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(UNIQUEID$8, i);
            target.setStringValue(uniqueID);
        }
    }
    
    /**
     * Appends the value as the last "uniqueID" element
     */
    public void addUniqueID(java.lang.String uniqueID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNIQUEID$8);
            target.setStringValue(uniqueID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "uniqueID" element
     */
    public org.apache.xmlbeans.XmlString insertNewUniqueID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(UNIQUEID$8, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "uniqueID" element
     */
    public org.apache.xmlbeans.XmlString addNewUniqueID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNIQUEID$8);
            return target;
        }
    }
    
    /**
     * Removes the ith "uniqueID" element
     */
    public void removeUniqueID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEID$8, i);
        }
    }
}
