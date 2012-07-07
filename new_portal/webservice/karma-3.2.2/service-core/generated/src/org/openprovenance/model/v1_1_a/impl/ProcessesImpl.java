/*
 * XML Type:  Processes
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Processes
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML Processes(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class ProcessesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.Processes
{
    
    public ProcessesImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESS$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "process");
    
    
    /**
     * Gets array of all "process" elements
     */
    public org.openprovenance.model.v1_1_a.Process[] getProcessArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(PROCESS$0, targetList);
            org.openprovenance.model.v1_1_a.Process[] result = new org.openprovenance.model.v1_1_a.Process[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "process" element
     */
    public org.openprovenance.model.v1_1_a.Process getProcessArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Process target = null;
            target = (org.openprovenance.model.v1_1_a.Process)get_store().find_element_user(PROCESS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "process" element
     */
    public int sizeOfProcessArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESS$0);
        }
    }
    
    /**
     * Sets array of all "process" element
     */
    public void setProcessArray(org.openprovenance.model.v1_1_a.Process[] processArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(processArray, PROCESS$0);
        }
    }
    
    /**
     * Sets ith "process" element
     */
    public void setProcessArray(int i, org.openprovenance.model.v1_1_a.Process process)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Process target = null;
            target = (org.openprovenance.model.v1_1_a.Process)get_store().find_element_user(PROCESS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(process);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "process" element
     */
    public org.openprovenance.model.v1_1_a.Process insertNewProcess(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Process target = null;
            target = (org.openprovenance.model.v1_1_a.Process)get_store().insert_element_user(PROCESS$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "process" element
     */
    public org.openprovenance.model.v1_1_a.Process addNewProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Process target = null;
            target = (org.openprovenance.model.v1_1_a.Process)get_store().add_element_user(PROCESS$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "process" element
     */
    public void removeProcess(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESS$0, i);
        }
    }
}
