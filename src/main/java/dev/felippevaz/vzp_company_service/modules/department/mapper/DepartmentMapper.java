package dev.felippevaz.vzp_company_service.modules.department.mapper;

import dev.felippevaz.vzp_company_service.modules.department.domain.Department;
import dev.felippevaz.vzp_company_service.modules.department.dto.request.DepartmentRequestDTO;
import dev.felippevaz.vzp_company_service.modules.department.dto.response.DepartmentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {DepartmentMapperUtil.class})

public interface DepartmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "manager", source = "managerId", qualifiedByName = "getEntity")
    Department toEntity(DepartmentRequestDTO departmentRequestDTO);

    DepartmentResponseDTO toResponseDTO(Department department);

    List<DepartmentResponseDTO> toResponseDTO(List<Department> departments);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "manager", source = "managerId", qualifiedByName = "getEntity")
    void updateEntityFromDTO(DepartmentRequestDTO departmentRequestDTO, @MappingTarget Department department);
}
