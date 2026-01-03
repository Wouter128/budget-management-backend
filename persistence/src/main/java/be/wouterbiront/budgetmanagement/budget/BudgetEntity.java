package be.wouterbiront.budgetmanagement.budget;

import be.wouterbiront.budgetmanagement.transaction.TransactionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    @Column(name = "money")
    private BigDecimal Money;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_id", referencedColumnName = "id")
    private List<TransactionEntity> transactions;

    public BudgetEntity(String id, Month month, BigDecimal Money, List<TransactionEntity> transactions) {
        this.id = id;
        this.month = month;
        this.Money = Money;
        this.transactions = transactions;
    }
}
