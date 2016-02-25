package embeddable.id;

import javax.persistence.*;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity
public class Project {
    @Id
    private long id;

    @MapsId("deptId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "DEPT_NUM", referencedColumnName = "id"),
            @JoinColumn(name = "DEPT_SS", referencedColumnName = "ss")
    })
    private Department department;
}
