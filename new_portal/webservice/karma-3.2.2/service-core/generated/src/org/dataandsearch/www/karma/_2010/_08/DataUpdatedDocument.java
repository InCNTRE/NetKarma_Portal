/*
 * An XML document type.
 * Localname: dataUpdated
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataUpdatedDocument
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08;


/**
 * A document containing one dataUpdated(@http://www.dataandsearch.org/karma/2010/08/) element.
 *
 * This is a complex type.
 */
public interface DataUpdatedDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DataUpdatedDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("dataupdated5ad9doctype");
    
    /**
     * Gets the "dataUpdated" element
     */
    org.dataandsearch.www.karma._2010._08.DataLifeCycleType getDataUpdated();
    
    /**
     * Sets the "dataUpdated" element
     */
    void setDataUpdated(org.dataandsearch.www.karma._2010._08.DataLifeCycleType dataUpdated);
    
    /**
     * Appends and returns a new empty "dataUpdated" element
     */
    org.dataandsearch.www.karma._2010._08.DataLifeCycleType addNewDataUpdated();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument newInstance() {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.DataUpdatedDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.DataUpdatedDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
