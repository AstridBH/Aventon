package com.aventon.platform.u202215823.crm.infrastructure.persistence.jpa.repositories;


import com.aventon.platform.u202215823.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202215823.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202215823.crm.domain.model.valueobjects.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    boolean existsByUserEmailAddressAndProductIdAndRatingAspect_Id(EmailAdress userEmailAddress, ProductId productId, Long ratingAspectId);
}
