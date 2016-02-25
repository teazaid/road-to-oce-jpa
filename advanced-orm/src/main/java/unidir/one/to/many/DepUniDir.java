package unidir.one.to.many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity
public class DepUniDir {
    @Id
    private Long id;

    @OneToMany
    @JoinTable(name="uni_dir")
    private Collection<EmployeeUniDir> employeeUniDirs;
}
