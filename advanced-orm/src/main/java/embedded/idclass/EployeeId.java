package embedded.idclass;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by alexanderz on 23.02.16.
 */
@Embeddable
public class EployeeId implements Serializable {
    private Long id;
    private String name;

    public EployeeId() {}

    public EployeeId(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
