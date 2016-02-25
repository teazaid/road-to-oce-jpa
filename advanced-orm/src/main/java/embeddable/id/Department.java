package embeddable.id;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity
public class Department {
    @EmbeddedId
    private DeptId deptId;

    @OneToMany(mappedBy = "department")
    private java.util.List<Project> projects;
}
