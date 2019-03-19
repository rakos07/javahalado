package hu.me;

import java.util.List;

public interface UserController {
    List<ErrorMessage> saveUser(UserDTO userDTO);
    List<UserDTO> getUserDTOStore();
}
