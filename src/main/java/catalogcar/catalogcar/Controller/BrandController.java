package catalogcar.catalogcar.Controller;


import catalogcar.catalogcar.DTO.BrandDTO;
import catalogcar.catalogcar.Service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable UUID id) {
        BrandDTO brandDTO = brandService.getBrandById(id);
        return brandDTO != null
                ? ResponseEntity.ok(brandDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        List<BrandDTO> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
        BrandDTO createdBrand = brandService.createBrand(brandDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable UUID id, @RequestBody BrandDTO brandDTO) {
        BrandDTO updatedBrand = brandService.updateBrand(id, brandDTO);
        return updatedBrand != null
                ? ResponseEntity.ok(updatedBrand)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable UUID id) {
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}