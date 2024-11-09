package com.aventon.platform.u202215823.crm.domain.services;

import com.aventon.platform.u202215823.crm.domain.model.command.RatingAspectsCommand;

public interface RatingAspectsCommandService {
    void handle(RatingAspectsCommand command);
}
