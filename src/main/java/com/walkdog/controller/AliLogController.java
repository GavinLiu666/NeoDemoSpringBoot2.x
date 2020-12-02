package com.walkdog.controller;

import com.walkdog.entity.request.LogRequest;
import com.walkdog.service.AliLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu_y
 */
@RestController
@RequestMapping("/log")
public class AliLogController {

    private final AliLogService aliLogService;


    public AliLogController(AliLogService aliLogService) {
        this.aliLogService = aliLogService;
    }

    @PostMapping("/get-log-by-date")
    public String test1(@RequestBody LogRequest request) {
        aliLogService.requestLog(request);
        return "ok";
    }


}
