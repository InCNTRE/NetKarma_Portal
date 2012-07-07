/*
 * XML Type:  dataProductNameListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductNameListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10;


/**
 * An XML dataProductNameListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public interface DataProductNameListType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DataProductNameListType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("dataproductnamelisttypeb350type");
    
    /**
     * Gets array of all "dataProductName" elements
     */
    java.lang.String[] getDataProductNameArray();
    
    /**
     * Gets ith "dataProductName" element
     */
    java.lang.String getDataProductNameArray(int i);
    
    /**
     * Gets (as xml) array of all "dataProductName" elements
     */
    org.apache.xmlbeans.XmlString[] xgetDataProductNameArray();
    
    /**
     * Gets (as xml) ith "dataProductName" element
     */
    org.apache.xmlbeans.XmlString xgetDataProductNameArray(int i);
    
    /**
     * Returns number of "dataProductName" element
     */
    int sizeOfDataProductNameArray();
    
    /**
     * Sets array of all "dataProductName" element
     */
    void setDataProductNameArray(java.lang.String[] dataProductNameArray);
    
    /**
     * Sets ith "dataProductName" element
     */
    void setDataProductNameArray(int i, java.lang.String dataProductName);
    
    /**
     * Sets (as xml) array of all "dataProductName" element
     */
    void xsetDataProductNameArray(org.apache.xmlbeans.XmlString[] dataProductNameArray);
    
    /**
     * Sets (as xml) ith "dataProductName" element
     */
    void xsetDataProductNameArray(int i, org.apache.xmlbeans.XmlString dataProductName);
    
    /**
     * Inserts the value as the ith "dataProductName" element
     */
    void insertDataProductName(int i, java.lang.String dataProductName);
    
    /**
     * Appends the value as the last "dataProductName" element
     */
    void addDataProductName(java.lang.String dataProductName);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "dataProductName" element
     */
    org.apache.xmlbeans.XmlString insertNewDataProductName(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "dataProductName" element
     */
    org.apache.xmlbeans.XmlString addNewDataProductName();
    
    /**
     * Removes the ith "dataProductName" element
     */
    void removeDataProductName(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType newInstance() {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductNameListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductNameListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
