/*
 * An XML document type.
 * Localname: opmGraph
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.OpmGraphDocument
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a.impl;
/**
 * A document containing one opmGraph(@http://openprovenance.org/model/v1.1.a) element.
 *
 * This is a complex type.
 */
public class OpmGraphDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.openprovenance.model.v1_1_a.OpmGraphDocument
{
    
    public OpmGraphDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPMGRAPH$0 = 
        new javax.xml.namespace.QName("http://openprovenance.org/model/v1.1.a", "opmGraph");
    
    
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
}
