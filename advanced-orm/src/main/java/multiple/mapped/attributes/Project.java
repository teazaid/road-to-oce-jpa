package multiple.mapped.attributes;

import javax.persistence.*;

/**
 * Created by alexanderz on 24.02.16.
 */
@Entity
@IdClass(ProjectId.class)
public class Project {
    @Id
    private String name;
    @Id
    private DepId dept;

    //@MapKey(name="dept")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "DEPT_NUM", referencedColumnName = "NUM"),
            @JoinColumn(name = "DEPT_CTY", referencedColumnName = "COUNTRY"),
    })
    private Department department;

}
