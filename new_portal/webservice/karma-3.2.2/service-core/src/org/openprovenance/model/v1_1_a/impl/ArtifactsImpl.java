/*
 * XML Type:  Artifacts
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Artifacts
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML Artifacts(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class ArtifactsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.Artifacts
{
    
    public ArtifactsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARTIFACT$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "artifact");
    
    
    /**
     * Gets array of all "artifact" elements
     */
    public org.openprovenance.model.v1_1_a.Artifact[] getArtifactArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ARTIFACT$0, targetList);
            org.openprovenance.model.v1_1_a.Artifact[] result = new org.openprovenance.model.v1_1_a.Artifact[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "artifact" element
     */
    public org.openprovenance.model.v1_1_a.Artifact getArtifactArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Artifact target = null;
            target = (org.openprovenance.model.v1_1_a.Artifact)get_store().find_element_user(ARTIFACT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "artifact" element
     */
    public int sizeOfArtifactArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARTIFACT$0);
        }
    }
    
    /**
     * Sets array of all "artifact" element
     */
    public void setArtifactArray(org.openprovenance.model.v1_1_a.Artifact[] artifactArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(artifactArray, ARTIFACT$0);
        }
    }
    
    /**
     * Sets ith "artifact" element
     */
    public void setArtifactArray(int i, org.openprovenance.model.v1_1_a.Artifact artifact)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Artifact target = null;
            target = (org.openprovenance.model.v1_1_a.Artifact)get_store().find_element_user(ARTIFACT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(artifact);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "artifact" element
     */
    public org.openprovenance.model.v1_1_a.Artifact insertNewArtifact(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Artifact target = null;
            target = (org.openprovenance.model.v1_1_a.Artifact)get_store().insert_element_user(ARTIFACT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "artifact" element
     */
    public org.openprovenance.model.v1_1_a.Artifact addNewArtifact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Artifact target = null;
            target = (org.openprovenance.model.v1_1_a.Artifact)get_store().add_element_user(ARTIFACT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "artifact" element
     */
    public void removeArtifact(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARTIFACT$0, i);
        }
    }
}
