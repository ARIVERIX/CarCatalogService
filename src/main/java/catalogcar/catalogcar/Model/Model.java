package catalogcar.catalogcar.Model;

import catalogcar.catalogcar.Model.Brand;
import catalogcar.catalogcar.Model.Offer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING) // Указываем, что хотим хранить значение как строку
    private Category category;

    public enum Category {
        CAR("машина"),
        BUSS("автобус"),
        TRUCK("грузовик"),
        MOTORCYCLE("мотоцикл");

        private final String displayName;

        Category(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private String imageUrl;
    private Integer startYear;
    private Integer endYear;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Offer> offers;
}
