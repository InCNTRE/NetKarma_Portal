/*
 * XML Type:  uniqueFileListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.UniqueFileListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML uniqueFileListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class UniqueFileListTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.UniqueFileListType
{
    
    public UniqueFileListTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILEURIDETAILSTYPE$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "fileURIDetailsType");
    
    
    /**
     * Gets array of all "fileURIDetailsType" elements
     */
    public org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType[] getFileURIDetailsTypeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(FILEURIDETAILSTYPE$0, targetList);
            org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType[] result = new org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "fileURIDetailsType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType getFileURIDetailsTypeArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType)get_store().find_element_user(FILEURIDETAILSTYPE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "fileURIDetailsType" element
     */
    public int sizeOfFileURIDetailsTypeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FILEURIDETAILSTYPE$0);
        }
    }
    
    /**
     * Sets array of all "fileURIDetailsType" element
     */
    public void setFileURIDetailsTypeArray(org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType[] fileURIDetailsTypeArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(fileURIDetailsTypeArray, FILEURIDETAILSTYPE$0);
        }
    }
    
    /**
     * Sets ith "fileURIDetailsType" element
     */
    public void setFileURIDetailsTypeArray(int i, org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType fileURIDetailsType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType)get_store().find_element_user(FILEURIDETAILSTYPE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(fileURIDetailsType);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "fileURIDetailsType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType insertNewFileURIDetailsType(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType)get_store().insert_element_user(FILEURIDETAILSTYPE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "fileURIDetailsType" element
     */
    public org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType addNewFileURIDetailsType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType)get_store().add_element_user(FILEURIDETAILSTYPE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "fileURIDetailsType" element
     */
    public void removeFileURIDetailsType(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FILEURIDETAILSTYPE$0, i);
        }
    }
}
