package com.example.modularmonolith.customer.infrastructure.db;

import com.example.modularmonolith.customer.domain.enums.TaxType;
import com.example.modularmonolith.customer.domain.model.Customer;
import com.example.modularmonolith.customer.domain.spi.CustomerRepository;
import com.example.modularmonolith.customer.infrastructure.db.table.CustomerTable;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<String, CustomerTable> tables = new ConcurrentHashMap<>();

    @Override
    public Optional<Customer> findById(String id) {
        CustomerTable customerTable = tables.get(id);
        if (customerTable == null) {
            return Optional.empty();
        }
        return Optional.of(new Customer(customerTable.id(), TaxType.valueOf(customerTable.taxType())));
    }
}
