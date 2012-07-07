/*
 * XML Type:  getServiceDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getServiceDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetServiceDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType
{
    
    public GetServiceDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEDETAILLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "serviceDetailList");
    
    
    /**
     * Gets the "serviceDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType getServiceDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType)get_store().find_element_user(SERVICEDETAILLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "serviceDetailList" element
     */
    public void setServiceDetailList(org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType serviceDetailList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType)get_store().find_element_user(SERVICEDETAILLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType)get_store().add_element_user(SERVICEDETAILLIST$0);
            }
            target.set(serviceDetailList);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType addNewServiceDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType)get_store().add_element_user(SERVICEDETAILLIST$0);
            return target;
        }
    }
}
