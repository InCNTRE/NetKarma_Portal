/*
 * XML Type:  workflowInformationType
 * Namespace: http://www.dataandsearch.org/karma/2010/08/
 * Java type: org.dataandsearch.www.karma._2010._08.WorkflowInformationType
 *
 * Automatically generated - do not modify.
 */
package org.dataandsearch.www.karma._2010._08.impl;
/**
 * An XML workflowInformationType(@http://www.dataandsearch.org/karma/2010/08/).
 *
 * This is a complex type.
 */
public class WorkflowInformationTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.WorkflowInformationType
{
    
    public WorkflowInformationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WORKFLOWID$0 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflowID");
    private static final javax.xml.namespace.QName WORKFLOWNODEID$2 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "workflowNodeID");
    private static final javax.xml.namespace.QName TIMESTEP$4 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "timestep");
    private static final javax.xml.namespace.QName ANNOTATIONS$6 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "annotations");
    private static final javax.xml.namespace.QName USERBEHALF$8 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "userBehalf");
    private static final javax.xml.namespace.QName INSTANCEOF$10 = 
        new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "instanceOf");
    
    
    /**
     * Gets the "workflowID" element
     */
    public java.lang.String getWorkflowID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "workflowID" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetWorkflowID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(WORKFLOWID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "workflowID" element
     */
    public void setWorkflowID(java.lang.String workflowID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKFLOWID$0);
            }
            target.setStringValue(workflowID);
        }
    }
    
    /**
     * Sets (as xml) the "workflowID" element
     */
    public void xsetWorkflowID(org.apache.xmlbeans.XmlAnyURI workflowID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(WORKFLOWID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(WORKFLOWID$0);
            }
            target.set(workflowID);
        }
    }
    
    /**
     * Gets the "workflowNodeID" element
     */
    public java.lang.String getWorkflowNodeID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWNODEID$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "workflowNodeID" element
     */
    public org.apache.xmlbeans.XmlString xgetWorkflowNodeID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWNODEID$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "workflowNodeID" element
     */
    public boolean isSetWorkflowNodeID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WORKFLOWNODEID$2) != 0;
        }
    }
    
    /**
     * Sets the "workflowNodeID" element
     */
    public void setWorkflowNodeID(java.lang.String workflowNodeID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKFLOWNODEID$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKFLOWNODEID$2);
            }
            target.setStringValue(workflowNodeID);
        }
    }
    
    /**
     * Sets (as xml) the "workflowNodeID" element
     */
    public void xsetWorkflowNodeID(org.apache.xmlbeans.XmlString workflowNodeID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKFLOWNODEID$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WORKFLOWNODEID$2);
            }
            target.set(workflowNodeID);
        }
    }
    
    /**
     * Unsets the "workflowNodeID" element
     */
    public void unsetWorkflowNodeID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WORKFLOWNODEID$2, 0);
        }
    }
    
    /**
     * Gets the "timestep" element
     */
    public int getTimestep()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMESTEP$4, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "timestep" element
     */
    public org.apache.xmlbeans.XmlInt xgetTimestep()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(TIMESTEP$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "timestep" element
     */
    public boolean isSetTimestep()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TIMESTEP$4) != 0;
        }
    }
    
    /**
     * Sets the "timestep" element
     */
    public void setTimestep(int timestep)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMESTEP$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIMESTEP$4);
            }
            target.setIntValue(timestep);
        }
    }
    
    /**
     * Sets (as xml) the "timestep" element
     */
    public void xsetTimestep(org.apache.xmlbeans.XmlInt timestep)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(TIMESTEP$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(TIMESTEP$4);
            }
            target.set(timestep);
        }
    }
    
    /**
     * Unsets the "timestep" element
     */
    public void unsetTimestep()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TIMESTEP$4, 0);
        }
    }
    
    /**
     * Gets array of all "annotations" elements
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType[] getAnnotationsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANNOTATIONS$6, targetList);
            org.dataandsearch.www.karma._2010._08.AnnotationType[] result = new org.dataandsearch.www.karma._2010._08.AnnotationType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType getAnnotationsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "annotations" element
     */
    public int sizeOfAnnotationsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANNOTATIONS$6);
        }
    }
    
    /**
     * Sets array of all "annotations" element
     */
    public void setAnnotationsArray(org.dataandsearch.www.karma._2010._08.AnnotationType[] annotationsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(annotationsArray, ANNOTATIONS$6);
        }
    }
    
    /**
     * Sets ith "annotations" element
     */
    public void setAnnotationsArray(int i, org.dataandsearch.www.karma._2010._08.AnnotationType annotations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().find_element_user(ANNOTATIONS$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(annotations);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType insertNewAnnotations(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().insert_element_user(ANNOTATIONS$6, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "annotations" element
     */
    public org.dataandsearch.www.karma._2010._08.AnnotationType addNewAnnotations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.AnnotationType target = null;
            target = (org.dataandsearch.www.karma._2010._08.AnnotationType)get_store().add_element_user(ANNOTATIONS$6);
            return target;
        }
    }
    
    /**
     * Removes the ith "annotations" element
     */
    public void removeAnnotations(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANNOTATIONS$6, i);
        }
    }
    
    /**
     * Gets the "userBehalf" element
     */
    public org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf getUserBehalf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf)get_store().find_element_user(USERBEHALF$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "userBehalf" element
     */
    public boolean isSetUserBehalf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(USERBEHALF$8) != 0;
        }
    }
    
    /**
     * Sets the "userBehalf" element
     */
    public void setUserBehalf(org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf userBehalf)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf)get_store().find_element_user(USERBEHALF$8, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf)get_store().add_element_user(USERBEHALF$8);
            }
            target.set(userBehalf);
        }
    }
    
    /**
     * Appends and returns a new empty "userBehalf" element
     */
    public org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf addNewUserBehalf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf target = null;
            target = (org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf)get_store().add_element_user(USERBEHALF$8);
            return target;
        }
    }
    
    /**
     * Unsets the "userBehalf" element
     */
    public void unsetUserBehalf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(USERBEHALF$8, 0);
        }
    }
    
    /**
     * Gets the "instanceOf" element
     */
    public org.dataandsearch.www.karma._2010._08.InstanceOfType getInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InstanceOfType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().find_element_user(INSTANCEOF$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "instanceOf" element
     */
    public boolean isSetInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INSTANCEOF$10) != 0;
        }
    }
    
    /**
     * Sets the "instanceOf" element
     */
    public void setInstanceOf(org.dataandsearch.www.karma._2010._08.InstanceOfType xinstanceOf)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InstanceOfType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().find_element_user(INSTANCEOF$10, 0);
            if (target == null)
            {
                target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().add_element_user(INSTANCEOF$10);
            }
            target.set(xinstanceOf);
        }
    }
    
    /**
     * Appends and returns a new empty "instanceOf" element
     */
    public org.dataandsearch.www.karma._2010._08.InstanceOfType addNewInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.dataandsearch.www.karma._2010._08.InstanceOfType target = null;
            target = (org.dataandsearch.www.karma._2010._08.InstanceOfType)get_store().add_element_user(INSTANCEOF$10);
            return target;
        }
    }
    
    /**
     * Unsets the "instanceOf" element
     */
    public void unsetInstanceOf()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INSTANCEOF$10, 0);
        }
    }
    /**
     * An XML userBehalf(@http://www.dataandsearch.org/karma/2010/08/).
     *
     * This is a complex type.
     */
    public static class UserBehalfImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf
    {
        
        public UserBehalfImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName USERDN$0 = 
            new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "userDN");
        private static final javax.xml.namespace.QName AUTHORSHIP$2 = 
            new javax.xml.namespace.QName("http://www.dataandsearch.org/karma/2010/08/", "authorship");
        
        
        /**
         * Gets the "userDN" element
         */
        public java.lang.String getUserDN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERDN$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "userDN" element
         */
        public org.apache.xmlbeans.XmlString xgetUserDN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERDN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "userDN" element
         */
        public void setUserDN(java.lang.String userDN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERDN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USERDN$0);
                }
                target.setStringValue(userDN);
            }
        }
        
        /**
         * Sets (as xml) the "userDN" element
         */
        public void xsetUserDN(org.apache.xmlbeans.XmlString userDN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERDN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USERDN$0);
                }
                target.set(userDN);
            }
        }
        
        /**
         * Gets the "authorship" element
         */
        public org.dataandsearch.www.karma._2010._08.AuthorshipEnumType.Enum getAuthorship()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORSHIP$2, 0);
                if (target == null)
                {
                    return null;
                }
                return (org.dataandsearch.www.karma._2010._08.AuthorshipEnumType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "authorship" element
         */
        public org.dataandsearch.www.karma._2010._08.AuthorshipEnumType xgetAuthorship()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.dataandsearch.www.karma._2010._08.AuthorshipEnumType target = null;
                target = (org.dataandsearch.www.karma._2010._08.AuthorshipEnumType)get_store().find_element_user(AUTHORSHIP$2, 0);
                return target;
            }
        }
        
        /**
         * True if has "authorship" element
         */
        public boolean isSetAuthorship()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(AUTHORSHIP$2) != 0;
            }
        }
        
        /**
         * Sets the "authorship" element
         */
        public void setAuthorship(org.dataandsearch.www.karma._2010._08.AuthorshipEnumType.Enum authorship)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AUTHORSHIP$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AUTHORSHIP$2);
                }
                target.setEnumValue(authorship);
            }
        }
        
        /**
         * Sets (as xml) the "authorship" element
         */
        public void xsetAuthorship(org.dataandsearch.www.karma._2010._08.AuthorshipEnumType authorship)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.dataandsearch.www.karma._2010._08.AuthorshipEnumType target = null;
                target = (org.dataandsearch.www.karma._2010._08.AuthorshipEnumType)get_store().find_element_user(AUTHORSHIP$2, 0);
                if (target == null)
                {
                    target = (org.dataandsearch.www.karma._2010._08.AuthorshipEnumType)get_store().add_element_user(AUTHORSHIP$2);
                }
                target.set(authorship);
            }
        }
        
        /**
         * Unsets the "authorship" element
         */
        public void unsetAuthorship()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(AUTHORSHIP$2, 0);
            }
        }
    }
}
