package onetomany.advanced;

import javax.persistence.*;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity(name="EMP")
@Table(name = "EmpD")
public class Employee111 {
    @Id
    private Long emp_id;

    @ManyToOne
    @JoinTable(name = "emp_dep_additional")
    private Department department;

    public Long getId() {
        return emp_id;
    }

    public void setId(Long id) {
        this.emp_id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
