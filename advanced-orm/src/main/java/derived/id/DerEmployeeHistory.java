package derived.id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by alexanderz on 24.02.16.
 */
@Entity
// Composite-id class must implement Serializable: derived.id.DerEmployeeHistory
public class DerEmployeeHistory implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "EMP_ID")
    private DerEmployee derEmployee;

    public DerEmployee getDerEmployee() {
        return derEmployee;
    }

    public void setDerEmployee(DerEmployee derEmployee) {
        this.derEmployee = derEmployee;
    }
}
