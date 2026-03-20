package dev.felippevaz.vzp_company_service.modules.company.mapper;

import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import dev.felippevaz.vzp_company_service.modules.company.dto.request.CompanyRequestDTO;
import dev.felippevaz.vzp_company_service.modules.company.dto.response.CompanyResponseDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CompanyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startedServiceAt", ignore = true)
    @Mapping(target = "departments", ignore = true)
    @Mapping(target = "status", ignore = true)
    Company toEntity(CompanyRequestDTO companyRequestDTO);

    CompanyResponseDTO toResponseDTO(Company company);

    List<CompanyResponseDTO> toResponseDTO(List<Company> companies);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startedServiceAt", ignore = true)
    @Mapping(target = "departments", ignore = true)
    @Mapping(target = "status", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(CompanyRequestDTO requestDTO, @MappingTarget Company company);
}
