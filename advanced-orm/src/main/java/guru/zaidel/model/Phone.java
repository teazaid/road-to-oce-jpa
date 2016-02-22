package guru.zaidel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by alexanderz on 22.02.16.
 */
@Entity
public class Phone {
    @Id
    private String num;

    private String type;

    @ManyToMany(mappedBy = "contactInfo.phones")
    private java.util.List<Employee> employees;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
