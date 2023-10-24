package catalogcar.catalogcar.Service;

import catalogcar.catalogcar.DTO.UserRoleDTO;

import java.util.List;
import java.util.UUID;

public interface UserRoleService {

    UserRoleDTO getUserRoleById(UUID id);

    List<UserRoleDTO> getAllUserRoles();

    UserRoleDTO createUserRole(UserRoleDTO userRoleDto);

    UserRoleDTO updateUserRole(UUID id, UserRoleDTO userRoleDto);

    void deleteUserRole(UUID id);
}