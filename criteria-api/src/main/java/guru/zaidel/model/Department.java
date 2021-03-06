package guru.zaidel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by alexanderz on 16.02.16.
 */
@Entity
public class Department {
    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
