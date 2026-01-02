package be.wouterbiront.budgetmanagement.user.ports.in;

public interface CreateUserCommand {
    void execute(String id, String firstName, String lastName);
}
