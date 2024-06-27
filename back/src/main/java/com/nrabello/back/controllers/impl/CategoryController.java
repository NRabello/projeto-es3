package com.nrabello.back.controllers.impl;

import com.nrabello.back.controllers.IController;
import com.nrabello.back.domain.Category;
import com.nrabello.back.service.impl.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/category")
@RestController
@Component
public class CategoryController implements IController {

    @Autowired
    CategoryFacade facade;

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
