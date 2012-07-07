/*
 * XML Type:  WasGeneratedBy
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.WasGeneratedBy
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a;


/**
 * An XML WasGeneratedBy(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public interface WasGeneratedBy extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(WasGeneratedBy.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("wasgeneratedby254dtype");
    
    /**
     * Gets the "effect" element
     */
    org.openprovenance.model.v1_1_a.ArtifactRef getEffect();
    
    /**
     * Sets the "effect" element
     */
    void setEffect(org.openprovenance.model.v1_1_a.ArtifactRef effect);
    
    /**
     * Appends and returns a new empty "effect" element
     */
    org.openprovenance.model.v1_1_a.ArtifactRef addNewEffect();
    
    /**
     * Gets the "role" element
     */
    org.openprovenance.model.v1_1_a.Role getRole();
    
    /**
     * Sets the "role" element
     */
    void setRole(org.openprovenance.model.v1_1_a.Role role);
    
    /**
     * Appends and returns a new empty "role" element
     */
    org.openprovenance.model.v1_1_a.Role addNewRole();
    
    /**
     * Gets the "cause" element
     */
    org.openprovenance.model.v1_1_a.ProcessRef getCause();
    
    /**
     * Sets the "cause" element
     */
    void setCause(org.openprovenance.model.v1_1_a.ProcessRef cause);
    
    /**
     * Appends and returns a new empty "cause" element
     */
    org.openprovenance.model.v1_1_a.ProcessRef addNewCause();
    
    /**
     * Gets array of all "account" elements
     */
    org.openprovenance.model.v1_1_a.AccountRef[] getAccountArray();
    
    /**
     * Gets ith "account" element
     */
    org.openprovenance.model.v1_1_a.AccountRef getAccountArray(int i);
    
    /**
     * Returns number of "account" element
     */
    int sizeOfAccountArray();
    
    /**
     * Sets array of all "account" element
     */
    void setAccountArray(org.openprovenance.model.v1_1_a.AccountRef[] accountArray);
    
    /**
     * Sets ith "account" element
     */
    void setAccountArray(int i, org.openprovenance.model.v1_1_a.AccountRef account);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "account" element
     */
    org.openprovenance.model.v1_1_a.AccountRef insertNewAccount(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "account" element
     */
    org.openprovenance.model.v1_1_a.AccountRef addNewAccount();
    
    /**
     * Removes the ith "account" element
     */
    void removeAccount(int i);
    
    /**
     * Gets the "time" element
     */
    org.openprovenance.model.v1_1_a.OTime getTime();
    
    /**
     * True if has "time" element
     */
    boolean isSetTime();
    
    /**
     * Sets the "time" element
     */
    void setTime(org.openprovenance.model.v1_1_a.OTime time);
    
    /**
     * Appends and returns a new empty "time" element
     */
    org.openprovenance.model.v1_1_a.OTime addNewTime();
    
    /**
     * Unsets the "time" element
     */
    void unsetTime();
    
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
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy newInstance() {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.WasGeneratedBy parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.WasGeneratedBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
