package catalogcar.catalogcar.Service.Impl;

import catalogcar.catalogcar.DTO.OfferDTO;
import catalogcar.catalogcar.Model.Model;
import catalogcar.catalogcar.Model.Offer;
import catalogcar.catalogcar.Model.User;
import catalogcar.catalogcar.Repository.OfferRepository;
import catalogcar.catalogcar.Service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OfferDTO getOfferById(UUID id) {
        Offer offer = offerRepository.findById(id).orElse(null);
        if (offer == null) {
            // Handle the case where the offer with the given ID is not found
            return null;
        }
        return modelMapper.map(offer, OfferDTO.class);
    }

    @Override
    public List<OfferDTO> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OfferDTO createOffer(OfferDTO offerDTO, UUID modelId, UUID sellerId) {
        Offer offer = modelMapper.map(offerDTO, Offer.class);

        // Set the model for the offer
        Model model = new Model();
        model.setId(modelId);
        offer.setModel(model);

        // Set the seller for the offer
        User seller = new User();
        seller.setId(sellerId);
        offer.setSeller(seller);

        Offer savedOffer = offerRepository.save(offer);
        return modelMapper.map(savedOffer, OfferDTO.class);
    }

    @Override
    public OfferDTO updateOffer(UUID id, OfferDTO offerDTO) {
        Offer existingOffer = offerRepository.findById(id).orElse(null);
        if (existingOffer == null) {
            // Handle the case where the offer with the given ID is not found
            return null;
        }

        modelMapper.map(offerDTO, existingOffer);
        Offer updatedOffer = offerRepository.save(existingOffer);
        return modelMapper.map(updatedOffer, OfferDTO.class);
    }

    @Override
    public void deleteOffer(UUID id) {
        offerRepository.deleteById(id);
    }
}
