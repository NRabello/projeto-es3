package com.nrabello.back.controllers;

import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.service.PricingGroupFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/pricingGroup")
@RestController
@Component
public class PricingGroupController implements IController<PricingGroup>{

    @Autowired
    PricingGroupFacade facade;

    @Override
    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(facade.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    @GetMapping(value = "/findById")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    @GetMapping(value = "/find")
    public ResponseEntity<?> find(@RequestBody String filter) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody PricingGroup pricingGroup) {
        try {
            facade.save(pricingGroup);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PatchMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody PricingGroup pricingGroup) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    @GetMapping(value = "/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
