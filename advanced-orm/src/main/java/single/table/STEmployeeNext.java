package single.table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by alexanderz on 29.02.16.
 */
@Entity
@DiscriminatorValue(value = "DiscriminatorForThisClass")
public class STEmployeeNext extends STEmployee {
}
