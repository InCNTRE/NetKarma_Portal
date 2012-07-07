/*
 * XML Type:  getAnnotationDetailRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getAnnotationDetailRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetAnnotationDetailRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType
{
    
    public GetAnnotationDetailRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANNOTATIONPAIREDIDLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "annotationPairedIDList");
    
    
    /**
     * Gets the "annotationPairedIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType getAnnotationPairedIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType)get_store().find_element_user(ANNOTATIONPAIREDIDLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "annotationPairedIDList" element
     */
    public void setAnnotationPairedIDList(org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType annotationPairedIDList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType)get_store().find_element_user(ANNOTATIONPAIREDIDLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType)get_store().add_element_user(ANNOTATIONPAIREDIDLIST$0);
            }
            target.set(annotationPairedIDList);
        }
    }
    
    /**
     * Appends and returns a new empty "annotationPairedIDList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType addNewAnnotationPairedIDList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType)get_store().add_element_user(ANNOTATIONPAIREDIDLIST$0);
            return target;
        }
    }
}
