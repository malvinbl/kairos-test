package com.kairos.test.pvp.application;

import com.kairos.test.pvp.domain.model.PriceDetail;
import com.kairos.test.pvp.domain.repository.PriceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        PriceDetail priceDetail = priceRepository.findPricingDetails(productId, brandId, date)
                .max(pricePriorityComparator)
                .orElse(null);

        validateResponse(priceDetail);
        return priceDetail;
    }

    private void validateResponse(PriceDetail priceDetail) {
        if (priceDetail == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
