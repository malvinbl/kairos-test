package com.kairos.test.pvp.infrastructure.http.controller.mapper;

import com.kairos.test.pvp.domain.model.PriceDetail;
import com.kairos.test.pvp.infrastructure.http.controller.dto.PriceDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public PriceDetailResponse toPriceDetailResponse(PriceDetail priceDetail) {
        return new PriceDetailResponse(
            priceDetail.productId(),
            priceDetail.brandId(),
            priceDetail.priceList(),
            priceDetail.startDate(),
            priceDetail.entDate(),
            priceDetail.price()
        );
    }

}
