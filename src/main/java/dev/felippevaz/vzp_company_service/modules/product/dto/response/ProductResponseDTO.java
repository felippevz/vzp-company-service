package dev.felippevaz.vzp_company_service.modules.product.dto.response;

import java.math.BigDecimal;

public record ProductResponseDTO(

        Long id,
        String sku,
        String name,
        String description,
        BigDecimal purchasePrice,
        BigDecimal salePrice,
        String category
        
) {}