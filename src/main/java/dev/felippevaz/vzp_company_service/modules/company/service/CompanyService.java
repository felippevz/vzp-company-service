package dev.felippevaz.vzp_company_service.modules.company.service;

import dev.felippevaz.vzp_company_service.exceptions.ServiceException;
import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import dev.felippevaz.vzp_company_service.modules.company.dto.request.CompanyRequestDTO;
import dev.felippevaz.vzp_company_service.modules.company.dto.response.CompanyResponseDTO;
import dev.felippevaz.vzp_company_service.modules.company.mapper.CompanyMapper;
import dev.felippevaz.vzp_company_service.modules.company.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository repository, CompanyMapper companyMapper) {
        this.repository = repository;
        this.companyMapper = companyMapper;
    }

    public List<CompanyResponseDTO> findAll() {
        return this.companyMapper.toResponseDTOList(this.repository.findAll());
    }

    public CompanyResponseDTO create(CompanyRequestDTO companyRequestDTO) {
        return this.companyMapper.toResponseDTO(
                this.repository.save(this.companyMapper.toEntity(companyRequestDTO))
        );
    }

    public CompanyResponseDTO read(Long id) {
        return this.companyMapper.toResponseDTO(getCompany(id));
    }

    public CompanyResponseDTO update(Long id, CompanyRequestDTO updatedCompany) {

        Company company = getCompany(id);

        this.companyMapper.updateEntityFromDTO(updatedCompany, company);

        return this.companyMapper.toResponseDTO(this.repository.save(company));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    private Company getCompany(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ServiceException("company.not.found", HttpStatus.NOT_FOUND, id));
    }
}

