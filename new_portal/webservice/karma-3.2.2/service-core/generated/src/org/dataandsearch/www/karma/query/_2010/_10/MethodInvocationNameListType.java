/*
 * XML Type:  methodInvocationNameListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10;


/**
 * An XML methodInvocationNameListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public interface MethodInvocationNameListType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MethodInvocationNameListType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("methodinvocationnamelisttypecfaetype");
    
    /**
     * Gets array of all "methodInvocationName" elements
     */
    java.lang.String[] getMethodInvocationNameArray();
    
    /**
     * Gets ith "methodInvocationName" element
     */
    java.lang.String getMethodInvocationNameArray(int i);
    
    /**
     * Gets (as xml) array of all "methodInvocationName" elements
     */
    org.apache.xmlbeans.XmlString[] xgetMethodInvocationNameArray();
    
    /**
     * Gets (as xml) ith "methodInvocationName" element
     */
    org.apache.xmlbeans.XmlString xgetMethodInvocationNameArray(int i);
    
    /**
     * Returns number of "methodInvocationName" element
     */
    int sizeOfMethodInvocationNameArray();
    
    /**
     * Sets array of all "methodInvocationName" element
     */
    void setMethodInvocationNameArray(java.lang.String[] methodInvocationNameArray);
    
    /**
     * Sets ith "methodInvocationName" element
     */
    void setMethodInvocationNameArray(int i, java.lang.String methodInvocationName);
    
    /**
     * Sets (as xml) array of all "methodInvocationName" element
     */
    void xsetMethodInvocationNameArray(org.apache.xmlbeans.XmlString[] methodInvocationNameArray);
    
    /**
     * Sets (as xml) ith "methodInvocationName" element
     */
    void xsetMethodInvocationNameArray(int i, org.apache.xmlbeans.XmlString methodInvocationName);
    
    /**
     * Inserts the value as the ith "methodInvocationName" element
     */
    void insertMethodInvocationName(int i, java.lang.String methodInvocationName);
    
    /**
     * Appends the value as the last "methodInvocationName" element
     */
    void addMethodInvocationName(java.lang.String methodInvocationName);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "methodInvocationName" element
     */
    org.apache.xmlbeans.XmlString insertNewMethodInvocationName(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "methodInvocationName" element
     */
    org.apache.xmlbeans.XmlString addNewMethodInvocationName();
    
    /**
     * Removes the ith "methodInvocationName" element
     */
    void removeMethodInvocationName(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType newInstance() {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.MethodInvocationNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
