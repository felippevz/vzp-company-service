package dev.felippevaz.vzp_company_service.modules.product.mapper;

import dev.felippevaz.vzp_company_service.modules.product.domain.Product;
import dev.felippevaz.vzp_company_service.modules.product.dto.request.ProductRequestDTO;
import dev.felippevaz.vzp_company_service.modules.product.dto.response.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    Product toEntity(ProductRequestDTO productRequestDTO);

    ProductResponseDTO toResponseDTO(Product product);

    List<ProductResponseDTO> toResponseDTO(List<Product> products);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    void updateEntityFromDTO(ProductRequestDTO productRequestDTO, Product product);
}
