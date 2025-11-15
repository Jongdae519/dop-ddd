package com.example.modularmonolith.customer.domain.model;


import com.example.modularmonolith.customer.domain.enums.TaxType;

public record Customer(
        String id,
        TaxType taxType
) {
}
