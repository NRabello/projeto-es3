package com.nrabello.back.controllers;

import com.nrabello.back.domain.ReasonActivationDeactivation;
import com.nrabello.back.service.ReasonActivationDeactivationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/reason")
@RestController
@Component
public class ReasonActivationDeactivationController implements IController<ReasonActivationDeactivation>{

    @Autowired
    ReasonActivationDeactivationFacade facade;

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> find(String filter) {
        return null;
    }

    @Override
    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody ReasonActivationDeactivation reasonActivationDeactivation) {
        try {
            facade.save(reasonActivationDeactivation);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> update(ReasonActivationDeactivation reasonActivationDeactivation) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }
}
