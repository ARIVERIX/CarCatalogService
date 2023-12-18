//package catalogcar.catalogcar.Service.Impl;
//
//import catalogcar.catalogcar.DTO.UserDTO;
//import catalogcar.catalogcar.Model.User;
//import catalogcar.catalogcar.Model.UserRole;
//import catalogcar.catalogcar.Repository.UserRepository;
//import catalogcar.catalogcar.Repository.UserRoleRepository;
//import catalogcar.catalogcar.Service.UserService;
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
//public class UserServiceImpl implements UserService {
//
//    private  UserRepository userRepository;
//    private  ModelMapper modelMapper;
//    private  UserRoleRepository userRoleRepository;
//    @Autowired
//    public void setUsersRepository(UserRepository usersRepository){
//        this.userRepository = usersRepository;
//    }
//    @Autowired
//    public void setRolesRepository(UserRoleRepository roleRepository){
//        this.userRoleRepository = roleRepository;
//    }
//    @Autowired
//    public void setModelMapper(ModelMapper modelMapper){
//        this.modelMapper = modelMapper;
//    }
//
//    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserRoleRepository userRoleRepository) {
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//        this.userRoleRepository = userRoleRepository;
//    }
//
//    @Override
//    public UserDTO getUserById(UUID id) {
//        User user = userRepository.findById(id).orElse(null);
//        if (user == null) {
//            return null;
//        }
//        return modelMapper.map(user, UserDTO.class);
//    }
//
//    @Override
//    public List<UserDTO> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(user -> modelMapper.map(user, UserDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDTO createUser(UserDTO userDTO) {
//        User user = modelMapper.map(userDTO, User.class);
//        UserRole role = userRoleRepository.findByRole(UserRole.Role.valueOf(userDTO.getRole()));
//        user.setUserRole(role);
//        user.setCreated(LocalDateTime.now());
//        user.setModified(LocalDateTime.now());
//        user.setId(UUID.randomUUID());
//        User savedUser = userRepository.save(user);
//        return modelMapper.map(savedUser, UserDTO.class);
//    }
//
//    @Override
//    public UserDTO updateUser(UUID id, UserDTO userDTO) {
//        User existingUser = userRepository.findById(id).orElse(null);
//        if (existingUser == null) {
//            return null;
//        }
//        modelMapper.map(userDTO, existingUser);
//        existingUser.setModified(LocalDateTime.now());
//        User updatedUser = userRepository.save(existingUser);
//        return modelMapper.map(updatedUser, UserDTO.class);
//    }
//
//    @Override
//    public void deleteUser(UUID id) {
//        userRepository.deleteById(id);
//    }
//}