package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.OfferDTO;
import catalogcar.catalogcar.Service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOfferById(@PathVariable UUID id) {
        OfferDTO offerDTO = offerService.getOfferById(id);
        if (offerDTO != null) {
            return ResponseEntity.ok(offerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public List<OfferDTO> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PostMapping("/{modelId}/{sellerId}")
    public ResponseEntity<OfferDTO> createOffer(@RequestBody OfferDTO offerDTO, @PathVariable UUID modelId, @PathVariable UUID sellerId) {
        OfferDTO createdOffer = offerService.createOffer(offerDTO, modelId, sellerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOffer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferDTO> updateOffer(@PathVariable UUID id, @RequestBody OfferDTO offerDTO) {
        OfferDTO updatedOffer = offerService.updateOffer(id, offerDTO);
        if (updatedOffer != null) {
            return ResponseEntity.ok(updatedOffer);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable UUID id) {
        offerService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }
}
