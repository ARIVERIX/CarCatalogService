package catalogcar.catalogcar.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Category category;
    public enum Category {
        CAR, BUSS, TRUCK, MOTORCYCLE
    }

    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private LocalDateTime created;
    private LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Offer> offers;
}