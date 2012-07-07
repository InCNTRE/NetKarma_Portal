/*
 * XML Type:  dataTransferType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.DataTransferType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08;


/**
 * An XML dataTransferType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public interface DataTransferType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DataTransferType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("datatransfertype2e39type");
    
    /**
     * Gets the "sender" element
     */
    org.dataandsearch.www.karma._2010._08.EntityType getSender();
    
    /**
     * Sets the "sender" element
     */
    void setSender(org.dataandsearch.www.karma._2010._08.EntityType sender);
    
    /**
     * Appends and returns a new empty "sender" element
     */
    org.dataandsearch.www.karma._2010._08.EntityType addNewSender();
    
    /**
     * Gets the "receiver" element
     */
    org.dataandsearch.www.karma._2010._08.EntityType getReceiver();
    
    /**
     * Sets the "receiver" element
     */
    void setReceiver(org.dataandsearch.www.karma._2010._08.EntityType receiver);
    
    /**
     * Appends and returns a new empty "receiver" element
     */
    org.dataandsearch.www.karma._2010._08.EntityType addNewReceiver();
    
    /**
     * Gets the "transferTime" element
     */
    java.util.Calendar getTransferTime();
    
    /**
     * Gets (as xml) the "transferTime" element
     */
    org.apache.xmlbeans.XmlDateTime xgetTransferTime();
    
    /**
     * Sets the "transferTime" element
     */
    void setTransferTime(java.util.Calendar transferTime);
    
    /**
     * Sets (as xml) the "transferTime" element
     */
    void xsetTransferTime(org.apache.xmlbeans.XmlDateTime transferTime);
    
    /**
     * Gets the "fault" element
     */
    org.dataandsearch.www.karma._2010._08.DataObjectType getFault();
    
    /**
     * True if has "fault" element
     */
    boolean isSetFault();
    
    /**
     * Sets the "fault" element
     */
    void setFault(org.dataandsearch.www.karma._2010._08.DataObjectType fault);
    
    /**
     * Appends and returns a new empty "fault" element
     */
    org.dataandsearch.www.karma._2010._08.DataObjectType addNewFault();
    
    /**
     * Unsets the "fault" element
     */
    void unsetFault();
    
    /**
     * Gets the "result" element
     */
    org.dataandsearch.www.karma._2010._08.DataObjectType getResult();
    
    /**
     * True if has "result" element
     */
    boolean isSetResult();
    
    /**
     * Sets the "result" element
     */
    void setResult(org.dataandsearch.www.karma._2010._08.DataObjectType result);
    
    /**
     * Appends and returns a new empty "result" element
     */
    org.dataandsearch.www.karma._2010._08.DataObjectType addNewResult();
    
    /**
     * Unsets the "result" element
     */
    void unsetResult();
    
    /**
     * Gets array of all "annotations" elements
     */
    org.dataandsearch.www.karma._2010._08.AnnotationType[] getAnnotationsArray();
    
    /**
     * Gets ith "annotations" element
     */
    org.dataandsearch.www.karma._2010._08.AnnotationType getAnnotationsArray(int i);
    
    /**
     * Returns number of "annotations" element
     */
    int sizeOfAnnotationsArray();
    
    /**
     * Sets array of all "annotations" element
     */
    void setAnnotationsArray(org.dataandsearch.www.karma._2010._08.AnnotationType[] annotationsArray);
    
    /**
     * Sets ith "annotations" element
     */
    void setAnnotationsArray(int i, org.dataandsearch.www.karma._2010._08.AnnotationType annotations);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "annotations" element
     */
    org.dataandsearch.www.karma._2010._08.AnnotationType insertNewAnnotations(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotations" element
     */
    org.dataandsearch.www.karma._2010._08.AnnotationType addNewAnnotations();
    
    /**
     * Removes the ith "annotations" element
     */
    void removeAnnotations(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma._2010._08.DataTransferType newInstance() {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.DataTransferType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.DataTransferType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
