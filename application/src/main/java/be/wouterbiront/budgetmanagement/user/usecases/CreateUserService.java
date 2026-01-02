package be.wouterbiront.budgetmanagement.user.usecases;

import be.wouterbiront.budgetmanagement.features.user.model.User;
import be.wouterbiront.budgetmanagement.user.ports.in.CreateUserCommand;
import be.wouterbiront.budgetmanagement.user.ports.out.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUserCommand {

    private final UserRepositoryPort userRepository;

    @Autowired
    public CreateUserService(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(String id, String firstName, String lastName) {
        User user = User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        userRepository.save(user);
    }
}
