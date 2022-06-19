package com.techvify.interview.service.impl;

import com.techvify.interview.entity.Interviewer;
import com.techvify.interview.repository.IInterviewerRepository;
import com.techvify.interview.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InterviewerService implements IService {
    @Autowired
    private IInterviewerRepository interviewerRepository;

    @Override
    public ResponseEntity<Map<String,Object>> getAllPagination
            (int page,
             int size) {
        try {
            List<Interviewer> interviewers = new ArrayList<Interviewer>();
            Pageable pageable = PageRequest.of(page,size);

            Page<Interviewer> pageTuts = interviewerRepository.findAll(pageable);
            interviewers = pageTuts.getContent();

            Map<String,Object> response = new HashMap<>();

            response.put("interviewers",interviewers);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
