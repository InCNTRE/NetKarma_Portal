/*
 * An XML document type.
 * Localname: getNodeCountOfGraphResponse
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getNodeCountOfGraphResponse(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetNodeCountOfGraphResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseDocument
{
    
    public GetNodeCountOfGraphResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETNODECOUNTOFGRAPHRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getNodeCountOfGraphResponse");
    
    
    /**
     * Gets the "getNodeCountOfGraphResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType getGetNodeCountOfGraphResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType)get_store().find_element_user(GETNODECOUNTOFGRAPHRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getNodeCountOfGraphResponse" element
     */
    public void setGetNodeCountOfGraphResponse(org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType getNodeCountOfGraphResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType)get_store().find_element_user(GETNODECOUNTOFGRAPHRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType)get_store().add_element_user(GETNODECOUNTOFGRAPHRESPONSE$0);
            }
            target.set(getNodeCountOfGraphResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getNodeCountOfGraphResponse" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType addNewGetNodeCountOfGraphResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType)get_store().add_element_user(GETNODECOUNTOFGRAPHRESPONSE$0);
            return target;
        }
    }
}
