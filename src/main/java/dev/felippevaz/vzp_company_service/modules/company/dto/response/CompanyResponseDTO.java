package dev.felippevaz.vzp_company_service.modules.company.dto.response;

import dev.felippevaz.vzp_company_service.common.domain.Address;

import java.time.LocalDate;
import java.util.List;

public record CompanyResponseDTO(

        Long id,
        String name,
        String cnpj,
        List<String> emails,
        List<String> phones,
        Address address,
        LocalDate foundation

) {}
