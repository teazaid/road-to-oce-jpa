package guru.zaidel.model;

import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * Created by alexanderz on 02.03.16.
 */
@OptimisticLocking
@Entity
public class Employee {
    @Id
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    private Long version;
}
