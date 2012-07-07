/*
 * XML Type:  OPMGraph
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.OPMGraph
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a;


/**
 * An XML OPMGraph(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public interface OPMGraph extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OPMGraph.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("opmgraph7488type");
    
    /**
     * Gets the "accounts" element
     */
    org.openprovenance.model.v1_1_a.Accounts getAccounts();
    
    /**
     * True if has "accounts" element
     */
    boolean isSetAccounts();
    
    /**
     * Sets the "accounts" element
     */
    void setAccounts(org.openprovenance.model.v1_1_a.Accounts accounts);
    
    /**
     * Appends and returns a new empty "accounts" element
     */
    org.openprovenance.model.v1_1_a.Accounts addNewAccounts();
    
    /**
     * Unsets the "accounts" element
     */
    void unsetAccounts();
    
    /**
     * Gets the "processes" element
     */
    org.openprovenance.model.v1_1_a.Processes getProcesses();
    
    /**
     * True if has "processes" element
     */
    boolean isSetProcesses();
    
    /**
     * Sets the "processes" element
     */
    void setProcesses(org.openprovenance.model.v1_1_a.Processes processes);
    
    /**
     * Appends and returns a new empty "processes" element
     */
    org.openprovenance.model.v1_1_a.Processes addNewProcesses();
    
    /**
     * Unsets the "processes" element
     */
    void unsetProcesses();
    
    /**
     * Gets the "artifacts" element
     */
    org.openprovenance.model.v1_1_a.Artifacts getArtifacts();
    
    /**
     * True if has "artifacts" element
     */
    boolean isSetArtifacts();
    
    /**
     * Sets the "artifacts" element
     */
    void setArtifacts(org.openprovenance.model.v1_1_a.Artifacts artifacts);
    
    /**
     * Appends and returns a new empty "artifacts" element
     */
    org.openprovenance.model.v1_1_a.Artifacts addNewArtifacts();
    
    /**
     * Unsets the "artifacts" element
     */
    void unsetArtifacts();
    
    /**
     * Gets the "agents" element
     */
    org.openprovenance.model.v1_1_a.Agents getAgents();
    
    /**
     * True if has "agents" element
     */
    boolean isSetAgents();
    
    /**
     * Sets the "agents" element
     */
    void setAgents(org.openprovenance.model.v1_1_a.Agents agents);
    
    /**
     * Appends and returns a new empty "agents" element
     */
    org.openprovenance.model.v1_1_a.Agents addNewAgents();
    
    /**
     * Unsets the "agents" element
     */
    void unsetAgents();
    
    /**
     * Gets the "causalDependencies" element
     */
    org.openprovenance.model.v1_1_a.CausalDependencies getCausalDependencies();
    
    /**
     * True if has "causalDependencies" element
     */
    boolean isSetCausalDependencies();
    
    /**
     * Sets the "causalDependencies" element
     */
    void setCausalDependencies(org.openprovenance.model.v1_1_a.CausalDependencies causalDependencies);
    
    /**
     * Appends and returns a new empty "causalDependencies" element
     */
    org.openprovenance.model.v1_1_a.CausalDependencies addNewCausalDependencies();
    
    /**
     * Unsets the "causalDependencies" element
     */
    void unsetCausalDependencies();
    
    /**
     * Gets the "annotations" element
     */
    org.openprovenance.model.v1_1_a.Annotations getAnnotations();
    
    /**
     * True if has "annotations" element
     */
    boolean isSetAnnotations();
    
    /**
     * Sets the "annotations" element
     */
    void setAnnotations(org.openprovenance.model.v1_1_a.Annotations annotations);
    
    /**
     * Appends and returns a new empty "annotations" element
     */
    org.openprovenance.model.v1_1_a.Annotations addNewAnnotations();
    
    /**
     * Unsets the "annotations" element
     */
    void unsetAnnotations();
    
    /**
     * Gets array of all "annotation" elements
     */
    org.openprovenance.model.v1_1_a.EmbeddedAnnotation[] getAnnotationArray();
    
    /**
     * Gets ith "annotation" element
     */
    org.openprovenance.model.v1_1_a.EmbeddedAnnotation getAnnotationArray(int i);
    
    /**
     * Returns number of "annotation" element
     */
    int sizeOfAnnotationArray();
    
    /**
     * Sets array of all "annotation" element
     */
    void setAnnotationArray(org.openprovenance.model.v1_1_a.EmbeddedAnnotation[] annotationArray);
    
    /**
     * Sets ith "annotation" element
     */
    void setAnnotationArray(int i, org.openprovenance.model.v1_1_a.EmbeddedAnnotation annotation);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "annotation" element
     */
    org.openprovenance.model.v1_1_a.EmbeddedAnnotation insertNewAnnotation(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotation" element
     */
    org.openprovenance.model.v1_1_a.EmbeddedAnnotation addNewAnnotation();
    
    /**
     * Removes the ith "annotation" element
     */
    void removeAnnotation(int i);
    
    /**
     * Gets the "id" attribute
     */
    java.lang.String getId();
    
    /**
     * Gets (as xml) the "id" attribute
     */
    org.apache.xmlbeans.XmlID xgetId();
    
    /**
     * True if has "id" attribute
     */
    boolean isSetId();
    
    /**
     * Sets the "id" attribute
     */
    void setId(java.lang.String id);
    
    /**
     * Sets (as xml) the "id" attribute
     */
    void xsetId(org.apache.xmlbeans.XmlID id);
    
    /**
     * Unsets the "id" attribute
     */
    void unsetId();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.openprovenance.model.v1_1_a.OPMGraph newInstance() {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.OPMGraph parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.OPMGraph) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
