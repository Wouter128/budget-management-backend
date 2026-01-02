package be.wouterbiront.budgetmanagement.features.money.model;

import be.wouterbiront.budgetmanagement.common.enums.Currency;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    @Builder
    private Money(BigDecimal amount, Currency currency) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) > 0) throw new IllegalArgumentException("amount is not present or negative");
        if (currency == null) throw new IllegalArgumentException("currency is required");

        this.amount = amount;
        this.currency = currency;
    }
}
