package dev.felippevaz.vzp_company_service.modules.employee.controller;

import dev.felippevaz.vzp_company_service.modules.employee.dto.request.EmployeeRequestDTO;
import dev.felippevaz.vzp_company_service.modules.employee.dto.response.EmployeeResponseDTO;
import dev.felippevaz.vzp_company_service.modules.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(employeeRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@PathVariable Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return ResponseEntity.ok(this.service.update(id, employeeRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
