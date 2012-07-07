/*
 * XML Type:  findMethodInvocationRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findMethodInvocationRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindMethodInvocationRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestType
{
    
    public FindMethodInvocationRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceIDList");
    private static final javax.xml.namespace.QName METHODNAMELIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodNameList");
    private static final javax.xml.namespace.QName METHODPARAMSNAME$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodParamsName");
    private static final javax.xml.namespace.QName ANNOTATIONLIST$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "annotationList");
    private static final javax.xml.namespace.QName ISINPUTOFDATAPRODUCTID$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isInputOfDataProductID");
    private static final javax.xml.namespace.QName ISOUTPUTOFDATAPRODUCTID$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isOutputOfDataProductID");
    private static final javax.xml.namespace.QName HASINSTANCEOFMETHOD$12 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "hasInstanceOfMethod");
    private static final javax.xml.namespace.QName TIMESTAMP$14 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "timestamp");
    private static final javax.xml.namespace.QName REQUESTSTATUS$16 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "requestStatus");
    private static final javax.xml.namespace.QName REQUESTSENDTIME$18 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "requestSendTime");
    private static final javax.xml.namespace.QName REQUESTRECEIVETIME$20 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "requestReceiveTime");
    private static final javax.xml.namespace.QName RESPONSESTATUS$22 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "responseStatus");
    private static final javax.xml.namespace.QName RESPONSESENDTIME$24 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "responseSendTime");
    private static final javax.xml.namespace.QName RESPONSERECEIVETIME$26 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "responseReceiveTime");
    
    
    /**
     * Gets the "serviceIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceIDListType getServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICEIDLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "serviceIDList" element
     */
    public boolean isSetServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICEIDLIST$0) != 0;
        }
    }
    
    /**
     * Sets the "serviceIDList" element
     */
    public void setServiceIDList(org.dataandsearch.www.karma.query._2010._10.ServiceIDListType serviceIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICEIDLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICEIDLIST$0);
            }
            target.set(serviceIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceIDListType addNewServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICEIDLIST$0);
            return target;
        }
    }
    
    /**
     * Unsets the "serviceIDList" element
     */
    public void unsetServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICEIDLIST$0, 0);
        }
    }
    
    /**
     * Gets the "methodNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodNameListType getMethodNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().find_element_user(METHODNAMELIST$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "methodNameList" element
     */
    public boolean isSetMethodNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODNAMELIST$2) != 0;
        }
    }
    
    /**
     * Sets the "methodNameList" element
     */
    public void setMethodNameList(org.dataandsearch.www.karma.query._2010._10.MethodNameListType methodNameList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().find_element_user(METHODNAMELIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().add_element_user(METHODNAMELIST$2);
            }
            target.set(methodNameList);
        }
    }
    
    /**
     * Appends and returns a new empty "methodNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodNameListType addNewMethodNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().add_element_user(METHODNAMELIST$2);
            return target;
        }
    }
    
    /**
     * Unsets the "methodNameList" element
     */
    public void unsetMethodNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODNAMELIST$2, 0);
        }
    }
    
    /**
     * Gets the "methodParamsName" element
     */
    public java.lang.String getMethodParamsName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODPARAMSNAME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "methodParamsName" element
     */
    public org.apache.xmlbeans.XmlString xgetMethodParamsName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODPARAMSNAME$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "methodParamsName" element
     */
    public boolean isSetMethodParamsName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODPARAMSNAME$4) != 0;
        }
    }
    
    /**
     * Sets the "methodParamsName" element
     */
    public void setMethodParamsName(java.lang.String methodParamsName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODPARAMSNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODPARAMSNAME$4);
            }
            target.setStringValue(methodParamsName);
        }
    }
    
    /**
     * Sets (as xml) the "methodParamsName" element
     */
    public void xsetMethodParamsName(org.apache.xmlbeans.XmlString methodParamsName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODPARAMSNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(METHODPARAMSNAME$4);
            }
            target.set(methodParamsName);
        }
    }
    
    /**
     * Unsets the "methodParamsName" element
     */
    public void unsetMethodParamsName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODPARAMSNAME$4, 0);
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$6, 0);
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
            return get_store().count_elements(ANNOTATIONLIST$6) != 0;
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$6, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$6);
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$6);
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
            get_store().remove_element(ANNOTATIONLIST$6, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$8, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$8, 0);
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
            return get_store().count_elements(ISINPUTOFDATAPRODUCTID$8) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISINPUTOFDATAPRODUCTID$8);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISINPUTOFDATAPRODUCTID$8);
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
            get_store().remove_element(ISINPUTOFDATAPRODUCTID$8, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$10, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$10, 0);
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
            return get_store().count_elements(ISOUTPUTOFDATAPRODUCTID$10) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISOUTPUTOFDATAPRODUCTID$10);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISOUTPUTOFDATAPRODUCTID$10);
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
            get_store().remove_element(ISOUTPUTOFDATAPRODUCTID$10, 0);
        }
    }
    
    /**
     * Gets the "hasInstanceOfMethod" element
     */
    public java.lang.String getHasInstanceOfMethod()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFMETHOD$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "hasInstanceOfMethod" element
     */
    public org.apache.xmlbeans.XmlString xgetHasInstanceOfMethod()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFMETHOD$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "hasInstanceOfMethod" element
     */
    public boolean isSetHasInstanceOfMethod()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(HASINSTANCEOFMETHOD$12) != 0;
        }
    }
    
    /**
     * Sets the "hasInstanceOfMethod" element
     */
    public void setHasInstanceOfMethod(java.lang.String hasInstanceOfMethod)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFMETHOD$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HASINSTANCEOFMETHOD$12);
            }
            target.setStringValue(hasInstanceOfMethod);
        }
    }
    
    /**
     * Sets (as xml) the "hasInstanceOfMethod" element
     */
    public void xsetHasInstanceOfMethod(org.apache.xmlbeans.XmlString hasInstanceOfMethod)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFMETHOD$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HASINSTANCEOFMETHOD$12);
            }
            target.set(hasInstanceOfMethod);
        }
    }
    
    /**
     * Unsets the "hasInstanceOfMethod" element
     */
    public void unsetHasInstanceOfMethod()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(HASINSTANCEOFMETHOD$12, 0);
        }
    }
    
    /**
     * Gets the "timestamp" element
     */
    public java.util.Calendar getTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMESTAMP$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "timestamp" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TIMESTAMP$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "timestamp" element
     */
    public boolean isSetTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TIMESTAMP$14) != 0;
        }
    }
    
    /**
     * Sets the "timestamp" element
     */
    public void setTimestamp(java.util.Calendar timestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMESTAMP$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIMESTAMP$14);
            }
            target.setCalendarValue(timestamp);
        }
    }
    
    /**
     * Sets (as xml) the "timestamp" element
     */
    public void xsetTimestamp(org.apache.xmlbeans.XmlDateTime timestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(TIMESTAMP$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(TIMESTAMP$14);
            }
            target.set(timestamp);
        }
    }
    
    /**
     * Unsets the "timestamp" element
     */
    public void unsetTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TIMESTAMP$14, 0);
        }
    }
    
    /**
     * Gets the "requestStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum getRequestStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTSTATUS$16, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "requestStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.StatusEnumType xgetRequestStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.StatusEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().find_element_user(REQUESTSTATUS$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "requestStatus" element
     */
    public boolean isSetRequestStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REQUESTSTATUS$16) != 0;
        }
    }
    
    /**
     * Sets the "requestStatus" element
     */
    public void setRequestStatus(org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum requestStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTSTATUS$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REQUESTSTATUS$16);
            }
            target.setEnumValue(requestStatus);
        }
    }
    
    /**
     * Sets (as xml) the "requestStatus" element
     */
    public void xsetRequestStatus(org.dataandsearch.www.karma._2010._08.StatusEnumType requestStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.StatusEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().find_element_user(REQUESTSTATUS$16, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().add_element_user(REQUESTSTATUS$16);
            }
            target.set(requestStatus);
        }
    }
    
    /**
     * Unsets the "requestStatus" element
     */
    public void unsetRequestStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REQUESTSTATUS$16, 0);
        }
    }
    
    /**
     * Gets the "requestSendTime" element
     */
    public java.util.Calendar getRequestSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTSENDTIME$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "requestSendTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetRequestSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(REQUESTSENDTIME$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "requestSendTime" element
     */
    public boolean isSetRequestSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REQUESTSENDTIME$18) != 0;
        }
    }
    
    /**
     * Sets the "requestSendTime" element
     */
    public void setRequestSendTime(java.util.Calendar requestSendTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTSENDTIME$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REQUESTSENDTIME$18);
            }
            target.setCalendarValue(requestSendTime);
        }
    }
    
    /**
     * Sets (as xml) the "requestSendTime" element
     */
    public void xsetRequestSendTime(org.apache.xmlbeans.XmlDateTime requestSendTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(REQUESTSENDTIME$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(REQUESTSENDTIME$18);
            }
            target.set(requestSendTime);
        }
    }
    
    /**
     * Unsets the "requestSendTime" element
     */
    public void unsetRequestSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REQUESTSENDTIME$18, 0);
        }
    }
    
    /**
     * Gets the "requestReceiveTime" element
     */
    public java.util.Calendar getRequestReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTRECEIVETIME$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "requestReceiveTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetRequestReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(REQUESTRECEIVETIME$20, 0);
            return target;
        }
    }
    
    /**
     * True if has "requestReceiveTime" element
     */
    public boolean isSetRequestReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REQUESTRECEIVETIME$20) != 0;
        }
    }
    
    /**
     * Sets the "requestReceiveTime" element
     */
    public void setRequestReceiveTime(java.util.Calendar requestReceiveTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTRECEIVETIME$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REQUESTRECEIVETIME$20);
            }
            target.setCalendarValue(requestReceiveTime);
        }
    }
    
    /**
     * Sets (as xml) the "requestReceiveTime" element
     */
    public void xsetRequestReceiveTime(org.apache.xmlbeans.XmlDateTime requestReceiveTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(REQUESTRECEIVETIME$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(REQUESTRECEIVETIME$20);
            }
            target.set(requestReceiveTime);
        }
    }
    
    /**
     * Unsets the "requestReceiveTime" element
     */
    public void unsetRequestReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REQUESTRECEIVETIME$20, 0);
        }
    }
    
    /**
     * Gets the "responseStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum getResponseStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSESTATUS$22, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "responseStatus" element
     */
    public org.dataandsearch.www.karma._2010._08.StatusEnumType xgetResponseStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.StatusEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().find_element_user(RESPONSESTATUS$22, 0);
            return target;
        }
    }
    
    /**
     * True if has "responseStatus" element
     */
    public boolean isSetResponseStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESPONSESTATUS$22) != 0;
        }
    }
    
    /**
     * Sets the "responseStatus" element
     */
    public void setResponseStatus(org.dataandsearch.www.karma._2010._08.StatusEnumType.Enum responseStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSESTATUS$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESPONSESTATUS$22);
            }
            target.setEnumValue(responseStatus);
        }
    }
    
    /**
     * Sets (as xml) the "responseStatus" element
     */
    public void xsetResponseStatus(org.dataandsearch.www.karma._2010._08.StatusEnumType responseStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.StatusEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().find_element_user(RESPONSESTATUS$22, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.StatusEnumType)get_store().add_element_user(RESPONSESTATUS$22);
            }
            target.set(responseStatus);
        }
    }
    
    /**
     * Unsets the "responseStatus" element
     */
    public void unsetResponseStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESPONSESTATUS$22, 0);
        }
    }
    
    /**
     * Gets the "responseSendTime" element
     */
    public java.util.Calendar getResponseSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSESENDTIME$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "responseSendTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetResponseSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(RESPONSESENDTIME$24, 0);
            return target;
        }
    }
    
    /**
     * True if has "responseSendTime" element
     */
    public boolean isSetResponseSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESPONSESENDTIME$24) != 0;
        }
    }
    
    /**
     * Sets the "responseSendTime" element
     */
    public void setResponseSendTime(java.util.Calendar responseSendTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSESENDTIME$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESPONSESENDTIME$24);
            }
            target.setCalendarValue(responseSendTime);
        }
    }
    
    /**
     * Sets (as xml) the "responseSendTime" element
     */
    public void xsetResponseSendTime(org.apache.xmlbeans.XmlDateTime responseSendTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(RESPONSESENDTIME$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(RESPONSESENDTIME$24);
            }
            target.set(responseSendTime);
        }
    }
    
    /**
     * Unsets the "responseSendTime" element
     */
    public void unsetResponseSendTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESPONSESENDTIME$24, 0);
        }
    }
    
    /**
     * Gets the "responseReceiveTime" element
     */
    public java.util.Calendar getResponseReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSERECEIVETIME$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "responseReceiveTime" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetResponseReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(RESPONSERECEIVETIME$26, 0);
            return target;
        }
    }
    
    /**
     * True if has "responseReceiveTime" element
     */
    public boolean isSetResponseReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESPONSERECEIVETIME$26) != 0;
        }
    }
    
    /**
     * Sets the "responseReceiveTime" element
     */
    public void setResponseReceiveTime(java.util.Calendar responseReceiveTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSERECEIVETIME$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESPONSERECEIVETIME$26);
            }
            target.setCalendarValue(responseReceiveTime);
        }
    }
    
    /**
     * Sets (as xml) the "responseReceiveTime" element
     */
    public void xsetResponseReceiveTime(org.apache.xmlbeans.XmlDateTime responseReceiveTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(RESPONSERECEIVETIME$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(RESPONSERECEIVETIME$26);
            }
            target.set(responseReceiveTime);
        }
    }
    
    /**
     * Unsets the "responseReceiveTime" element
     */
    public void unsetResponseReceiveTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESPONSERECEIVETIME$26, 0);
        }
    }
}
