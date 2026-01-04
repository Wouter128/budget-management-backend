package be.wouterbiront.budgetmanagement.features.transaction.model;

import be.wouterbiront.budgetmanagement.features.category.model.Category;
import be.wouterbiront.budgetmanagement.features.money.model.Money;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class Transaction {
    private final String id;
    private final Money amount;
    private final Category category;
    private final Date date;
    private final String description;
    private final String budgetId;

    @Builder
    private Transaction(String id, Money amount, Category category, Date date, String description, String budgetId) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id is required");
        if (amount == null) throw new IllegalArgumentException("amount is required");
        if (category == null) throw new IllegalArgumentException("category is required");
        if (date == null) throw new IllegalArgumentException("date is required");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("description is required");
        if (budgetId == null || budgetId.isBlank()) throw new IllegalArgumentException("budgetId is required");

        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.budgetId = budgetId;
    }
}
