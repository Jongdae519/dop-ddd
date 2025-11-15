package com.example.modularmonolith.bill.domain;

import com.example.modularmonolith.bill.domain.api.FindBilling;
import com.example.modularmonolith.bill.domain.api.dto.BillingDto;
import com.example.modularmonolith.bill.domain.model.Billing;
import com.example.modularmonolith.bill.domain.spi.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillingQueryService implements FindBilling {

    private final BillingRepository billingRepository;

    public Optional<BillingDto> byId(String id) {
        Optional<Billing> billing = billingRepository.findById(id);
        return billing.map(i -> new BillingDto(i.id(), i.amount()));
    }
}
