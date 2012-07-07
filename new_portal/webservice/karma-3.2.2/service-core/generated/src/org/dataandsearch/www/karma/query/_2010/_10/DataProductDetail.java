/*
 * XML Type:  dataProductDetail
 * Namespace: http://www.dataandsearch.org/karma/query/2010/10/
 * Java type: org.dataandsearch.www.karma.query._2010._10.DataProductDetail
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma.query._2010._10;


/**
 * An XML dataProductDetail(@http://www.dataandsearch.org/karma/query/2010/10/).
 *
 * This is a complex type.
 */
public interface DataProductDetail extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DataProductDetail.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("dataproductdetaild87etype");
    
    /**
     * Gets the "fileURI" element
     */
    java.lang.String getFileURI();
    
    /**
     * Gets (as xml) the "fileURI" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetFileURI();
    
    /**
     * True if has "fileURI" element
     */
    boolean isSetFileURI();
    
    /**
     * Sets the "fileURI" element
     */
    void setFileURI(java.lang.String fileURI);
    
    /**
     * Sets (as xml) the "fileURI" element
     */
    void xsetFileURI(org.apache.xmlbeans.XmlAnyURI fileURI);
    
    /**
     * Unsets the "fileURI" element
     */
    void unsetFileURI();
    
    /**
     * Gets the "owner" element
     */
    java.lang.String getOwner();
    
    /**
     * Gets (as xml) the "owner" element
     */
    org.apache.xmlbeans.XmlString xgetOwner();
    
    /**
     * True if has "owner" element
     */
    boolean isSetOwner();
    
    /**
     * Sets the "owner" element
     */
    void setOwner(java.lang.String owner);
    
    /**
     * Sets (as xml) the "owner" element
     */
    void xsetOwner(org.apache.xmlbeans.XmlString owner);
    
    /**
     * Unsets the "owner" element
     */
    void unsetOwner();
    
    /**
     * Gets the "creationDate" element
     */
    java.util.Calendar getCreationDate();
    
    /**
     * Gets (as xml) the "creationDate" element
     */
    org.apache.xmlbeans.XmlDateTime xgetCreationDate();
    
    /**
     * True if has "creationDate" element
     */
    boolean isSetCreationDate();
    
    /**
     * Sets the "creationDate" element
     */
    void setCreationDate(java.util.Calendar creationDate);
    
    /**
     * Sets (as xml) the "creationDate" element
     */
    void xsetCreationDate(org.apache.xmlbeans.XmlDateTime creationDate);
    
    /**
     * Unsets the "creationDate" element
     */
    void unsetCreationDate();
    
    /**
     * Gets the "size" element
     */
    long getSize();
    
    /**
     * Gets (as xml) the "size" element
     */
    org.apache.xmlbeans.XmlLong xgetSize();
    
    /**
     * True if has "size" element
     */
    boolean isSetSize();
    
    /**
     * Sets the "size" element
     */
    void setSize(long size);
    
    /**
     * Sets (as xml) the "size" element
     */
    void xsetSize(org.apache.xmlbeans.XmlLong size);
    
    /**
     * Unsets the "size" element
     */
    void unsetSize();
    
    /**
     * Gets the "md5" element
     */
    java.lang.String getMd5();
    
    /**
     * Gets (as xml) the "md5" element
     */
    org.apache.xmlbeans.XmlString xgetMd5();
    
    /**
     * True if has "md5" element
     */
    boolean isSetMd5();
    
    /**
     * Sets the "md5" element
     */
    void setMd5(java.lang.String md5);
    
    /**
     * Sets (as xml) the "md5" element
     */
    void xsetMd5(org.apache.xmlbeans.XmlString md5);
    
    /**
     * Unsets the "md5" element
     */
    void unsetMd5();
    
    /**
     * Gets the "fileName" element
     */
    java.lang.String getFileName();
    
    /**
     * Gets (as xml) the "fileName" element
     */
    org.apache.xmlbeans.XmlString xgetFileName();
    
    /**
     * True if has "fileName" element
     */
    boolean isSetFileName();
    
    /**
     * Sets the "fileName" element
     */
    void setFileName(java.lang.String fileName);
    
    /**
     * Sets (as xml) the "fileName" element
     */
    void xsetFileName(org.apache.xmlbeans.XmlString fileName);
    
    /**
     * Unsets the "fileName" element
     */
    void unsetFileName();
    
    /**
     * Gets the "blockContent" element
     */
    java.lang.String getBlockContent();
    
    /**
     * Gets (as xml) the "blockContent" element
     */
    org.apache.xmlbeans.XmlString xgetBlockContent();
    
    /**
     * True if has "blockContent" element
     */
    boolean isSetBlockContent();
    
    /**
     * Sets the "blockContent" element
     */
    void setBlockContent(java.lang.String blockContent);
    
    /**
     * Sets (as xml) the "blockContent" element
     */
    void xsetBlockContent(org.apache.xmlbeans.XmlString blockContent);
    
    /**
     * Unsets the "blockContent" element
     */
    void unsetBlockContent();
    
    /**
     * Gets the "collectionURI" element
     */
    java.lang.String getCollectionURI();
    
    /**
     * Gets (as xml) the "collectionURI" element
     */
    org.apache.xmlbeans.XmlString xgetCollectionURI();
    
    /**
     * True if has "collectionURI" element
     */
    boolean isSetCollectionURI();
    
    /**
     * Sets the "collectionURI" element
     */
    void setCollectionURI(java.lang.String collectionURI);
    
    /**
     * Sets (as xml) the "collectionURI" element
     */
    void xsetCollectionURI(org.apache.xmlbeans.XmlString collectionURI);
    
    /**
     * Unsets the "collectionURI" element
     */
    void unsetCollectionURI();
    
    /**
     * Gets array of all "membership" elements
     */
    org.dataandsearch.www.karma.query._2010._10.MembershipDetail[] getMembershipArray();
    
    /**
     * Gets ith "membership" element
     */
    org.dataandsearch.www.karma.query._2010._10.MembershipDetail getMembershipArray(int i);
    
    /**
     * Returns number of "membership" element
     */
    int sizeOfMembershipArray();
    
    /**
     * Sets array of all "membership" element
     */
    void setMembershipArray(org.dataandsearch.www.karma.query._2010._10.MembershipDetail[] membershipArray);
    
    /**
     * Sets ith "membership" element
     */
    void setMembershipArray(int i, org.dataandsearch.www.karma.query._2010._10.MembershipDetail membership);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "membership" element
     */
    org.dataandsearch.www.karma.query._2010._10.MembershipDetail insertNewMembership(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "membership" element
     */
    org.dataandsearch.www.karma.query._2010._10.MembershipDetail addNewMembership();
    
    /**
     * Removes the ith "membership" element
     */
    void removeMembership(int i);
    
    /**
     * Gets the "id" attribute
     */
    java.lang.String getId();
    
    /**
     * Gets (as xml) the "id" attribute
     */
    org.apache.xmlbeans.XmlString xgetId();
    
    /**
     * Sets the "id" attribute
     */
    void setId(java.lang.String id);
    
    /**
     * Sets (as xml) the "id" attribute
     */
    void xsetId(org.apache.xmlbeans.XmlString id);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail newInstance() {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.dataandsearch.www.karma.query._2010._10.DataProductDetail parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.dataandsearch.www.karma.query._2010._10.DataProductDetail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
