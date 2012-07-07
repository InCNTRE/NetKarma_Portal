/*
 * XML Type:  getWorkflowGraphRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getWorkflowGraphRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetWorkflowGraphRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType
{
    
    public GetWorkflowGraphRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "workflowID");
    private static final javax.xml.namespace.QName INFORMATIONDETAILLEVEL$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "informationDetailLevel");
    private static final javax.xml.namespace.QName FORMAT$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "format");
    
    
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
     * Gets the "informationDetailLevel" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DetailEnumType.Enum getInformationDetailLevel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INFORMATIONDETAILLEVEL$2, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma.query._2010._10.DetailEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "informationDetailLevel" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DetailEnumType xgetInformationDetailLevel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DetailEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DetailEnumType)get_store().find_element_user(INFORMATIONDETAILLEVEL$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "informationDetailLevel" element
     */
    public boolean isSetInformationDetailLevel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INFORMATIONDETAILLEVEL$2) != 0;
        }
    }
    
    /**
     * Sets the "informationDetailLevel" element
     */
    public void setInformationDetailLevel(org.dataandsearch.www.karma.query._2010._10.DetailEnumType.Enum informationDetailLevel)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INFORMATIONDETAILLEVEL$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INFORMATIONDETAILLEVEL$2);
            }
            target.setEnumValue(informationDetailLevel);
        }
    }
    
    /**
     * Sets (as xml) the "informationDetailLevel" element
     */
    public void xsetInformationDetailLevel(org.dataandsearch.www.karma.query._2010._10.DetailEnumType informationDetailLevel)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DetailEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DetailEnumType)get_store().find_element_user(INFORMATIONDETAILLEVEL$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DetailEnumType)get_store().add_element_user(INFORMATIONDETAILLEVEL$2);
            }
            target.set(informationDetailLevel);
        }
    }
    
    /**
     * Unsets the "informationDetailLevel" element
     */
    public void unsetInformationDetailLevel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INFORMATIONDETAILLEVEL$2, 0);
        }
    }
    
    /**
     * Gets the "format" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FormatEnumType.Enum getFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$4, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma.query._2010._10.FormatEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "format" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FormatEnumType xgetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FormatEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FormatEnumType)get_store().find_element_user(FORMAT$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "format" element
     */
    public void setFormat(org.dataandsearch.www.karma.query._2010._10.FormatEnumType.Enum format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMAT$4);
            }
            target.setEnumValue(format);
        }
    }
    
    /**
     * Sets (as xml) the "format" element
     */
    public void xsetFormat(org.dataandsearch.www.karma.query._2010._10.FormatEnumType format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FormatEnumType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FormatEnumType)get_store().find_element_user(FORMAT$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FormatEnumType)get_store().add_element_user(FORMAT$4);
            }
            target.set(format);
        }
    }
}
