package dev.felippevaz.vzp_company_service.modules.department.service;

import dev.felippevaz.vzp_company_service.common.infrastructure.CompanySpecification;
import dev.felippevaz.vzp_company_service.exceptions.ServiceException;
import dev.felippevaz.vzp_company_service.modules.department.domain.Department;
import dev.felippevaz.vzp_company_service.modules.department.dto.request.DepartmentRequestDTO;
import dev.felippevaz.vzp_company_service.modules.department.dto.response.DepartmentResponseDTO;
import dev.felippevaz.vzp_company_service.modules.department.mapper.DepartmentMapper;
import dev.felippevaz.vzp_company_service.modules.department.repository.DepartmentRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DepartmentResponseDTO> findAll() {
        return this.mapper.toResponseDTO(this.repository.findAll());
    }

    public DepartmentResponseDTO create(DepartmentRequestDTO departmentRequestDTO) {
        return this.mapper.toResponseDTO(
                this.repository.save(this.mapper.toEntity(departmentRequestDTO))
        );
    }

    public DepartmentResponseDTO read(Long id) {
        return this.mapper.toResponseDTO(getDepartment(id));
    }

    public DepartmentResponseDTO update(Long id, DepartmentRequestDTO departmentRequestDTO) {

        Department department = getDepartment(id);

        this.mapper.updateEntityFromDTO(departmentRequestDTO, department);

        return this.mapper.toResponseDTO(this.repository.save(department));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public Department getDepartment(Long id) {
        return this.repository.findOne(
                Specification.<Department>where(CompanySpecification.byCompany())
                        .and(CompanySpecification.byId(id))
        ).orElseThrow(() -> new ServiceException("department.not.found", HttpStatus.NOT_FOUND));
    }
}
