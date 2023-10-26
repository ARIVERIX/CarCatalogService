package catalogcar.catalogcar.Model;

import catalogcar.catalogcar.Model.Model;
import catalogcar.catalogcar.Model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "offers")
public class Offer extends BaseEntity {
    private String description;

    @Enumerated(EnumType.STRING)
    private Engine engine;

    public enum Engine {
        GASOLINE("Gasoline"),   // Значение "Gasoline"
        DIESEL("Diesel"),       // Значение "Diesel"
        ELECTRIC("Electric"),   // Значение "Electric"
        HYBRID("Hybrid");       // Значение "Hybrid"

        private final String displayName;

        Engine(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private String imageUrl;
    private Integer mileage;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    public enum Transmission {
        MANUAL("Manual"),       // Значение "Manual"
        AUTOMATIC("Automatic"); // Значение "Automatic"

        private final String displayName;

        Transmission(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private Integer year;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;
}
