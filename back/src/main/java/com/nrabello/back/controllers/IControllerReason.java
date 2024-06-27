package com.nrabello.back.controllers;

import com.nrabello.back.domain.Book;
import com.nrabello.back.domain.ReasonActivationDeactivation;
import org.springframework.http.ResponseEntity;

public interface IControllerReason extends IController{
    ResponseEntity<?> save(ReasonActivationDeactivation reasonActivationDeactivation);
}
