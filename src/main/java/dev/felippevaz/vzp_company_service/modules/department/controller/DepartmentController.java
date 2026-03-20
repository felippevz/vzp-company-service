package dev.felippevaz.vzp_company_service.modules.department.controller;

import dev.felippevaz.vzp_company_service.modules.department.dto.request.DepartmentRequestDTO;
import dev.felippevaz.vzp_company_service.modules.department.dto.response.DepartmentResponseDTO;
import dev.felippevaz.vzp_company_service.modules.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deparment")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> create(@RequestBody @Valid DepartmentRequestDTO departmentRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(departmentRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> update(@PathVariable Long id, @RequestBody @Valid DepartmentRequestDTO departmentRequestDTO) {
        return ResponseEntity.ok(this.service.update(id, departmentRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
