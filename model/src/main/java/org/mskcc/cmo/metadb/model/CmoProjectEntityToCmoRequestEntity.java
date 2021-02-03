package org.mskcc.cmo.metadb.model;

import java.io.Serializable;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "PR_TO_REQUEST")
public class CmoProjectEntityToCmoRequestEntity implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @StartNode
    private CmoProjectEntity cmoProjectEntity;
    @EndNode
    private CmoRequestEntity cmoRequestEntity;
    
    CmoProjectEntityToCmoRequestEntity() {}
    
    private Long getId() {
        return id;
    }
    
    private void setId(Long id) {
        this.id = id;
    }
    
    private CmoProjectEntity getCmoProjectEntity() {
        return cmoProjectEntity;
    }
    
    private void setCmoProjectEntity(CmoProjectEntity cmoProjectEntity) {
        this.cmoProjectEntity = cmoProjectEntity;
    }
    
    private CmoRequestEntity getCmoRequestEntity() {
        return cmoRequestEntity;
    }
    
    private void setCmoRequestEntity(CmoRequestEntity cmoRequestEntity) {
        this.cmoRequestEntity = cmoRequestEntity;
    }
}
