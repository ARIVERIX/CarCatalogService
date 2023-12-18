package catalogcar.catalogcar.utils.validation;


import catalogcar.catalogcar.Repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidator2 implements ConstraintValidator<UniqueNameN, String> {
    private final UserRepository usersRepository;

    public UniqueNameValidator2(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return  usersRepository.findByUsername(value).isEmpty();
    }
}