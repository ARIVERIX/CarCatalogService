package catalogcar.catalogcar.Service.Impl;

import catalogcar.catalogcar.DTO.UserDTO;
import catalogcar.catalogcar.Model.User;
import catalogcar.catalogcar.Repository.UserRepository;
import catalogcar.catalogcar.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO getUserById(UUID id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            // Handle the case where the user with the given ID is not found
            return null;
        }
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            // Handle the case where the user with the given ID is not found
            return null;
        }
        modelMapper.map(userDTO, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
