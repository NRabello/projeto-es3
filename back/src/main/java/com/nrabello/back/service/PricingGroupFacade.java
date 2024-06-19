package com.nrabello.back.service;

import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.strategies.pricingGroup.FindAllPricingGroupStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PricingGroupFacade implements IFacade<PricingGroup>{

    @Autowired
    FindAllPricingGroupStrategy findAllPricingGroupStrategy;

    @Override
    public List<PricingGroup> findAll() {
        return findAllPricingGroupStrategy.process(new PricingGroup());
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

    }

    @Override
    public void update(PricingGroup pricingGroup) {

    }

    @Override
    public void delete(Long id) {

    }
}
