package com.walkdog.controller;

import com.walkdog.entity.graph.CompanyGraph;
import com.walkdog.entity.request.AddCompetitionRequest;
import com.walkdog.service.CompetitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liu_y
 */
@RestController
@RequestMapping("/competition")
public class CompetitionController {

    private final CompetitionService service;

    public CompetitionController(CompetitionService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public String test2(@RequestBody AddCompetitionRequest request) {
        service.add(request.getName1(), request.getName2());
        return "success";
    }

    @GetMapping("/company/{company_id}/list")
    public List<CompanyGraph> test2(@PathVariable("company_id") long companyId) {
        return service.findCompetitorById(companyId);
    }


}
