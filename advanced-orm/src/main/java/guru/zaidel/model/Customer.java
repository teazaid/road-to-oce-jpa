package guru.zaidel.model;

import javax.persistence.*;

/**
 * Created by alexanderz on 22.02.16.
 */
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
