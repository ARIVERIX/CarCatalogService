package catalogcar.catalogcar.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ModelDTO {
    private UUID id;
    private String name;
    private String category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    private BrandDTO brand;
}
