package be.wouterbiront.budgetmanagement.features.budget.model;

import be.wouterbiront.budgetmanagement.features.transaction.model.Transaction;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Collections;
import java.util.List;

@Getter
public class Budget {
    private final String id;
    private Month month;
    private BigDecimal Money;
    private List<Transaction> transactions;

    @Builder
    private Budget(String id, Month month, BigDecimal Money) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id is required");
        if (month == null) throw new IllegalArgumentException("month is required");
        if (Money == null) throw new IllegalArgumentException("Money is required");

        this.id = id;
        this.month = month;
        this.Money = Money;
        this.transactions = Collections.emptyList();
    }

    public void changeMonth(Month month) {
        this.month = month;
    }

    public void changeMoney(BigDecimal Money) {
        this.Money = Money;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
