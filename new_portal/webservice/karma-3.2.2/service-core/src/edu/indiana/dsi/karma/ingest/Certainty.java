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
# File:  Certainty.java
# Description:  Class represents certainty of notification events
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

public class Certainty {
    
    public static enum CertaintySourceEnum {
        UNKNOWN,
        INFERENCE,
        NOTIFICATION,
        CODE_LOGIC;
    }
    
    private final CertaintySourceEnum certaintySource;
    private final byte certaintyScore;
    public static final byte DEFAULT_CERTAINTY_SCORE = (byte)50;
    
    public Certainty(byte certaintyScore, CertaintySourceEnum certaintySource) throws IngestException {
        if (certaintyScore >= 0 && certaintyScore <= 100) {
            this.certaintyScore = certaintyScore;
            this.certaintySource = certaintySource;
        } else {
            throw new IngestException("Certainty score out of range");
        }
    }
     
    public CertaintySourceEnum getCertaintySource() {
        return certaintySource;
    }
    
    public byte getCertaintyScore() {
        return certaintyScore;
    }
    
    public boolean isMoreCertainThan(Certainty another) {
        if (another == null) {
            return true;
        }
        
        if (this.getCertaintySource().equals(another.getCertaintySource())) {
            return (this.getCertaintyScore() > another.getCertaintyScore());
        }
        
        switch (this.getCertaintySource()) {
        case UNKNOWN:
            return false;
        case INFERENCE:
            switch (another.getCertaintySource()) {
            case UNKNOWN:
                return true;
            default:
                return false;
            }
        case NOTIFICATION:
            switch (another.getCertaintySource()) {
            case UNKNOWN:
            case INFERENCE:
                return true;
            default:
                return false;
            }
        case CODE_LOGIC:
            switch (another.getCertaintySource()) {
            case CODE_LOGIC:
                return false;
            default:
                return true;
            }
        }
        assert false : "Should not reach here. this.certaintySource: " + this.getCertaintySource().name() + " another.certaintySource: " + another.getCertaintySource().name();
        return false;
    }
}


