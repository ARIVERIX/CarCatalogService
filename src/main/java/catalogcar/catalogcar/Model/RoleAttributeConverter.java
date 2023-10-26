package catalogcar.catalogcar.Model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static catalogcar.catalogcar.Model.UserRole.Role.ADMIN;
import static catalogcar.catalogcar.Model.UserRole.Role.USER;

@Converter
public class RoleAttributeConverter implements AttributeConverter<UserRole.Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserRole.Role role) {
        return role.ordinate;
    }

    @Override
    public UserRole.Role convertToEntityAttribute(Integer integer) {
        if (integer == 10) {
            return ADMIN;
        }
        return USER;
    }
}