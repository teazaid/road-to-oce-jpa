package guru.zaidel.model;

import javax.persistence.*;

/**
 * Created by alexanderz on 21.02.16.
 */
@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Convert(converter = BooleanToIntConverter.class)
    private boolean bounded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBounded() {
        return bounded;
    }

    public void setBounded(boolean bounded) {
        this.bounded = bounded;
    }
}
