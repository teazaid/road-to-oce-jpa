package multiple.mapped.attributes;

import java.io.Serializable;

/**
 * Created by alexanderz on 24.02.16.
 */
public class ProjectId implements Serializable {
    private String name;
    private DepId dept;

    public ProjectId() {
    }

    public ProjectId(String name, DepId dept) {
        this.name = name;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepId getDept() {
        return dept;
    }

    public void setDept(DepId dept) {
        this.dept = dept;
    }
}
