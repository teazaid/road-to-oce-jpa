package guru.zaidel.model;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class DepartmentAsMapOfEmployees {
    @Id
    private Long lol;

    @OneToMany(mappedBy = "departmentAsMapOfEmployees")
    @MapKeyColumn(name="emp_key")
    private Map<String, EmployeeAsMapValue> employees;

    public DepartmentAsMapOfEmployees() {
    }

    public DepartmentAsMapOfEmployees(Long id) {
        this.lol = id;
    }

    public Long getId() {
        return lol;
    }

    public void setId(Long id) {
        this.lol = id;
    }

    public Map<String, EmployeeAsMapValue> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, EmployeeAsMapValue> employees) {
        this.employees = employees;
    }
}
