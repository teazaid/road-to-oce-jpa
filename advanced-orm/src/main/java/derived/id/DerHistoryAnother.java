package derived.id;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexanderz on 24.02.16.
 */
@Entity
public class DerHistoryAnother implements Serializable {
    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "another_id")
    private DerEmployeeTwo DerEmployeeTwo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public derived.id.DerEmployeeTwo getDerEmployeeTwo() {
        return DerEmployeeTwo;
    }

    public void setDerEmployeeTwo(derived.id.DerEmployeeTwo derEmployeeTwo) {
        DerEmployeeTwo = derEmployeeTwo;
    }
}
