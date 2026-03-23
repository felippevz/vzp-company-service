package dev.felippevaz.vzp_company_service.modules.product.domain;

import dev.felippevaz.vzp_company_service.common.domain.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {

    private String sku;
    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String category;
}
