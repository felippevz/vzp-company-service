package dev.felippevaz.vzp_company_service.modules.company.service;

import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import dev.felippevaz.vzp_company_service.modules.company.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> findAll() {
        return this.repository.findAll();
    }

    public Company create(Company company) {
        return this.repository.save(company);
    }

    public Company read(Long id) {
        return getCompany(id);
    }

    public Company update(Long id, Company updatedCompany) {

        Company Company = getCompany(id);
        BeanUtils.copyProperties(updatedCompany, Company);

        return Company;
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    private Company getCompany(Long id) {

        //todo: treat error later

        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company not found!"));
    }
}

