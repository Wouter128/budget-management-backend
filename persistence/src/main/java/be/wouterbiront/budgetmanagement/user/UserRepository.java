package be.wouterbiront.budgetmanagement.user;

import be.wouterbiront.budgetmanagement.features.user.model.User;
import be.wouterbiront.budgetmanagement.user.ports.out.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public User findByFirstNameAndLastName(String firstName, String lastName) {
        Optional<UserEntity> userEntityOpt = jpaUserRepository.findByFirstNameAndLastName(firstName, lastName);
        if (userEntityOpt.isPresent()) {
            UserEntity userEntity = userEntityOpt.get();
            return User.builder()
                    .id(userEntity.getId())
                    .firstName(userEntity.getFirstName())
                    .lastName(userEntity.getLastName())
                    .budget(null) // TODO: Temporary, add actual budget if available
                    .build();
        }

        // TODO: create custom exception (NotFoundException)
        throw new RuntimeException("User not found");
    }
}
