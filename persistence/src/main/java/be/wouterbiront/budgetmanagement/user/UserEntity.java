package be.wouterbiront.budgetmanagement.user;

import be.wouterbiront.budgetmanagement.budget.BudgetEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id", referencedColumnName = "id")
    private BudgetEntity budget;

    public UserEntity(String id, String firstName, String lastName, BudgetEntity budget) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
    }
}
