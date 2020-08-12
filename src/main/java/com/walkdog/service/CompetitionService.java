package com.walkdog.service;

import com.walkdog.entity.graph.CompanyGraph;
import com.walkdog.entity.relationship.CompetitionRelationship;
import com.walkdog.repository.CompanyGraphRepository;
import com.walkdog.repository.CompetitionRelationshipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu_y
 */
@Service
public class CompetitionService {

    private final CompetitionRelationshipRepository competitionRelationshipRepository;
    private final CompanyGraphRepository companyGraphRepository;

    public CompetitionService(CompetitionRelationshipRepository competitionRelationshipRepository,
                              CompanyGraphRepository companyGraphRepository) {
        this.competitionRelationshipRepository = competitionRelationshipRepository;
        this.companyGraphRepository = companyGraphRepository;
    }


    @Transactional(rollbackFor = Exception.class)
    public String add(String companyName1, String companyName2) {
        CompanyGraph companyGraph1 = companyGraphRepository.findOneByName(companyName1);
        CompanyGraph companyGraph2 = companyGraphRepository.findOneByName(companyName2);

        CompetitionRelationship cr1 = CompetitionRelationship
                .builder().company1(companyGraph1).company2(companyGraph2).build();
        CompetitionRelationship cr2 = CompetitionRelationship
                .builder().company1(companyGraph2).company2(companyGraph1).build();

        List<CompetitionRelationship> list = new ArrayList<>();
        list.add(cr1);
        list.add(cr2);

        competitionRelationshipRepository.saveAll(list);

        return "success";
    }

}
