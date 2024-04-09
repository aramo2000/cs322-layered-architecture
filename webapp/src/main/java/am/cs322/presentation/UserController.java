package am.cs322.presentation;

import am.cs322.presentation.model.CreateUserRequest;
import am.cs322.model.UserDTO;

public interface UserController {

    public UserDTO createUser(CreateUserRequest request);

}
