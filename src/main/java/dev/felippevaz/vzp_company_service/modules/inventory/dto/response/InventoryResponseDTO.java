package dev.felippevaz.vzp_company_service.modules.inventory.dto.response;

import dev.felippevaz.vzp_company_service.modules.product.domain.Product;

public record InventoryResponseDTO(

        Long id,
        Product product,
        Integer quantity,
        Integer minimalAlert,

        //todo: create Object 'ZoneInfos' after
        String zone,
        String aisle,
        String codeAisle,
        String level
) {}
