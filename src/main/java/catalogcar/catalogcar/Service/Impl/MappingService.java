package catalogcar.catalogcar.Service.Impl;

import catalogcar.catalogcar.DTO.*;
import catalogcar.catalogcar.Model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    private final ModelMapper modelMapper;

    @Autowired
    public MappingService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BrandDTO convertToDto(Brand brand) {
        return modelMapper.map(brand, BrandDTO.class);
    }

    public Brand convertToEntity(BrandDTO brandDto) {
        return modelMapper.map(brandDto, Brand.class);
    }

    public ModelDTO convertToDto(Model model) {
        return modelMapper.map(model, ModelDTO.class);
    }

    public Model convertToEntity(ModelDTO modelDto) {
        return modelMapper.map(modelDto, Model.class);
    }

    public OfferDTO convertToDto(Offer offer) {
        return modelMapper.map(offer, OfferDTO.class);
    }

    public Offer convertToEntity(OfferDTO offerDto) {
        return modelMapper.map(offerDto, Offer.class);
    }

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity(UserDTO userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public UserRoleDTO convertToDto(UserRole userRole) {
        return modelMapper.map(userRole, UserRoleDTO.class);
    }

    public UserRole convertToEntity(UserRoleDTO userRoleDto) {
        return modelMapper.map(userRoleDto, UserRole.class);
    }
}











//•	Методы внутри класса MappingService используют этот ModelMapper для выполнения конвертации между модельными объектами и их DTO-представлениями. Модельный объект преобразуется в DTO и наоборот.