/*
 * XML Type:  entityEnumSubtype
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.EntityEnumSubtype
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08;


/**
 * An XML entityEnumSubtype(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is an atomic type that is a restriction of org.dataandsearch.www.karma._2010._08.EntityEnumSubtype.
 */
public interface EntityEnumSubtype extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EntityEnumSubtype.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("entityenumsubtypee1cetype");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum CONTROLLER = Enum.forString("CONTROLLER");
    static final Enum HUMAN_PROXY = Enum.forString("HUMAN_PROXY");
    
    static final int INT_CONTROLLER = Enum.INT_CONTROLLER;
    static final int INT_HUMAN_PROXY = Enum.INT_HUMAN_PROXY;
    
    /**
     * Enumeration value class for org.dataandsearch.www.karma._2010._08.EntityEnumSubtype.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_CONTROLLER
     * Enum.forString(s); // returns the enum value for a string
     * Enum.forInt(i); // returns the enum value for an int
     * </pre>
     * Enumeration objects are immutable singleton objects that
     * can be compared using == object equality. They have no
     * public constructor. See the constants defined within this
     * class for all the valid values.
     */
    static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
    {
        /**
         * Returns the enum value for a string, or null if none.
         */
        public static Enum forString(java.lang.String s)
            { return (Enum)table.forString(s); }
        /**
         * Returns the enum value corresponding to an int, or null if none.
         */
        public static Enum forInt(int i)
            { return (Enum)table.forInt(i); }
        
        private Enum(java.lang.String s, int i)
            { super(s, i); }
        
        static final int INT_CONTROLLER = 1;
        static final int INT_HUMAN_PROXY = 2;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("CONTROLLER", INT_CONTROLLER),
                new Enum("HUMAN_PROXY", INT_HUMAN_PROXY),
            }
        );
        private static final long serialVersionUID = 1L;
        private java.lang.Object readResolve() { return forInt(intValue()); } 
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype newValue(java.lang.Object obj) {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) type.newValue( obj ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype newInstance() {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma._2010._08.EntityEnumSubtype parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
