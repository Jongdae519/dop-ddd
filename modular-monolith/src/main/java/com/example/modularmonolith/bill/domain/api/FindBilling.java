package com.example.modularmonolith.bill.domain.api;


import com.example.modularmonolith.bill.domain.api.dto.BillingDto;

import java.util.Optional;

public interface FindBilling {

    Optional<BillingDto> byId(String id);
}
