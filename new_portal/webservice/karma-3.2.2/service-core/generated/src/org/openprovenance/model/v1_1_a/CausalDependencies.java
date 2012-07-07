/*
 * XML Type:  CausalDependencies
 * Namespace: http://openprovenance.org/model/v1.1.a
 * Java type: org.openprovenance.model.v1_1_a.CausalDependencies
 *
 * Automatically generated - do not modify.
 */
package org.openprovenance.model.v1_1_a;


/**
 * An XML CausalDependencies(@http://openprovenance.org/model/v1.1.a).
 *
 * This is a complex type.
 */
public interface CausalDependencies extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CausalDependencies.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE9D4A70CB02FB1E7560EB21BF61BE7E4").resolveHandle("causaldependencies5e9atype");
    
    /**
     * Gets array of all "used" elements
     */
    org.openprovenance.model.v1_1_a.Used[] getUsedArray();
    
    /**
     * Gets ith "used" element
     */
    org.openprovenance.model.v1_1_a.Used getUsedArray(int i);
    
    /**
     * Returns number of "used" element
     */
    int sizeOfUsedArray();
    
    /**
     * Sets array of all "used" element
     */
    void setUsedArray(org.openprovenance.model.v1_1_a.Used[] usedArray);
    
    /**
     * Sets ith "used" element
     */
    void setUsedArray(int i, org.openprovenance.model.v1_1_a.Used used);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "used" element
     */
    org.openprovenance.model.v1_1_a.Used insertNewUsed(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "used" element
     */
    org.openprovenance.model.v1_1_a.Used addNewUsed();
    
    /**
     * Removes the ith "used" element
     */
    void removeUsed(int i);
    
    /**
     * Gets array of all "wasGeneratedBy" elements
     */
    org.openprovenance.model.v1_1_a.WasGeneratedBy[] getWasGeneratedByArray();
    
    /**
     * Gets ith "wasGeneratedBy" element
     */
    org.openprovenance.model.v1_1_a.WasGeneratedBy getWasGeneratedByArray(int i);
    
    /**
     * Returns number of "wasGeneratedBy" element
     */
    int sizeOfWasGeneratedByArray();
    
    /**
     * Sets array of all "wasGeneratedBy" element
     */
    void setWasGeneratedByArray(org.openprovenance.model.v1_1_a.WasGeneratedBy[] wasGeneratedByArray);
    
    /**
     * Sets ith "wasGeneratedBy" element
     */
    void setWasGeneratedByArray(int i, org.openprovenance.model.v1_1_a.WasGeneratedBy wasGeneratedBy);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasGeneratedBy" element
     */
    org.openprovenance.model.v1_1_a.WasGeneratedBy insertNewWasGeneratedBy(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasGeneratedBy" element
     */
    org.openprovenance.model.v1_1_a.WasGeneratedBy addNewWasGeneratedBy();
    
    /**
     * Removes the ith "wasGeneratedBy" element
     */
    void removeWasGeneratedBy(int i);
    
    /**
     * Gets array of all "wasTriggeredBy" elements
     */
    org.openprovenance.model.v1_1_a.WasTriggeredBy[] getWasTriggeredByArray();
    
    /**
     * Gets ith "wasTriggeredBy" element
     */
    org.openprovenance.model.v1_1_a.WasTriggeredBy getWasTriggeredByArray(int i);
    
    /**
     * Returns number of "wasTriggeredBy" element
     */
    int sizeOfWasTriggeredByArray();
    
    /**
     * Sets array of all "wasTriggeredBy" element
     */
    void setWasTriggeredByArray(org.openprovenance.model.v1_1_a.WasTriggeredBy[] wasTriggeredByArray);
    
    /**
     * Sets ith "wasTriggeredBy" element
     */
    void setWasTriggeredByArray(int i, org.openprovenance.model.v1_1_a.WasTriggeredBy wasTriggeredBy);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasTriggeredBy" element
     */
    org.openprovenance.model.v1_1_a.WasTriggeredBy insertNewWasTriggeredBy(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasTriggeredBy" element
     */
    org.openprovenance.model.v1_1_a.WasTriggeredBy addNewWasTriggeredBy();
    
    /**
     * Removes the ith "wasTriggeredBy" element
     */
    void removeWasTriggeredBy(int i);
    
    /**
     * Gets array of all "wasDerivedFrom" elements
     */
    org.openprovenance.model.v1_1_a.WasDerivedFrom[] getWasDerivedFromArray();
    
    /**
     * Gets ith "wasDerivedFrom" element
     */
    org.openprovenance.model.v1_1_a.WasDerivedFrom getWasDerivedFromArray(int i);
    
    /**
     * Returns number of "wasDerivedFrom" element
     */
    int sizeOfWasDerivedFromArray();
    
    /**
     * Sets array of all "wasDerivedFrom" element
     */
    void setWasDerivedFromArray(org.openprovenance.model.v1_1_a.WasDerivedFrom[] wasDerivedFromArray);
    
    /**
     * Sets ith "wasDerivedFrom" element
     */
    void setWasDerivedFromArray(int i, org.openprovenance.model.v1_1_a.WasDerivedFrom wasDerivedFrom);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasDerivedFrom" element
     */
    org.openprovenance.model.v1_1_a.WasDerivedFrom insertNewWasDerivedFrom(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasDerivedFrom" element
     */
    org.openprovenance.model.v1_1_a.WasDerivedFrom addNewWasDerivedFrom();
    
    /**
     * Removes the ith "wasDerivedFrom" element
     */
    void removeWasDerivedFrom(int i);
    
    /**
     * Gets array of all "wasControlledBy" elements
     */
    org.openprovenance.model.v1_1_a.WasControlledBy[] getWasControlledByArray();
    
    /**
     * Gets ith "wasControlledBy" element
     */
    org.openprovenance.model.v1_1_a.WasControlledBy getWasControlledByArray(int i);
    
    /**
     * Returns number of "wasControlledBy" element
     */
    int sizeOfWasControlledByArray();
    
    /**
     * Sets array of all "wasControlledBy" element
     */
    void setWasControlledByArray(org.openprovenance.model.v1_1_a.WasControlledBy[] wasControlledByArray);
    
    /**
     * Sets ith "wasControlledBy" element
     */
    void setWasControlledByArray(int i, org.openprovenance.model.v1_1_a.WasControlledBy wasControlledBy);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasControlledBy" element
     */
    org.openprovenance.model.v1_1_a.WasControlledBy insertNewWasControlledBy(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasControlledBy" element
     */
    org.openprovenance.model.v1_1_a.WasControlledBy addNewWasControlledBy();
    
    /**
     * Removes the ith "wasControlledBy" element
     */
    void removeWasControlledBy(int i);
    
    /**
     * Gets array of all "used_" elements
     */
    org.openprovenance.model.v1_1_a.UsedStar[] getUsed2Array();
    
    /**
     * Gets ith "used_" element
     */
    org.openprovenance.model.v1_1_a.UsedStar getUsed2Array(int i);
    
    /**
     * Returns number of "used_" element
     */
    int sizeOfUsed2Array();
    
    /**
     * Sets array of all "used_" element
     */
    void setUsed2Array(org.openprovenance.model.v1_1_a.UsedStar[] used2Array);
    
    /**
     * Sets ith "used_" element
     */
    void setUsed2Array(int i, org.openprovenance.model.v1_1_a.UsedStar used2);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "used_" element
     */
    org.openprovenance.model.v1_1_a.UsedStar insertNewUsed2(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "used_" element
     */
    org.openprovenance.model.v1_1_a.UsedStar addNewUsed2();
    
    /**
     * Removes the ith "used_" element
     */
    void removeUsed2(int i);
    
    /**
     * Gets array of all "wasGeneratedBy_" elements
     */
    org.openprovenance.model.v1_1_a.WasGeneratedByStar[] getWasGeneratedBy2Array();
    
    /**
     * Gets ith "wasGeneratedBy_" element
     */
    org.openprovenance.model.v1_1_a.WasGeneratedByStar getWasGeneratedBy2Array(int i);
    
    /**
     * Returns number of "wasGeneratedBy_" element
     */
    int sizeOfWasGeneratedBy2Array();
    
    /**
     * Sets array of all "wasGeneratedBy_" element
     */
    void setWasGeneratedBy2Array(org.openprovenance.model.v1_1_a.WasGeneratedByStar[] wasGeneratedBy2Array);
    
    /**
     * Sets ith "wasGeneratedBy_" element
     */
    void setWasGeneratedBy2Array(int i, org.openprovenance.model.v1_1_a.WasGeneratedByStar wasGeneratedBy2);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasGeneratedBy_" element
     */
    org.openprovenance.model.v1_1_a.WasGeneratedByStar insertNewWasGeneratedBy2(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasGeneratedBy_" element
     */
    org.openprovenance.model.v1_1_a.WasGeneratedByStar addNewWasGeneratedBy2();
    
    /**
     * Removes the ith "wasGeneratedBy_" element
     */
    void removeWasGeneratedBy2(int i);
    
    /**
     * Gets array of all "wasTriggeredBy_" elements
     */
    org.openprovenance.model.v1_1_a.WasTriggeredByStar[] getWasTriggeredBy2Array();
    
    /**
     * Gets ith "wasTriggeredBy_" element
     */
    org.openprovenance.model.v1_1_a.WasTriggeredByStar getWasTriggeredBy2Array(int i);
    
    /**
     * Returns number of "wasTriggeredBy_" element
     */
    int sizeOfWasTriggeredBy2Array();
    
    /**
     * Sets array of all "wasTriggeredBy_" element
     */
    void setWasTriggeredBy2Array(org.openprovenance.model.v1_1_a.WasTriggeredByStar[] wasTriggeredBy2Array);
    
    /**
     * Sets ith "wasTriggeredBy_" element
     */
    void setWasTriggeredBy2Array(int i, org.openprovenance.model.v1_1_a.WasTriggeredByStar wasTriggeredBy2);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasTriggeredBy_" element
     */
    org.openprovenance.model.v1_1_a.WasTriggeredByStar insertNewWasTriggeredBy2(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasTriggeredBy_" element
     */
    org.openprovenance.model.v1_1_a.WasTriggeredByStar addNewWasTriggeredBy2();
    
    /**
     * Removes the ith "wasTriggeredBy_" element
     */
    void removeWasTriggeredBy2(int i);
    
    /**
     * Gets array of all "wasDerivedFrom_" elements
     */
    org.openprovenance.model.v1_1_a.WasDerivedFromStar[] getWasDerivedFrom2Array();
    
    /**
     * Gets ith "wasDerivedFrom_" element
     */
    org.openprovenance.model.v1_1_a.WasDerivedFromStar getWasDerivedFrom2Array(int i);
    
    /**
     * Returns number of "wasDerivedFrom_" element
     */
    int sizeOfWasDerivedFrom2Array();
    
    /**
     * Sets array of all "wasDerivedFrom_" element
     */
    void setWasDerivedFrom2Array(org.openprovenance.model.v1_1_a.WasDerivedFromStar[] wasDerivedFrom2Array);
    
    /**
     * Sets ith "wasDerivedFrom_" element
     */
    void setWasDerivedFrom2Array(int i, org.openprovenance.model.v1_1_a.WasDerivedFromStar wasDerivedFrom2);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "wasDerivedFrom_" element
     */
    org.openprovenance.model.v1_1_a.WasDerivedFromStar insertNewWasDerivedFrom2(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "wasDerivedFrom_" element
     */
    org.openprovenance.model.v1_1_a.WasDerivedFromStar addNewWasDerivedFrom2();
    
    /**
     * Removes the ith "wasDerivedFrom_" element
     */
    void removeWasDerivedFrom2(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.openprovenance.model.v1_1_a.CausalDependencies newInstance() {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openprovenance.model.v1_1_a.CausalDependencies parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openprovenance.model.v1_1_a.CausalDependencies) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
