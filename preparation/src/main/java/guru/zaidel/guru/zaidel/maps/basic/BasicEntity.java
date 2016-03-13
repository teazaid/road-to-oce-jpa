package guru.zaidel.guru.zaidel.maps.basic;

import javax.persistence.*;

/**
 * Created by alexanderz on 12.03.16.
 */
@Entity
public class BasicEntity {
    @Id
    private long id;
    @Basic
    private String name;

    @ManyToOne
    @JoinTable(name = "basicEntity_table",
        joinColumns = @JoinColumn(name = "basicEntity_id"),
            inverseJoinColumns = @JoinColumn(name = "basicEmployee_id")
    )
    private BasicEmployee basicEmployee;
}
