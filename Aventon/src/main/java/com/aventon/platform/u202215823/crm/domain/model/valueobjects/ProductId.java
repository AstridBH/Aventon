package com.aventon.platform.u202215823.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductId(Long productId) {
    public ProductId {
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("productId must be a positive non-null value");
        }
    }
}
