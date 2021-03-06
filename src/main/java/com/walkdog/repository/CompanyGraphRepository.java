package com.walkdog.repository;

import com.walkdog.entity.graph.CompanyGraph;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 节点Repository
 *
 * @author liu_y
 */
@Repository
public interface CompanyGraphRepository extends Neo4jRepository<CompanyGraph, Long> {


    List<CompanyGraph> findListByName(@Param("name") String name);

    @Query("match (c:Company{name:$companyName})<--(n)  return n")
    List<CompanyGraph> findNeighbourByName(@Param("companyName") String companyName);

    CompanyGraph findOneByName(@Param("name") String name);

    /**
     * 通过id 查找到所有的竞争对手
     *
     * @param companyId companyId
     * @return CompanyGraph list
     */
    @Query("match (c:Company)<-[:COMPETITION]-(n) where id(c) =$companyId return n")
    List<CompanyGraph> findCompetitorById(@Param("companyId") long companyId);


}
