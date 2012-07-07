/*
 * XML Type:  findAbstractMethodResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findAbstractMethodResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindAbstractMethodResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseType
{
    
    public FindAbstractMethodResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNIQUEIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "uniqueIDList");
    private static final javax.xml.namespace.QName METHODNAMELIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodNameList");
    
    
    /**
     * Gets the "uniqueIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueIDListType getUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEIDLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "uniqueIDList" element
     */
    public boolean isSetUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNIQUEIDLIST$0) != 0;
        }
    }
    
    /**
     * Sets the "uniqueIDList" element
     */
    public void setUniqueIDList(org.dataandsearch.www.karma.query._2010._10.UniqueIDListType uniqueIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().find_element_user(UNIQUEIDLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEIDLIST$0);
            }
            target.set(uniqueIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "uniqueIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.UniqueIDListType addNewUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.UniqueIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.UniqueIDListType)get_store().add_element_user(UNIQUEIDLIST$0);
            return target;
        }
    }
    
    /**
     * Unsets the "uniqueIDList" element
     */
    public void unsetUniqueIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNIQUEIDLIST$0, 0);
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
}
