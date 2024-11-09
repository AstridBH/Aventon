package com.aventon.platform.u202215823.crm.domain.model.aggregates;

import com.aventon.platform.u202215823.crm.domain.model.entities.RatingAspect;
import com.aventon.platform.u202215823.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202215823.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202215823.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

/**
 * Rating Aggregate Root
 * The Rating class is an aggregate root that represents a rating of a bicycle product.
 */

@Entity
@Getter
public class Rating extends AuditableAbstractAggregateRoot<Rating> {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "product_id", nullable = false))
    private ProductId productId;

    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "user_email_address", nullable = false))
    private EmailAdress userEmailAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rating_aspect_id")
    private RatingAspect ratingAspect;

    @Column(nullable = false)
    @Size(max = 360)
    private String comment;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratedAt;

    public Rating(){}

    public Rating(ProductId productId, EmailAdress userEmailAddress, RatingAspect ratingAspect, String comment, Date ratedAt) {
        this.productId = productId;
        this.userEmailAddress = userEmailAddress;
        this.ratingAspect = ratingAspect;
        this.comment = comment;
        this.ratedAt = new Date();
    }

    @PrePersist
    protected void onCreate() {
        this.ratedAt = new Date();
    }
}