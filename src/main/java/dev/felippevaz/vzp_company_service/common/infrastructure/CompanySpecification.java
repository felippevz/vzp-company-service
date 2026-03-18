package dev.felippevaz.vzp_company_service.common.infrastructure;

import dev.felippevaz.vzp_company_service.exceptions.ServiceException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;

public class CompanySpecification {

    public static <T> Specification<T> byCompany() {
        return (root, query, criteriaBuilder) -> {

            Long id = CompanyContext.getCurrentTenant();

            if(id == null) {
                throw new ServiceException("company.not.found", HttpStatus.NOT_FOUND);
            }

            return criteriaBuilder.equal(root.get("company").get("id"), id);
        };
    }

    public static <T> Specification<T> byId(Long id) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"), id));
    }
}
