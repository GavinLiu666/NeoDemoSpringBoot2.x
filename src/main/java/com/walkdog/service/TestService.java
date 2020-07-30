package com.walkdog.service;

import com.walkdog.entity.graph.CompanyGraph;
import com.walkdog.entity.relationship.SupplyRelationship;
import com.walkdog.entity.request.AddSupplyRequest;
import com.walkdog.repository.CompanyGraphRepository;
import com.walkdog.repository.SupplyRelationshipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liu_y
 */
@Service
public class TestService {

    private final CompanyGraphRepository companyGraphRepository;
    private final SupplyRelationshipRepository supplyRelationshipRepository;

    public TestService(CompanyGraphRepository companyGraphRepository, SupplyRelationshipRepository supplyRelationshipRepository) {
        this.companyGraphRepository = companyGraphRepository;
        this.supplyRelationshipRepository = supplyRelationshipRepository;
    }

    /**
     * 同时保存节点和关系
     *
     * @param request
     */
    public void testSave(AddSupplyRequest request) {
        //采购占比
        String scale = request.getScale();
        // 采购金额
        int amount = request.getAmount();
        //供应商名称
        String supplyName = request.getSupplyName();
        String companyName = request.getCompanyName();
        //公司实体部分及添加公司节点部分省略...(companyGraph)
        CompanyGraph supplyGraph = companyGraphRepository.findOneByName(supplyName);
        CompanyGraph companyGraph = companyGraphRepository.findOneByName(companyName);
        if (null == supplyGraph) {
            supplyGraph = CompanyGraph.builder().name(supplyName).build();
        }
        if (null == companyGraph) {
            companyGraph = CompanyGraph.builder().name(companyName).build();
        }
        //添加供应商节点
        companyGraphRepository.save(supplyGraph);
        companyGraphRepository.save(companyGraph);
        String indexName = companyName + "-" + supplyName;
        //供应商关系
        SupplyRelationship supplyRelationship =
                SupplyRelationship.builder()
                        .company(companyGraph)
                        .supply(supplyGraph)
                        .amount(amount)
                        .scale(scale)
                        .indexName(indexName)
                        .build();
        //添加供应关系
        supplyRelationshipRepository.save(supplyRelationship);
    }

    /**
     * 给已有节点添加关系
     *
     * @param request
     */
    public void addRelation(AddSupplyRequest request) {

        CompanyGraph companyGraph = companyGraphRepository.findOneByName(request.getCompanyName());
        CompanyGraph supplyGraph = companyGraphRepository.findOneByName(request.getSupplyName());

        SupplyRelationship supplyRelationship =
                SupplyRelationship.builder()
                        .company(companyGraph)
                        .supply(supplyGraph)
                        .amount(request.getAmount())
                        .scale(request.getScale())
                        .indexName(request.getSupplyName() + "-" + request.getCompanyName())
                        .build();
        supplyRelationshipRepository.save(supplyRelationship);
    }

    /**
     * 查询关系
     *
     * @param request
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public SupplyRelationship getRelation(AddSupplyRequest request) {

        return supplyRelationshipRepository.findBySupplyAndCompany(
                request.getCompanyName(),
                request.getSupplyName());
    }

    /**
     * 删除关系
     *
     * @param request
     */
    @Transactional
    public List<Long> delRelation(AddSupplyRequest request) {

        CompanyGraph companyGraph = companyGraphRepository.findOneByName(request.getCompanyName());
        CompanyGraph supplyGraph = companyGraphRepository.findOneByName(request.getSupplyName());


        SupplyRelationship relationship = supplyRelationshipRepository.findBySupplyAndCompany(
                request.getCompanyName(),
                request.getSupplyName());
        return null;
    }

    public List<CompanyGraph> findNeighbourByName(String name) {
        return companyGraphRepository.findNeighbourByName(name);
    }
}
