package com.kairos.test.pvp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Table(name = "price")
@Entity
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "curr", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity productEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brandEntity;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "price_list_id", nullable = false, unique = true)
    private PriceListEntity priceList;

}
