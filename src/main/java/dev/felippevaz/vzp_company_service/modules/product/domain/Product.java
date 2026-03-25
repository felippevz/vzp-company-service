package dev.felippevaz.vzp_company_service.modules.product.domain;

import dev.felippevaz.vzp_company_service.common.domain.BaseEntity;
import dev.felippevaz.vzp_company_service.modules.inventory.domain.Inventory;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;

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

    @OneToMany(mappedBy = "product")
    private List<Inventory> inventories;
}
