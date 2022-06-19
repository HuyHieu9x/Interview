package com.techvify.interview.controller;

import com.techvify.interview.service.impl.InterviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {
    @Autowired
    private InterviewerService interviewerService;

    @GetMapping("/{page}/{size}")
    public ResponseEntity<Map<String,Object>> getAllPagination(@PathVariable("page") int page,
                                                               @PathVariable("size") int size){
        return interviewerService.getAllPagination(page,size);
    }
}
