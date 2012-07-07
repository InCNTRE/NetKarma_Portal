/*
 * XML Type:  CausalDependencies
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.CausalDependencies
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * An XML CausalDependencies(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public class CausalDependenciesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.CausalDependencies
{
    
    public CausalDependenciesImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName USED$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "used");
    private static final javax.xml.namespace.QName WASGENERATEDBY$2 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "wasGeneratedBy");
    private static final javax.xml.namespace.QName WASTRIGGEREDBY$4 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "wasTriggeredBy");
    private static final javax.xml.namespace.QName WASDERIVEDFROM$6 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "wasDerivedFrom");
    private static final javax.xml.namespace.QName WASCONTROLLEDBY$8 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "wasControlledBy");
    private static final javax.xml.namespace.QName USED2$10 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "used_");
    private static final javax.xml.namespace.QName WASGENERATEDBY2$12 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "wasGeneratedBy_");
    private static final javax.xml.namespace.QName WASTRIGGEREDBY2$14 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "wasTriggeredBy_");
    private static final javax.xml.namespace.QName WASDERIVEDFROM2$16 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "wasDerivedFrom_");
    
    
    /**
     * Gets array of all "used" elements
     */
    public org.openprovenance.model.v1_1_a.Used[] getUsedArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(USED$0, targetList);
            org.openprovenance.model.v1_1_a.Used[] result = new org.openprovenance.model.v1_1_a.Used[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "used" element
     */
    public org.openprovenance.model.v1_1_a.Used getUsedArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Used target = null;
            target = (org.openprovenance.model.v1_1_a.Used)get_store().find_element_user(USED$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "used" element
     */
    public int sizeOfUsedArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(USED$0);
        }
    }
    
    /**
     * Sets array of all "used" element
     */
    public void setUsedArray(org.openprovenance.model.v1_1_a.Used[] usedArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(usedArray, USED$0);
        }
    }
    
    /**
     * Sets ith "used" element
     */
    public void setUsedArray(int i, org.openprovenance.model.v1_1_a.Used used)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Used target = null;
            target = (org.openprovenance.model.v1_1_a.Used)get_store().find_element_user(USED$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(used);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "used" element
     */
    public org.openprovenance.model.v1_1_a.Used insertNewUsed(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Used target = null;
            target = (org.openprovenance.model.v1_1_a.Used)get_store().insert_element_user(USED$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "used" element
     */
    public org.openprovenance.model.v1_1_a.Used addNewUsed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.Used target = null;
            target = (org.openprovenance.model.v1_1_a.Used)get_store().add_element_user(USED$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "used" element
     */
    public void removeUsed(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(USED$0, i);
        }
    }
    
    /**
     * Gets array of all "wasGeneratedBy" elements
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedBy[] getWasGeneratedByArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WASGENERATEDBY$2, targetList);
            org.openprovenance.model.v1_1_a.WasGeneratedBy[] result = new org.openprovenance.model.v1_1_a.WasGeneratedBy[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "wasGeneratedBy" element
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedBy getWasGeneratedByArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedBy)get_store().find_element_user(WASGENERATEDBY$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "wasGeneratedBy" element
     */
    public int sizeOfWasGeneratedByArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WASGENERATEDBY$2);
        }
    }
    
    /**
     * Sets array of all "wasGeneratedBy" element
     */
    public void setWasGeneratedByArray(org.openprovenance.model.v1_1_a.WasGeneratedBy[] wasGeneratedByArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wasGeneratedByArray, WASGENERATEDBY$2);
        }
    }
    
    /**
     * Sets ith "wasGeneratedBy" element
     */
    public void setWasGeneratedByArray(int i, org.openprovenance.model.v1_1_a.WasGeneratedBy wasGeneratedBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedBy)get_store().find_element_user(WASGENERATEDBY$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wasGeneratedBy);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasGeneratedBy" element
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedBy insertNewWasGeneratedBy(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedBy)get_store().insert_element_user(WASGENERATEDBY$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasGeneratedBy" element
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedBy addNewWasGeneratedBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedBy)get_store().add_element_user(WASGENERATEDBY$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "wasGeneratedBy" element
     */
    public void removeWasGeneratedBy(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WASGENERATEDBY$2, i);
        }
    }
    
    /**
     * Gets array of all "wasTriggeredBy" elements
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredBy[] getWasTriggeredByArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WASTRIGGEREDBY$4, targetList);
            org.openprovenance.model.v1_1_a.WasTriggeredBy[] result = new org.openprovenance.model.v1_1_a.WasTriggeredBy[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "wasTriggeredBy" element
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredBy getWasTriggeredByArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredBy)get_store().find_element_user(WASTRIGGEREDBY$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "wasTriggeredBy" element
     */
    public int sizeOfWasTriggeredByArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WASTRIGGEREDBY$4);
        }
    }
    
    /**
     * Sets array of all "wasTriggeredBy" element
     */
    public void setWasTriggeredByArray(org.openprovenance.model.v1_1_a.WasTriggeredBy[] wasTriggeredByArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wasTriggeredByArray, WASTRIGGEREDBY$4);
        }
    }
    
    /**
     * Sets ith "wasTriggeredBy" element
     */
    public void setWasTriggeredByArray(int i, org.openprovenance.model.v1_1_a.WasTriggeredBy wasTriggeredBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredBy)get_store().find_element_user(WASTRIGGEREDBY$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wasTriggeredBy);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasTriggeredBy" element
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredBy insertNewWasTriggeredBy(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredBy)get_store().insert_element_user(WASTRIGGEREDBY$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasTriggeredBy" element
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredBy addNewWasTriggeredBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredBy)get_store().add_element_user(WASTRIGGEREDBY$4);
            return target;
        }
    }
    
    /**
     * Removes the ith "wasTriggeredBy" element
     */
    public void removeWasTriggeredBy(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WASTRIGGEREDBY$4, i);
        }
    }
    
    /**
     * Gets array of all "wasDerivedFrom" elements
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFrom[] getWasDerivedFromArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WASDERIVEDFROM$6, targetList);
            org.openprovenance.model.v1_1_a.WasDerivedFrom[] result = new org.openprovenance.model.v1_1_a.WasDerivedFrom[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "wasDerivedFrom" element
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFrom getWasDerivedFromArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFrom target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFrom)get_store().find_element_user(WASDERIVEDFROM$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "wasDerivedFrom" element
     */
    public int sizeOfWasDerivedFromArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WASDERIVEDFROM$6);
        }
    }
    
    /**
     * Sets array of all "wasDerivedFrom" element
     */
    public void setWasDerivedFromArray(org.openprovenance.model.v1_1_a.WasDerivedFrom[] wasDerivedFromArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wasDerivedFromArray, WASDERIVEDFROM$6);
        }
    }
    
    /**
     * Sets ith "wasDerivedFrom" element
     */
    public void setWasDerivedFromArray(int i, org.openprovenance.model.v1_1_a.WasDerivedFrom wasDerivedFrom)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFrom target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFrom)get_store().find_element_user(WASDERIVEDFROM$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wasDerivedFrom);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasDerivedFrom" element
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFrom insertNewWasDerivedFrom(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFrom target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFrom)get_store().insert_element_user(WASDERIVEDFROM$6, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasDerivedFrom" element
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFrom addNewWasDerivedFrom()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFrom target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFrom)get_store().add_element_user(WASDERIVEDFROM$6);
            return target;
        }
    }
    
    /**
     * Removes the ith "wasDerivedFrom" element
     */
    public void removeWasDerivedFrom(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WASDERIVEDFROM$6, i);
        }
    }
    
    /**
     * Gets array of all "wasControlledBy" elements
     */
    public org.openprovenance.model.v1_1_a.WasControlledBy[] getWasControlledByArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WASCONTROLLEDBY$8, targetList);
            org.openprovenance.model.v1_1_a.WasControlledBy[] result = new org.openprovenance.model.v1_1_a.WasControlledBy[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "wasControlledBy" element
     */
    public org.openprovenance.model.v1_1_a.WasControlledBy getWasControlledByArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasControlledBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasControlledBy)get_store().find_element_user(WASCONTROLLEDBY$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "wasControlledBy" element
     */
    public int sizeOfWasControlledByArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WASCONTROLLEDBY$8);
        }
    }
    
    /**
     * Sets array of all "wasControlledBy" element
     */
    public void setWasControlledByArray(org.openprovenance.model.v1_1_a.WasControlledBy[] wasControlledByArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wasControlledByArray, WASCONTROLLEDBY$8);
        }
    }
    
    /**
     * Sets ith "wasControlledBy" element
     */
    public void setWasControlledByArray(int i, org.openprovenance.model.v1_1_a.WasControlledBy wasControlledBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasControlledBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasControlledBy)get_store().find_element_user(WASCONTROLLEDBY$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wasControlledBy);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasControlledBy" element
     */
    public org.openprovenance.model.v1_1_a.WasControlledBy insertNewWasControlledBy(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasControlledBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasControlledBy)get_store().insert_element_user(WASCONTROLLEDBY$8, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasControlledBy" element
     */
    public org.openprovenance.model.v1_1_a.WasControlledBy addNewWasControlledBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasControlledBy target = null;
            target = (org.openprovenance.model.v1_1_a.WasControlledBy)get_store().add_element_user(WASCONTROLLEDBY$8);
            return target;
        }
    }
    
    /**
     * Removes the ith "wasControlledBy" element
     */
    public void removeWasControlledBy(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WASCONTROLLEDBY$8, i);
        }
    }
    
    /**
     * Gets array of all "used_" elements
     */
    public org.openprovenance.model.v1_1_a.UsedStar[] getUsed2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(USED2$10, targetList);
            org.openprovenance.model.v1_1_a.UsedStar[] result = new org.openprovenance.model.v1_1_a.UsedStar[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "used_" element
     */
    public org.openprovenance.model.v1_1_a.UsedStar getUsed2Array(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.UsedStar target = null;
            target = (org.openprovenance.model.v1_1_a.UsedStar)get_store().find_element_user(USED2$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "used_" element
     */
    public int sizeOfUsed2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(USED2$10);
        }
    }
    
    /**
     * Sets array of all "used_" element
     */
    public void setUsed2Array(org.openprovenance.model.v1_1_a.UsedStar[] used2Array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(used2Array, USED2$10);
        }
    }
    
    /**
     * Sets ith "used_" element
     */
    public void setUsed2Array(int i, org.openprovenance.model.v1_1_a.UsedStar used2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.UsedStar target = null;
            target = (org.openprovenance.model.v1_1_a.UsedStar)get_store().find_element_user(USED2$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(used2);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "used_" element
     */
    public org.openprovenance.model.v1_1_a.UsedStar insertNewUsed2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.UsedStar target = null;
            target = (org.openprovenance.model.v1_1_a.UsedStar)get_store().insert_element_user(USED2$10, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "used_" element
     */
    public org.openprovenance.model.v1_1_a.UsedStar addNewUsed2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.UsedStar target = null;
            target = (org.openprovenance.model.v1_1_a.UsedStar)get_store().add_element_user(USED2$10);
            return target;
        }
    }
    
    /**
     * Removes the ith "used_" element
     */
    public void removeUsed2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(USED2$10, i);
        }
    }
    
    /**
     * Gets array of all "wasGeneratedBy_" elements
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedByStar[] getWasGeneratedBy2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WASGENERATEDBY2$12, targetList);
            org.openprovenance.model.v1_1_a.WasGeneratedByStar[] result = new org.openprovenance.model.v1_1_a.WasGeneratedByStar[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "wasGeneratedBy_" element
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedByStar getWasGeneratedBy2Array(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedByStar)get_store().find_element_user(WASGENERATEDBY2$12, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "wasGeneratedBy_" element
     */
    public int sizeOfWasGeneratedBy2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WASGENERATEDBY2$12);
        }
    }
    
    /**
     * Sets array of all "wasGeneratedBy_" element
     */
    public void setWasGeneratedBy2Array(org.openprovenance.model.v1_1_a.WasGeneratedByStar[] wasGeneratedBy2Array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wasGeneratedBy2Array, WASGENERATEDBY2$12);
        }
    }
    
    /**
     * Sets ith "wasGeneratedBy_" element
     */
    public void setWasGeneratedBy2Array(int i, org.openprovenance.model.v1_1_a.WasGeneratedByStar wasGeneratedBy2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedByStar)get_store().find_element_user(WASGENERATEDBY2$12, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wasGeneratedBy2);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasGeneratedBy_" element
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedByStar insertNewWasGeneratedBy2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedByStar)get_store().insert_element_user(WASGENERATEDBY2$12, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasGeneratedBy_" element
     */
    public org.openprovenance.model.v1_1_a.WasGeneratedByStar addNewWasGeneratedBy2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasGeneratedByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasGeneratedByStar)get_store().add_element_user(WASGENERATEDBY2$12);
            return target;
        }
    }
    
    /**
     * Removes the ith "wasGeneratedBy_" element
     */
    public void removeWasGeneratedBy2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WASGENERATEDBY2$12, i);
        }
    }
    
    /**
     * Gets array of all "wasTriggeredBy_" elements
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredByStar[] getWasTriggeredBy2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WASTRIGGEREDBY2$14, targetList);
            org.openprovenance.model.v1_1_a.WasTriggeredByStar[] result = new org.openprovenance.model.v1_1_a.WasTriggeredByStar[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "wasTriggeredBy_" element
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredByStar getWasTriggeredBy2Array(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredByStar)get_store().find_element_user(WASTRIGGEREDBY2$14, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "wasTriggeredBy_" element
     */
    public int sizeOfWasTriggeredBy2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WASTRIGGEREDBY2$14);
        }
    }
    
    /**
     * Sets array of all "wasTriggeredBy_" element
     */
    public void setWasTriggeredBy2Array(org.openprovenance.model.v1_1_a.WasTriggeredByStar[] wasTriggeredBy2Array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wasTriggeredBy2Array, WASTRIGGEREDBY2$14);
        }
    }
    
    /**
     * Sets ith "wasTriggeredBy_" element
     */
    public void setWasTriggeredBy2Array(int i, org.openprovenance.model.v1_1_a.WasTriggeredByStar wasTriggeredBy2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredByStar)get_store().find_element_user(WASTRIGGEREDBY2$14, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wasTriggeredBy2);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasTriggeredBy_" element
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredByStar insertNewWasTriggeredBy2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredByStar)get_store().insert_element_user(WASTRIGGEREDBY2$14, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasTriggeredBy_" element
     */
    public org.openprovenance.model.v1_1_a.WasTriggeredByStar addNewWasTriggeredBy2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasTriggeredByStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasTriggeredByStar)get_store().add_element_user(WASTRIGGEREDBY2$14);
            return target;
        }
    }
    
    /**
     * Removes the ith "wasTriggeredBy_" element
     */
    public void removeWasTriggeredBy2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WASTRIGGEREDBY2$14, i);
        }
    }
    
    /**
     * Gets array of all "wasDerivedFrom_" elements
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFromStar[] getWasDerivedFrom2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WASDERIVEDFROM2$16, targetList);
            org.openprovenance.model.v1_1_a.WasDerivedFromStar[] result = new org.openprovenance.model.v1_1_a.WasDerivedFromStar[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "wasDerivedFrom_" element
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFromStar getWasDerivedFrom2Array(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFromStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFromStar)get_store().find_element_user(WASDERIVEDFROM2$16, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "wasDerivedFrom_" element
     */
    public int sizeOfWasDerivedFrom2Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WASDERIVEDFROM2$16);
        }
    }
    
    /**
     * Sets array of all "wasDerivedFrom_" element
     */
    public void setWasDerivedFrom2Array(org.openprovenance.model.v1_1_a.WasDerivedFromStar[] wasDerivedFrom2Array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wasDerivedFrom2Array, WASDERIVEDFROM2$16);
        }
    }
    
    /**
     * Sets ith "wasDerivedFrom_" element
     */
    public void setWasDerivedFrom2Array(int i, org.openprovenance.model.v1_1_a.WasDerivedFromStar wasDerivedFrom2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFromStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFromStar)get_store().find_element_user(WASDERIVEDFROM2$16, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wasDerivedFrom2);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasDerivedFrom_" element
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFromStar insertNewWasDerivedFrom2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFromStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFromStar)get_store().insert_element_user(WASDERIVEDFROM2$16, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasDerivedFrom_" element
     */
    public org.openprovenance.model.v1_1_a.WasDerivedFromStar addNewWasDerivedFrom2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.WasDerivedFromStar target = null;
            target = (org.openprovenance.model.v1_1_a.WasDerivedFromStar)get_store().add_element_user(WASDERIVEDFROM2$16);
            return target;
        }
    }
    
    /**
     * Removes the ith "wasDerivedFrom_" element
     */
    public void removeWasDerivedFrom2(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WASDERIVEDFROM2$16, i);
        }
    }
}
