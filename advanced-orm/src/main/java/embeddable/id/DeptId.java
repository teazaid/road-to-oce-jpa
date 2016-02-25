package embeddable.id;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by alexanderz on 25.02.16.
 */
@Embeddable
public class DeptId implements Serializable {
    private int id;
    private String ss;

    public DeptId() {
    }

    public DeptId(int id, String ss) {
        this.id = id;
        this.ss = ss;
    }

    public int getId() {
        return id;
    }

    public String getSs() {
        return ss;
    }
}