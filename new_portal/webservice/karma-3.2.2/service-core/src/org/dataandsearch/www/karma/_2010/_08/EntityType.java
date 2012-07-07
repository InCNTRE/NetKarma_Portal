/*
 * XML Type:  entityType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.EntityType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08;


/**
 * An XML entityType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public interface EntityType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EntityType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("entitytype9f27type");
    
    /**
     * Gets the "userInformation" element
     */
    org.dataandsearch.www.karma._2010._08.UserInformationType getUserInformation();
    
    /**
     * True if has "userInformation" element
     */
    boolean isSetUserInformation();
    
    /**
     * Sets the "userInformation" element
     */
    void setUserInformation(org.dataandsearch.www.karma._2010._08.UserInformationType userInformation);
    
    /**
     * Appends and returns a new empty "userInformation" element
     */
    org.dataandsearch.www.karma._2010._08.UserInformationType addNewUserInformation();
    
    /**
     * Unsets the "userInformation" element
     */
    void unsetUserInformation();
    
    /**
     * Gets the "workflowInformation" element
     */
    org.dataandsearch.www.karma._2010._08.WorkflowInformationType getWorkflowInformation();
    
    /**
     * True if has "workflowInformation" element
     */
    boolean isSetWorkflowInformation();
    
    /**
     * Sets the "workflowInformation" element
     */
    void setWorkflowInformation(org.dataandsearch.www.karma._2010._08.WorkflowInformationType workflowInformation);
    
    /**
     * Appends and returns a new empty "workflowInformation" element
     */
    org.dataandsearch.www.karma._2010._08.WorkflowInformationType addNewWorkflowInformation();
    
    /**
     * Unsets the "workflowInformation" element
     */
    void unsetWorkflowInformation();
    
    /**
     * Gets the "serviceInformation" element
     */
    org.dataandsearch.www.karma._2010._08.ServiceInformationType getServiceInformation();
    
    /**
     * True if has "serviceInformation" element
     */
    boolean isSetServiceInformation();
    
    /**
     * Sets the "serviceInformation" element
     */
    void setServiceInformation(org.dataandsearch.www.karma._2010._08.ServiceInformationType serviceInformation);
    
    /**
     * Appends and returns a new empty "serviceInformation" element
     */
    org.dataandsearch.www.karma._2010._08.ServiceInformationType addNewServiceInformation();
    
    /**
     * Unsets the "serviceInformation" element
     */
    void unsetServiceInformation();
    
    /**
     * Gets the "methodInformation" element
     */
    org.dataandsearch.www.karma._2010._08.MethodInformationType getMethodInformation();
    
    /**
     * True if has "methodInformation" element
     */
    boolean isSetMethodInformation();
    
    /**
     * Sets the "methodInformation" element
     */
    void setMethodInformation(org.dataandsearch.www.karma._2010._08.MethodInformationType methodInformation);
    
    /**
     * Appends and returns a new empty "methodInformation" element
     */
    org.dataandsearch.www.karma._2010._08.MethodInformationType addNewMethodInformation();
    
    /**
     * Unsets the "methodInformation" element
     */
    void unsetMethodInformation();
    
    /**
     * Gets the "type" element
     */
    org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum getType();
    
    /**
     * Gets (as xml) the "type" element
     */
    org.dataandsearch.www.karma._2010._08.EntityEnumType xgetType();
    
    /**
     * Sets the "type" element
     */
    void setType(org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum type);
    
    /**
     * Sets (as xml) the "type" element
     */
    void xsetType(org.dataandsearch.www.karma._2010._08.EntityEnumType type);
    
    /**
     * Gets the "subtype" element
     */
    org.dataandsearch.www.karma._2010._08.EntityEnumSubtype.Enum getSubtype();
    
    /**
     * Gets (as xml) the "subtype" element
     */
    org.dataandsearch.www.karma._2010._08.EntityEnumSubtype xgetSubtype();
    
    /**
     * True if has "subtype" element
     */
    boolean isSetSubtype();
    
    /**
     * Sets the "subtype" element
     */
    void setSubtype(org.dataandsearch.www.karma._2010._08.EntityEnumSubtype.Enum subtype);
    
    /**
     * Sets (as xml) the "subtype" element
     */
    void xsetSubtype(org.dataandsearch.www.karma._2010._08.EntityEnumSubtype subtype);
    
    /**
     * Unsets the "subtype" element
     */
    void unsetSubtype();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma._2010._08.EntityType newInstance() {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.EntityType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.EntityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
