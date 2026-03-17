package dev.felippevaz.vzp_company_service.common.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    private String street;
    private String number;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
