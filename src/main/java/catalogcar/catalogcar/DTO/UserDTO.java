package catalogcar.catalogcar.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String role;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;
}
