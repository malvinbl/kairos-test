package com.kairos.test.pvp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Table(name = "brand")
@Entity
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brandEntity", orphanRemoval = true)
    private List<PriceEntity> priceEntities;

}
