package com.nrabello.back.repositories;

import com.nrabello.back.domain.PricingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingGroupRepository extends JpaRepository<PricingGroup, Long>{
}
