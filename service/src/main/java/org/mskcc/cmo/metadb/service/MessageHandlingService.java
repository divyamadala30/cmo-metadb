package org.mskcc.cmo.metadb.service;

import org.mskcc.cmo.messaging.Gateway;
import org.mskcc.cmo.shared.neo4j.SampleMetadataEntity;

public interface MessageHandlingService {

    void initialize(Gateway gateway) throws Exception;

    void newSampleHandler(SampleMetadataEntity sample) throws Exception;
    
    void shutdown() throws Exception;
}