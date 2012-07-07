/*
 * An XML document type.
 * Localname: workflowInitialized
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.WorkflowInitializedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one workflowInitialized(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class WorkflowInitializedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.WorkflowInitializedDocument
{
    
    public WorkflowInitializedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWINITIALIZED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflowInitialized");
    
    
    /**
     * Gets the "workflowInitialized" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType getWorkflowInitialized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(WORKFLOWINITIALIZED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "workflowInitialized" element
     */
    public void setWorkflowInitialized(org.dataandsearch.www.karma._2010._08.EntityLifeCycleType workflowInitialized)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(WORKFLOWINITIALIZED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(WORKFLOWINITIALIZED$0);
            }
            target.set(workflowInitialized);
        }
    }
    
    /**
     * Appends and returns a new empty "workflowInitialized" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType addNewWorkflowInitialized()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(WORKFLOWINITIALIZED$0);
            return target;
        }
    }
}
