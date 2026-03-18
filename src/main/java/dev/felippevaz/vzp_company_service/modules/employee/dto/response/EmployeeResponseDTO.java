package dev.felippevaz.vzp_company_service.modules.employee.dto.response;

import dev.felippevaz.vzp_company_service.common.domain.Address;

public record EmployeeResponseDTO(
        Long id,
        String name,
        String email,
        Address address,
        Long department //todo: return simple departmentDTO later
) {}
