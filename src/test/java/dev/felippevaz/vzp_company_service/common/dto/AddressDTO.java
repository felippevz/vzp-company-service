package dev.felippevaz.vzp_company_service.common.dto;

public record AddressDTO(

        String street,
        String number,
        String city,
        String state,
        String country,
        String zipCode

) {}