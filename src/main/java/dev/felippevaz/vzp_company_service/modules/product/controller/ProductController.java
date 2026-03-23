package dev.felippevaz.vzp_company_service.modules.product.controller;

import dev.felippevaz.vzp_company_service.modules.product.dto.request.ProductRequestDTO;
import dev.felippevaz.vzp_company_service.modules.product.dto.response.ProductResponseDTO;
import dev.felippevaz.vzp_company_service.modules.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(productRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(this.service.update(id, productRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
