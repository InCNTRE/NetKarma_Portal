/*
 * XML Type:  Agents
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Agents
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML Agents(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class AgentsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.Agents
{
    
    public AgentsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AGENT$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "agent");
    
    
    /**
     * Gets array of all "agent" elements
     */
    public org.openprovenance.model.v1_1_a.Agent[] getAgentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(AGENT$0, targetList);
            org.openprovenance.model.v1_1_a.Agent[] result = new org.openprovenance.model.v1_1_a.Agent[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "agent" element
     */
    public org.openprovenance.model.v1_1_a.Agent getAgentArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Agent target = null;
            target = (org.openprovenance.model.v1_1_a.Agent)get_store().find_element_user(AGENT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "agent" element
     */
    public int sizeOfAgentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AGENT$0);
        }
    }
    
    /**
     * Sets array of all "agent" element
     */
    public void setAgentArray(org.openprovenance.model.v1_1_a.Agent[] agentArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(agentArray, AGENT$0);
        }
    }
    
    /**
     * Sets ith "agent" element
     */
    public void setAgentArray(int i, org.openprovenance.model.v1_1_a.Agent agent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Agent target = null;
            target = (org.openprovenance.model.v1_1_a.Agent)get_store().find_element_user(AGENT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(agent);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "agent" element
     */
    public org.openprovenance.model.v1_1_a.Agent insertNewAgent(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Agent target = null;
            target = (org.openprovenance.model.v1_1_a.Agent)get_store().insert_element_user(AGENT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "agent" element
     */
    public org.openprovenance.model.v1_1_a.Agent addNewAgent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Agent target = null;
            target = (org.openprovenance.model.v1_1_a.Agent)get_store().add_element_user(AGENT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "agent" element
     */
    public void removeAgent(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AGENT$0, i);
        }
    }
}
