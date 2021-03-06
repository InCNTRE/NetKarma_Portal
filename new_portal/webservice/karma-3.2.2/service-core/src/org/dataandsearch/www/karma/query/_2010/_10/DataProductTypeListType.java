/*
 * XML Type:  dataProductTypeListType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10;


/**
 * An XML dataProductTypeListType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public interface DataProductTypeListType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DataProductTypeListType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("dataproducttypelisttypebf3ftype");
    
    /**
     * Gets array of all "dataProductType" elements
     */
    org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum[] getDataProductTypeArray();
    
    /**
     * Gets ith "dataProductType" element
     */
    org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum getDataProductTypeArray(int i);
    
    /**
     * Gets (as xml) array of all "dataProductType" elements
     */
    org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType[] xgetDataProductTypeArray();
    
    /**
     * Gets (as xml) ith "dataProductType" element
     */
    org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType xgetDataProductTypeArray(int i);
    
    /**
     * Returns number of "dataProductType" element
     */
    int sizeOfDataProductTypeArray();
    
    /**
     * Sets array of all "dataProductType" element
     */
    void setDataProductTypeArray(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum[] dataProductTypeArray);
    
    /**
     * Sets ith "dataProductType" element
     */
    void setDataProductTypeArray(int i, org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum dataProductType);
    
    /**
     * Sets (as xml) array of all "dataProductType" element
     */
    void xsetDataProductTypeArray(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType[] dataProductTypeArray);
    
    /**
     * Sets (as xml) ith "dataProductType" element
     */
    void xsetDataProductTypeArray(int i, org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType dataProductType);
    
    /**
     * Inserts the value as the ith "dataProductType" element
     */
    void insertDataProductType(int i, org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum dataProductType);
    
    /**
     * Appends the value as the last "dataProductType" element
     */
    void addDataProductType(org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum dataProductType);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "dataProductType" element
     */
    org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType insertNewDataProductType(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "dataProductType" element
     */
    org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType addNewDataProductType();
    
    /**
     * Removes the ith "dataProductType" element
     */
    void removeDataProductType(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType newInstance() {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
