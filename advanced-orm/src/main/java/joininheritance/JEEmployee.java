package joininheritance;

import javax.persistence.*;

/**
 * Created by alexanderz on 29.02.16.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "DISCR")
public class JEEmployee {
}
