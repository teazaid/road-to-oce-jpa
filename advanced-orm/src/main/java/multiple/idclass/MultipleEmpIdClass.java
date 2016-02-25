package multiple.idclass;

import guru.zaidel.model.Employee;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexanderz on 25.02.16.
 */
@Entity
@IdClass(MEmpId.class)
@SecondaryTables({
    @SecondaryTable(name = "ORG_STRUCTURE",
        pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "COUNTRY", referencedColumnName = "COUNTRY"),
                @PrimaryKeyJoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
        }
    ),
    @SecondaryTable(name = "EMP_LOB",
            pkJoinColumns = {
                    @PrimaryKeyJoinColumn(name = "COUNTRY", referencedColumnName = "COUNTRY"),
                    @PrimaryKeyJoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
            }
    )
})
public class MultipleEmpIdClass {
    @Id
    private String country;
    @Id
    @Column(name = "EMP_ID")
    private int id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(table = "EMP_LOB")
    private byte[] photo;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "MGR_COUNTRY", referencedColumnName = "COUNTRY", table = "ORG_STRUCTURE"),
            @JoinColumn(name = "MGR_ID", referencedColumnName = "EMP_ID", table = "ORG_STRUCTURE")
    })
    private MultipleEmpIdClass manager;
}

class MEmpId implements Serializable {
    private String country;
    private int id;

    public MEmpId() {
    }

    public MEmpId(String country, int id) {
        this.country = country;
        this.id = id;
    }
}


