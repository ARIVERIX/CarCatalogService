package catalogcar.catalogcar.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    @Enumerated(EnumType.STRING)
    private Engine engine;
    public enum Engine{
        GASOLINE, DIESEL, ELECTRIC, HYBRID
    }
    private String imageUrl;
    private Integer mileage;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    public enum Transmission{
        MANUAL, AUTOMATIC
    }
    private Integer year;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;
}
