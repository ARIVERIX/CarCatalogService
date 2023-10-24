package catalogcar.catalogcar.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BrandDTO {
    private UUID id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;
}

