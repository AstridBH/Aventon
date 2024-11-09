package com.aventon.platform.u202215823.crm.application.internal.eventhandlers;

import com.aventon.platform.u202215823.crm.domain.model.command.RatingAspectsCommand;
import com.aventon.platform.u202215823.crm.domain.services.RatingAspectsCommandService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {

    private final RatingAspectsCommandService ratingAspectsCommandService;

    public ApplicationReadyEventHandler(RatingAspectsCommandService ratingAspectsCommandService) {
        this.ratingAspectsCommandService = ratingAspectsCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event){
        ratingAspectsCommandService.handle(new RatingAspectsCommand());
    }
}
