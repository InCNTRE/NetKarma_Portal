/*
 * XML Type:  getProvenanceHistoryRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10;


/**
 * An XML getProvenanceHistoryRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public interface GetProvenanceHistoryRequestType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetProvenanceHistoryRequestType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("getprovenancehistoryrequesttypeb7d4type");
    
    /**
     * Gets the "artifactID" element
     */
    java.lang.String getArtifactID();
    
    /**
     * Gets (as xml) the "artifactID" element
     */
    org.apache.xmlbeans.XmlString xgetArtifactID();
    
    /**
     * Sets the "artifactID" element
     */
    void setArtifactID(java.lang.String artifactID);
    
    /**
     * Sets (as xml) the "artifactID" element
     */
    void xsetArtifactID(org.apache.xmlbeans.XmlString artifactID);
    
    /**
     * Gets the "timeRange" element
     */
    long getTimeRange();
    
    /**
     * Gets (as xml) the "timeRange" element
     */
    org.apache.xmlbeans.XmlLong xgetTimeRange();
    
    /**
     * True if has "timeRange" element
     */
    boolean isSetTimeRange();
    
    /**
     * Sets the "timeRange" element
     */
    void setTimeRange(long timeRange);
    
    /**
     * Sets (as xml) the "timeRange" element
     */
    void xsetTimeRange(org.apache.xmlbeans.XmlLong timeRange);
    
    /**
     * Unsets the "timeRange" element
     */
    void unsetTimeRange();
    
    /**
     * Gets the "informationDetailLevel" element
     */
    org.dataandsearch.www.karma.query._2010._10.DetailEnumType.Enum getInformationDetailLevel();
    
    /**
     * Gets (as xml) the "informationDetailLevel" element
     */
    org.dataandsearch.www.karma.query._2010._10.DetailEnumType xgetInformationDetailLevel();
    
    /**
     * True if has "informationDetailLevel" element
     */
    boolean isSetInformationDetailLevel();
    
    /**
     * Sets the "informationDetailLevel" element
     */
    void setInformationDetailLevel(org.dataandsearch.www.karma.query._2010._10.DetailEnumType.Enum informationDetailLevel);
    
    /**
     * Sets (as xml) the "informationDetailLevel" element
     */
    void xsetInformationDetailLevel(org.dataandsearch.www.karma.query._2010._10.DetailEnumType informationDetailLevel);
    
    /**
     * Unsets the "informationDetailLevel" element
     */
    void unsetInformationDetailLevel();
    
    /**
     * Gets the "format" element
     */
    org.dataandsearch.www.karma.query._2010._10.FormatEnumType.Enum getFormat();
    
    /**
     * Gets (as xml) the "format" element
     */
    org.dataandsearch.www.karma.query._2010._10.FormatEnumType xgetFormat();
    
    /**
     * Sets the "format" element
     */
    void setFormat(org.dataandsearch.www.karma.query._2010._10.FormatEnumType.Enum format);
    
    /**
     * Sets (as xml) the "format" element
     */
    void xsetFormat(org.dataandsearch.www.karma.query._2010._10.FormatEnumType format);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType newInstance() {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
