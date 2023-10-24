package catalogcar.catalogcar.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private UserRole UserRole;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;
}
