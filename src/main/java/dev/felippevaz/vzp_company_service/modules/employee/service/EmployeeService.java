package dev.felippevaz.vzp_company_service.modules.employee.service;

import dev.felippevaz.vzp_company_service.common.infrastructure.CompanySpecification;
import dev.felippevaz.vzp_company_service.exceptions.ServiceException;
import dev.felippevaz.vzp_company_service.modules.employee.domain.Employee;
import dev.felippevaz.vzp_company_service.modules.employee.dto.request.EmployeeRequestDTO;
import dev.felippevaz.vzp_company_service.modules.employee.dto.response.EmployeeResponseDTO;
import dev.felippevaz.vzp_company_service.modules.employee.mapper.EmployeeMapper;
import dev.felippevaz.vzp_company_service.modules.employee.repository.EmployeeRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper employeeMapper) {
        this.repository = repository;
        this.mapper = employeeMapper;
    }

    public List<EmployeeResponseDTO> findAll() {
        return this.mapper.toResponseDTOList(this.repository.findAll(
                Specification.where(CompanySpecification.byCompany())
        ));
    }

    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO) {
        return this.mapper.toResponseDTO(
                this.repository.save(this.mapper.toEntity(employeeRequestDTO))
        );
    }

    public EmployeeResponseDTO read(Long id) {
        return this.mapper.toResponseDTO(getEmployee(id));
    }

    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO employeeRequestDTO) {

        Employee employee = getEmployee(id);

        this.mapper.updateEntityFromDTO(employeeRequestDTO, employee);

        return this.mapper.toResponseDTO(this.repository.save(employee));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    private Employee getEmployee(Long id) {
        return this.repository.findOne(
                Specification.<Employee>where(CompanySpecification.byCompany())
                        .and(CompanySpecification.byId(id))
        ).orElseThrow(() -> new ServiceException("employee.not.found", HttpStatus.NOT_FOUND));
    };
}
