/*
 * XML Type:  getNodeCountOfGraphRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getNodeCountOfGraphRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetNodeCountOfGraphRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType
{
    
    public GetNodeCountOfGraphRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "workflowID");
    
    
    /**
     * Gets the "workflowID" element
     */
    public java.lang.String getWorkflowID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "workflowID" element
     */
    public org.apache.xmlbeans.XmlString xgetWorkflowID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "workflowID" element
     */
    public boolean isSetWorkflowID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WORKFLOWID$0) != 0;
        }
    }
    
    /**
     * Sets the "workflowID" element
     */
    public void setWorkflowID(java.lang.String workflowID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKFLOWID$0);
            }
            target.setStringValue(workflowID);
        }
    }
    
    /**
     * Sets (as xml) the "workflowID" element
     */
    public void xsetWorkflowID(org.apache.xmlbeans.XmlString workflowID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WORKFLOWID$0);
            }
            target.set(workflowID);
        }
    }
    
    /**
     * Unsets the "workflowID" element
     */
    public void unsetWorkflowID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WORKFLOWID$0, 0);
        }
    }
}
