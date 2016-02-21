package guru.zaidel.model;

import javax.persistence.AttributeConverter;

/**
 * Created by alexanderz on 21.02.16.
 */
public class EmployeeTypeConverter implements AttributeConverter<EmployeeType, String> {
    @Override
    public String convertToDatabaseColumn(EmployeeType attribute) {
        return attribute.name().toLowerCase();
    }

    @Override
    public EmployeeType convertToEntityAttribute(String dbData) {
        return EmployeeType.valueOf(dbData.toUpperCase());
    }
}
