package com.aventon.platform.u202215823.crm.domain.model.command;

import com.aventon.platform.u202215823.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202215823.crm.domain.model.valueobjects.ProductId;

import java.util.Date;

public record CreateRatingCommand(ProductId productId, EmailAdress userEmailAddress, Long ratingAspectId, String comment, Date ratedAt) {
}
