package catalogcar.catalogcar.utils.validation;


import catalogcar.catalogcar.Repository.BrandRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
    private final BrandRepository brandsRepository;

    public UniqueNameValidator(BrandRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return  brandsRepository.findByName(value).isEmpty();
    }
}
