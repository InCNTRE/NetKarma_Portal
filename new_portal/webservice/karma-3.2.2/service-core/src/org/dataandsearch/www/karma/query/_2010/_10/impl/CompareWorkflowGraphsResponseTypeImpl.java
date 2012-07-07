/*
 * XML Type:  compareWorkflowGraphsResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML compareWorkflowGraphsResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class CompareWorkflowGraphsResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseType
{
    
    public CompareWorkflowGraphsResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DIFFERENCES$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "differences");
    
    
    /**
     * Gets the "differences" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DifferenceType getDifferences()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DifferenceType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DifferenceType)get_store().find_element_user(DIFFERENCES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "differences" element
     */
    public boolean isSetDifferences()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DIFFERENCES$0) != 0;
        }
    }
    
    /**
     * Sets the "differences" element
     */
    public void setDifferences(org.dataandsearch.www.karma.query._2010._10.DifferenceType differences)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DifferenceType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DifferenceType)get_store().find_element_user(DIFFERENCES$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DifferenceType)get_store().add_element_user(DIFFERENCES$0);
            }
            target.set(differences);
        }
    }
    
    /**
     * Appends and returns a new empty "differences" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DifferenceType addNewDifferences()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DifferenceType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DifferenceType)get_store().add_element_user(DIFFERENCES$0);
            return target;
        }
    }
    
    /**
     * Unsets the "differences" element
     */
    public void unsetDifferences()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DIFFERENCES$0, 0);
        }
    }
}
