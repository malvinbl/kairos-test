package com.kairos.test.pvp.domain.repository;

import com.kairos.test.pvp.domain.model.PriceDetail;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public interface PriceRepository {

    Stream<PriceDetail> findPricingDetails(Long productId, Long brandId, LocalDateTime date);

}
