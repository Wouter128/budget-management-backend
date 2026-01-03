package be.wouterbiront.budgetmanagement.user;

import be.wouterbiront.budgetmanagement.budget.BudgetEntity;
import be.wouterbiront.budgetmanagement.features.budget.model.Budget;
import be.wouterbiront.budgetmanagement.features.user.model.User;
import be.wouterbiront.budgetmanagement.user.ports.out.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    @Autowired
    public UserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }


    @Override
    public void save(User user) {
        UserEntity userEntity = new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), null);
        jpaUserRepository.save(userEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }
}
