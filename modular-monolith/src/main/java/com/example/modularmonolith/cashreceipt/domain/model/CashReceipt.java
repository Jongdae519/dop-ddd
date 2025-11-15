package com.example.modularmonolith.cashreceipt.domain.model;

public sealed interface CashReceipt permits DraftedCashReceipt, IssuedCashReceipt {
}
