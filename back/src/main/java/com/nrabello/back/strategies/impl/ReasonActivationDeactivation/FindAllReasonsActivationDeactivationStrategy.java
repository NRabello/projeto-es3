package com.nrabello.back.strategies.impl.ReasonActivationDeactivation;

import com.nrabello.back.database.impl.ReasonActivationDeactivationDao;
import com.nrabello.back.domain.ReasonActivationDeactivation;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllReasonsActivationDeactivationStrategy implements IStrategy<ReasonActivationDeactivation> {

    @Autowired
    ReasonActivationDeactivationDao dao;

    @Override
    public List<ReasonActivationDeactivation> process(ReasonActivationDeactivation reasonActivationDeactivation) {
        return dao.findAll();
    }
}
