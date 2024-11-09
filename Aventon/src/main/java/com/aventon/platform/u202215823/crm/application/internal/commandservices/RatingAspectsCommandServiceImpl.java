package com.aventon.platform.u202215823.crm.application.internal.commandservices;

import com.aventon.platform.u202215823.crm.domain.model.command.RatingAspectsCommand;
import com.aventon.platform.u202215823.crm.domain.model.entities.RatingAspect;
import com.aventon.platform.u202215823.crm.domain.model.valueobjects.RatingAspects;
import com.aventon.platform.u202215823.crm.domain.services.RatingAspectsCommandService;
import com.aventon.platform.u202215823.crm.infrastructure.persistence.jpa.repositories.RatingAspectsRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RatingAspectsCommandServiceImpl implements RatingAspectsCommandService {
   private final RatingAspectsRepository ratingAspectsRepository;

    public RatingAspectsCommandServiceImpl(RatingAspectsRepository ratingAspectsRepository) {
         this.ratingAspectsRepository = ratingAspectsRepository;
    }

    @Override
    public void handle(RatingAspectsCommand command) {
        Arrays.stream(RatingAspects.values()).forEach(ratingAspects -> {
            if (!ratingAspectsRepository.existsByName(ratingAspects)) {
                ratingAspectsRepository.save(new RatingAspect(ratingAspects));
            }
        });
    }
}
