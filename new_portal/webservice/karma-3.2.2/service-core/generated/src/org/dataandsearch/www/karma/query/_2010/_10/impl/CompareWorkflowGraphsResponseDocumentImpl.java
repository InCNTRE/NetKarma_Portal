/*
 * An XML document type.
 * Localname: compareWorkflowGraphsResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one compareWorkflowGraphsResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class CompareWorkflowGraphsResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseDocument
{
    
    public CompareWorkflowGraphsResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPAREWORKFLOWGRAPHSRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "compareWorkflowGraphsResponse");
    
    
    /**
     * Gets the "compareWorkflowGraphsResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType getCompareWorkflowGraphsResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType)get_store().find_element_user(COMPAREWORKFLOWGRAPHSRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "compareWorkflowGraphsResponse" element
     */
    public void setCompareWorkflowGraphsResponse(org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType compareWorkflowGraphsResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType)get_store().find_element_user(COMPAREWORKFLOWGRAPHSRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType)get_store().add_element_user(COMPAREWORKFLOWGRAPHSRESPONSE$0);
            }
            target.set(compareWorkflowGraphsResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "compareWorkflowGraphsResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType addNewCompareWorkflowGraphsResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType)get_store().add_element_user(COMPAREWORKFLOWGRAPHSRESPONSE$0);
            return target;
        }
    }
}
