/*
 * An XML document type.
 * Localname: getWorkflowGraphResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getWorkflowGraphResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetWorkflowGraphResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseDocument
{
    
    public GetWorkflowGraphResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETWORKFLOWGRAPHRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getWorkflowGraphResponse");
    
    
    /**
     * Gets the "getWorkflowGraphResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType getGetWorkflowGraphResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType)get_store().find_element_user(GETWORKFLOWGRAPHRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getWorkflowGraphResponse" element
     */
    public void setGetWorkflowGraphResponse(org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType getWorkflowGraphResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType)get_store().find_element_user(GETWORKFLOWGRAPHRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType)get_store().add_element_user(GETWORKFLOWGRAPHRESPONSE$0);
            }
            target.set(getWorkflowGraphResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getWorkflowGraphResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType addNewGetWorkflowGraphResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType)get_store().add_element_user(GETWORKFLOWGRAPHRESPONSE$0);
            return target;
        }
    }
}
