package dev.felippevaz.vzp_company_service.modules.inventory.mapper;

import dev.felippevaz.vzp_company_service.modules.inventory.domain.Inventory;
import dev.felippevaz.vzp_company_service.modules.inventory.dto.request.InventoryRequestDTO;
import dev.felippevaz.vzp_company_service.modules.inventory.dto.response.InventoryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface InventoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    Inventory toEntity(InventoryRequestDTO inventoryRequestDTO);

    InventoryResponseDTO toResponseDTO(Inventory inventory);

    List<InventoryResponseDTO> toResponseDTO(List<Inventory> inventories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    void updateEntityFromDTO(InventoryRequestDTO requestDTO, @MappingTarget Inventory inventory);
}
