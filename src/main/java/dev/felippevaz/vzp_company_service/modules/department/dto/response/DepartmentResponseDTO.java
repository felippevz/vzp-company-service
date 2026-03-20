package dev.felippevaz.vzp_company_service.modules.department.dto.response;

import dev.felippevaz.vzp_company_service.modules.employee.domain.Employee;

public record DepartmentResponseDTO(

        String name,
        String location,
        Employee manager

) {}
