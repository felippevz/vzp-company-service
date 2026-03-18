package dev.felippevaz.vzp_company_service.modules.employee.dto.request;

import dev.felippevaz.vzp_company_service.common.domain.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequestDTO (

        @NotBlank
        String name,

        @Email
        String email,

        @NotNull
        Address address,

        @NotNull
        Long department //todo: return simple departmentDTO later
){}
