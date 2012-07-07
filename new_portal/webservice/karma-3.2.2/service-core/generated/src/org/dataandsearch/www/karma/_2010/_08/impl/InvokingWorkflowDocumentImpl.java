/*
 * An XML document type.
 * Localname: invokingWorkflow
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one invokingWorkflow(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class InvokingWorkflowDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument
{
    
    public InvokingWorkflowDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INVOKINGWORKFLOW$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "invokingWorkflow");
    
    
    /**
     * Gets the "invokingWorkflow" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType getInvokingWorkflow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(INVOKINGWORKFLOW$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "invokingWorkflow" element
     */
    public void setInvokingWorkflow(org.dataandsearch.www.karma._2010._08.InvocationType invokingWorkflow)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().find_element_user(INVOKINGWORKFLOW$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(INVOKINGWORKFLOW$0);
            }
            target.set(invokingWorkflow);
        }
    }
    
    /**
     * Appends and returns a new empty "invokingWorkflow" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationType addNewInvokingWorkflow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationType)get_store().add_element_user(INVOKINGWORKFLOW$0);
            return target;
        }
    }
}
