package com.nrabello.back.service.impl;

import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.service.IFacade;
import com.nrabello.back.strategies.impl.pricingGroup.FindAllPricingGroupStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PricingGroupFacade implements IFacade<PricingGroup> {

    @Autowired
    FindAllPricingGroupStrategy findAllPricingGroupStrategy;

    @Override
    public List<PricingGroup> findAll() {
        return findAllPricingGroupStrategy.process(new PricingGroup());
    }

}
