package com.techvify.interview.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IService<E> {
    ResponseEntity<Map<String,Object>> getAllPagination(int page, int size);
}
