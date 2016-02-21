package guru.zaidel.model;

import javax.persistence.AttributeConverter;

/**
 * Created by alexanderz on 21.02.16.
 */
public class BooleanToIntConverter implements AttributeConverter<Boolean, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        return attribute ? 1 : 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer dbData) {
        return dbData > 0 ? true : false;
    }
}
