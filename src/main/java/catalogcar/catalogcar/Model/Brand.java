package catalogcar.catalogcar.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "brands")
public class Brand extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<Model> models;
}