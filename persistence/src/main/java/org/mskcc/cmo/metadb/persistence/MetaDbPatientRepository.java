package org.mskcc.cmo.metadb.persistence;

import java.util.UUID;
import org.mskcc.cmo.metadb.model.MetaDbPatient;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ochoaa
 */
public interface MetaDbPatientRepository extends Neo4jRepository<MetaDbPatient, Long> {
    @Query("MATCH (pm: Patient)<-[:IS_ALIAS]-(pa:PatientAlias "
            + "{value: $patientId}) RETURN pm")
    MetaDbPatient findPatientByPatientAlias(
            @Param("patientId") String patientId);

    @Query("MATCH (sm: Sample {metaDbSampleId: $metaDbSampleId})"
            + "MATCH (sm)<-[:HAS_SAMPLE]-(p: Patient)"
            + "RETURN p;")
    MetaDbPatient findPatientBySampleId(@Param("metaDbSampleId") UUID metaDbSampleId);

    @Query("MATCH (s: Sample {metaDbSampleId: $metaDbSampleId}) "
            + "MATCH (s)<-[:HAS_SAMPLE]-(p: Patient) "
            + "RETURN p.metaDbPatientId")
    UUID findPatientIdBySample(@Param("metaDbSampleId") UUID metaDbSampleId);
}
