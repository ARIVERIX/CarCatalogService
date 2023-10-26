package catalogcar.catalogcar.Model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static catalogcar.catalogcar.Model.UserRole.Role.ADMIN;
import static catalogcar.catalogcar.Model.UserRole.Role.USER;

@Converter
public class RoleAttributeConverter implements AttributeConverter<UserRole.Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserRole.Role role) { //Преобразует значение роли пользователя (UserRole.Role) в целое число и сохраняет его
        return role.ordinate;
    }

    @Override
    public UserRole.Role convertToEntityAttribute(Integer integer) { //Преобразует целое число из базы данных обратно в значение роли пользователя (UserRole.Role).
        if (integer == 10) {
            return ADMIN;
        }
        return USER;
    }
}