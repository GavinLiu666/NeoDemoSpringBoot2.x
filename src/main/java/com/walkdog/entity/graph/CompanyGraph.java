package com.walkdog.entity.graph;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author liu_y
 */
@Builder
@Data
@NodeEntity(label = "Company")
public class CompanyGraph {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 供应商名称
     */
    @Property(name = "name")
    private String name;


}
