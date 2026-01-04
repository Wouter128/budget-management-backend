package be.wouterbiront.budgetmanagement.budget;

import be.wouterbiront.budgetmanagement.money.MoneyEntity;
import be.wouterbiront.budgetmanagement.transaction.TransactionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.List;

@Entity
@Table(name = "budget")
@NoArgsConstructor
@Getter
public class BudgetEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "month")
    private Month month;
    @Embedded
    @Column(name = "money")
    private MoneyEntity money;
    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions;

    public BudgetEntity(String id, Month month, MoneyEntity money, List<TransactionEntity> transactions) {
        this.id = id;
        this.month = month;
        this.money = money;
        this.transactions = transactions;
    }
}
