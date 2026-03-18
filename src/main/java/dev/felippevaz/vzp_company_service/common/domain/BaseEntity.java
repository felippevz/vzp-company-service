package dev.felippevaz.vzp_company_service.common.domain;

import dev.felippevaz.vzp_company_service.common.infrastructure.CompanyContext;
import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @PrePersist
    public void prePersist() {

        Long id = CompanyContext.getCurrentTenant();

        Company company = new Company();
        company.setId(id);

        this.company = company;
    }
}
