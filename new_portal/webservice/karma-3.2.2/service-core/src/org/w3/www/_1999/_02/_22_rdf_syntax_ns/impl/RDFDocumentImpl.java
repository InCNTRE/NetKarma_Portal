/*
 * An XML document type.
 * Localname: RDF
 * Namespace: http://www.w3.org/1999/02/22-rdf-syntax-ns#
 * Java type: org.w3.www._1999._02._22_rdf_syntax_ns.RDFDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.www._1999._02._22_rdf_syntax_ns.impl;
/**
 * A document containing one RDF(@http://www.w3.org/1999/02/22-rdf-syntax-ns#) element.
 *
 * This is a complex type.
 */
public class RDFDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.www._1999._02._22_rdf_syntax_ns.RDFDocument
{
    
    public RDFDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RDF$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "RDF");
    
    
    /**
     * Gets the "RDF" element
     */
    public org.w3.www._1999._02._22_rdf_syntax_ns.RdfType getRDF()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.www._1999._02._22_rdf_syntax_ns.RdfType target = null;
            target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().find_element_user(RDF$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "RDF" element
     */
    public void setRDF(org.w3.www._1999._02._22_rdf_syntax_ns.RdfType rdf)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.www._1999._02._22_rdf_syntax_ns.RdfType target = null;
            target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().find_element_user(RDF$0, 0);
            if (target == null)
            {
                target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().add_element_user(RDF$0);
            }
            target.set(rdf);
        }
    }
    
    /**
     * Appends and returns a new empty "RDF" element
     */
    public org.w3.www._1999._02._22_rdf_syntax_ns.RdfType addNewRDF()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.www._1999._02._22_rdf_syntax_ns.RdfType target = null;
            target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().add_element_user(RDF$0);
            return target;
        }
    }
}
