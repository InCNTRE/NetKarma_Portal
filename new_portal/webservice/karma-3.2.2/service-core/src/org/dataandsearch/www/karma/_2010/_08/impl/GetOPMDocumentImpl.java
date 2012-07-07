/*
 * An XML document type.
 * Localname: getOPM
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.GetOPMDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * A document containing one getOPM(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public class GetOPMDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.GetOPMDocument
{
    
    public GetOPMDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETOPM$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "getOPM");
    
    
    /**
     * Gets the "getOPM" element
     */
    public org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM getGetOPM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM target = null;
            target = (org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM)get_store().find_element_user(GETOPM$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOPM" element
     */
    public void setGetOPM(org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM getOPM)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM target = null;
            target = (org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM)get_store().find_element_user(GETOPM$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM)get_store().add_element_user(GETOPM$0);
            }
            target.set(getOPM);
        }
    }
    
    /**
     * Appends and returns a new empty "getOPM" element
     */
    public org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM addNewGetOPM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM target = null;
            target = (org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM)get_store().add_element_user(GETOPM$0);
            return target;
        }
    }
    /**
     * An XML getOPM(@http://www.dataandsearch.org/karma/2010/08/).
     *
     * This is a complex type.
     */
    public static class GetOPMImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM
    {
        
        public GetOPMImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IN$0 = 
            new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "in");
        
        
        /**
         * Gets the "in" element
         */
        public java.lang.String getIn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IN$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "in" element
         */
        public org.apache.xmlbeans.XmlString xgetIn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "in" element
         */
        public void setIn(java.lang.String in)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IN$0);
                }
                target.setStringValue(in);
            }
        }
        
        /**
         * Sets (as xml) the "in" element
         */
        public void xsetIn(org.apache.xmlbeans.XmlString in)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(IN$0);
                }
                target.set(in);
            }
        }
    }
}
