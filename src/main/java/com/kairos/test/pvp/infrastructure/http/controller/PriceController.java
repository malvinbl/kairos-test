package com.kairos.test.pvp.infrastructure.http.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kairos.test.pvp.application.PriceDetailUseCase;
import com.kairos.test.pvp.domain.model.PriceDetail;
import com.kairos.test.pvp.infrastructure.http.controller.dto.PriceDetailResponse;
import com.kairos.test.pvp.infrastructure.http.controller.mapper.PriceMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Tag(name = "Price Controller")
@RequiredArgsConstructor
@RequestMapping("/prices")
@RestController
public class PriceController {

    private final PriceDetailUseCase priceDetailUseCase;
    private final PriceMapper priceMapper;

    @Operation(summary = "Get price detail")
    @GetMapping("/detail")
    public ResponseEntity<PriceDetailResponse> getPriceDetail(
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @RequestParam(name = "date")
        LocalDateTime date,

        @RequestParam(name = "productId")
        Long productId,

        @RequestParam(name = "brandId")
        Long brandId
    ) {
        PriceDetail priceDetail = priceDetailUseCase.getPriceDetail(productId, brandId, date);
        PriceDetailResponse response = priceMapper.toPriceDetailResponse(priceDetail);
        return ResponseEntity.ok(response);
    }

}
