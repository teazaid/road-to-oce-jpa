package guru.zaidel.model;

import javax.persistence.*;

/**
 * Created by alexanderz on 22.02.16.
 */
@SqlResultSetMapping(
        name = "scalaMapping",
        columns = {@ColumnResult(name = "id")}
)
@NamedStoredProcedureQuery(name = "emp_fetch",
        procedureName = "emp_fetch",
        parameters = {
                @StoredProcedureParameter(name="empList", type = void.class, mode = ParameterMode.REF_CURSOR)
        },
        resultClasses = Customer.class
)
@NamedEntityGraph(
        attributeNodes = {
            @NamedAttributeNode("id")
        }
)
@Entity
public class Customer {
    @Id
    private Long id;

    @Embedded
    @AttributeOverride(name = "address.zip", column = @Column(name = "ZIP"))
    @AssociationOverrides({
            @AssociationOverride(name = "primaryPhone",
                joinColumns = @JoinColumn(name = "EMERG_PHONE")),
            @AssociationOverride(name = "phones",
                joinTable = @JoinTable(name = "CUST_PHONE"))
    })
    private ContactInfo contactInfo;
}
