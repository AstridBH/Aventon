package com.aventon.platform.u202215823.crm.domain.model.entities;

import com.aventon.platform.u202215823.crm.domain.model.valueobjects.RatingAspects;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class RatingAspect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RatingAspects name;

    public RatingAspect(){}

    public RatingAspect(RatingAspects name){
        this.name = name;
    }
}
