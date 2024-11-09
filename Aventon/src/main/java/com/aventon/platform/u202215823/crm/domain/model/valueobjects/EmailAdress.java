package com.aventon.platform.u202215823.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EmailAdress(String email) {
    public EmailAdress {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email address must not be null or empty");
        }
        if (email.length() > 50) {
            throw new IllegalArgumentException("Email address must not exceed 50 characters");
        }
    }
}
