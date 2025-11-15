package com.example.modularmonolith.customer.domain;

import com.example.modularmonolith.customer.domain.api.FindCustomer;
import com.example.modularmonolith.customer.domain.api.dto.CustomerDto;
import com.example.modularmonolith.customer.domain.model.Customer;
import com.example.modularmonolith.customer.domain.spi.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerQueryService implements FindCustomer {

    private final CustomerRepository customerRepository;

    public Optional<CustomerDto> byId(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(i -> new CustomerDto(i.id(), i.taxType().name()));
    }
}
