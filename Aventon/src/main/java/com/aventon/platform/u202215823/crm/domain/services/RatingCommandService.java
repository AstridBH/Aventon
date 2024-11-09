package com.aventon.platform.u202215823.crm.domain.services;

import com.aventon.platform.u202215823.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202215823.crm.domain.model.command.CreateRatingCommand;

import java.util.Optional;

public interface RatingCommandService {
    Optional<Rating> handle(CreateRatingCommand command);
}
