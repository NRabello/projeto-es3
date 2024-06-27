package com.nrabello.back.controllers.impl;

import com.nrabello.back.controllers.IController;
import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.service.impl.PricingGroupFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/pricingGroup")
@RestController
@Component
public class PricingGroupController implements IController {

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
}
