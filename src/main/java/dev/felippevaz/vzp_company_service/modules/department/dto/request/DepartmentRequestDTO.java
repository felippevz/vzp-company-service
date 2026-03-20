package dev.felippevaz.vzp_company_service.modules.department.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DepartmentRequestDTO(

        @NotNull
        String name,

        String location,

        @NotNull
        @Positive
        Long managerId
) {}