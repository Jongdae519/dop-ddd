package com.example.modularmonolith.bill.domain.spi;


import com.example.modularmonolith.bill.domain.model.Billing;

import java.util.Optional;

public interface BillingRepository {

    Optional<Billing> findById(String id);
}
