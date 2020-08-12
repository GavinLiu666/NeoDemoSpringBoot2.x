package com.walkdog.controller;

import com.walkdog.entity.graph.CompanyGraph;
import com.walkdog.entity.relationship.SupplyRelationship;
import com.walkdog.entity.request.AddSupplyRequest;
import com.walkdog.service.TestService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liu_y
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get-neighbour")
    public List<CompanyGraph> test1(@RequestParam String name) {
        return testService.findNeighbourByName(name);
    }

    @PostMapping("/save")
    public String test1(@RequestBody AddSupplyRequest request) {
        testService.testSave(request);
        return "success";
    }

    @PostMapping("/add-relation")
    public String test2(@RequestBody AddSupplyRequest request) {
        testService.addRelation(request);
        return "success";
    }

    @PostMapping("/add-company")
    public String test5(@RequestParam String name) {
        testService.addCompany(name);
        return "success";
    }


    @DeleteMapping("/del-relation")
    public String test3(@RequestBody AddSupplyRequest request) {
        return String.valueOf(testService.delRelation(request));
    }

    @GetMapping("/get-relation")
    public SupplyRelationship test4(@RequestBody AddSupplyRequest request) {
        SupplyRelationship relationship = testService.getRelation(request);
        System.out.printf("relationShip = %s \n\r",
                null == relationship ? "null" : relationship.toString());
        return relationship;
    }


}
