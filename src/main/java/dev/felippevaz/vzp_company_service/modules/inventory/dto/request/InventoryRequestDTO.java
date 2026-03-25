package dev.felippevaz.vzp_company_service.modules.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record InventoryRequestDTO(

        @NotNull
        Long product_id,

        @Positive
        Integer quantity,

        @Positive
        Integer minimalAlert,

        //todo: create Object 'ZoneInfos' after

        @NotBlank
        String zone,

        @NotBlank
        String aisle,

        @NotBlank
        String codeAisle,

        @NotBlank
        String level

) {}
