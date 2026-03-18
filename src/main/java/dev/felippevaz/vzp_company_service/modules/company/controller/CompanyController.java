package dev.felippevaz.vzp_company_service.modules.company.controller;

import dev.felippevaz.vzp_company_service.modules.company.dto.request.CompanyRequestDTO;
import dev.felippevaz.vzp_company_service.modules.company.dto.response.CompanyResponseDTO;
import dev.felippevaz.vzp_company_service.modules.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> create(@RequestBody CompanyRequestDTO companyRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(companyRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> update(@PathVariable Long id, @RequestBody CompanyRequestDTO companyRequestDTO) {
        return ResponseEntity.ok(this.service.update(id, companyRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
