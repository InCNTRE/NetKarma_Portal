/*
 * An XML document type.
 * Localname: getNodeCountOfGraphRequest
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * A document containing one getNodeCountOfGraphRequest(@http://www.dataandsearch.org/karma/query/2010/10/) element.
 *
 * This is a complex type.
 */
public class GetNodeCountOfGraphRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestDocument
{
    
    public GetNodeCountOfGraphRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETNODECOUNTOFGRAPHREQUEST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "getNodeCountOfGraphRequest");
    
    
    /**
     * Gets the "getNodeCountOfGraphRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType getGetNodeCountOfGraphRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType)get_store().find_element_user(GETNODECOUNTOFGRAPHREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getNodeCountOfGraphRequest" element
     */
    public void setGetNodeCountOfGraphRequest(org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType getNodeCountOfGraphRequest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType)get_store().find_element_user(GETNODECOUNTOFGRAPHREQUEST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType)get_store().add_element_user(GETNODECOUNTOFGRAPHREQUEST$0);
            }
            target.set(getNodeCountOfGraphRequest);
        }
    }
    
    /**
     * Appends and returns a new empty "getNodeCountOfGraphRequest" element
     */
    public org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType addNewGetNodeCountOfGraphRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType)get_store().add_element_user(GETNODECOUNTOFGRAPHREQUEST$0);
            return target;
        }
    }
}
