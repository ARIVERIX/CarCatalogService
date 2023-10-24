package catalogcar.catalogcar.Service;

import catalogcar.catalogcar.DTO.OfferDTO;

import java.util.List;
import java.util.UUID;

public interface OfferService {

    OfferDTO getOfferById(UUID id);

    List<OfferDTO> getAllOffers();

    OfferDTO createOffer(OfferDTO offerDTO, UUID modelId, UUID sellerId);

    OfferDTO updateOffer(UUID id, OfferDTO offerDTO);

    void deleteOffer(UUID id);
}
