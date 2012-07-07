/*
 * XML Type:  compareWorkflowGraphsRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML compareWorkflowGraphsRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class CompareWorkflowGraphsRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestType
{
    
    public CompareWorkflowGraphsRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWID1$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "workflowID1");
    private static final javax.xml.namespace.QName WORKFLOWID2$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "workflowID2");
    
    
    /**
     * Gets the "workflowID1" element
     */
    public java.lang.String getWorkflowID1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "workflowID1" element
     */
    public org.apache.xmlbeans.XmlString xgetWorkflowID1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID1$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "workflowID1" element
     */
    public boolean isSetWorkflowID1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WORKFLOWID1$0) != 0;
        }
    }
    
    /**
     * Sets the "workflowID1" element
     */
    public void setWorkflowID1(java.lang.String workflowID1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKFLOWID1$0);
            }
            target.setStringValue(workflowID1);
        }
    }
    
    /**
     * Sets (as xml) the "workflowID1" element
     */
    public void xsetWorkflowID1(org.apache.xmlbeans.XmlString workflowID1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WORKFLOWID1$0);
            }
            target.set(workflowID1);
        }
    }
    
    /**
     * Unsets the "workflowID1" element
     */
    public void unsetWorkflowID1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WORKFLOWID1$0, 0);
        }
    }
    
    /**
     * Gets the "workflowID2" element
     */
    public java.lang.String getWorkflowID2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID2$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "workflowID2" element
     */
    public org.apache.xmlbeans.XmlString xgetWorkflowID2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID2$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "workflowID2" element
     */
    public boolean isSetWorkflowID2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WORKFLOWID2$2) != 0;
        }
    }
    
    /**
     * Sets the "workflowID2" element
     */
    public void setWorkflowID2(java.lang.String workflowID2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID2$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKFLOWID2$2);
            }
            target.setStringValue(workflowID2);
        }
    }
    
    /**
     * Sets (as xml) the "workflowID2" element
     */
    public void xsetWorkflowID2(org.apache.xmlbeans.XmlString workflowID2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID2$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WORKFLOWID2$2);
            }
            target.set(workflowID2);
        }
    }
    
    /**
     * Unsets the "workflowID2" element
     */
    public void unsetWorkflowID2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WORKFLOWID2$2, 0);
        }
    }
}
