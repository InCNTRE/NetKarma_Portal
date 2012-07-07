/*
 * An XML document type.
 * Localname: compareWorkflowGraphsRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one compareWorkflowGraphsRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class CompareWorkflowGraphsRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestDocument
{
    
    public CompareWorkflowGraphsRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPAREWORKFLOWGRAPHSREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "compareWorkflowGraphsRequest");
    
    
    /**
     * Gets the "compareWorkflowGraphsRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType getCompareWorkflowGraphsRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType)get_store().find_element_user(COMPAREWORKFLOWGRAPHSREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "compareWorkflowGraphsRequest" element
     */
    public void setCompareWorkflowGraphsRequest(org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType compareWorkflowGraphsRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType)get_store().find_element_user(COMPAREWORKFLOWGRAPHSREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType)get_store().add_element_user(COMPAREWORKFLOWGRAPHSREQUEST$0);
            }
            target.set(compareWorkflowGraphsRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "compareWorkflowGraphsRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType addNewCompareWorkflowGraphsRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType)get_store().add_element_user(COMPAREWORKFLOWGRAPHSREQUEST$0);
            return target;
        }
    }
}
