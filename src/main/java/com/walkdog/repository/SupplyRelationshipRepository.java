package com.walkdog.repository;

import com.walkdog.entity.graph.CompanyGraph;
import com.walkdog.entity.relationship.SupplyRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 关系Repository
 *
 * @author liu_y
 */
@Repository
public interface SupplyRelationshipRepository extends Neo4jRepository<SupplyRelationship, Long> {

    @Query(value = "match (c1:Company) where c1.name=$supplyName match(c2:Company) where c2.name=$companyName match(c1)-[r]->(c2) return r")
    SupplyRelationship findBySupplyAndCompany(@Param("supplyName") String supply,
                                              @Param("companyName") String company);

//    SupplyRelationship findBy


    List<Long> deleteBySupplyAndCompany(@Param("supply") CompanyGraph supply,
                                        @Param("company") CompanyGraph company);

}