package com.aventon.platform.u202215823.crm.interfaces.rest.transform;

import com.aventon.platform.u202215823.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202215823.crm.interfaces.rest.resources.RatingResource;

public class RatingResourceFromEntityAssembler {
    public static RatingResource toResourceFromEntity(Rating entity) {
        return new RatingResource(entity.getId(), entity.getProductId(), entity.getUserEmailAddress(), entity.getRatingAspect().getId(), entity.getComment(), entity.getRatedAt());
    }
}
