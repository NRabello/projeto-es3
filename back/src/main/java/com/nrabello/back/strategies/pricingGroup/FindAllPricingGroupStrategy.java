package com.nrabello.back.strategies.pricingGroup;

import com.nrabello.back.database.PricingGroupDao;
import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllPricingGroupStrategy implements IStrategy<PricingGroup> {

    @Autowired
    PricingGroupDao dao;

    @Override
    public List<PricingGroup> process(PricingGroup pricingGroup) {
        return dao.findAll();
    }
}
