/*
 * XML Type:  findMethodInvocationResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findMethodInvocationResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindMethodInvocationResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseType
{
    
    public FindMethodInvocationResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METHODINVOCATIONIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodInvocationIDList");
    private static final javax.xml.namespace.QName METHODINVOCATIONNAMELIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodInvocationNameList");
    
    
    /**
     * Gets the "methodInvocationIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType getMethodInvocationIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType)get_store().find_element_user(METHODINVOCATIONIDLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "methodInvocationIDList" element
     */
    public boolean isSetMethodInvocationIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODINVOCATIONIDLIST$0) != 0;
        }
    }
    
    /**
     * Sets the "methodInvocationIDList" element
     */
    public void setMethodInvocationIDList(org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType methodInvocationIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType)get_store().find_element_user(METHODINVOCATIONIDLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType)get_store().add_element_user(METHODINVOCATIONIDLIST$0);
            }
            target.set(methodInvocationIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "methodInvocationIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType addNewMethodInvocationIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationIDListType)get_store().add_element_user(METHODINVOCATIONIDLIST$0);
            return target;
        }
    }
    
    /**
     * Unsets the "methodInvocationIDList" element
     */
    public void unsetMethodInvocationIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODINVOCATIONIDLIST$0, 0);
        }
    }
    
    /**
     * Gets the "methodInvocationNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType getMethodInvocationNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType)get_store().find_element_user(METHODINVOCATIONNAMELIST$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "methodInvocationNameList" element
     */
    public boolean isSetMethodInvocationNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODINVOCATIONNAMELIST$2) != 0;
        }
    }
    
    /**
     * Sets the "methodInvocationNameList" element
     */
    public void setMethodInvocationNameList(org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType methodInvocationNameList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType)get_store().find_element_user(METHODINVOCATIONNAMELIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType)get_store().add_element_user(METHODINVOCATIONNAMELIST$2);
            }
            target.set(methodInvocationNameList);
        }
    }
    
    /**
     * Appends and returns a new empty "methodInvocationNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType addNewMethodInvocationNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType)get_store().add_element_user(METHODINVOCATIONNAMELIST$2);
            return target;
        }
    }
    
    /**
     * Unsets the "methodInvocationNameList" element
     */
    public void unsetMethodInvocationNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODINVOCATIONNAMELIST$2, 0);
        }
    }
}
