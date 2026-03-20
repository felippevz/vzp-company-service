package dev.felippevaz.vzp_company_service.modules.employee.mapper;

import dev.felippevaz.vzp_company_service.modules.employee.domain.Employee;
import dev.felippevaz.vzp_company_service.modules.employee.dto.request.EmployeeRequestDTO;
import dev.felippevaz.vzp_company_service.modules.employee.dto.response.EmployeeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    Employee toEntity(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO toResponseDTO(Employee employee);

    List<EmployeeResponseDTO> toResponseDTO(List<Employee> employees);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    void updateEntityFromDTO(EmployeeRequestDTO requestDTO, @MappingTarget Employee employee);
}
