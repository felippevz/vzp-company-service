package dev.felippevaz.vzp_company_service.modules.company.service;

import dev.felippevaz.vzp_company_service.exceptions.ServiceException;
import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import dev.felippevaz.vzp_company_service.modules.company.dto.request.CompanyRequestDTO;
import dev.felippevaz.vzp_company_service.modules.company.dto.response.CompanyResponseDTO;
import dev.felippevaz.vzp_company_service.modules.company.mapper.CompanyMapper;
import dev.felippevaz.vzp_company_service.modules.company.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    public CompanyService(CompanyRepository repository, CompanyMapper companyMapper) {
        this.repository = repository;
        this.mapper = companyMapper;
    }

    public List<CompanyResponseDTO> findAll() {
        return this.mapper.toResponseDTOList(this.repository.findAll());
    }

    public CompanyResponseDTO create(CompanyRequestDTO companyRequestDTO) {
        return this.mapper.toResponseDTO(
                this.repository.save(this.mapper.toEntity(companyRequestDTO))
        );
    }

    public CompanyResponseDTO read(Long id) {
        return this.mapper.toResponseDTO(getCompany(id));
    }

    public CompanyResponseDTO update(Long id, CompanyRequestDTO updatedCompany) {

        Company company = getCompany(id);

        this.mapper.updateEntityFromDTO(updatedCompany, company);

        return this.mapper.toResponseDTO(this.repository.save(company));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    private Company getCompany(Long id) {
        return this.repository.findById(id).orElseThrow(
                () -> new ServiceException("company.not.found", HttpStatus.NOT_FOUND, id)
        );
    }
}

