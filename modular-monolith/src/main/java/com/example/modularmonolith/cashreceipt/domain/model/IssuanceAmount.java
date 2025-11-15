package com.example.modularmonolith.cashreceipt.domain.model;

import com.example.modularmonolith.cashreceipt.domain.enums.TaxType;
import org.springframework.util.Assert;

public record IssuanceAmount(
        long totalAmount,
        long actualAmount) {

    public IssuanceAmount{
        Assert.isTrue(totalAmount > 0, "TotalAmount must be greater than 0");
        Assert.isTrue(actualAmount > 0, "ActualAmountmust be greater than 0");
    }

    public static IssuanceAmount of(long totalAmount, TaxType taxType) {
        return switch (taxType) {
            case TAXABLE -> new IssuanceAmount(totalAmount, (long) (totalAmount * 0.9));
            case TAX_EXEMPT -> new IssuanceAmount(totalAmount, totalAmount);
            case null -> throw new IllegalArgumentException("TaxType must not be null");
        };
    }
}
