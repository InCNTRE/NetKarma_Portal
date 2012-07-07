/*
 * XML Type:  findAbstractMethodRequestType
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10;


/**
 * An XML findAbstractMethodRequestType(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public interface FindAbstractMethodRequestType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FindAbstractMethodRequestType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("findabstractmethodrequesttype06b5type");
    
    /**
     * Gets the "returnAll" element
     */
    boolean getReturnAll();
    
    /**
     * Gets (as xml) the "returnAll" element
     */
    org.apache.xmlbeans.XmlBoolean xgetReturnAll();
    
    /**
     * True if has "returnAll" element
     */
    boolean isSetReturnAll();
    
    /**
     * Sets the "returnAll" element
     */
    void setReturnAll(boolean returnAll);
    
    /**
     * Sets (as xml) the "returnAll" element
     */
    void xsetReturnAll(org.apache.xmlbeans.XmlBoolean returnAll);
    
    /**
     * Unsets the "returnAll" element
     */
    void unsetReturnAll();
    
    /**
     * Gets the "serviceIDList" element
     */
    org.dataandsearch.www.karma.query._2010._10.ServiceIDListType getServiceIDList();
    
    /**
     * True if has "serviceIDList" element
     */
    boolean isSetServiceIDList();
    
    /**
     * Sets the "serviceIDList" element
     */
    void setServiceIDList(org.dataandsearch.www.karma.query._2010._10.ServiceIDListType serviceIDList);
    
    /**
     * Appends and returns a new empty "serviceIDList" element
     */
    org.dataandsearch.www.karma.query._2010._10.ServiceIDListType addNewServiceIDList();
    
    /**
     * Unsets the "serviceIDList" element
     */
    void unsetServiceIDList();
    
    /**
     * Gets the "methodNameList" element
     */
    org.dataandsearch.www.karma.query._2010._10.MethodNameListType getMethodNameList();
    
    /**
     * True if has "methodNameList" element
     */
    boolean isSetMethodNameList();
    
    /**
     * Sets the "methodNameList" element
     */
    void setMethodNameList(org.dataandsearch.www.karma.query._2010._10.MethodNameListType methodNameList);
    
    /**
     * Appends and returns a new empty "methodNameList" element
     */
    org.dataandsearch.www.karma.query._2010._10.MethodNameListType addNewMethodNameList();
    
    /**
     * Unsets the "methodNameList" element
     */
    void unsetMethodNameList();
    
    /**
     * Gets the "methodParamsName" element
     */
    java.lang.String getMethodParamsName();
    
    /**
     * Gets (as xml) the "methodParamsName" element
     */
    org.apache.xmlbeans.XmlString xgetMethodParamsName();
    
    /**
     * True if has "methodParamsName" element
     */
    boolean isSetMethodParamsName();
    
    /**
     * Sets the "methodParamsName" element
     */
    void setMethodParamsName(java.lang.String methodParamsName);
    
    /**
     * Sets (as xml) the "methodParamsName" element
     */
    void xsetMethodParamsName(org.apache.xmlbeans.XmlString methodParamsName);
    
    /**
     * Unsets the "methodParamsName" element
     */
    void unsetMethodParamsName();
    
    /**
     * Gets the "annotationList" element
     */
    org.dataandsearch.www.karma.query._2010._10.AnnotationListType getAnnotationList();
    
    /**
     * True if has "annotationList" element
     */
    boolean isSetAnnotationList();
    
    /**
     * Sets the "annotationList" element
     */
    void setAnnotationList(org.dataandsearch.www.karma.query._2010._10.AnnotationListType annotationList);
    
    /**
     * Appends and returns a new empty "annotationList" element
     */
    org.dataandsearch.www.karma.query._2010._10.AnnotationListType addNewAnnotationList();
    
    /**
     * Unsets the "annotationList" element
     */
    void unsetAnnotationList();
    
    /**
     * Gets the "isInputOfDataProductID" element
     */
    java.lang.String getIsInputOfDataProductID();
    
    /**
     * Gets (as xml) the "isInputOfDataProductID" element
     */
    org.apache.xmlbeans.XmlString xgetIsInputOfDataProductID();
    
    /**
     * True if has "isInputOfDataProductID" element
     */
    boolean isSetIsInputOfDataProductID();
    
    /**
     * Sets the "isInputOfDataProductID" element
     */
    void setIsInputOfDataProductID(java.lang.String isInputOfDataProductID);
    
    /**
     * Sets (as xml) the "isInputOfDataProductID" element
     */
    void xsetIsInputOfDataProductID(org.apache.xmlbeans.XmlString isInputOfDataProductID);
    
    /**
     * Unsets the "isInputOfDataProductID" element
     */
    void unsetIsInputOfDataProductID();
    
    /**
     * Gets the "isOutputOfDataProductID" element
     */
    java.lang.String getIsOutputOfDataProductID();
    
    /**
     * Gets (as xml) the "isOutputOfDataProductID" element
     */
    org.apache.xmlbeans.XmlString xgetIsOutputOfDataProductID();
    
    /**
     * True if has "isOutputOfDataProductID" element
     */
    boolean isSetIsOutputOfDataProductID();
    
    /**
     * Sets the "isOutputOfDataProductID" element
     */
    void setIsOutputOfDataProductID(java.lang.String isOutputOfDataProductID);
    
    /**
     * Sets (as xml) the "isOutputOfDataProductID" element
     */
    void xsetIsOutputOfDataProductID(org.apache.xmlbeans.XmlString isOutputOfDataProductID);
    
    /**
     * Unsets the "isOutputOfDataProductID" element
     */
    void unsetIsOutputOfDataProductID();
    
    /**
     * Gets the "hasInstanceOfMethod" element
     */
    java.lang.String getHasInstanceOfMethod();
    
    /**
     * Gets (as xml) the "hasInstanceOfMethod" element
     */
    org.apache.xmlbeans.XmlString xgetHasInstanceOfMethod();
    
    /**
     * True if has "hasInstanceOfMethod" element
     */
    boolean isSetHasInstanceOfMethod();
    
    /**
     * Sets the "hasInstanceOfMethod" element
     */
    void setHasInstanceOfMethod(java.lang.String hasInstanceOfMethod);
    
    /**
     * Sets (as xml) the "hasInstanceOfMethod" element
     */
    void xsetHasInstanceOfMethod(org.apache.xmlbeans.XmlString hasInstanceOfMethod);
    
    /**
     * Unsets the "hasInstanceOfMethod" element
     */
    void unsetHasInstanceOfMethod();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType newInstance() {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
