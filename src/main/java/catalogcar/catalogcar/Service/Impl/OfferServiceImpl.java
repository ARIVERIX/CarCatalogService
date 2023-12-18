//package catalogcar.catalogcar.Service.Impl;
//
//import catalogcar.catalogcar.DTO.OfferDTO;
//import catalogcar.catalogcar.Model.Model;
//import catalogcar.catalogcar.Model.Offer;
//import catalogcar.catalogcar.Model.User;
//import catalogcar.catalogcar.Repository.OfferRepository;
//import catalogcar.catalogcar.Service.OfferService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class OfferServiceImpl implements OfferService {
//
//    private  OfferRepository offerRepository;
//    private  ModelMapper modelMapper;
//    @Autowired
//    public void setOffersRepository(OfferRepository offersRepository){
//        this.offerRepository = offersRepository;
//    }
//    @Autowired
//    public void setModelMapper(ModelMapper modelMapper){
//        this.modelMapper = modelMapper;
//    }
//
//    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
//        this.offerRepository = offerRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public OfferDTO getOfferById(UUID id) {
//        Offer offer = offerRepository.findById(id).orElse(null);
//        if (offer == null) {
//            return null;
//        }
//        return modelMapper.map(offer, OfferDTO.class);
//    }
//
//    @Override
//    public List<OfferDTO> getAllOffers() {
//        List<Offer> offers = offerRepository.findAll();
//        return offers.stream()
//                .map(offer -> modelMapper.map(offer, OfferDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public OfferDTO createOffer(OfferDTO offerDTO, UUID modelId, UUID sellerId) {
//        Offer offer = modelMapper.map(offerDTO, Offer.class);
//
//        Model model = new Model();
//        model.setId(modelId);
//        offer.setModel(model);
//
//        User seller = new User();
//        seller.setId(sellerId);
//        offer.setSeller(seller);
//
//        offer.setCreated(LocalDateTime.now());
//        offer.setModified(LocalDateTime.now());
//        offer.setId(UUID.randomUUID());
//
//        Offer savedOffer = offerRepository.save(offer);
//        return modelMapper.map(savedOffer, OfferDTO.class);
//    }
//
//    @Override
//    public OfferDTO updateOffer(UUID id, OfferDTO offerDTO) {
//        Offer existingOffer = offerRepository.findById(id).orElse(null);
//        if (existingOffer == null) {
//            return null;
//        }
//        modelMapper.map(offerDTO, existingOffer);
//        existingOffer.setModified(LocalDateTime.now());
//        Offer updatedOffer = offerRepository.save(existingOffer);
//        return modelMapper.map(updatedOffer, OfferDTO.class);
//    }
//
//    @Override
//    public void deleteOffer(UUID id) {
//        offerRepository.deleteById(id);
//    }
//}
