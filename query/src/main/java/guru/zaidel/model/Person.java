package guru.zaidel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alexanderz on 04.02.16.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "person")
    private Collection<Phone> phones = new ArrayList<Phone>();

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

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }
}

