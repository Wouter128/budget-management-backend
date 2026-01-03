package be.wouterbiront.budgetmanagement.money;

import be.wouterbiront.budgetmanagement.common.enums.Currency;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Getter
@NoArgsConstructor
public class MoneyEntity {
    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    public MoneyEntity(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
