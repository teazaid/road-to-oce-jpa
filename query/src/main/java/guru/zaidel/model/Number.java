package guru.zaidel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by alexanderz on 11.02.16.
 */
@Entity
public class Number {
    @Id
    private Long id;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
