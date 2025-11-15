package com.example.modularmonolith.cashreceipt.domain.model;

import org.springframework.util.Assert;

public record DraftedCashReceipt(
        String id,
        IssuanceAmount issuanceAmount
) implements CashReceipt {

    public DraftedCashReceipt {
        Assert.notNull(id, "Id must not be null");
        Assert.notNull(issuanceAmount, "IssuanceAmount must not be null");
    }
}
