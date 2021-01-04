package org.mskcc.cmo.metadb.service.impl;

import org.mskcc.cmo.metadb.persistence.SampleMetadataRepository;
import org.mskcc.cmo.metadb.service.SampleService;
import org.mskcc.cmo.shared.neo4j.SampleMetadataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleMetadataRepository sampleMetadataRepository;

    @Override
    public SampleMetadataEntity insertSampleMetadata(SampleMetadataEntity sample) {
        // create prerequisite request, patient nodes with the help of other services
        // sample, metadata, nodes etc
        return sampleMetadataRepository.insertSampleMetadata(sample);
    }
    
    @Override
    public SampleMetadataEntity updateSampleMetadata(SampleMetadataEntity sample) {
        // create prerequisite request, patient nodes with the help of other services
        // sample, metadata, nodes etc
        return sampleMetadataRepository.updateSampleMetadata(sample);
    }
    
    @Override
    public SampleMetadataEntity findSampleByIgoId(String igoId) {
        return sampleMetadataRepository.findSampleByIgoId(igoId);
    }
}
