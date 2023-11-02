package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.UserRoleDTO;
import catalogcar.catalogcar.Service.UserRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getUserRoleById(@PathVariable UUID id) {
        UserRoleDTO userRoleDTO = userRoleService.getUserRoleById(id);
        if (userRoleDTO != null) {
            return ResponseEntity.ok(userRoleDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public List<UserRoleDTO> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @PostMapping("/")
    public ResponseEntity<UserRoleDTO> createUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        UserRoleDTO createdUserRole = userRoleService.createUserRole(userRoleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRoleDTO> updateUserRole(@PathVariable UUID id, @RequestBody UserRoleDTO userRoleDTO) {
        UserRoleDTO updatedUserRole = userRoleService.updateUserRole(id, userRoleDTO);
        if (updatedUserRole != null) {
            return ResponseEntity.ok(updatedUserRole);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable UUID id) {
        userRoleService.deleteUserRole(id);
        return ResponseEntity.noContent().build();
    }
}
