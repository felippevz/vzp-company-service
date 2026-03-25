package dev.felippevaz.vzp_company_service.modules.inventory.controller;

import dev.felippevaz.vzp_company_service.modules.inventory.dto.request.InventoryRequestDTO;
import dev.felippevaz.vzp_company_service.modules.inventory.dto.response.InventoryResponseDTO;
import dev.felippevaz.vzp_company_service.modules.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<InventoryResponseDTO>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<InventoryResponseDTO> create(@RequestBody @Valid InventoryRequestDTO inventoryRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(inventoryRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryResponseDTO> update(@PathVariable Long id, @RequestBody @Valid InventoryRequestDTO inventoryRequestDTO) {
        return ResponseEntity.ok(this.service.update(id, inventoryRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
