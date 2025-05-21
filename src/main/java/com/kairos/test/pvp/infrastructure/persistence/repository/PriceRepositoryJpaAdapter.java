package com.kairos.test.pvp.infrastructure.persistence.repository;

import com.kairos.test.pvp.domain.model.PriceDetail;
import com.kairos.test.pvp.domain.repository.PriceRepository;
import com.kairos.test.pvp.infrastructure.persistence.entity.PriceEntity;
import com.kairos.test.pvp.infrastructure.persistence.mapper.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Repository
public class PriceRepositoryJpaAdapter implements PriceRepository {

    private final JpaPriceRepository jpaPriceRepository;
    private final PriceEntityMapper priceEntityMapper;

    @Override
    public Stream<PriceDetail> findPricingDetails(Long productId, Long brandId, LocalDateTime date) {
        Stream<PriceEntity> priceEntities = jpaPriceRepository.findByParams(productId, brandId, date);
        return priceEntityMapper.toPriceDetailStream(priceEntities);
    }

}
