package com.walkdog.repository;

import com.walkdog.entity.relationship.CompetitionRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * 关系Repository
 *
 * @author liu_y
 */
@Repository
public interface CompetitionRelationshipRepository extends Neo4jRepository<CompetitionRelationship, Long> {


}