package catalogcar.catalogcar.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @OneToMany(mappedBy = "brand",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Model> model;
    private String name;

    public Set<Model> getModel() {
        return model;
    }
    public void setModel(Set<Model> model) {
        this.model = model;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    protected Brand() {
    }

}
