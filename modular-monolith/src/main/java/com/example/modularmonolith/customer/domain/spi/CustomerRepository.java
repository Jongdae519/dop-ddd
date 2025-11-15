package com.example.modularmonolith.customer.domain.spi;

import com.example.modularmonolith.customer.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(String id);
}
