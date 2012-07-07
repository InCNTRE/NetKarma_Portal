/*
 * An XML document type.
 * Localname: workflowFailed
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.WorkflowFailedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one workflowFailed(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class WorkflowFailedDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.WorkflowFailedDocument
{
    
    public WorkflowFailedDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWFAILED$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflowFailed");
    
    
    /**
     * Gets the "workflowFailed" element
     */
    public org.dataandsearch.www.karma._2010._08.WorkflowFailedType getWorkflowFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowFailedType target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowFailedType)get_store().find_element_user(WORKFLOWFAILED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "workflowFailed" element
     */
    public void setWorkflowFailed(org.dataandsearch.www.karma._2010._08.WorkflowFailedType workflowFailed)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowFailedType target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowFailedType)get_store().find_element_user(WORKFLOWFAILED$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.WorkflowFailedType)get_store().add_element_user(WORKFLOWFAILED$0);
            }
            target.set(workflowFailed);
        }
    }
    
    /**
     * Appends and returns a new empty "workflowFailed" element
     */
    public org.dataandsearch.www.karma._2010._08.WorkflowFailedType addNewWorkflowFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowFailedType target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowFailedType)get_store().add_element_user(WORKFLOWFAILED$0);
            return target;
        }
    }
}
