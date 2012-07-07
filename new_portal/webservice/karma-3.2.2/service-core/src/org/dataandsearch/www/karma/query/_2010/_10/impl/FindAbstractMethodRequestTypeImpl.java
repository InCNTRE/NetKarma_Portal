/*
 * XML Type:  findAbstractMethodRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findAbstractMethodRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindAbstractMethodRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType
{
    
    public FindAbstractMethodRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RETURNALL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "returnAll");
    private static final javax.xml.namespace.QName SERVICEIDLIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceIDList");
    private static final javax.xml.namespace.QName METHODNAMELIST$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodNameList");
    private static final javax.xml.namespace.QName METHODPARAMSNAME$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodParamsName");
    private static final javax.xml.namespace.QName ANNOTATIONLIST$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "annotationList");
    private static final javax.xml.namespace.QName ISINPUTOFDATAPRODUCTID$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isInputOfDataProductID");
    private static final javax.xml.namespace.QName ISOUTPUTOFDATAPRODUCTID$12 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isOutputOfDataProductID");
    private static final javax.xml.namespace.QName HASINSTANCEOFMETHOD$14 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "hasInstanceOfMethod");
    
    
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
     * Gets the "serviceIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceIDListType getServiceIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICEIDLIST$2, 0);
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
            return get_store().count_elements(SERVICEIDLIST$2) != 0;
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
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().find_element_user(SERVICEIDLIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICEIDLIST$2);
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
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceIDListType)get_store().add_element_user(SERVICEIDLIST$2);
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
            get_store().remove_element(SERVICEIDLIST$2, 0);
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
            target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().find_element_user(METHODNAMELIST$4, 0);
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
            return get_store().count_elements(METHODNAMELIST$4) != 0;
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
            target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().find_element_user(METHODNAMELIST$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().add_element_user(METHODNAMELIST$4);
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
            target = (org.dataandsearch.www.karma.query._2010._10.MethodNameListType)get_store().add_element_user(METHODNAMELIST$4);
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
            get_store().remove_element(METHODNAMELIST$4, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODPARAMSNAME$6, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODPARAMSNAME$6, 0);
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
            return get_store().count_elements(METHODPARAMSNAME$6) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METHODPARAMSNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METHODPARAMSNAME$6);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(METHODPARAMSNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(METHODPARAMSNAME$6);
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
            get_store().remove_element(METHODPARAMSNAME$6, 0);
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$8, 0);
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
            return get_store().count_elements(ANNOTATIONLIST$8) != 0;
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$8, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$8);
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
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$8);
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
            get_store().remove_element(ANNOTATIONLIST$8, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$10, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$10, 0);
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
            return get_store().count_elements(ISINPUTOFDATAPRODUCTID$10) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISINPUTOFDATAPRODUCTID$10);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFDATAPRODUCTID$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISINPUTOFDATAPRODUCTID$10);
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
            get_store().remove_element(ISINPUTOFDATAPRODUCTID$10, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$12, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$12, 0);
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
            return get_store().count_elements(ISOUTPUTOFDATAPRODUCTID$12) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISOUTPUTOFDATAPRODUCTID$12);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFDATAPRODUCTID$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISOUTPUTOFDATAPRODUCTID$12);
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
            get_store().remove_element(ISOUTPUTOFDATAPRODUCTID$12, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFMETHOD$14, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFMETHOD$14, 0);
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
            return get_store().count_elements(HASINSTANCEOFMETHOD$14) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFMETHOD$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HASINSTANCEOFMETHOD$14);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFMETHOD$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HASINSTANCEOFMETHOD$14);
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
            get_store().remove_element(HASINSTANCEOFMETHOD$14, 0);
        }
    }
}
