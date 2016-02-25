package onetomany.advanced;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity
@Table(name = "DepD")
public class Department {
    @Id
    private Long dep__id;

    private String name;

    @OneToMany(mappedBy = "department")
    private Collection<Employee111> emp;

    public Long getId() {
        return dep__id;
    }

    public void setId(Long id) {
        this.dep__id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
