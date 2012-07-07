/*
 * XML Type:  findAbstractServiceRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findAbstractServiceRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindAbstractServiceRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType
{
    
    public FindAbstractServiceRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RETURNALL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "returnAll");
    private static final javax.xml.namespace.QName METHODNAME$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodName");
    private static final javax.xml.namespace.QName WORKFLOWID$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "workflowID");
    private static final javax.xml.namespace.QName SUBSERVICENAME$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "subServiceName");
    private static final javax.xml.namespace.QName NEXTSERVICENAME$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "nextServiceName");
    private static final javax.xml.namespace.QName SERVICENAME$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceName");
    private static final javax.xml.namespace.QName VERSION$12 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "version");
    private static final javax.xml.namespace.QName ANNOTATIONLIST$14 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "annotationList");
    private static final javax.xml.namespace.QName ISINPUTOFDATAPRODUCTID$16 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isInputOfDataProductID");
    private static final javax.xml.namespace.QName ISOUTPUTOFDATAPRODUCTID$18 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isOutputOfDataProductID");
    private static final javax.xml.namespace.QName HASINSTANCEOFSERVICE$20 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "hasInstanceOfService");
    
    
    /**
     * Gets the "returnAll" element
     */
    public boolean getReturnAll()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURNALL$0, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "returnAll" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetReturnAll()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(RETURNALL$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "returnAll" element
     */
    public boolean isSetReturnAll()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RETURNALL$0) != 0;
        }
    }
    
    /**
     * Sets the "returnAll" element
     */
    public void setReturnAll(boolean returnAll)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURNALL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RETURNALL$0);
            }
            target.setBooleanValue(returnAll);
        }
    }
    
    /**
     * Sets (as xml) the "returnAll" element
     */
    public void xsetReturnAll(org.apache.xmlbeans.XmlBoolean returnAll)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(RETURNALL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(RETURNALL$0);
            }
            target.set(returnAll);
        }
    }
    
    /**
     * Unsets the "returnAll" element
     */
    public void unsetReturnAll()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RETURNALL$0, 0);
        }
    }
    
    /**
     * Gets the "methodName" element
     */
    public java.lang.String getMethodName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "methodName" element
     */
    public org.apache.xmlbeans.XmlString xgetMethodName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODNAME$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "methodName" element
     */
    public boolean isSetMethodName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODNAME$2) != 0;
        }
    }
    
    /**
     * Sets the "methodName" element
     */
    public void setMethodName(java.lang.String methodName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODNAME$2);
            }
            target.setStringValue(methodName);
        }
    }
    
    /**
     * Sets (as xml) the "methodName" element
     */
    public void xsetMethodName(org.apache.xmlbeans.XmlString methodName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(METHODNAME$2);
            }
            target.set(methodName);
        }
    }
    
    /**
     * Unsets the "methodName" element
     */
    public void unsetMethodName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODNAME$2, 0);
        }
    }
    
    /**
     * Gets the "workflowID" element
     */
    public java.lang.String getWorkflowID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$4, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID$4, 0);
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
            return get_store().count_elements(WORKFLOWID$4) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKFLOWID$4);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WORKFLOWID$4);
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
            get_store().remove_element(WORKFLOWID$4, 0);
        }
    }
    
    /**
     * Gets the "subServiceName" element
     */
    public java.lang.String getSubServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBSERVICENAME$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "subServiceName" element
     */
    public org.apache.xmlbeans.XmlString xgetSubServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUBSERVICENAME$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "subServiceName" element
     */
    public boolean isSetSubServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SUBSERVICENAME$6) != 0;
        }
    }
    
    /**
     * Sets the "subServiceName" element
     */
    public void setSubServiceName(java.lang.String subServiceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBSERVICENAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUBSERVICENAME$6);
            }
            target.setStringValue(subServiceName);
        }
    }
    
    /**
     * Sets (as xml) the "subServiceName" element
     */
    public void xsetSubServiceName(org.apache.xmlbeans.XmlString subServiceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUBSERVICENAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUBSERVICENAME$6);
            }
            target.set(subServiceName);
        }
    }
    
    /**
     * Unsets the "subServiceName" element
     */
    public void unsetSubServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SUBSERVICENAME$6, 0);
        }
    }
    
    /**
     * Gets the "nextServiceName" element
     */
    public java.lang.String getNextServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTSERVICENAME$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nextServiceName" element
     */
    public org.apache.xmlbeans.XmlString xgetNextServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTSERVICENAME$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "nextServiceName" element
     */
    public boolean isSetNextServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NEXTSERVICENAME$8) != 0;
        }
    }
    
    /**
     * Sets the "nextServiceName" element
     */
    public void setNextServiceName(java.lang.String nextServiceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTSERVICENAME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NEXTSERVICENAME$8);
            }
            target.setStringValue(nextServiceName);
        }
    }
    
    /**
     * Sets (as xml) the "nextServiceName" element
     */
    public void xsetNextServiceName(org.apache.xmlbeans.XmlString nextServiceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTSERVICENAME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NEXTSERVICENAME$8);
            }
            target.set(nextServiceName);
        }
    }
    
    /**
     * Unsets the "nextServiceName" element
     */
    public void unsetNextServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NEXTSERVICENAME$8, 0);
        }
    }
    
    /**
     * Gets the "serviceName" element
     */
    public java.lang.String getServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SERVICENAME$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "serviceName" element
     */
    public org.apache.xmlbeans.XmlString xgetServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SERVICENAME$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "serviceName" element
     */
    public boolean isSetServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICENAME$10) != 0;
        }
    }
    
    /**
     * Sets the "serviceName" element
     */
    public void setServiceName(java.lang.String serviceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SERVICENAME$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SERVICENAME$10);
            }
            target.setStringValue(serviceName);
        }
    }
    
    /**
     * Sets (as xml) the "serviceName" element
     */
    public void xsetServiceName(org.apache.xmlbeans.XmlString serviceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SERVICENAME$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SERVICENAME$10);
            }
            target.set(serviceName);
        }
    }
    
    /**
     * Unsets the "serviceName" element
     */
    public void unsetServiceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICENAME$10, 0);
        }
    }
    
    /**
     * Gets the "version" element
     */
    public java.lang.String getVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "version" element
     */
    public org.apache.xmlbeans.XmlString xgetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VERSION$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "version" element
     */
    public boolean isSetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VERSION$12) != 0;
        }
    }
    
    /**
     * Sets the "version" element
     */
    public void setVersion(java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VERSION$12);
            }
            target.setStringValue(version);
        }
    }
    
    /**
     * Sets (as xml) the "version" element
     */
    public void xsetVersion(org.apache.xmlbeans.XmlString version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VERSION$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VERSION$12);
            }
            target.set(version);
        }
    }
    
    /**
     * Unsets the "version" element
     */
    public void unsetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VERSION$12, 0);
        }
    }
    
    /**
     * Gets the "annotationList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AnnotationListType getAnnotationList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$14, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "annotationList" element
     */
    public boolean isSetAnnotationList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANNOTATIONLIST$14) != 0;
        }
    }
    
    /**
     * Sets the "annotationList" element
     */
    public void setAnnotationList(org.dataandsearch.www.karma.query._2010._10.AnnotationListType annotationList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$14, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$14);
            }
            target.set(annotationList);
        }
    }
    
    /**
     * Appends and returns a new empty "annotationList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AnnotationListType addNewAnnotationList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$14);
            return target;
        }
    }
    
    /**
     * Unsets the "annotationList" element
     */
    public void unsetAnnotationList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANNOTATIONLIST$14, 0);
        }
    }
    
    /**
     * Gets the "isInputOfDataProductID" element
     */
    public java.lang.String getIsInputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isInputOfDataProductID" element
     */
    public org.apache.xmlbeans.XmlString xgetIsInputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "isInputOfDataProductID" element
     */
    public boolean isSetIsInputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISINPUTOFDATAPRODUCTID$16) != 0;
        }
    }
    
    /**
     * Sets the "isInputOfDataProductID" element
     */
    public void setIsInputOfDataProductID(java.lang.String isInputOfDataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISINPUTOFDATAPRODUCTID$16);
            }
            target.setStringValue(isInputOfDataProductID);
        }
    }
    
    /**
     * Sets (as xml) the "isInputOfDataProductID" element
     */
    public void xsetIsInputOfDataProductID(org.apache.xmlbeans.XmlString isInputOfDataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISINPUTOFDATAPRODUCTID$16);
            }
            target.set(isInputOfDataProductID);
        }
    }
    
    /**
     * Unsets the "isInputOfDataProductID" element
     */
    public void unsetIsInputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISINPUTOFDATAPRODUCTID$16, 0);
        }
    }
    
    /**
     * Gets the "isOutputOfDataProductID" element
     */
    public java.lang.String getIsOutputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isOutputOfDataProductID" element
     */
    public org.apache.xmlbeans.XmlString xgetIsOutputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "isOutputOfDataProductID" element
     */
    public boolean isSetIsOutputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISOUTPUTOFDATAPRODUCTID$18) != 0;
        }
    }
    
    /**
     * Sets the "isOutputOfDataProductID" element
     */
    public void setIsOutputOfDataProductID(java.lang.String isOutputOfDataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISOUTPUTOFDATAPRODUCTID$18);
            }
            target.setStringValue(isOutputOfDataProductID);
        }
    }
    
    /**
     * Sets (as xml) the "isOutputOfDataProductID" element
     */
    public void xsetIsOutputOfDataProductID(org.apache.xmlbeans.XmlString isOutputOfDataProductID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISOUTPUTOFDATAPRODUCTID$18);
            }
            target.set(isOutputOfDataProductID);
        }
    }
    
    /**
     * Unsets the "isOutputOfDataProductID" element
     */
    public void unsetIsOutputOfDataProductID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISOUTPUTOFDATAPRODUCTID$18, 0);
        }
    }
    
    /**
     * Gets the "hasInstanceOfService" element
     */
    public java.lang.String getHasInstanceOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFSERVICE$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "hasInstanceOfService" element
     */
    public org.apache.xmlbeans.XmlString xgetHasInstanceOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFSERVICE$20, 0);
            return target;
        }
    }
    
    /**
     * True if has "hasInstanceOfService" element
     */
    public boolean isSetHasInstanceOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(HASINSTANCEOFSERVICE$20) != 0;
        }
    }
    
    /**
     * Sets the "hasInstanceOfService" element
     */
    public void setHasInstanceOfService(java.lang.String hasInstanceOfService)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFSERVICE$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HASINSTANCEOFSERVICE$20);
            }
            target.setStringValue(hasInstanceOfService);
        }
    }
    
    /**
     * Sets (as xml) the "hasInstanceOfService" element
     */
    public void xsetHasInstanceOfService(org.apache.xmlbeans.XmlString hasInstanceOfService)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFSERVICE$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HASINSTANCEOFSERVICE$20);
            }
            target.set(hasInstanceOfService);
        }
    }
    
    /**
     * Unsets the "hasInstanceOfService" element
     */
    public void unsetHasInstanceOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(HASINSTANCEOFSERVICE$20, 0);
        }
    }
}
