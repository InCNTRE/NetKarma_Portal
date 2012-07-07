/*
#
# Copyright 2007 The Trustees of Indiana University
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or areed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# -----------------------------------------------------------------
#
# Project: Karma-Service-core
# File:  AnnotationFactory.java
# Description:  Factory for annotation
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;
import org.dataandsearch.www.karma._2010._08.AnnotationType;

import edu.indiana.dsi.karma.ingest.Annotation;
import edu.indiana.dsi.karma.ingest.Annotation.AnnotationDefinitionScopeEnum;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 *
 */
public class AnnotationFactory {
    protected static HashMap<String, AnnotationDefinitionScopeEnum> annotationScopeDictionary = null;
    protected static final XmlOptions PRETTY_PRINT_OPTS = new XmlOptions().setSavePrettyPrint();
    
    public static class AnnotationImpl implements Annotation {

        private final String property;
        private final String value;
        private AnnotationDefinitionScopeEnum scope;
        
        AnnotationImpl(String property, String value) {
            this.property = property;
            this.value = value;
            if (annotationScopeDictionary != null) {
                this.scope = annotationScopeDictionary.get(property);
            }
            if (annotationScopeDictionary == null || this.scope == null) {
                this.scope = AnnotationDefinitionScopeEnum.EXTERNAL_SOURCE;
            }
            // use a dictionary to look up the scope based on scope
        }
        
        public String getProperty() { return property; }
        public String getValue() { return value; }
        public AnnotationDefinitionScopeEnum getScope() {
            return scope;
        }
        
    }

    public static Annotation createAnnotation(String property, String value) {
        Annotation annotation = new AnnotationImpl(property, value);
        return annotation;
    }
    
    public static void setScopeDictionary(HashMap<String, AnnotationDefinitionScopeEnum> scopeDictionary) {
        annotationScopeDictionary = scopeDictionary;
    }

    public static void addScopeDefinition(String property, AnnotationDefinitionScopeEnum scope) {
        if (annotationScopeDictionary == null) {
            annotationScopeDictionary = new HashMap<String, AnnotationDefinitionScopeEnum>();
        }
        annotationScopeDictionary.put(property, scope);
    }

    
    /**
     * Convert an array of AnnotationType XmlBeans objects to a List of Annotation objects
     * @param annotationsArray array of AnnotationType objects
     * @return List of Annotation objects
     * 
     * @author Yiming Sun
     */
    public static List<Annotation> convert(AnnotationType[] annotationsArray) {
        List<Annotation> annotationList = null;
        if (annotationsArray != null && annotationsArray.length > 0) {
            annotationList = new ArrayList<Annotation>();
            for (AnnotationType annotation : annotationsArray) {
                annotationList.add(convert(annotation));
            }
        }
        return annotationList;
    }

    public static Annotation convert(AnnotationType annotationType) {
        Annotation annotation = null;
        if (annotationType != null) {
            String property = annotationType.getProperty();
            String xmlText = annotationType.getValue().xmlText(PRETTY_PRINT_OPTS);

            annotation = new AnnotationImpl(property, xmlText);
        }
        return annotation;
    }


}

