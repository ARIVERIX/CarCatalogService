package catalogcar.catalogcar.Service;

import catalogcar.catalogcar.DTO.AddBrandsDto;
import catalogcar.catalogcar.DTO.ShowBrandInfoDto;
import catalogcar.catalogcar.DTO.ShowDetailedBrandInfo;
import catalogcar.catalogcar.Model.Brand;
import catalogcar.catalogcar.Repository.BrandRepository;

import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class NewBrandsServices {
    private final BrandRepository brandsRepository;
    private final ModelMapper mapper;

    public NewBrandsServices(BrandRepository brandsRepository, ModelMapper mapper) {
        this.brandsRepository = brandsRepository;
        this.mapper = mapper;
    }
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public void addBrands(AddBrandsDto addBrandsDto) {
        brandsRepository.saveAndFlush(mapper.map(addBrandsDto, Brand.class));
    }
    @Cacheable("brands")
    public List<ShowBrandInfoDto> allBrands() {
        return brandsRepository.findAll().stream().map(brands -> mapper.map(brands, ShowBrandInfoDto.class))
                .collect(Collectors.toList());
    }

    public ShowDetailedBrandInfo brandsDetails(String name) {
        return mapper.map(brandsRepository.findByName(name).orElse(null), ShowDetailedBrandInfo.class);
    }
    @CacheEvict(cacheNames = "brands",allEntries = true)
    public void removeBrands(String name) {
        brandsRepository.deleteByName(name);
    }
}
