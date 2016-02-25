package secondary.table;

import javax.persistence.*;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity
@Table(name = "EMP_SEC")
@SecondaryTable(name = "emp_sec_address",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMP_ID1"))
public class EmpSecondary {
    @Id
    private Long id;
    private String mainTableRecord;
    @Column(table = "EMP_SEC")
    private String secondatyTableRecord;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column = @Column(table = "EMP_SEC")),
            @AttributeOverride(name="zipCode", column = @Column(table = "EMP_SEC"))
    })
    private AddressWithSecondary addressWithSecondary;
}

@Embeddable
class AddressWithSecondary {
    private String street;
    private String zipCode;
}
