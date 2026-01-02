package be.wouterbiront.budgetmanagement.controller;

import be.wouterbiront.budgetmanagement.dto.UserDto;
import be.wouterbiront.budgetmanagement.user.ports.in.CreateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserCommand createUserCommand;

    @Autowired
    public UserController(CreateUserCommand createUserCommand) {
        this.createUserCommand = createUserCommand;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/create")
    public void createUser(@RequestBody UserDto userDto) {
        createUserCommand.execute(userDto.id, userDto.firstName, userDto.lastName);
    }
}
