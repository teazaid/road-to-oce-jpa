package embedded.idclass;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by alexanderz on 23.02.16.
 */
@Entity
public class EployeeEntity {

    @EmbeddedId
    private EployeeId id;

    private String field;

    public EployeeId getId() {
        return id;
    }

    public void setId(EployeeId id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
