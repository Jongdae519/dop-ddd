package com.example.modularmonolith.cashreceipt.domain;

import com.example.modularmonolith.cashreceipt.domain.api.IssueCashReceipt;
import com.example.modularmonolith.cashreceipt.domain.enums.TaxType;
import com.example.modularmonolith.cashreceipt.domain.model.DraftedCashReceipt;
import com.example.modularmonolith.cashreceipt.domain.model.IssuanceAmount;
import com.example.modularmonolith.cashreceipt.domain.model.IssuedCashReceipt;
import com.example.modularmonolith.cashreceipt.domain.spi.CashReceiptIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CashReceiptIssuanceService implements IssueCashReceipt {

    private final CashReceiptIssuer cashReceiptIssuer;

    @Override
    public void forPaidBilling(long amount, TaxType taxType) {
        DraftedCashReceipt draftedCashReceipt = new DraftedCashReceipt(
                UUID.randomUUID().toString(), IssuanceAmount.of(amount, taxType));

        IssuedCashReceipt issuedCashReceipt = cashReceiptIssuer.issue(draftedCashReceipt);
    }
}
