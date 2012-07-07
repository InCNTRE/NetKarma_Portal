/*
 * XML Type:  getAnnotationDetailResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getAnnotationDetailResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetAnnotationDetailResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType
{
    
    public GetAnnotationDetailResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANNOTATIONLIST$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/query/2010/10/", "annotationList");
    
    
    /**
     * Gets the "annotationList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AnnotationListType getAnnotationList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "annotationList" element
     */
    public void setAnnotationList(org.dataandsearch.www.karma.query._2010._10.AnnotationListType annotationList)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().find_element_user(ANNOTATIONLIST$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$0);
            }
            target.set(annotationList);
        }
    }
    
    /**
     * Appends and returns a new empty "annotationList" element
     */
    public org.dataandsearch.www.karma.query._2010._10.AnnotationListType addNewAnnotationList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma.query._2010._10.AnnotationListType target = null;
            target = (org.dataandsearch.www.karma.query._2010._10.AnnotationListType)get_store().add_element_user(ANNOTATIONLIST$0);
            return target;
        }
    }
}
