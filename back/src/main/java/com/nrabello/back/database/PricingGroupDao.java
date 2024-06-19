package com.nrabello.back.database;

import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.repositories.PricingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingGroupDao implements IDao<PricingGroup>{

    @Autowired
    PricingGroupRepository repository;


    @Override
    public List<PricingGroup> findAll() {
        return repository.findAll();
    }

    @Override
    public PricingGroup findById(Long id) {
        return null;
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
