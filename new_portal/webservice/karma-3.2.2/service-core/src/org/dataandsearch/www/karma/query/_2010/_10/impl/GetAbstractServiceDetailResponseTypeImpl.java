/*
 * XML Type:  getAbstractServiceDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getAbstractServiceDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetAbstractServiceDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType
{
    
    public GetAbstractServiceDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTSERVICEDETAILLISTTYPE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "abstractServiceDetailListType");
    
    
    /**
     * Gets the "abstractServiceDetailListType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType getAbstractServiceDetailListType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType)get_store().find_element_user(ABSTRACTSERVICEDETAILLISTTYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "abstractServiceDetailListType" element
     */
    public void setAbstractServiceDetailListType(org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType abstractServiceDetailListType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType)get_store().find_element_user(ABSTRACTSERVICEDETAILLISTTYPE$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType)get_store().add_element_user(ABSTRACTSERVICEDETAILLISTTYPE$0);
            }
            target.set(abstractServiceDetailListType);
        }
    }
    
    /**
     * Appends and returns a new empty "abstractServiceDetailListType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType addNewAbstractServiceDetailListType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType)get_store().add_element_user(ABSTRACTSERVICEDETAILLISTTYPE$0);
            return target;
        }
    }
}
