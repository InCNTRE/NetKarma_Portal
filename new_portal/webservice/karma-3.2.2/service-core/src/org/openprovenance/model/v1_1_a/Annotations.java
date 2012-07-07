/*
 * XML Type:  Annotations
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.Annotations
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a;


/**
 * An XML Annotations(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public interface Annotations extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Annotations.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("annotations7118type");
    
    /**
     * Gets array of all "annotation" elements
     */
    org.openprovenance.model.v1_1_a.Annotation[] getAnnotationArray();
    
    /**
     * Gets ith "annotation" element
     */
    org.openprovenance.model.v1_1_a.Annotation getAnnotationArray(int i);
    
    /**
     * Returns number of "annotation" element
     */
    int sizeOfAnnotationArray();
    
    /**
     * Sets array of all "annotation" element
     */
    void setAnnotationArray(org.openprovenance.model.v1_1_a.Annotation[] annotationArray);
    
    /**
     * Sets ith "annotation" element
     */
    void setAnnotationArray(int i, org.openprovenance.model.v1_1_a.Annotation annotation);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "annotation" element
     */
    org.openprovenance.model.v1_1_a.Annotation insertNewAnnotation(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotation" element
     */
    org.openprovenance.model.v1_1_a.Annotation addNewAnnotation();
    
    /**
     * Removes the ith "annotation" element
     */
    void removeAnnotation(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.openprovenance.model.v1_1_a.Annotations newInstance() {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.Annotations parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.Annotations parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.Annotations parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.Annotations) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
