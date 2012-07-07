/*
 * XML Type:  getProvenanceHistoryRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getProvenanceHistoryRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetProvenanceHistoryRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType
{
    
    public GetProvenanceHistoryRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARTIFACTID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "artifactID");
    private static final javax.xml.namespace.QName TIMERANGE$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "timeRange");
    private static final javax.xml.namespace.QName INFORMATIONDETAILLEVEL$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "informationDetailLevel");
    private static final javax.xml.namespace.QName FORMAT$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "format");
    
    
    /**
     * Gets the "artifactID" element
     */
    public java.lang.String getArtifactID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARTIFACTID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "artifactID" element
     */
    public org.apache.xmlbeans.XmlString xgetArtifactID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARTIFACTID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "artifactID" element
     */
    public void setArtifactID(java.lang.String artifactID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARTIFACTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARTIFACTID$0);
            }
            target.setStringValue(artifactID);
        }
    }
    
    /**
     * Sets (as xml) the "artifactID" element
     */
    public void xsetArtifactID(org.apache.xmlbeans.XmlString artifactID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARTIFACTID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ARTIFACTID$0);
            }
            target.set(artifactID);
        }
    }
    
    /**
     * Gets the "timeRange" element
     */
    public long getTimeRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMERANGE$2, 0);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "timeRange" element
     */
    public org.apache.xmlbeans.XmlLong xgetTimeRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(TIMERANGE$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "timeRange" element
     */
    public boolean isSetTimeRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TIMERANGE$2) != 0;
        }
    }
    
    /**
     * Sets the "timeRange" element
     */
    public void setTimeRange(long timeRange)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMERANGE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIMERANGE$2);
            }
            target.setLongValue(timeRange);
        }
    }
    
    /**
     * Sets (as xml) the "timeRange" element
     */
    public void xsetTimeRange(org.apache.xmlbeans.XmlLong timeRange)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(TIMERANGE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_element_user(TIMERANGE$2);
            }
            target.set(timeRange);
        }
    }
    
    /**
     * Unsets the "timeRange" element
     */
    public void unsetTimeRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TIMERANGE$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INFORMATIONDETAILLEVEL$4, 0);
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
            target = (org.dataandsearch.www.karma.query._2010._10.DetailEnumType)get_store().find_element_user(INFORMATIONDETAILLEVEL$4, 0);
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
            return get_store().count_elements(INFORMATIONDETAILLEVEL$4) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INFORMATIONDETAILLEVEL$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INFORMATIONDETAILLEVEL$4);
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
            target = (org.dataandsearch.www.karma.query._2010._10.DetailEnumType)get_store().find_element_user(INFORMATIONDETAILLEVEL$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DetailEnumType)get_store().add_element_user(INFORMATIONDETAILLEVEL$4);
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
            get_store().remove_element(INFORMATIONDETAILLEVEL$4, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$6, 0);
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
            target = (org.dataandsearch.www.karma.query._2010._10.FormatEnumType)get_store().find_element_user(FORMAT$6, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMAT$6);
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
            target = (org.dataandsearch.www.karma.query._2010._10.FormatEnumType)get_store().find_element_user(FORMAT$6, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.FormatEnumType)get_store().add_element_user(FORMAT$6);
            }
            target.set(format);
        }
    }
}
