/*
 * XML Type:  findAbstractDataProductRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML findAbstractDataProductRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class FindAbstractDataProductRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType
{
    
    public FindAbstractDataProductRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RETURNALL$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "returnAll");
    private static final javax.xml.namespace.QName DATAPRODUCTNAMELIST$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductNameList");
    private static final javax.xml.namespace.QName DATAPRODUCTTYPELIST$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "dataProductTypeList");
    private static final javax.xml.namespace.QName ISINPUTOFSERVICEID$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isInputOfServiceID");
    private static final javax.xml.namespace.QName ISOUTPUTOFSERVICEID$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isOutputOfServiceID");
    private static final javax.xml.namespace.QName ISINPUTOFMETHODID$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isInputOfMethodID");
    private static final javax.xml.namespace.QName ISOUTPUTOFMETHODID$12 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "isOutputOfMethodID");
    private static final javax.xml.namespace.QName HASINSTANCEOFDATAPRODUCT$14 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "hasInstanceOfDataProduct");
    
    
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
     * Gets the "dataProductNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductNameListType getDataProductNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType)get_store().find_element_user(DATAPRODUCTNAMELIST$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "dataProductNameList" element
     */
    public boolean isSetDataProductNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAPRODUCTNAMELIST$2) != 0;
        }
    }
    
    /**
     * Sets the "dataProductNameList" element
     */
    public void setDataProductNameList(org.dataandsearch.www.karma.query._2010._10.DataProductNameListType dataProductNameList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType)get_store().find_element_user(DATAPRODUCTNAMELIST$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType)get_store().add_element_user(DATAPRODUCTNAMELIST$2);
            }
            target.set(dataProductNameList);
        }
    }
    
    /**
     * Appends and returns a new empty "dataProductNameList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductNameListType addNewDataProductNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductNameListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType)get_store().add_element_user(DATAPRODUCTNAMELIST$2);
            return target;
        }
    }
    
    /**
     * Unsets the "dataProductNameList" element
     */
    public void unsetDataProductNameList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAPRODUCTNAMELIST$2, 0);
        }
    }
    
    /**
     * Gets the "dataProductTypeList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType getDataProductTypeList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType)get_store().find_element_user(DATAPRODUCTTYPELIST$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "dataProductTypeList" element
     */
    public boolean isSetDataProductTypeList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAPRODUCTTYPELIST$4) != 0;
        }
    }
    
    /**
     * Sets the "dataProductTypeList" element
     */
    public void setDataProductTypeList(org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType dataProductTypeList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType)get_store().find_element_user(DATAPRODUCTTYPELIST$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType)get_store().add_element_user(DATAPRODUCTTYPELIST$4);
            }
            target.set(dataProductTypeList);
        }
    }
    
    /**
     * Appends and returns a new empty "dataProductTypeList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType addNewDataProductTypeList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType)get_store().add_element_user(DATAPRODUCTTYPELIST$4);
            return target;
        }
    }
    
    /**
     * Unsets the "dataProductTypeList" element
     */
    public void unsetDataProductTypeList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAPRODUCTTYPELIST$4, 0);
        }
    }
    
    /**
     * Gets the "isInputOfServiceID" element
     */
    public java.lang.String getIsInputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFSERVICEID$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isInputOfServiceID" element
     */
    public org.apache.xmlbeans.XmlString xgetIsInputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFSERVICEID$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "isInputOfServiceID" element
     */
    public boolean isSetIsInputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISINPUTOFSERVICEID$6) != 0;
        }
    }
    
    /**
     * Sets the "isInputOfServiceID" element
     */
    public void setIsInputOfServiceID(java.lang.String isInputOfServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFSERVICEID$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISINPUTOFSERVICEID$6);
            }
            target.setStringValue(isInputOfServiceID);
        }
    }
    
    /**
     * Sets (as xml) the "isInputOfServiceID" element
     */
    public void xsetIsInputOfServiceID(org.apache.xmlbeans.XmlString isInputOfServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFSERVICEID$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISINPUTOFSERVICEID$6);
            }
            target.set(isInputOfServiceID);
        }
    }
    
    /**
     * Unsets the "isInputOfServiceID" element
     */
    public void unsetIsInputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISINPUTOFSERVICEID$6, 0);
        }
    }
    
    /**
     * Gets the "isOutputOfServiceID" element
     */
    public java.lang.String getIsOutputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFSERVICEID$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isOutputOfServiceID" element
     */
    public org.apache.xmlbeans.XmlString xgetIsOutputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFSERVICEID$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "isOutputOfServiceID" element
     */
    public boolean isSetIsOutputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISOUTPUTOFSERVICEID$8) != 0;
        }
    }
    
    /**
     * Sets the "isOutputOfServiceID" element
     */
    public void setIsOutputOfServiceID(java.lang.String isOutputOfServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFSERVICEID$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISOUTPUTOFSERVICEID$8);
            }
            target.setStringValue(isOutputOfServiceID);
        }
    }
    
    /**
     * Sets (as xml) the "isOutputOfServiceID" element
     */
    public void xsetIsOutputOfServiceID(org.apache.xmlbeans.XmlString isOutputOfServiceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFSERVICEID$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISOUTPUTOFSERVICEID$8);
            }
            target.set(isOutputOfServiceID);
        }
    }
    
    /**
     * Unsets the "isOutputOfServiceID" element
     */
    public void unsetIsOutputOfServiceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISOUTPUTOFSERVICEID$8, 0);
        }
    }
    
    /**
     * Gets the "isInputOfMethodID" element
     */
    public java.lang.String getIsInputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFMETHODID$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isInputOfMethodID" element
     */
    public org.apache.xmlbeans.XmlString xgetIsInputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFMETHODID$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "isInputOfMethodID" element
     */
    public boolean isSetIsInputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISINPUTOFMETHODID$10) != 0;
        }
    }
    
    /**
     * Sets the "isInputOfMethodID" element
     */
    public void setIsInputOfMethodID(java.lang.String isInputOfMethodID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISINPUTOFMETHODID$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISINPUTOFMETHODID$10);
            }
            target.setStringValue(isInputOfMethodID);
        }
    }
    
    /**
     * Sets (as xml) the "isInputOfMethodID" element
     */
    public void xsetIsInputOfMethodID(org.apache.xmlbeans.XmlString isInputOfMethodID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISINPUTOFMETHODID$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISINPUTOFMETHODID$10);
            }
            target.set(isInputOfMethodID);
        }
    }
    
    /**
     * Unsets the "isInputOfMethodID" element
     */
    public void unsetIsInputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISINPUTOFMETHODID$10, 0);
        }
    }
    
    /**
     * Gets the "isOutputOfMethodID" element
     */
    public java.lang.String getIsOutputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFMETHODID$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isOutputOfMethodID" element
     */
    public org.apache.xmlbeans.XmlString xgetIsOutputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFMETHODID$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "isOutputOfMethodID" element
     */
    public boolean isSetIsOutputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISOUTPUTOFMETHODID$12) != 0;
        }
    }
    
    /**
     * Sets the "isOutputOfMethodID" element
     */
    public void setIsOutputOfMethodID(java.lang.String isOutputOfMethodID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISOUTPUTOFMETHODID$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISOUTPUTOFMETHODID$12);
            }
            target.setStringValue(isOutputOfMethodID);
        }
    }
    
    /**
     * Sets (as xml) the "isOutputOfMethodID" element
     */
    public void xsetIsOutputOfMethodID(org.apache.xmlbeans.XmlString isOutputOfMethodID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISOUTPUTOFMETHODID$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISOUTPUTOFMETHODID$12);
            }
            target.set(isOutputOfMethodID);
        }
    }
    
    /**
     * Unsets the "isOutputOfMethodID" element
     */
    public void unsetIsOutputOfMethodID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISOUTPUTOFMETHODID$12, 0);
        }
    }
    
    /**
     * Gets the "hasInstanceOfDataProduct" element
     */
    public java.lang.String getHasInstanceOfDataProduct()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFDATAPRODUCT$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "hasInstanceOfDataProduct" element
     */
    public org.apache.xmlbeans.XmlString xgetHasInstanceOfDataProduct()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFDATAPRODUCT$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "hasInstanceOfDataProduct" element
     */
    public boolean isSetHasInstanceOfDataProduct()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(HASINSTANCEOFDATAPRODUCT$14) != 0;
        }
    }
    
    /**
     * Sets the "hasInstanceOfDataProduct" element
     */
    public void setHasInstanceOfDataProduct(java.lang.String hasInstanceOfDataProduct)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HASINSTANCEOFDATAPRODUCT$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HASINSTANCEOFDATAPRODUCT$14);
            }
            target.setStringValue(hasInstanceOfDataProduct);
        }
    }
    
    /**
     * Sets (as xml) the "hasInstanceOfDataProduct" element
     */
    public void xsetHasInstanceOfDataProduct(org.apache.xmlbeans.XmlString hasInstanceOfDataProduct)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HASINSTANCEOFDATAPRODUCT$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HASINSTANCEOFDATAPRODUCT$14);
            }
            target.set(hasInstanceOfDataProduct);
        }
    }
    
    /**
     * Unsets the "hasInstanceOfDataProduct" element
     */
    public void unsetHasInstanceOfDataProduct()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(HASINSTANCEOFDATAPRODUCT$14, 0);
        }
    }
}
