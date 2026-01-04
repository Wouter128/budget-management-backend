package be.wouterbiront.budgetmanagement.user.usecases;

import be.wouterbiront.budgetmanagement.features.user.model.User;
import be.wouterbiront.budgetmanagement.user.ports.in.GetUserQuery;
import be.wouterbiront.budgetmanagement.user.ports.out.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserService implements GetUserQuery {

    private final UserRepositoryPort userRepositoryPort;

    @Autowired
    public GetUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User read(String firstName, String lastName) {
        return userRepositoryPort.findByFirstNameAndLastName(firstName, lastName);
    }
}
