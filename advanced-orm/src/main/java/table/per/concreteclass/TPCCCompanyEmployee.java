package table.per.concreteclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by alexanderz on 29.02.16.
 */
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "New_NAme"))
})
public class TPCCCompanyEmployee extends TPCCEmployee {
}
