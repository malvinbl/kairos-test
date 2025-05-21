package com.kairos.test.pvp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "price_list")
@Entity
public class PriceListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
