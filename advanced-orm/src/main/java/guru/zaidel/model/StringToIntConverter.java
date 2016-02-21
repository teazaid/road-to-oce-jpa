package guru.zaidel.model;

import javax.persistence.AttributeConverter;

/**
 * Created by alexanderz on 21.02.16.
 */
public class StringToIntConverter implements AttributeConverter<String, Integer> {
    @Override
    public Integer convertToDatabaseColumn(String attribute) {
        return attribute == null ? 0 : attribute.length();
    }

    @Override
    public String convertToEntityAttribute(Integer dbData) {
        return dbData.toString();
    }
}
