package com.kairos.test.pvp.infrastructure.persistence.mapper;

import com.kairos.test.pvp.domain.model.PriceDetail;
import com.kairos.test.pvp.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class PriceEntityMapper {

    public Stream<PriceDetail> toPriceDetailStream(Stream<PriceEntity> priceEntities) {
        return priceEntities.map(this::toPriceDetail);
    }

    private PriceDetail toPriceDetail(PriceEntity priceEntity) {
        return new PriceDetail(
            priceEntity.getStartDate(),
            priceEntity.getEndDate(),
            priceEntity.getProductEntity().getId(),
            priceEntity.getBrandEntity().getId(),
            priceEntity.getPriceList().getId(),
            priceEntity.getPriority(),
            priceEntity.getPrice()
        );
    }

}
