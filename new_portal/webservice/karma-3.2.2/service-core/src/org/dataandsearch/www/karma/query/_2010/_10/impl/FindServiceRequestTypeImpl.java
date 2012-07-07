/*
 * XML Type:  findServiceRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findServiceRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindServiceRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType
{
    
    public FindServiceRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NAME$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "name");
    private static final javax.xml.namespace.QName HOSTNAME$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "hostName");
    private static final javax.xml.namespace.QName ARCHITECTURE$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "architecture");
    private static final javax.xml.namespace.QName INITIALIZATIONTIME$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "initializationTime");
    private static final javax.xml.namespace.QName TERMINATIONTIME$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "terminationTime");
    private static final javax.xml.namespace.QName ISSUCCESS$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isSuccess");
    private static final javax.xml.namespace.QName WORKFLOWID$12 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "workflowID");
    private static final javax.xml.namespace.QName SUBSERVICEID$14 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "subServiceID");
    private static final javax.xml.namespace.QName NEXTSERVICEID$16 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "nextServiceID");
    private static final javax.xml.namespace.QName ANNOTATIONLIST$18 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "annotationList");
    
    
    /**
     * Gets the "name" element
     */
    public java.lang.String getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "name" element
     */
    public org.apache.xmlbeans.XmlString xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "name" element
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NAME$0) != 0;
        }
    }
    
    /**
     * Sets the "name" element
     */
    public void setName(java.lang.String name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$0);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" element
     */
    public void xsetName(org.apache.xmlbeans.XmlString name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$0);
            }
            target.set(name);
        }
    }
    
    /**
     * Unsets the "name" element
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NAME$0, 0);
        }
    }
    
    /**
     * Gets the "hostName" element
     */
    public java.lang.String getHostName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOSTNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "hostName" element
     */
    public org.apache.xmlbeans.XmlString xgetHostName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOSTNAME$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "hostName" element
     */
    public boolean isSetHostName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(HOSTNAME$2) != 0;
        }
    }
    
    /**
     * Sets the "hostName" element
     */
    public void setHostName(java.lang.String hostName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOSTNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HOSTNAME$2);
            }
            target.setStringValue(hostName);
        }
    }
    
    /**
     * Sets (as xml) the "hostName" element
     */
    public void xsetHostName(org.apache.xmlbeans.XmlString hostName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOSTNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HOSTNAME$2);
            }
            target.set(hostName);
        }
    }
    
    /**
     * Unsets the "hostName" element
     */
    public void unsetHostName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(HOSTNAME$2, 0);
        }
    }
    
    /**
     * Gets the "architecture" element
     */
    public java.lang.String getArchitecture()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARCHITECTURE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "architecture" element
     */
    public org.apache.xmlbeans.XmlString xgetArchitecture()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARCHITECTURE$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "architecture" element
     */
    public boolean isSetArchitecture()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARCHITECTURE$4) != 0;
        }
    }
    
    /**
     * Sets the "architecture" element
     */
    public void setArchitecture(java.lang.String architecture)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARCHITECTURE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARCHITECTURE$4);
            }
            target.setStringValue(architecture);
        }
    }
    
    /**
     * Sets (as xml) the "architecture" element
     */
    public void xsetArchitecture(org.apache.xmlbeans.XmlString architecture)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARCHITECTURE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ARCHITECTURE$4);
            }
            target.set(architecture);
        }
    }
    
    /**
     * Unsets the "architecture" element
     */
    public void unsetArchitecture()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARCHITECTURE$4, 0);
        }
    }
    
    /**
     * Gets the "initializationTime" element
     */
    public java.util.Calendar getInitializationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INITIALIZATIONTIME$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "initializationTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetInitializationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(INITIALIZATIONTIME$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "initializationTime" element
     */
    public boolean isSetInitializationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INITIALIZATIONTIME$6) != 0;
        }
    }
    
    /**
     * Sets the "initializationTime" element
     */
    public void setInitializationTime(java.util.Calendar initializationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INITIALIZATIONTIME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INITIALIZATIONTIME$6);
            }
            target.setCalendarValue(initializationTime);
        }
    }
    
    /**
     * Sets (as xml) the "initializationTime" element
     */
    public void xsetInitializationTime(org.apache.xmlbeans.XmlDateTime initializationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(INITIALIZATIONTIME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(INITIALIZATIONTIME$6);
            }
            target.set(initializationTime);
        }
    }
    
    /**
     * Unsets the "initializationTime" element
     */
    public void unsetInitializationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INITIALIZATIONTIME$6, 0);
        }
    }
    
    /**
     * Gets the "terminationTime" element
     */
    public java.util.Calendar getTerminationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TERMINATIONTIME$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "terminationTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetTerminationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TERMINATIONTIME$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "terminationTime" element
     */
    public boolean isSetTerminationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TERMINATIONTIME$8) != 0;
        }
    }
    
    /**
     * Sets the "terminationTime" element
     */
    public void setTerminationTime(java.util.Calendar terminationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TERMINATIONTIME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TERMINATIONTIME$8);
            }
            target.setCalendarValue(terminationTime);
        }
    }
    
    /**
     * Sets (as xml) the "terminationTime" element
     */
    public void xsetTerminationTime(org.apache.xmlbeans.XmlDateTime terminationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TERMINATIONTIME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(TERMINATIONTIME$8);
            }
            target.set(terminationTime);
        }
    }
    
    /**
     * Unsets the "terminationTime" element
     */
    public void unsetTerminationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TERMINATIONTIME$8, 0);
        }
    }
    
    /**
     * Gets the "isSuccess" element
     */
    public boolean getIsSuccess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUCCESS$10, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "isSuccess" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetIsSuccess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ISSUCCESS$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "isSuccess" element
     */
    public boolean isSetIsSuccess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISSUCCESS$10) != 0;
        }
    }
    
    /**
     * Sets the "isSuccess" element
     */
    public void setIsSuccess(boolean isSuccess)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUCCESS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUCCESS$10);
            }
            target.setBooleanValue(isSuccess);
        }
    }
    
    /**
     * Sets (as xml) the "isSuccess" element
     */
    public void xsetIsSuccess(org.apache.xmlbeans.XmlBoolean isSuccess)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ISSUCCESS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ISSUCCESS$10);
            }
            target.set(isSuccess);
        }
    }
    
    /**
     * Unsets the "isSuccess" element
     */
    public void unsetIsSuccess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISSUCCESS$10, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$12, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID$12, 0);
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
            return get_store().count_elements(WORKFLOWID$12) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKFLOWID$12);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWID$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WORKFLOWID$12);
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
            get_store().remove_element(WORKFLOWID$12, 0);
        }
    }
    
    /**
     * Gets the "subServiceID" element
     */
    public java.lang.String getSubServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBSERVICEID$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "subServiceID" element
     */
    public org.apache.xmlbeans.XmlString xgetSubServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUBSERVICEID$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "subServiceID" element
     */
    public boolean isSetSubServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SUBSERVICEID$14) != 0;
        }
    }
    
    /**
     * Sets the "subServiceID" element
     */
    public void setSubServiceID(java.lang.String subServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBSERVICEID$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUBSERVICEID$14);
            }
            target.setStringValue(subServiceID);
        }
    }
    
    /**
     * Sets (as xml) the "subServiceID" element
     */
    public void xsetSubServiceID(org.apache.xmlbeans.XmlString subServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUBSERVICEID$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUBSERVICEID$14);
            }
            target.set(subServiceID);
        }
    }
    
    /**
     * Unsets the "subServiceID" element
     */
    public void unsetSubServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SUBSERVICEID$14, 0);
        }
    }
    
    /**
     * Gets the "nextServiceID" element
     */
    public java.lang.String getNextServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTSERVICEID$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nextServiceID" element
     */
    public org.apache.xmlbeans.XmlString xgetNextServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTSERVICEID$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "nextServiceID" element
     */
    public boolean isSetNextServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NEXTSERVICEID$16) != 0;
        }
    }
    
    /**
     * Sets the "nextServiceID" element
     */
    public void setNextServiceID(java.lang.String nextServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTSERVICEID$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NEXTSERVICEID$16);
            }
            target.setStringValue(nextServiceID);
        }
    }
    
    /**
     * Sets (as xml) the "nextServiceID" element
     */
    public void xsetNextServiceID(org.apache.xmlbeans.XmlString nextServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTSERVICEID$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NEXTSERVICEID$16);
            }
            target.set(nextServiceID);
        }
    }
    
    /**
     * Unsets the "nextServiceID" element
     */
    public void unsetNextServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NEXTSERVICEID$16, 0);
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$18, 0);
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
            return get_store().count_elements(ANNOTATIONLIST$18) != 0;
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$18, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$18);
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$18);
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
            get_store().remove_element(ANNOTATIONLIST$18, 0);
        }
    }
}
