/*
 * XML Type:  getClientDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getClientDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetClientDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType
{
    
    public GetClientDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CLIENTDETAILLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "clientDetailList");
    
    
    /**
     * Gets the "clientDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ClientDetailListType getClientDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ClientDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ClientDetailListType)get_store().find_element_user(CLIENTDETAILLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "clientDetailList" element
     */
    public void setClientDetailList(org.dataandsearch.www.karma.query._2010._10.ClientDetailListType clientDetailList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ClientDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ClientDetailListType)get_store().find_element_user(CLIENTDETAILLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.ClientDetailListType)get_store().add_element_user(CLIENTDETAILLIST$0);
            }
            target.set(clientDetailList);
        }
    }
    
    /**
     * Appends and returns a new empty "clientDetailList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.ClientDetailListType addNewClientDetailList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.ClientDetailListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.ClientDetailListType)get_store().add_element_user(CLIENTDETAILLIST$0);
            return target;
        }
    }
}
