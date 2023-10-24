package catalogcar.catalogcar.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<Model> models;
}