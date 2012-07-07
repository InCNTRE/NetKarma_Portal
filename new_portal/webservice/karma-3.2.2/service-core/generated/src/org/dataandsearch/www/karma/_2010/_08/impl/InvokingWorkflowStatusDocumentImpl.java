/*
 * An XML document type.
 * Localname: invokingWorkflowStatus
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.InvokingWorkflowStatusDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one invokingWorkflowStatus(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class InvokingWorkflowStatusDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.InvokingWorkflowStatusDocument
{
    
    public InvokingWorkflowStatusDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INVOKINGWORKFLOWSTATUS$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "invokingWorkflowStatus");
    
    
    /**
     * Gets the "invokingWorkflowStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationStatusType getInvokingWorkflowStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().find_element_user(INVOKINGWORKFLOWSTATUS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "invokingWorkflowStatus" element
     */
    public void setInvokingWorkflowStatus(org.dataandsearch.www.karma._2010._08.InvocationStatusType invokingWorkflowStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().find_element_user(INVOKINGWORKFLOWSTATUS$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().add_element_user(INVOKINGWORKFLOWSTATUS$0);
            }
            target.set(invokingWorkflowStatus);
        }
    }
    
    /**
     * Appends and returns a new empty "invokingWorkflowStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.InvocationStatusType addNewInvokingWorkflowStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InvocationStatusType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InvocationStatusType)get_store().add_element_user(INVOKINGWORKFLOWSTATUS$0);
            return target;
        }
    }
}
