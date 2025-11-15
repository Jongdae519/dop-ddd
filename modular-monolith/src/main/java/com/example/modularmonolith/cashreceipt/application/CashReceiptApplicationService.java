package com.example.modularmonolith.cashreceipt.application;

import com.example.modularmonolith.bill.domain.api.FindBilling;
import com.example.modularmonolith.bill.domain.api.dto.BillingDto;
import com.example.modularmonolith.cashreceipt.domain.api.IssueCashReceipt;
import com.example.modularmonolith.cashreceipt.domain.enums.TaxType;
import com.example.modularmonolith.customer.domain.api.FindCustomer;
import com.example.modularmonolith.customer.domain.api.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashReceiptApplicationService {

    private final FindBilling findBilling;
    private final FindCustomer findCustomer;
    private final IssueCashReceipt issueCashReceipt;

    public void issue(String billingId, String customerId) {
        BillingDto billingDto = findBilling.byId(billingId).orElseThrow(() -> new RuntimeException("billing is not found"));
        CustomerDto customerDto = findCustomer.byId(customerId).orElseThrow(() -> new RuntimeException("customer is not found"));
        TaxType taxType = TaxType.valueOf(customerDto.taxType());

        issueCashReceipt.forPaidBilling(billingDto.amount(), taxType);
    }
}

