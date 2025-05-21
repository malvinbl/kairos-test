package com.kairos.test.pvp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Table(name = "product")
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productEntity", orphanRemoval = true)
    private List<PriceEntity> priceEntities;

}
