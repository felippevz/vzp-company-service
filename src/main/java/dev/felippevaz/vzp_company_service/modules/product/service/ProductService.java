package dev.felippevaz.vzp_company_service.modules.product.service;

import dev.felippevaz.vzp_company_service.common.infrastructure.CompanySpecification;
import dev.felippevaz.vzp_company_service.exceptions.ServiceException;
import dev.felippevaz.vzp_company_service.modules.product.domain.Product;
import dev.felippevaz.vzp_company_service.modules.product.dto.request.ProductRequestDTO;
import dev.felippevaz.vzp_company_service.modules.product.dto.response.ProductResponseDTO;
import dev.felippevaz.vzp_company_service.modules.product.mapper.ProductMapper;
import dev.felippevaz.vzp_company_service.modules.product.repository.ProductRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProductResponseDTO> findAll() {
        return this.mapper.toResponseDTO(this.repository.findAll(
                Specification.where(CompanySpecification.byCompany())
        ));
    }

    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        return this.mapper.toResponseDTO(
                this.repository.save(this.mapper.toEntity(productRequestDTO)));
    }

    public ProductResponseDTO read(Long id) {
        return this.mapper.toResponseDTO(getProduct(id));
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {

        Product product = getProduct(id);

        this.mapper.updateEntityFromDTO(productRequestDTO, product);

        return this.mapper.toResponseDTO(this.repository.save(product));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    protected Product getProduct(Long id) {
        return this.repository.findOne(
                Specification.<Product>where(CompanySpecification.byCompany())
                        .and(CompanySpecification.byId(id))
        ).orElseThrow(() -> new ServiceException("product.not.found", HttpStatus.NOT_FOUND));
    }
}
