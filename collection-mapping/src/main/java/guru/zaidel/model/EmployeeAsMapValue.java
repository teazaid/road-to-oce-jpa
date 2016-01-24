package guru.zaidel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class EmployeeAsMapValue {
    @Id
    private Long id;


    /*
    @ManyToOne
    private DepartmentAsMapOfEmployees departmentAsMapOfEmployees;

    create table EmployeeAsMapValue (
        id bigint not null,
        departmentAsMapOfEmployees_id bigint,
        employees_KEY varchar(255),
        primary key (id)
    )
     */


    /*
    @ManyToOne
    @JoinColumn(name = "dep_column")
    private DepartmentAsMapOfEmployees departmentAsMapOfEmployees;

    create table EmployeeAsMapValue (
        id bigint not null,
        dep_column bigint,
        emp_key varchar(255) not null,
        primary key (id)
    )
    */
    @ManyToOne
    @JoinColumn(name = "dep_column")
    private DepartmentAsMapOfEmployees departmentAsMapOfEmployees;

    public EmployeeAsMapValue() {
    }

    public EmployeeAsMapValue(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentAsMapOfEmployees getDepartmentAsMapOfEmployees() {
        return departmentAsMapOfEmployees;
    }

    public void setDepartmentAsMapOfEmployees(DepartmentAsMapOfEmployees departmentAsMapOfEmployees) {
        this.departmentAsMapOfEmployees = departmentAsMapOfEmployees;
    }
}
