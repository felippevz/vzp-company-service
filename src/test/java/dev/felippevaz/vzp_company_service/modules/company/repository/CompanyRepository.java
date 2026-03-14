package dev.felippevaz.vzp_company_service.modules.company.repository;

import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
