package com.nrabello.back.database.impl;

import com.nrabello.back.database.IDao;
import com.nrabello.back.domain.ReasonActivationDeactivation;
import com.nrabello.back.repositories.ReasonActivationDeactivationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReasonActivationDeactivationDao implements IDao<ReasonActivationDeactivation> {

    @Autowired
    ReasonActivationDeactivationRepository repository;

    @Override
    public List<ReasonActivationDeactivation> findAll() {
        return null;
    }

    @Override
    public Optional<ReasonActivationDeactivation> findById(Long id) {
        return null;
    }

    @Override
    public List<ReasonActivationDeactivation> find(String filter) {
        return null;
    }

    @Override
    public void save(ReasonActivationDeactivation reasonActivationDeactivation) {
        repository.save(reasonActivationDeactivation);
    }

    @Override
    public void update(ReasonActivationDeactivation reasonActivationDeactivation) {

    }

    @Override
    public void delete(Long id) {

    }
}
