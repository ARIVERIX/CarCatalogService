package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.BrandDTO;
import catalogcar.catalogcar.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable UUID id) {
        BrandDTO brandDTO = brandService.getBrandById(id);
        if (brandDTO != null) {
            return ResponseEntity.ok(brandDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        List<BrandDTO> brandDTOs = brandService.getAllBrands();
        return ResponseEntity.ok(brandDTOs);
    }

    @PostMapping("/")
    public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
        BrandDTO createdBrand = brandService.createBrand(brandDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable UUID id, @RequestBody BrandDTO brandDTO) {
        BrandDTO updatedBrand = brandService.updateBrand(id, brandDTO);
        if (updatedBrand != null) {
            return ResponseEntity.ok(updatedBrand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable UUID id) {
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}