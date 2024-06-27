package com.nrabello.back.service;

import com.nrabello.back.domain.ReasonActivationDeactivation;

public interface IFacadeReason extends IFacade<ReasonActivationDeactivation>{

    void save(ReasonActivationDeactivation reasonActivationDeactivation);
}
