/*
 * An XML document type.
 * Localname: workflowInvoked
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one workflowInvoked(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class WorkflowInvokedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument
{
    
    public WorkflowInvokedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWINVOKED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflowInvoked");
    
    
    /**
     * Gets the "workflowInvoked" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType getWorkflowInvoked()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(WORKFLOWINVOKED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "workflowInvoked" element
     */
    public void setWorkflowInvoked(org.dataandsearch.www.karma._2010._08.InvocationType workflowInvoked)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(WORKFLOWINVOKED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(WORKFLOWINVOKED$0);
            }
            target.set(workflowInvoked);
        }
    }
    
    /**
     * Appends and returns a new empty "workflowInvoked" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType addNewWorkflowInvoked()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(WORKFLOWINVOKED$0);
            return target;
        }
    }
}
