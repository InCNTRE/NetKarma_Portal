/*
 * XML Type:  getWorkflowGraphResponseType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10.impl;
/**
 * An XML getWorkflowGraphResponseType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public class GetWorkflowGraphResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType
{
    
    public GetWorkflowGraphResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPMGRAPH$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "opmGraph");
    private static final javax.xml.namespace.QName RDF$2 = 
        new javax.xml.namespace.QName("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "RDF");
    
    
    /**
     * Gets the "opmGraph" element
     */
    public org.openprovenance.model.v1_1_a.OPMGraph getOpmGraph()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OPMGraph target = null;
            target = (org.openprovenance.model.v1_1_a.OPMGraph)get_store().find_element_user(OPMGRAPH$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "opmGraph" element
     */
    public boolean isSetOpmGraph()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OPMGRAPH$0) != 0;
        }
    }
    
    /**
     * Sets the "opmGraph" element
     */
    public void setOpmGraph(org.openprovenance.model.v1_1_a.OPMGraph opmGraph)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OPMGraph target = null;
            target = (org.openprovenance.model.v1_1_a.OPMGraph)get_store().find_element_user(OPMGRAPH$0, 0);
            if (target == null)
            {
                target = (org.openprovenance.model.v1_1_a.OPMGraph)get_store().add_element_user(OPMGRAPH$0);
            }
            target.set(opmGraph);
        }
    }
    
    /**
     * Appends and returns a new empty "opmGraph" element
     */
    public org.openprovenance.model.v1_1_a.OPMGraph addNewOpmGraph()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.openprovenance.model.v1_1_a.OPMGraph target = null;
            target = (org.openprovenance.model.v1_1_a.OPMGraph)get_store().add_element_user(OPMGRAPH$0);
            return target;
        }
    }
    
    /**
     * Unsets the "opmGraph" element
     */
    public void unsetOpmGraph()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OPMGRAPH$0, 0);
        }
    }
    
    /**
     * Gets the "RDF" element
     */
    public org.w3.www._1999._02._22_rdf_syntax_ns.RdfType getRDF()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.www._1999._02._22_rdf_syntax_ns.RdfType target = null;
            target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().find_element_user(RDF$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "RDF" element
     */
    public boolean isSetRDF()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RDF$2) != 0;
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
            target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().find_element_user(RDF$2, 0);
            if (target == null)
            {
                target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().add_element_user(RDF$2);
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
            target = (org.w3.www._1999._02._22_rdf_syntax_ns.RdfType)get_store().add_element_user(RDF$2);
            return target;
        }
    }
    
    /**
     * Unsets the "RDF" element
     */
    public void unsetRDF()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RDF$2, 0);
        }
    }
}
