/*
 * XML Type:  getAbstractMethodDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getAbstractMethodDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetAbstractMethodDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseType
{
    
    public GetAbstractMethodDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTMETHODLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "abstractMethodList");
    
    
    /**
     * Gets the "abstractMethodList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType getAbstractMethodList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType)get_store().find_element_user(ABSTRACTMETHODLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "abstractMethodList" element
     */
    public void setAbstractMethodList(org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType abstractMethodList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType)get_store().find_element_user(ABSTRACTMETHODLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType)get_store().add_element_user(ABSTRACTMETHODLIST$0);
            }
            target.set(abstractMethodList);
        }
    }
    
    /**
     * Appends and returns a new empty "abstractMethodList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType addNewAbstractMethodList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractMethodListType)get_store().add_element_user(ABSTRACTMETHODLIST$0);
            return target;
        }
    }
}
