package com.aventon.platform.u202215823.crm.application.internal.commandservices;

import com.aventon.platform.u202215823.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202215823.crm.domain.model.command.CreateRatingCommand;
import com.aventon.platform.u202215823.crm.domain.services.RatingCommandService;
import com.aventon.platform.u202215823.crm.infrastructure.persistence.jpa.repositories.RatingAspectsRepository;
import com.aventon.platform.u202215823.crm.infrastructure.persistence.jpa.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingCommandServiceImpl implements RatingCommandService {

    private final RatingRepository ratingRepository;
    private final RatingAspectsRepository ratingAspectsRepository;

    public RatingCommandServiceImpl(RatingRepository ratingRepository, RatingAspectsRepository ratingAspectsRepository) {
        this.ratingRepository = ratingRepository;
        this.ratingAspectsRepository = ratingAspectsRepository;
    }

    @Override
    public Optional<Rating> handle(CreateRatingCommand command) {
        if (ratingRepository.existsByUserEmailAddressAndProductIdAndRatingAspect_Id(
                (command.userEmailAddress()), command.productId(), command.ratingAspectId())) {
            throw new RuntimeException("Error: Rating already exists");
        }
        if (ratingAspectsRepository.findById(command.ratingAspectId()).isEmpty()) {
            throw new RuntimeException("Error: Rating Aspect does not exist");
        }
        var rating = new Rating(command.productId(), command.userEmailAddress(), ratingAspectsRepository.findById(command.ratingAspectId()).get(), command.comment(), command.ratedAt());
        ratingRepository.save(rating);
        return Optional.of(rating);
    }
}
