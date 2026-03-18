package dev.felippevaz.vzp_company_service.common.infrastructure;

import dev.felippevaz.vzp_company_service.modules.company.repository.CompanyRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CompanyFilter extends OncePerRequestFilter {

    private final CompanyRepository repository;

    public CompanyFilter(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {

            String path = request.getRequestURI();

            if(!path.startsWith("/company")) {

                String companyIdHeader = request.getHeader("company-id");

                if(companyIdHeader == null) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "missing 'company-id'");
                    return;
                }

                Long id = Long.parseLong(companyIdHeader);

                if(!repository.existsById(id)) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "company.not.found");
                    return;
                }

                CompanyContext.setCurrentTenant(id);
            }

            filterChain.doFilter(request, response);
        } finally {
            CompanyContext.clear();
        }
    }
}
