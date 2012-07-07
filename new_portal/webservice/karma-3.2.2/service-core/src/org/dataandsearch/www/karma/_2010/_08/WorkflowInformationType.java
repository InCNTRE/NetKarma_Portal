/*
 * XML Type:  workflowInformationType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.WorkflowInformationType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08;


/**
 * An XML workflowInformationType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public interface WorkflowInformationType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(WorkflowInformationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("workflowinformationtypebe7ftype");
    
    /**
     * Gets the "workflowID" element
     */
    java.lang.String getWorkflowID();
    
    /**
     * Gets (as xml) the "workflowID" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetWorkflowID();
    
    /**
     * Sets the "workflowID" element
     */
    void setWorkflowID(java.lang.String workflowID);
    
    /**
     * Sets (as xml) the "workflowID" element
     */
    void xsetWorkflowID(org.apache.xmlbeans.XmlAnyURI workflowID);
    
    /**
     * Gets the "workflowNodeID" element
     */
    java.lang.String getWorkflowNodeID();
    
    /**
     * Gets (as xml) the "workflowNodeID" element
     */
    org.apache.xmlbeans.XmlString xgetWorkflowNodeID();
    
    /**
     * True if has "workflowNodeID" element
     */
    boolean isSetWorkflowNodeID();
    
    /**
     * Sets the "workflowNodeID" element
     */
    void setWorkflowNodeID(java.lang.String workflowNodeID);
    
    /**
     * Sets (as xml) the "workflowNodeID" element
     */
    void xsetWorkflowNodeID(org.apache.xmlbeans.XmlString workflowNodeID);
    
    /**
     * Unsets the "workflowNodeID" element
     */
    void unsetWorkflowNodeID();
    
    /**
     * Gets the "timestep" element
     */
    int getTimestep();
    
    /**
     * Gets (as xml) the "timestep" element
     */
    org.apache.xmlbeans.XmlInt xgetTimestep();
    
    /**
     * True if has "timestep" element
     */
    boolean isSetTimestep();
    
    /**
     * Sets the "timestep" element
     */
    void setTimestep(int timestep);
    
    /**
     * Sets (as xml) the "timestep" element
     */
    void xsetTimestep(org.apache.xmlbeans.XmlInt timestep);
    
    /**
     * Unsets the "timestep" element
     */
    void unsetTimestep();
    
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
     * Gets the "userBehalf" element
     */
    org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf getUserBehalf();
    
    /**
     * True if has "userBehalf" element
     */
    boolean isSetUserBehalf();
    
    /**
     * Sets the "userBehalf" element
     */
    void setUserBehalf(org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf userBehalf);
    
    /**
     * Appends and returns a new empty "userBehalf" element
     */
    org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf addNewUserBehalf();
    
    /**
     * Unsets the "userBehalf" element
     */
    void unsetUserBehalf();
    
    /**
     * Gets the "instanceOf" element
     */
    org.dataandsearch.www.karma._2010._08.InstanceOfType getInstanceOf();
    
    /**
     * True if has "instanceOf" element
     */
    boolean isSetInstanceOf();
    
    /**
     * Sets the "instanceOf" element
     */
    void setInstanceOf(org.dataandsearch.www.karma._2010._08.InstanceOfType xinstanceOf);
    
    /**
     * Appends and returns a new empty "instanceOf" element
     */
    org.dataandsearch.www.karma._2010._08.InstanceOfType addNewInstanceOf();
    
    /**
     * Unsets the "instanceOf" element
     */
    void unsetInstanceOf();
    
    /**
     * An XML userBehalf(@http://www.dataandsearch.org/karma/2010/08/).
     *
     * This is a complex type.
     */
    public interface UserBehalf extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(UserBehalf.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("userbehalf65fcelemtype");
        
        /**
         * Gets the "userDN" element
         */
        java.lang.String getUserDN();
        
        /**
         * Gets (as xml) the "userDN" element
         */
        org.apache.xmlbeans.XmlString xgetUserDN();
        
        /**
         * Sets the "userDN" element
         */
        void setUserDN(java.lang.String userDN);
        
        /**
         * Sets (as xml) the "userDN" element
         */
        void xsetUserDN(org.apache.xmlbeans.XmlString userDN);
        
        /**
         * Gets the "authorship" element
         */
        org.dataandsearch.www.karma._2010._08.AuthorshipEnumType.Enum getAuthorship();
        
        /**
         * Gets (as xml) the "authorship" element
         */
        org.dataandsearch.www.karma._2010._08.AuthorshipEnumType xgetAuthorship();
        
        /**
         * True if has "authorship" element
         */
        boolean isSetAuthorship();
        
        /**
         * Sets the "authorship" element
         */
        void setAuthorship(org.dataandsearch.www.karma._2010._08.AuthorshipEnumType.Enum authorship);
        
        /**
         * Sets (as xml) the "authorship" element
         */
        void xsetAuthorship(org.dataandsearch.www.karma._2010._08.AuthorshipEnumType authorship);
        
        /**
         * Unsets the "authorship" element
         */
        void unsetAuthorship();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf newInstance() {
              return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType newInstance() {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.WorkflowInformationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.WorkflowInformationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
