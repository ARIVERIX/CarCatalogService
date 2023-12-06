package catalogcar.catalogcar.Service.Impl;

import catalogcar.catalogcar.DTO.UserRoleDTO;
import catalogcar.catalogcar.Model.UserRole;
import catalogcar.catalogcar.Repository.UserRoleRepository;
import catalogcar.catalogcar.Service.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private  UserRoleRepository userRoleRepository;
    private  ModelMapper modelMapper;

    @Autowired
    public void setRolesRepository(UserRoleRepository rolesRepository){
        this.userRoleRepository = rolesRepository;
    }
    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public UserRoleDTO getUserRoleById(UUID id) {
        UserRole userRole = userRoleRepository.findById(id).orElse(null);
        if (userRole == null) {

            return null;
        }
        return modelMapper.map(userRole, UserRoleDTO.class);
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream()
                .map(userRole -> modelMapper.map(userRole, UserRoleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleDTO createUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = modelMapper.map(userRoleDTO, UserRole.class);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return modelMapper.map(savedUserRole, UserRoleDTO.class);
    }

    @Override
    public UserRoleDTO updateUserRole(UUID id, UserRoleDTO userRoleDTO) {
        UserRole existingUserRole = userRoleRepository.findById(id).orElse(null);
        if (existingUserRole == null) {

            return null;
        }
        modelMapper.map(userRoleDTO, existingUserRole);
        UserRole updatedUserRole = userRoleRepository.save(existingUserRole);
        return modelMapper.map(updatedUserRole, UserRoleDTO.class);
    }

    @Override
    public void deleteUserRole(UUID id) {
        userRoleRepository.deleteById(id);
    }
}
