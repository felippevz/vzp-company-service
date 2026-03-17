package dev.felippevaz.vzp_company_service.modules.company.controller;

import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import dev.felippevaz.vzp_company_service.modules.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findCompanies() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(company));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> readCompany(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.read(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
