package guru.zaidel.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alexanderz on 22.02.16.
 */
@Converter(autoApply = true)
public class UrlToStringConverter implements AttributeConverter<URL, String> {
    @Override
    public String convertToDatabaseColumn(URL attribute) {
        return attribute.toString();
    }

    @Override
    public URL convertToEntityAttribute(String dbData) {
        URL result = null;
        try {
            result = new URL(dbData);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
