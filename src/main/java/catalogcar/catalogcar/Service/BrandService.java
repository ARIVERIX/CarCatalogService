package catalogcar.catalogcar.Service;

import catalogcar.catalogcar.DTO.BrandDTO;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    BrandDTO getBrandById(UUID id);

    List<BrandDTO> getAllBrands();

    BrandDTO createBrand(BrandDTO brandDTO);

    BrandDTO updateBrand(UUID id, BrandDTO brandDTO);

    void deleteBrand(UUID id);
}