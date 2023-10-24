package catalogcar.catalogcar;


import catalogcar.catalogcar.Model.Model;
import catalogcar.catalogcar.Model.Offer;
import catalogcar.catalogcar.Model.Offer.Engine;
import catalogcar.catalogcar.Model.Offer.Transmission;
import catalogcar.catalogcar.DTO.*;
import catalogcar.catalogcar.Model.UserRole;
import catalogcar.catalogcar.Service.*;
import catalogcar.catalogcar.Service.Impl.MappingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;


@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final MappingService mappingService;

    public DataInitializer(BrandService brandService, ModelService modelService,
                           OfferService offerService, UserService userService,
                           UserRoleService userRoleService, MappingService mappingService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.mappingService = mappingService;
    }

    @Override
    public void run(String... args) {
        // Создание брендов
        BrandDTO brandNissan = new BrandDTO();
        brandNissan.setName("Nissan");
        brandNissan.setCreated(LocalDateTime.now());
        brandNissan.setModified(LocalDateTime.now());
        brandNissan = brandService.createBrand(brandNissan);

        BrandDTO brandAudi = new BrandDTO();
        brandAudi.setName("Audi");
        brandAudi.setCreated(LocalDateTime.now());
        brandAudi.setModified(LocalDateTime.now());
        brandAudi  = brandService.createBrand(brandAudi);

        // Создание ролей пользователей
        UserRoleDTO roleAdmin = new UserRoleDTO();
        roleAdmin.setRole("ADMIN");
        roleAdmin = userRoleService.createUserRole(roleAdmin);

        UserRoleDTO roleUser = new UserRoleDTO();
        roleUser.setRole("USER");
        roleUser = userRoleService.createUserRole(roleUser);

        // Создание пользователей
        UserDTO userOne = new UserDTO();
        userOne.setUsername("Arove");
        userOne.setPassword("qwer123");
        userOne.setFirstName("Danil");
        userOne.setLastName("Teslenkov");
        userOne.setIsActive(true);
        userOne.setCreated(LocalDateTime.now());
        userOne.setModified(LocalDateTime.now());
        userOne.setImageUrl("https://example.com/users/userDenil.jpg");
        roleUser.setRole(String.valueOf(UserRole.Role.USER));
        userOne = userService.createUser(userOne);

        UserDTO userTwo = new UserDTO();
        userTwo.setUsername("Swalox");
        userTwo.setPassword("mwdtjbs1235asd");
        userTwo.setFirstName("Matvei");
        userTwo.setLastName("Abramov");
        userTwo.setIsActive(true);
        userTwo.setCreated(LocalDateTime.now());
        userTwo.setModified(LocalDateTime.now());
        userTwo.setImageUrl("https://example.com/users/userMatvei.jpg");
        roleAdmin.setRole(String.valueOf(UserRole.Role.ADMIN));
        userTwo = userService.createUser(userTwo);

        // Создание моделей автомобилей
        ModelDTO modelGTR = new ModelDTO();
        modelGTR.setName("GTR");
        modelGTR.setCategory(Model.Category.CAR.toString());
        modelGTR.setImageUrl("https://example.com/GTR-Nissan-N1.jpg");
        modelGTR.setStartYear(Integer.valueOf("2007"));
        modelGTR.setEndYear(Integer.valueOf("2023"));
        modelGTR.setCreated(LocalDateTime.now());
        modelGTR.setModified(LocalDateTime.now());
        modelGTR.setBrand(brandNissan); // Устанавливаем объект бренда
        modelGTR = modelService.createModel( modelGTR, brandNissan.getId());

        ModelDTO modelRS6 = new ModelDTO();
        modelRS6.setName("RS6 MTM");
        modelRS6.setCategory(Model.Category.CAR.toString());
        modelRS6.setImageUrl("https://example.com/RS6.jpg");
        modelRS6.setStartYear(Integer.valueOf("2018"));
        modelRS6.setEndYear(Integer.valueOf("2023"));
        modelRS6.setCreated(LocalDateTime.now());
        modelRS6.setModified(LocalDateTime.now());
        modelRS6.setBrand(brandAudi); // Устанавливаем объект бренда
        modelRS6 = modelService.createModel(modelRS6, brandAudi.getId());

        // Создание предложений
        OfferDTO offerOneGTR = new OfferDTO();
        offerOneGTR.setDescription("Nissan GTR for sale 5000$");
        offerOneGTR.setEngine(String.valueOf(Engine.ELECTRIC));
        offerOneGTR.setImageUrl("https://offer.com/GTR-sale-photo.jpg");
        offerOneGTR.setMileage(25000);
        offerOneGTR.setPrice(30000.00);
        offerOneGTR.setTransmission(String.valueOf(Transmission.MANUAL));
        offerOneGTR.setYear(2010);
        offerOneGTR.setCreated(LocalDateTime.now());
        offerOneGTR.setModified(LocalDateTime.now());
        offerOneGTR.setModel(modelGTR); // Устанавливаем объект модели
        offerOneGTR.setSeller(userOne); // Устанавливаем объект пользователя
        offerService.createOffer(offerOneGTR, modelGTR.getId(), userOne.getId());

        OfferDTO offerTwoRS6 = new OfferDTO();
        offerTwoRS6.setDescription("Audi RS6 modification MTM 1000HP");
        offerTwoRS6.setEngine(String.valueOf(Engine.DIESEL));
        offerTwoRS6.setImageUrl("https://offer.com/RS6-awd123.jpg");
        offerTwoRS6.setMileage(10000);
        offerTwoRS6.setPrice(85000.00);
        offerTwoRS6.setTransmission(String.valueOf(Transmission.AUTOMATIC));
        offerTwoRS6.setYear(2015);
        offerTwoRS6.setCreated(LocalDateTime.now());
        offerTwoRS6.setModified(LocalDateTime.now());
        offerTwoRS6.setModel(modelRS6); // Устанавливаем объект модели
        offerTwoRS6.setSeller(userTwo); // Устанавливаем объект пользователя
        offerService.createOffer(offerTwoRS6, modelRS6.getId(), userTwo.getId());
    }
}