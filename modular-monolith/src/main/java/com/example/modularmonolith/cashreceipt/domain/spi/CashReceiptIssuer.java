package com.example.modularmonolith.cashreceipt.domain.spi;

import com.example.modularmonolith.cashreceipt.domain.model.DraftedCashReceipt;
import com.example.modularmonolith.cashreceipt.domain.model.IssuedCashReceipt;

public interface CashReceiptIssuer {

    IssuedCashReceipt issue(DraftedCashReceipt draftedCashReceipt);
}
