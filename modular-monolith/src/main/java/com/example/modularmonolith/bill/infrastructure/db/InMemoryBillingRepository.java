package com.example.modularmonolith.bill.infrastructure.db;

import com.example.modularmonolith.bill.domain.model.Billing;
import com.example.modularmonolith.bill.domain.spi.BillingRepository;
import com.example.modularmonolith.bill.infrastructure.db.table.BillingTable;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBillingRepository implements BillingRepository {

    private final Map<String, BillingTable> tables = new ConcurrentHashMap<>();

    @Override
    public Optional<Billing> findById(String id) {
        BillingTable billingTable = tables.get(id);
        if (billingTable == null) {
            return Optional.empty();
        }
        return Optional.of(new Billing(billingTable.id(), billingTable.amount()));
    }
}
