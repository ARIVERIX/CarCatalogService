package catalogcar.catalogcar.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue
    private UUID id;
    @Convert(converter = RoleAttributeConverter.class)
    private Role role;
    public enum Role{
        USER(0), ADMIN(10);
        int ordinate;

        Role(int ordinate) {
            this.ordinate = ordinate;
        }
    }
}

