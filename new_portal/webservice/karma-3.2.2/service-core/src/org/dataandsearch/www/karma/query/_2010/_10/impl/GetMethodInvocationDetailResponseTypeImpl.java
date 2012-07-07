/*
 * XML Type:  getMethodInvocationDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getMethodInvocationDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetMethodInvocationDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseType
{
    
    public GetMethodInvocationDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METHODINVOCATIONDETAILLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "methodInvocationDetailList");
    
    
    /**
     * Gets the "methodInvocationDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType getMethodInvocationDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType)get_store().find_element_user(METHODINVOCATIONDETAILLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "methodInvocationDetailList" element
     */
    public void setMethodInvocationDetailList(org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType methodInvocationDetailList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType)get_store().find_element_user(METHODINVOCATIONDETAILLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType)get_store().add_element_user(METHODINVOCATIONDETAILLIST$0);
            }
            target.set(methodInvocationDetailList);
        }
    }
    
    /**
     * Appends and returns a new empty "methodInvocationDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType addNewMethodInvocationDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.MethodInvocationDetailListType)get_store().add_element_user(METHODINVOCATIONDETAILLIST$0);
            return target;
        }
    }
}
