package com.nrabello.back.service;

import com.nrabello.back.domain.ReasonActivationDeactivation;
import com.nrabello.back.strategies.ReasonActivationDeactivation.SaveReasonActiDeactStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReasonActivationDeactivationFacade implements IFacade<ReasonActivationDeactivation>{

    @Autowired
    SaveReasonActiDeactStrategy saveReasonActiDeactStrategy;

    @Override
    public List<ReasonActivationDeactivation> findAll() {
        return null;
    }

    @Override
    public ReasonActivationDeactivation findById(Long id) {
        return null;
    }

    @Override
    public List<ReasonActivationDeactivation> find(String filter) {
        return null;
    }

    @Override
    public void save(ReasonActivationDeactivation reasonActivationDeactivation) {
        saveReasonActiDeactStrategy.process(reasonActivationDeactivation);
    }

    @Override
    public void update(ReasonActivationDeactivation reasonActivationDeactivation) {

    }

    @Override
    public void delete(Long id) {

    }
}
