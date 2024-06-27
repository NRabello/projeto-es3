package com.nrabello.back.controllers.impl;

import com.nrabello.back.controllers.IControllerReason;
import com.nrabello.back.domain.ReasonActivationDeactivation;
import com.nrabello.back.service.impl.ReasonActivationDeactivationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/reason")
@RestController
@Component
public class ReasonActivationDeactivationController implements IControllerReason {

    @Autowired
    ReasonActivationDeactivationFacade facade;

    @Override
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(facade.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
}
