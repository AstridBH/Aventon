package com.aventon.platform.u202215823.crm.interfaces.rest.transform;

import com.aventon.platform.u202215823.crm.domain.model.command.CreateRatingCommand;
import com.aventon.platform.u202215823.crm.interfaces.rest.resources.CreateRatingResource;

public class CreateRatingCommandFromResourceAssembler {
    public static CreateRatingCommand toCommandFromResource(CreateRatingResource resource) {
        return new CreateRatingCommand(resource.productId(), resource.userEmailAddress(), resource.ratingAspectId(), resource.comment(), resource.ratedAt());
    }
}
