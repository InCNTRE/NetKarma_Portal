/*
 * XML Type:  addAnnotationByIdType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08;


/**
 * An XML addAnnotationByIdType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public interface AddAnnotationByIdType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddAnnotationByIdType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("addannotationbyidtypeccf4type");
    
    /**
     * Gets the "objectID" element
     */
    long getObjectID();
    
    /**
     * Gets (as xml) the "objectID" element
     */
    org.apache.xmlbeans.XmlLong xgetObjectID();
    
    /**
     * Sets the "objectID" element
     */
    void setObjectID(long objectID);
    
    /**
     * Sets (as xml) the "objectID" element
     */
    void xsetObjectID(org.apache.xmlbeans.XmlLong objectID);
    
    /**
     * Gets the "annotableObjectType" element
     */
    org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType.Enum getAnnotableObjectType();
    
    /**
     * Gets (as xml) the "annotableObjectType" element
     */
    org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType xgetAnnotableObjectType();
    
    /**
     * Sets the "annotableObjectType" element
     */
    void setAnnotableObjectType(org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType.Enum annotableObjectType);
    
    /**
     * Sets (as xml) the "annotableObjectType" element
     */
    void xsetAnnotableObjectType(org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType annotableObjectType);
    
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
     * Gets the "annotatingTimestamp" element
     */
    java.util.Calendar getAnnotatingTimestamp();
    
    /**
     * Gets (as xml) the "annotatingTimestamp" element
     */
    org.apache.xmlbeans.XmlDateTime xgetAnnotatingTimestamp();
    
    /**
     * True if has "annotatingTimestamp" element
     */
    boolean isSetAnnotatingTimestamp();
    
    /**
     * Sets the "annotatingTimestamp" element
     */
    void setAnnotatingTimestamp(java.util.Calendar annotatingTimestamp);
    
    /**
     * Sets (as xml) the "annotatingTimestamp" element
     */
    void xsetAnnotatingTimestamp(org.apache.xmlbeans.XmlDateTime annotatingTimestamp);
    
    /**
     * Unsets the "annotatingTimestamp" element
     */
    void unsetAnnotatingTimestamp();
    
    /**
     * Gets the "notificationtimestamp" element
     */
    java.util.Calendar getNotificationtimestamp();
    
    /**
     * Gets (as xml) the "notificationtimestamp" element
     */
    org.apache.xmlbeans.XmlDateTime xgetNotificationtimestamp();
    
    /**
     * Sets the "notificationtimestamp" element
     */
    void setNotificationtimestamp(java.util.Calendar notificationtimestamp);
    
    /**
     * Sets (as xml) the "notificationtimestamp" element
     */
    void xsetNotificationtimestamp(org.apache.xmlbeans.XmlDateTime notificationtimestamp);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType newInstance() {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
