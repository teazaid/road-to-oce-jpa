package guru.zaidel.model;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class EmployeeAsMapValueManyToMany {
    @Id
    private Long id;

    @JoinTable(name="DEP_EMP_TABLE", joinColumns = @JoinColumn(name="emp_id"),
            inverseJoinColumns = @JoinColumn(name="dep_id"))
    @MapKeyColumn(name="dep_key")
    @ManyToMany
    private Map<String, DepartmentAsMapOfEmployeesManyToMany> departmentsAsMapOfEmployeesManyToMany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, DepartmentAsMapOfEmployeesManyToMany> getDepartmentsAsMapOfEmployeesManyToMany() {
        return departmentsAsMapOfEmployeesManyToMany;
    }

    public void setDepartmentsAsMapOfEmployeesManyToMany(Map<String, DepartmentAsMapOfEmployeesManyToMany> departmentsAsMapOfEmployeesManyToMany) {
        this.departmentsAsMapOfEmployeesManyToMany = departmentsAsMapOfEmployeesManyToMany;
    }
}
