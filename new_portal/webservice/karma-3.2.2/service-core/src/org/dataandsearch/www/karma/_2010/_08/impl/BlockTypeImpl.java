/*
 * XML Type:  blockType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.BlockType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML blockType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class BlockTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.BlockType
{
    
    public BlockTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BLOCKCONTENT$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "blockContent");
    
    
    /**
     * Gets the "blockContent" element
     */
    public org.apache.xmlbeans.XmlObject getBlockContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(BLOCKCONTENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "blockContent" element
     */
    public void setBlockContent(org.apache.xmlbeans.XmlObject blockContent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(BLOCKCONTENT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(BLOCKCONTENT$0);
            }
            target.set(blockContent);
        }
    }
    
    /**
     * Appends and returns a new empty "blockContent" element
     */
    public org.apache.xmlbeans.XmlObject addNewBlockContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(BLOCKCONTENT$0);
            return target;
        }
    }
}
