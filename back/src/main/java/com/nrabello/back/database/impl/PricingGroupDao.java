package com.nrabello.back.database.impl;

import com.nrabello.back.database.IDao;
import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.repositories.PricingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PricingGroupDao implements IDao<PricingGroup> {

    @Autowired
    PricingGroupRepository repository;


    @Override
    public List<PricingGroup> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PricingGroup> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PricingGroup> find(String filter) {
        return null;
    }

    @Override
    public void save(PricingGroup pricingGroup) {
        repository.save(pricingGroup);
    }

    @Override
    public void update(PricingGroup pricingGroup) {

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
