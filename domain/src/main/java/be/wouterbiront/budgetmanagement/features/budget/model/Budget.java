package be.wouterbiront.budgetmanagement.features.budget.model;

import be.wouterbiront.budgetmanagement.features.money.model.Money;
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
    private Money money;
    private final List<Transaction> transactions;

    @Builder
    private Budget(String id, Month month, Money money) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id is required");
        if (month == null) throw new IllegalArgumentException("month is required");
        if (money == null) throw new IllegalArgumentException("money is required");

        this.id = id;
        this.month = month;
        this.money = money;
        this.transactions = Collections.emptyList();
    }

    public void changeMonth(Month month) {
        this.month = month;
    }

    public void changeMoney(Money money) {
        this.money = money;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
