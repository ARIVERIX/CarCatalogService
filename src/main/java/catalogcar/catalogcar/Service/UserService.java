package catalogcar.catalogcar.Service;

import catalogcar.catalogcar.DTO.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO getUserById(UUID id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UUID id, UserDTO userDTO);

    void deleteUser(UUID id);
}
