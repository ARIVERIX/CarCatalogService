package catalogcar.catalogcar.Service;


import catalogcar.catalogcar.DTO.AddUsersDto;
import catalogcar.catalogcar.DTO.ShowDetailedUserInfo;
import catalogcar.catalogcar.DTO.ShowUserInfoDto;
import catalogcar.catalogcar.Model.User;
import catalogcar.catalogcar.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class NewUsersServices {
    private final UserRepository usersRepository;
    private final ModelMapper mapper;

    public NewUsersServices(UserRepository usersRepository, ModelMapper mapper) {
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }
    @CacheEvict(cacheNames = "users", allEntries = true)
    public void addUsers(AddUsersDto addUsersDto) {
        usersRepository.saveAndFlush(mapper.map(addUsersDto, User.class));
    }
    @Cacheable("users")
    public List<ShowUserInfoDto> allUsers() {
        return usersRepository.findAll().stream().map(users -> mapper.map(users, ShowUserInfoDto.class))
                .collect(Collectors.toList());
    }

    public ShowDetailedUserInfo usersDetails(String email) {
        return mapper.map(usersRepository.findByEmail(email).orElse(null), ShowDetailedUserInfo.class);
    }
    @CacheEvict(cacheNames = "users",allEntries = true)
    public void removeUser(String email) {
        usersRepository.deleteByEmail(email);
    }
}
