package catalogcar.catalogcar.Service;

import catalogcar.catalogcar.DTO.AddOffersDto;
import catalogcar.catalogcar.DTO.ShowDetailedOfferInfo;
import catalogcar.catalogcar.DTO.ShowOfferInfoDto;
import catalogcar.catalogcar.Model.Model;
import catalogcar.catalogcar.Model.Offer;
import catalogcar.catalogcar.Model.User;
import catalogcar.catalogcar.Repository.ModelRepository;
import catalogcar.catalogcar.Repository.OfferRepository;
import catalogcar.catalogcar.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;


@Service
@EnableCaching
public class NewOffersServices {
    private final OfferRepository offersRepository;
    private final ModelRepository modelsRepository;
    private final UserRepository usersRepository;
    private final ModelMapper mapper;

    public NewOffersServices(OfferRepository offersRepository,ModelRepository modelsRepository,
                             UserRepository usersRepository, ModelMapper mapper) {
        this.offersRepository = offersRepository;
        this.modelsRepository = modelsRepository;
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void addOffer(AddOffersDto offersDto) {
        Offer offer = mapper.map(offersDto, Offer.class);
        User seller = usersRepository.findById(offersDto.getSeller_id())
                .orElseThrow(() -> new IllegalArgumentException("Error"));
        Model model = modelsRepository.findById(offersDto.getModel_id())
                .orElseThrow(() -> new IllegalArgumentException("Error"));
        offer.setSeller(seller);
        offer.setModel(model);
        offersRepository.saveAndFlush(offer);
    }
    @Cacheable("offers")
    public List<ShowOfferInfoDto> allOffers() {
        return offersRepository.findAll().stream().map(offers -> mapper.map(offers, ShowOfferInfoDto.class))
                .collect(Collectors.toList());
    }


    public ShowDetailedOfferInfo offersDetails(String description) {
        return mapper.map(offersRepository.findByDescription(description).orElse(null), ShowDetailedOfferInfo.class);
    }
    @CacheEvict(cacheNames = "offers",allEntries = true)
    public void removeOffer(String description) {
        offersRepository.deleteByDescription(description);
    }
}
