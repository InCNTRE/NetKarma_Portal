/*
 * XML Type:  OPMGraph
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.OPMGraph
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML OPMGraph(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class OPMGraphImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.OPMGraph
{
    
    public OPMGraphImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACCOUNTS$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "accounts");
    private static final javax.xml.namespace.QName PROCESSES$2 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "processes");
    private static final javax.xml.namespace.QName ARTIFACTS$4 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "artifacts");
    private static final javax.xml.namespace.QName AGENTS$6 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "agents");
    private static final javax.xml.namespace.QName CAUSALDEPENDENCIES$8 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "causalDependencies");
    private static final javax.xml.namespace.QName ANNOTATIONS$10 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "annotations");
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
     * Gets the "accounts" element
     */
    public org.openprovenance.model.v1_1_a.Accounts getAccounts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Accounts target = null;
            target = (org.openprovenance.model.v1_1_a.Accounts)get_store().find_element_user(ACCOUNTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "accounts" element
     */
    public boolean isSetAccounts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ACCOUNTS$0) != 0;
        }
    }
    
    /**
     * Sets the "accounts" element
     */
    public void setAccounts(org.openprovenance.model.v1_1_a.Accounts accounts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Accounts target = null;
            target = (org.openprovenance.model.v1_1_a.Accounts)get_store().find_element_user(ACCOUNTS$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Accounts)get_store().add_element_user(ACCOUNTS$0);
            }
            target.set(accounts);
        }
    }
    
    /**
     * Appends and returns a new empty "accounts" element
     */
    public org.openprovenance.model.v1_1_a.Accounts addNewAccounts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Accounts target = null;
            target = (org.openprovenance.model.v1_1_a.Accounts)get_store().add_element_user(ACCOUNTS$0);
            return target;
        }
    }
    
    /**
     * Unsets the "accounts" element
     */
    public void unsetAccounts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ACCOUNTS$0, 0);
        }
    }
    
    /**
     * Gets the "processes" element
     */
    public org.openprovenance.model.v1_1_a.Processes getProcesses()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Processes target = null;
            target = (org.openprovenance.model.v1_1_a.Processes)get_store().find_element_user(PROCESSES$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "processes" element
     */
    public boolean isSetProcesses()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESSES$2) != 0;
        }
    }
    
    /**
     * Sets the "processes" element
     */
    public void setProcesses(org.openprovenance.model.v1_1_a.Processes processes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Processes target = null;
            target = (org.openprovenance.model.v1_1_a.Processes)get_store().find_element_user(PROCESSES$2, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Processes)get_store().add_element_user(PROCESSES$2);
            }
            target.set(processes);
        }
    }
    
    /**
     * Appends and returns a new empty "processes" element
     */
    public org.openprovenance.model.v1_1_a.Processes addNewProcesses()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Processes target = null;
            target = (org.openprovenance.model.v1_1_a.Processes)get_store().add_element_user(PROCESSES$2);
            return target;
        }
    }
    
    /**
     * Unsets the "processes" element
     */
    public void unsetProcesses()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESSES$2, 0);
        }
    }
    
    /**
     * Gets the "artifacts" element
     */
    public org.openprovenance.model.v1_1_a.Artifacts getArtifacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Artifacts target = null;
            target = (org.openprovenance.model.v1_1_a.Artifacts)get_store().find_element_user(ARTIFACTS$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "artifacts" element
     */
    public boolean isSetArtifacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARTIFACTS$4) != 0;
        }
    }
    
    /**
     * Sets the "artifacts" element
     */
    public void setArtifacts(org.openprovenance.model.v1_1_a.Artifacts artifacts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Artifacts target = null;
            target = (org.openprovenance.model.v1_1_a.Artifacts)get_store().find_element_user(ARTIFACTS$4, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Artifacts)get_store().add_element_user(ARTIFACTS$4);
            }
            target.set(artifacts);
        }
    }
    
    /**
     * Appends and returns a new empty "artifacts" element
     */
    public org.openprovenance.model.v1_1_a.Artifacts addNewArtifacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Artifacts target = null;
            target = (org.openprovenance.model.v1_1_a.Artifacts)get_store().add_element_user(ARTIFACTS$4);
            return target;
        }
    }
    
    /**
     * Unsets the "artifacts" element
     */
    public void unsetArtifacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARTIFACTS$4, 0);
        }
    }
    
    /**
     * Gets the "agents" element
     */
    public org.openprovenance.model.v1_1_a.Agents getAgents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Agents target = null;
            target = (org.openprovenance.model.v1_1_a.Agents)get_store().find_element_user(AGENTS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "agents" element
     */
    public boolean isSetAgents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AGENTS$6) != 0;
        }
    }
    
    /**
     * Sets the "agents" element
     */
    public void setAgents(org.openprovenance.model.v1_1_a.Agents agents)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Agents target = null;
            target = (org.openprovenance.model.v1_1_a.Agents)get_store().find_element_user(AGENTS$6, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Agents)get_store().add_element_user(AGENTS$6);
            }
            target.set(agents);
        }
    }
    
    /**
     * Appends and returns a new empty "agents" element
     */
    public org.openprovenance.model.v1_1_a.Agents addNewAgents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Agents target = null;
            target = (org.openprovenance.model.v1_1_a.Agents)get_store().add_element_user(AGENTS$6);
            return target;
        }
    }
    
    /**
     * Unsets the "agents" element
     */
    public void unsetAgents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AGENTS$6, 0);
        }
    }
    
    /**
     * Gets the "causalDependencies" element
     */
    public org.openprovenance.model.v1_1_a.CausalDependencies getCausalDependencies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.CausalDependencies target = null;
            target = (org.openprovenance.model.v1_1_a.CausalDependencies)get_store().find_element_user(CAUSALDEPENDENCIES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "causalDependencies" element
     */
    public boolean isSetCausalDependencies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CAUSALDEPENDENCIES$8) != 0;
        }
    }
    
    /**
     * Sets the "causalDependencies" element
     */
    public void setCausalDependencies(org.openprovenance.model.v1_1_a.CausalDependencies causalDependencies)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.CausalDependencies target = null;
            target = (org.openprovenance.model.v1_1_a.CausalDependencies)get_store().find_element_user(CAUSALDEPENDENCIES$8, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.CausalDependencies)get_store().add_element_user(CAUSALDEPENDENCIES$8);
            }
            target.set(causalDependencies);
        }
    }
    
    /**
     * Appends and returns a new empty "causalDependencies" element
     */
    public org.openprovenance.model.v1_1_a.CausalDependencies addNewCausalDependencies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.CausalDependencies target = null;
            target = (org.openprovenance.model.v1_1_a.CausalDependencies)get_store().add_element_user(CAUSALDEPENDENCIES$8);
            return target;
        }
    }
    
    /**
     * Unsets the "causalDependencies" element
     */
    public void unsetCausalDependencies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CAUSALDEPENDENCIES$8, 0);
        }
    }
    
    /**
     * Gets the "annotations" element
     */
    public org.openprovenance.model.v1_1_a.Annotations getAnnotations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Annotations target = null;
            target = (org.openprovenance.model.v1_1_a.Annotations)get_store().find_element_user(ANNOTATIONS$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "annotations" element
     */
    public boolean isSetAnnotations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANNOTATIONS$10) != 0;
        }
    }
    
    /**
     * Sets the "annotations" element
     */
    public void setAnnotations(org.openprovenance.model.v1_1_a.Annotations annotations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Annotations target = null;
            target = (org.openprovenance.model.v1_1_a.Annotations)get_store().find_element_user(ANNOTATIONS$10, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.Annotations)get_store().add_element_user(ANNOTATIONS$10);
            }
            target.set(annotations);
        }
    }
    
    /**
     * Appends and returns a new empty "annotations" element
     */
    public org.openprovenance.model.v1_1_a.Annotations addNewAnnotations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Annotations target = null;
            target = (org.openprovenance.model.v1_1_a.Annotations)get_store().add_element_user(ANNOTATIONS$10);
            return target;
        }
    }
    
    /**
     * Unsets the "annotations" element
     */
    public void unsetAnnotations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANNOTATIONS$10, 0);
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
