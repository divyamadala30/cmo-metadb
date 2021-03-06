package org.mskcc.cmo.metadb.persistence;

import org.mskcc.cmo.metadb.model.MetaDbProject;
import org.mskcc.cmo.metadb.model.MetaDbRequest;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ochoaa
 */
@Repository
public interface MetaDbRequestRepository extends Neo4jRepository<MetaDbRequest, Long> {
    @Query("MATCH (r: Request {requestId: $reqId}) RETURN r;")
    MetaDbRequest findMetaDbRequestById(@Param("reqId") String reqId);

    @Query("MATCH (r: Request {requestId: $reqId}) "
            + "MATCH (r)<-[:HAS_REQUEST]-(p: Project) "
            + "RETURN p")
    MetaDbProject findMetaDbProjectByRequest(@Param("reqId") String reqId);

    @Query("MATCH (r: Request)-[:HAS_SAMPLE]->(s:Sample)"
            + "<-[:HAS_SAMPLE]-(p:Patient)"
            + "<-[:IS_ALIAS]-(pa:PatientAlias {value: $patientAliasId}) RETURN r")
    MetaDbRequest findMetadbRequestByPatientAlias(@Param("patientAliasId") String patientAliasId);
}
