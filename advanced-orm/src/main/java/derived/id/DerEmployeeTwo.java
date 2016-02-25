package derived.id;

import javax.persistence.*;

/**
 * Created by alexanderz on 24.02.16.
 */
@Entity
public class DerEmployeeTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@OneToOne(mappedBy = "derEmployee")
    /*
        * create table DerEmployee (
        id bigint not null,
        name varchar(255),
        primary key (id)
    )
Hibernate:
    create table DerEmployeeHistory (
        EMP_ID bigint not null,
        primary key (EMP_ID)
    )
        * */

    /*
    Hibernate:
    create table DerEmployee (
        id bigint not null,
        name varchar(255),
        derEmployeeHistory_EMP_ID bigint,
        primary key (id)
    )
Hibernate:
    create table DerEmployeeHistory (
        EMP_ID bigint not null,
        primary key (EMP_ID)
    )
    */
    @OneToOne(mappedBy = "derEmployee")
    private DerEmployeeHistory derEmployeeHistory;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DerEmployeeHistory getDerEmployeeHistory() {
        return derEmployeeHistory;
    }

    public void setDerEmployeeHistory(DerEmployeeHistory derEmployeeHistory) {
        this.derEmployeeHistory = derEmployeeHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
