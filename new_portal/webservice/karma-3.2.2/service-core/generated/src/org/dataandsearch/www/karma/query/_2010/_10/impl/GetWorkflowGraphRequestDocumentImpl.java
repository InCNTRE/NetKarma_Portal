/*
 * An XML document type.
 * Localname: getWorkflowGraphRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getWorkflowGraphRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetWorkflowGraphRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument
{
    
    public GetWorkflowGraphRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETWORKFLOWGRAPHREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getWorkflowGraphRequest");
    
    
    /**
     * Gets the "getWorkflowGraphRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType getGetWorkflowGraphRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType)get_store().find_element_user(GETWORKFLOWGRAPHREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getWorkflowGraphRequest" element
     */
    public void setGetWorkflowGraphRequest(org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType getWorkflowGraphRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType)get_store().find_element_user(GETWORKFLOWGRAPHREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType)get_store().add_element_user(GETWORKFLOWGRAPHREQUEST$0);
            }
            target.set(getWorkflowGraphRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getWorkflowGraphRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType addNewGetWorkflowGraphRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType)get_store().add_element_user(GETWORKFLOWGRAPHREQUEST$0);
            return target;
        }
    }
}
