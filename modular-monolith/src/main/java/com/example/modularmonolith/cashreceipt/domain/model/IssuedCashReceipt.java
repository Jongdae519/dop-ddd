package com.example.modularmonolith.cashreceipt.domain.model;

import org.springframework.util.Assert;

public record IssuedCashReceipt(
        String id,
        long amount,
        String approvalNumber
) implements CashReceipt {

    public IssuedCashReceipt {
        Assert.notNull(id, "Id must not be null");
        Assert.isTrue(amount > 0, "Amount must be greater than 0");
        Assert.notNull(approvalNumber, "ApprovalNumber must not be null");
    }
}
