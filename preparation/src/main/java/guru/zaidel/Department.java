package guru.zaidel;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by alexanderz on 09.03.16.
 */
@Entity
public class Department {
    @Id
    private long id;

    @OneToMany(mappedBy = "department")
    //@MapKeyColumn(name = "CUB_ID")
    @MapKey(name = "idField")
    private Map<String, Employee> employeeByCubilce;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Employee> getEmployeeByCubilce() {
        return employeeByCubilce;
    }

    public void setEmployeeByCubilce(Map<String, Employee> employeeByCubilce) {
        this.employeeByCubilce = employeeByCubilce;
    }
}
