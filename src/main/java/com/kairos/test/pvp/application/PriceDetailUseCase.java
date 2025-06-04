package com.kairos.test.pvp.application;

import com.kairos.test.pvp.domain.model.PriceDetail;
import com.kairos.test.pvp.domain.repository.PriceRepository;
import com.kairos.test.pvp.domain.exception.PriceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
public class PriceDetailUseCase {

    private final PriceRepository priceRepository;
    private final Comparator<PriceDetail> pricePriorityComparator;

    public PriceDetailUseCase(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
        this.pricePriorityComparator = Comparator.comparing(PriceDetail::priority);
    }

    @Transactional(readOnly = true)
    public PriceDetail getPriceDetail(Long productId, Long brandId, LocalDateTime date) {
        return priceRepository.findPricingDetails(productId, brandId, date)
                .max(pricePriorityComparator)
                .orElseThrow(PriceNotFoundException::new);
    }

}
