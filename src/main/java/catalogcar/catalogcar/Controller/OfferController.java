package catalogcar.catalogcar.Controller;

import catalogcar.catalogcar.DTO.OfferDTO;
import catalogcar.catalogcar.Service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOfferById(@PathVariable UUID id) {
        OfferDTO offerDTO = offerService.getOfferById(id);
        return offerDTO != null
                ? ResponseEntity.ok(offerDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        List<OfferDTO> offers = offerService.getAllOffers();
        return ResponseEntity.ok(offers);
    }

    @PostMapping("/{modelId}/{sellerId}")
    public ResponseEntity<OfferDTO> createOffer(@PathVariable UUID modelId, @PathVariable UUID sellerId, @RequestBody OfferDTO offerDTO) {
        OfferDTO createdOffer = offerService.createOffer(offerDTO, modelId, sellerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOffer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferDTO> updateOffer(@PathVariable UUID id, @RequestBody OfferDTO offerDTO) {
        OfferDTO updatedOffer = offerService.updateOffer(id, offerDTO);
        return updatedOffer != null
                ? ResponseEntity.ok(updatedOffer)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable UUID id) {
        offerService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }
}