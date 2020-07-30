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
@RelationshipEntity(type = "SUPPLY")
public class SupplyRelationship {
    @Id
    @GeneratedValue
    private Long id;

    private String indexName;

    /**
     * 关系的一端节点是 公司节点
     */
    @EndNode
    private CompanyGraph company;

    /**
     * 关系的另一端节点是 供应商节点
     */
    @StartNode
    private CompanyGraph supply;

    /*----下面是关系的属性----*/
    /**
     * 采购占比
     */
    private String scale;

    /**
     * 采购金额
     */
    private int amount;
}
