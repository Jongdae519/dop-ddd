package com.example.modularmonolith.cashreceipt.domain.api;

import com.example.modularmonolith.cashreceipt.domain.enums.TaxType;

public interface IssueCashReceipt {

    void forPaidBilling(long amount, TaxType taxType);
}
