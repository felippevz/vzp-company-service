package dev.felippevaz.vzp_company_service.modules.inventory.service;

import dev.felippevaz.vzp_company_service.common.infrastructure.CompanySpecification;
import dev.felippevaz.vzp_company_service.exceptions.ServiceException;
import dev.felippevaz.vzp_company_service.modules.inventory.domain.Inventory;
import dev.felippevaz.vzp_company_service.modules.inventory.dto.request.InventoryRequestDTO;
import dev.felippevaz.vzp_company_service.modules.inventory.dto.response.InventoryResponseDTO;
import dev.felippevaz.vzp_company_service.modules.inventory.mapper.InventoryMapper;
import dev.felippevaz.vzp_company_service.modules.inventory.repository.InventoryRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repository;
    private final InventoryMapper mapper;

    public InventoryService(InventoryRepository repository, InventoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<InventoryResponseDTO> findAll() {
        return this.mapper.toResponseDTO(this.repository.findAll(
                Specification.where(CompanySpecification.byCompany())
        ));
    }

    public InventoryResponseDTO create(InventoryRequestDTO inventoryRequestDTO) {
        return this.mapper.toResponseDTO(
                this.repository.save(this.mapper.toEntity(inventoryRequestDTO)
        ));
    }

    public InventoryResponseDTO read(Long id) {
        return this.mapper.toResponseDTO(getInventory(id));
    }

    public InventoryResponseDTO update(Long id, InventoryRequestDTO inventoryRequestDTO) {

        Inventory inventory = getInventory(id);

        this.mapper.updateEntityFromDTO(inventoryRequestDTO, inventory);

        return this.mapper.toResponseDTO(this.repository.save(inventory));

    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public Inventory getInventory(Long id) {
        return this.repository.findOne(
                Specification.<Inventory>where(CompanySpecification.byCompany())
                        .and(CompanySpecification.byId(id))
        ).orElseThrow(() -> new ServiceException("inventory.not.found", HttpStatus.NOT_FOUND));
    }
}
