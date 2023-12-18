//package catalogcar.catalogcar.Service.Impl;
//
//import catalogcar.catalogcar.DTO.BrandDTO;
//import catalogcar.catalogcar.Model.Brand;
//import catalogcar.catalogcar.Repository.BrandRepository;
//import catalogcar.catalogcar.Service.BrandService;
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
//public class BrandServiceImpl implements BrandService {
//
//    private  BrandRepository brandRepository;
//    private  ModelMapper modelMapper;
//
//    @Autowired
//    public void setBrandsRepository(BrandRepository brandsRepository){
//        this.brandRepository = brandsRepository;
//    }
//    @Autowired
//    public void setModelMapper(ModelMapper modelMapper){
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public BrandDTO getBrandById(UUID id) {
//        Brand brand = brandRepository.findById(id).orElse(null);
//        if (brand == null) {
//            return null;
//        }
//        return modelMapper.map(brand, BrandDTO.class);
//    }
//
//    @Override
//    public List<BrandDTO> getAllBrands() {
//        List<Brand> brands = brandRepository.findAll();
//        return brands.stream()
//                .map(brand -> modelMapper.map(brand, BrandDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public BrandDTO createBrand(BrandDTO brandDTO) {
//        Brand brand = modelMapper.map(brandDTO, Brand.class);
//        brand.setCreated(LocalDateTime.now());
//        brand.setModified(LocalDateTime.now());
//        brand.setId(UUID.randomUUID());
//        Brand savedBrand = brandRepository.save(brand);
//        return modelMapper.map(savedBrand, BrandDTO.class);
//    }
//
//    @Override
//    public BrandDTO updateBrand(UUID id, BrandDTO brandDTO) {
//        Brand existingBrand = brandRepository.findById(id).orElse(null);
//        if (existingBrand == null) {
//            return null;
//        }
//        modelMapper.map(brandDTO, existingBrand);
//        existingBrand.setModified(LocalDateTime.now());
//        Brand updatedBrand = brandRepository.save(existingBrand);
//        return modelMapper.map(updatedBrand, BrandDTO.class);
//    }
//
//    @Override
//    public void deleteBrand(UUID id) {
//        brandRepository.deleteById(id);
//    }
//}
