/*
 * XML Type:  entityType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.EntityType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML entityType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class EntityTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.EntityType
{
    
    public EntityTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName USERINFORMATION$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "userInformation");
    private static final javax.xml.namespace.QName WORKFLOWINFORMATION$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflowInformation");
    private static final javax.xml.namespace.QName SERVICEINFORMATION$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "serviceInformation");
    private static final javax.xml.namespace.QName METHODINFORMATION$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "methodInformation");
    private static final javax.xml.namespace.QName TYPE$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "type");
    private static final javax.xml.namespace.QName SUBTYPE$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "subtype");
    
    
    /**
     * Gets the "userInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.UserInformationType getUserInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.UserInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.UserInformationType)get_store().find_element_user(USERINFORMATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "userInformation" element
     */
    public boolean isSetUserInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(USERINFORMATION$0) != 0;
        }
    }
    
    /**
     * Sets the "userInformation" element
     */
    public void setUserInformation(org.dataandsearch.www.karma._2010._08.UserInformationType userInformation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.UserInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.UserInformationType)get_store().find_element_user(USERINFORMATION$0, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.UserInformationType)get_store().add_element_user(USERINFORMATION$0);
            }
            target.set(userInformation);
        }
    }
    
    /**
     * Appends and returns a new empty "userInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.UserInformationType addNewUserInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.UserInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.UserInformationType)get_store().add_element_user(USERINFORMATION$0);
            return target;
        }
    }
    
    /**
     * Unsets the "userInformation" element
     */
    public void unsetUserInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(USERINFORMATION$0, 0);
        }
    }
    
    /**
     * Gets the "workflowInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.WorkflowInformationType getWorkflowInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType)get_store().find_element_user(WORKFLOWINFORMATION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "workflowInformation" element
     */
    public boolean isSetWorkflowInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WORKFLOWINFORMATION$2) != 0;
        }
    }
    
    /**
     * Sets the "workflowInformation" element
     */
    public void setWorkflowInformation(org.dataandsearch.www.karma._2010._08.WorkflowInformationType workflowInformation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType)get_store().find_element_user(WORKFLOWINFORMATION$2, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType)get_store().add_element_user(WORKFLOWINFORMATION$2);
            }
            target.set(workflowInformation);
        }
    }
    
    /**
     * Appends and returns a new empty "workflowInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.WorkflowInformationType addNewWorkflowInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType)get_store().add_element_user(WORKFLOWINFORMATION$2);
            return target;
        }
    }
    
    /**
     * Unsets the "workflowInformation" element
     */
    public void unsetWorkflowInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WORKFLOWINFORMATION$2, 0);
        }
    }
    
    /**
     * Gets the "serviceInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.ServiceInformationType getServiceInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.ServiceInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.ServiceInformationType)get_store().find_element_user(SERVICEINFORMATION$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "serviceInformation" element
     */
    public boolean isSetServiceInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICEINFORMATION$4) != 0;
        }
    }
    
    /**
     * Sets the "serviceInformation" element
     */
    public void setServiceInformation(org.dataandsearch.www.karma._2010._08.ServiceInformationType serviceInformation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.ServiceInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.ServiceInformationType)get_store().find_element_user(SERVICEINFORMATION$4, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.ServiceInformationType)get_store().add_element_user(SERVICEINFORMATION$4);
            }
            target.set(serviceInformation);
        }
    }
    
    /**
     * Appends and returns a new empty "serviceInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.ServiceInformationType addNewServiceInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.ServiceInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.ServiceInformationType)get_store().add_element_user(SERVICEINFORMATION$4);
            return target;
        }
    }
    
    /**
     * Unsets the "serviceInformation" element
     */
    public void unsetServiceInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICEINFORMATION$4, 0);
        }
    }
    
    /**
     * Gets the "methodInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.MethodInformationType getMethodInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.MethodInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.MethodInformationType)get_store().find_element_user(METHODINFORMATION$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "methodInformation" element
     */
    public boolean isSetMethodInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHODINFORMATION$6) != 0;
        }
    }
    
    /**
     * Sets the "methodInformation" element
     */
    public void setMethodInformation(org.dataandsearch.www.karma._2010._08.MethodInformationType methodInformation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.MethodInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.MethodInformationType)get_store().find_element_user(METHODINFORMATION$6, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.MethodInformationType)get_store().add_element_user(METHODINFORMATION$6);
            }
            target.set(methodInformation);
        }
    }
    
    /**
     * Appends and returns a new empty "methodInformation" element
     */
    public org.dataandsearch.www.karma._2010._08.MethodInformationType addNewMethodInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.MethodInformationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.MethodInformationType)get_store().add_element_user(METHODINFORMATION$6);
            return target;
        }
    }
    
    /**
     * Unsets the "methodInformation" element
     */
    public void unsetMethodInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHODINFORMATION$6, 0);
        }
    }
    
    /**
     * Gets the "type" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "type" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityEnumType xgetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityEnumType)get_store().find_element_user(TYPE$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "type" element
     */
    public void setType(org.dataandsearch.www.karma._2010._08.EntityEnumType.Enum type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$8);
            }
            target.setEnumValue(type);
        }
    }
    
    /**
     * Sets (as xml) the "type" element
     */
    public void xsetType(org.dataandsearch.www.karma._2010._08.EntityEnumType type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityEnumType target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityEnumType)get_store().find_element_user(TYPE$8, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityEnumType)get_store().add_element_user(TYPE$8);
            }
            target.set(type);
        }
    }
    
    /**
     * Gets the "subtype" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityEnumSubtype.Enum getSubtype()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBTYPE$10, 0);
            if (target == null)
            {
                return null;
            }
            return (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "subtype" element
     */
    public org.dataandsearch.www.karma._2010._08.EntityEnumSubtype xgetSubtype()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityEnumSubtype target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype)get_store().find_element_user(SUBTYPE$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "subtype" element
     */
    public boolean isSetSubtype()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SUBTYPE$10) != 0;
        }
    }
    
    /**
     * Sets the "subtype" element
     */
    public void setSubtype(org.dataandsearch.www.karma._2010._08.EntityEnumSubtype.Enum subtype)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBTYPE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUBTYPE$10);
            }
            target.setEnumValue(subtype);
        }
    }
    
    /**
     * Sets (as xml) the "subtype" element
     */
    public void xsetSubtype(org.dataandsearch.www.karma._2010._08.EntityEnumSubtype subtype)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.EntityEnumSubtype target = null;
            target = (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype)get_store().find_element_user(SUBTYPE$10, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.EntityEnumSubtype)get_store().add_element_user(SUBTYPE$10);
            }
            target.set(subtype);
        }
    }
    
    /**
     * Unsets the "subtype" element
     */
    public void unsetSubtype()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SUBTYPE$10, 0);
        }
    }
}
