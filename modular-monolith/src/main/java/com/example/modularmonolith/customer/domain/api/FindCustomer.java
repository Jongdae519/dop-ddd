package com.example.modularmonolith.customer.domain.api;

import com.example.modularmonolith.customer.domain.api.dto.CustomerDto;

import java.util.Optional;

public interface FindCustomer {

    Optional<CustomerDto> byId(String customerId);
}
