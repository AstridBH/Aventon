package com.aventon.platform.u202215823.crm.infrastructure.persistence.jpa.repositories;

import com.aventon.platform.u202215823.crm.domain.model.entities.RatingAspect;
import com.aventon.platform.u202215823.crm.domain.model.valueobjects.RatingAspects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingAspectsRepository extends JpaRepository<RatingAspect, Long> {
    Optional<RatingAspect> findById(Long id);
    boolean existsByName(RatingAspects name);
}
