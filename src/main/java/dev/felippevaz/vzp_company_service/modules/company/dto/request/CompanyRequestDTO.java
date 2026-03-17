package dev.felippevaz.vzp_company_service.modules.company.dto.request;

import dev.felippevaz.vzp_company_service.common.domain.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CompanyRequestDTO(

        @NotBlank
        String name,

        @NotBlank
        String cnpj,

        List<@Email String> emails,

        List<String> phones,

        @NotNull
        Address address,

        LocalDate foundation

) {}