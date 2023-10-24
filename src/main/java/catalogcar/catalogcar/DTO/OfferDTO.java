package catalogcar.catalogcar.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OfferDTO {
    private UUID id;
    private String description;
    private String engine;
    private String imageUrl;
    private Integer mileage;
    private Double price;
    private String transmission;
    private Integer year;
    private LocalDateTime created;
    private LocalDateTime modified;
    private ModelDTO model;
    private UserDTO seller;
}
