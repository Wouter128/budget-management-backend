package be.wouterbiront.budgetmanagement.user.ports.in;

import be.wouterbiront.budgetmanagement.features.user.model.User;

public interface GetUserQuery {
    User read(String firstName, String lastName);
}
