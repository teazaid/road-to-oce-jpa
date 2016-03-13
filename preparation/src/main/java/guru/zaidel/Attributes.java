package guru.zaidel;

import javax.persistence.Embeddable;

/**
 * Created by alexanderz on 07.03.16.
 */
@Embeddable
public class Attributes {
    public Attributes() {
    }

    public Attributes(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
