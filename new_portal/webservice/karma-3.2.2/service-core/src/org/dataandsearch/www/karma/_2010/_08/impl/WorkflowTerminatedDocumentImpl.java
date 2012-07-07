/*
 * An XML document type.
 * Localname: workflowTerminated
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.WorkflowTerminatedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one workflowTerminated(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class WorkflowTerminatedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.WorkflowTerminatedDocument
{
    
    public WorkflowTerminatedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWTERMINATED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflowTerminated");
    
    
    /**
     * Gets the "workflowTerminated" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType getWorkflowTerminated()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(WORKFLOWTERMINATED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "workflowTerminated" element
     */
    public void setWorkflowTerminated(org.dataandsearch.www.karma._2010._08.EntityLifeCycleType workflowTerminated)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().find_element_user(WORKFLOWTERMINATED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(WORKFLOWTERMINATED$0);
            }
            target.set(workflowTerminated);
        }
    }
    
    /**
     * Appends and returns a new empty "workflowTerminated" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityLifeCycleType addNewWorkflowTerminated()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityLifeCycleType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityLifeCycleType)get_store().add_element_user(WORKFLOWTERMINATED$0);
            return target;
        }
    }
}
