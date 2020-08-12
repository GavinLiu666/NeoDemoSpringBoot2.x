package com.walkdog.entity.relationship;

import com.walkdog.entity.graph.CompanyGraph;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author liu_y
 */
@Data
@Builder
@RelationshipEntity(type = "COMPETITION")
public class CompetitionRelationship {
    @Id
    @GeneratedValue
    private Long id;

    @EndNode
    private CompanyGraph company1;

    @StartNode
    private CompanyGraph company2;

}
