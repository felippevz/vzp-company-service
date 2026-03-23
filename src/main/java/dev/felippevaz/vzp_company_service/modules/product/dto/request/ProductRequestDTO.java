package dev.felippevaz.vzp_company_service.modules.product.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDTO(

        @NotNull
        String sku,

        @NotNull
        String name,
        String description,

        @NotNull
        @Positive
        BigDecimal purchasePrice,

        @NotNull
        @Positive
        BigDecimal salePrice,

        String category

) {}