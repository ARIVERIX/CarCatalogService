package catalogcar.catalogcar.utils.validation;


import catalogcar.catalogcar.Repository.ModelRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidator1 implements ConstraintValidator<UniqueNameZ, String> {
    private final ModelRepository modelsRepository;

    public UniqueNameValidator1(ModelRepository modelsRepository) {
        this.modelsRepository=modelsRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return  modelsRepository.findByName(value).isEmpty();
    }
}
