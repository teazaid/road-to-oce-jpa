package compound.join.columns;

import guru.zaidel.model.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity
public class CompoundEmployee implements Serializable {
    @Id
    private String country;
    @Id
    @Column(name = "CEMP_ID")
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "MNG_COUNTRY", referencedColumnName = "COUNTRY"),
            @JoinColumn(name = "MNG_ID", referencedColumnName = "CEMP_ID")})
    private CompoundEmployee manager;

    @OneToMany(mappedBy = "manager")
    private Collection<CompoundEmployee> directs;
}
