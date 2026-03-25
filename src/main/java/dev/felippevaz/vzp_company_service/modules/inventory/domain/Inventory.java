package dev.felippevaz.vzp_company_service.modules.inventory.domain;

import dev.felippevaz.vzp_company_service.common.domain.BaseEntity;
import dev.felippevaz.vzp_company_service.modules.product.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inventory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private Integer minimalAlert;

    //todo: create Object 'ZoneInfos' after
    private String zone;
    private String aisle;
    private String codeAisle;
    private String level;
}
