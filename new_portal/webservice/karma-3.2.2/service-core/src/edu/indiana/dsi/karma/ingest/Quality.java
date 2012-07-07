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
# File:  Quality.java
# Description:  Class representing quality of data objects
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest;


/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 */

public class Quality {
    
    public static enum QualitySourceEnum {
        UNKNOWN,
        INFERENCE,
        QUALITY_ASSESSMENT;
    }

    public static final byte DEFAULT_QUALITY_SCORE = (byte)50;
    private final QualitySourceEnum qualitySource;
    private final byte qualityScore;
    
    public Quality(byte qualityScore, QualitySourceEnum qualitySource) throws IngestException {
        if (qualityScore >=0 && qualityScore <= 100) {
            this.qualityScore = qualityScore;
            this.qualitySource = qualitySource;
        } else {
            throw new IngestException("Quality score out of range");
        }
    }
    
    public QualitySourceEnum getQualitySource() {
        return qualitySource;
    }
    
    public byte getQualityScore() {
        return qualityScore;
    }
}

