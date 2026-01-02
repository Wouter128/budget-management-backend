package be.wouterbiront.budgetmanagement.user.ports.out;

import be.wouterbiront.budgetmanagement.features.user.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    void save(User user);
    Optional<User> findById(UUID id);
}
