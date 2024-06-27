package com.nrabello.back.controllers;

import org.springframework.http.ResponseEntity;

public interface IController {
    ResponseEntity<?> findAll();
}
