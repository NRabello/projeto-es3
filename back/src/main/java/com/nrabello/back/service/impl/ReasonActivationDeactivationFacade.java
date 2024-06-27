package com.nrabello.back.service.impl;

import com.nrabello.back.domain.ReasonActivationDeactivation;
import com.nrabello.back.service.IFacade;
import com.nrabello.back.service.IFacadeReason;
import com.nrabello.back.strategies.impl.ReasonActivationDeactivation.FindAllReasonsActivationDeactivationStrategy;
import com.nrabello.back.strategies.impl.ReasonActivationDeactivation.SaveReasonActiDeactStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ReasonActivationDeactivationFacade implements IFacadeReason {

    @Autowired
    SaveReasonActiDeactStrategy saveReasonActiDeactStrategy;

    @Autowired
    FindAllReasonsActivationDeactivationStrategy findAllReasonsActivationDeactivationStrategy;

    @Override
    public List<ReasonActivationDeactivation> findAll() {
        return findAllReasonsActivationDeactivationStrategy.process(new ReasonActivationDeactivation());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ReasonActivationDeactivation reasonActivationDeactivation) {
        saveReasonActiDeactStrategy.process(reasonActivationDeactivation);
    }

}
