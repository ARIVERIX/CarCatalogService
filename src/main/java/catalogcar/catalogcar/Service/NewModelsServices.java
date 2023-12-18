package catalogcar.catalogcar.Service;



import catalogcar.catalogcar.DTO.AddModelsDto;
import catalogcar.catalogcar.DTO.ShowDetailedModelInfo;
import catalogcar.catalogcar.DTO.ShowModelInfoDto;
import catalogcar.catalogcar.Model.Brand;
import catalogcar.catalogcar.Model.Model;
import catalogcar.catalogcar.Repository.BrandRepository;
import catalogcar.catalogcar.Repository.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@EnableCaching
public class NewModelsServices {
    private final ModelRepository modelsRepository;
    private final BrandRepository brandsRepository;
    private final ModelMapper mapper;
    private final AddModelsDto models;

    public NewModelsServices(ModelRepository modelsRepository, AddModelsDto models, BrandRepository brandsRepository, ModelMapper mapper) {
        this.modelsRepository = modelsRepository;
        this.brandsRepository = brandsRepository;
        this.models = models;
        this.mapper = mapper;
    }

    @CacheEvict(cacheNames = "models", allEntries = true)
    public void addModels(AddModelsDto models) {
        Model newModels = mapper.map(models, Model.class);
        Brand brand = brandsRepository.findById(models.getBrand_id())
                .orElseThrow(() -> new IllegalArgumentException("Error"));
        newModels.setBrand(brand);
        newModels.setBrand_id(brand.getId());
        modelsRepository.saveAndFlush(newModels);
    }
    @Cacheable("models")
    public List<ShowModelInfoDto> allModels() {
        return modelsRepository.findAll().stream().map(models -> mapper.map(models, ShowModelInfoDto.class))
                .collect(Collectors.toList());
    }

    public ShowDetailedModelInfo modelsDetails(String name) {
        return mapper.map(modelsRepository.findByName(name).orElse(null), ShowDetailedModelInfo.class);
    }
    @CacheEvict(cacheNames = "models",allEntries = true)
    public void removeModel(String name) {
        modelsRepository.deleteByName(name);
    }
}
