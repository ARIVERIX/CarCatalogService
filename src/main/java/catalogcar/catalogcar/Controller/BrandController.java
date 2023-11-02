package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.BrandDTO;
import catalogcar.catalogcar.Service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable UUID id) {
        BrandDTO brandDTO = brandService.getBrandById(id);
        if (brandDTO != null) {
            return new ResponseEntity<>(brandDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        List<BrandDTO> brandDTOs = brandService.getAllBrands();
        return new ResponseEntity<>(brandDTOs, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
        BrandDTO createdBrand = brandService.createBrand(brandDTO);
        return new ResponseEntity<>(createdBrand, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable UUID id, @RequestBody BrandDTO brandDTO) {
        BrandDTO updatedBrand = brandService.updateBrand(id, brandDTO);
        if (updatedBrand != null) {
            return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable UUID id) {
        brandService.deleteBrand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
