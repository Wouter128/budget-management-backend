package be.wouterbiront.budgetmanagement.transaction;

import be.wouterbiront.budgetmanagement.budget.BudgetEntity;
import be.wouterbiront.budgetmanagement.category.CategoryEntity;
import be.wouterbiront.budgetmanagement.money.MoneyEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@Getter
public class TransactionEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Embedded
    @Column(name = "amount")
    private MoneyEntity amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @Column(name = "date")
    private Date date;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_id", nullable = false)
    private BudgetEntity budget;

    public  TransactionEntity(String id, MoneyEntity amount, CategoryEntity category, Date date, String description,  BudgetEntity budget) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.budget = budget;
    }
}
