package catalogcar.catalogcar.Service.Impl;

import catalogcar.catalogcar.DTO.BrandDTO;
import catalogcar.catalogcar.Model.Brand;
import catalogcar.catalogcar.Repository.BrandRepository;
import catalogcar.catalogcar.Service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandDTO getBrandById(UUID id) {
        Brand brand = brandRepository.findById(id).orElse(null);
        if (brand == null) {
            return null;
        }
        return modelMapper.map(brand, BrandDTO.class);
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> modelMapper.map(brand, BrandDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        Brand savedBrand = brandRepository.save(brand);
        return modelMapper.map(savedBrand, BrandDTO.class);
    }

    @Override
    public BrandDTO updateBrand(UUID id, BrandDTO brandDTO) {
        Brand existingBrand = brandRepository.findById(id).orElse(null);
        if (existingBrand == null) {
            return null;
        }
        modelMapper.map(brandDTO, existingBrand);
        Brand updatedBrand = brandRepository.save(existingBrand);
        return modelMapper.map(updatedBrand, BrandDTO.class);
    }

    @Override
    public void deleteBrand(UUID id) {
        brandRepository.deleteById(id);
    }
}
