package be.wouterbiront.budgetmanagement.controller;

import be.wouterbiront.budgetmanagement.dto.LoginDto;
import be.wouterbiront.budgetmanagement.dto.UserDto;
import be.wouterbiront.budgetmanagement.features.user.model.User;
import be.wouterbiront.budgetmanagement.user.ports.in.CreateUserCommand;
import be.wouterbiront.budgetmanagement.user.ports.in.GetUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserCommand createUserCommand;
    private final GetUserQuery getUserQuery;

    @Autowired
    public UserController(CreateUserCommand createUserCommand, GetUserQuery getUserQuery) {
        this.createUserCommand = createUserCommand;
        this.getUserQuery = getUserQuery;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/create")
    public void createUser(@RequestBody UserDto userDto) {
        createUserCommand.execute(userDto.id, userDto.firstName, userDto.lastName);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/login")
    // TODO: Shouldn't be using RequestBody. Use PathVariable or Params
    public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto) {
        User user = getUserQuery.read(loginDto.firstName, loginDto.lastName);
        UserDto userDto = new UserDto();
        userDto.id = user.getId();
        userDto.firstName = user.getFirstName();
        userDto.lastName = user.getLastName();

        return ResponseEntity
                .ok()
                .body(userDto);
    }
}
