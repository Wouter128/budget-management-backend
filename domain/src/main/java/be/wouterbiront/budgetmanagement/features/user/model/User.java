package be.wouterbiront.budgetmanagement.features.user.model;

import be.wouterbiront.budgetmanagement.features.budget.model.Budget;
import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private Budget budget;

    @Builder
    private User(String id, String firstName, String lastName,  Budget budget) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id is required");
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("firstName is required");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("lastName is required");

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
    }

    public void assignBudget(Budget budget) {
        if (budget == null) throw new IllegalArgumentException("budget is required");
        if (this.budget != null) throw new IllegalArgumentException("budget is already assigned");

        this.budget = budget;
    }
}
