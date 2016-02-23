package idclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by alexanderz on 23.02.16.
 */
@Entity
@IdClass(EmployeeIdClass.class)
public class EmployeeWithIdClass {
    @Id
    private Long id;
    @Id
    @Column(name = "name_id")
    private String name;

    private String field;

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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
