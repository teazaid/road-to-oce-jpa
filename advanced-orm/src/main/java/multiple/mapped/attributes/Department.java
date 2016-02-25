package multiple.mapped.attributes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by alexanderz on 24.02.16.
 */
@Entity
@IdClass(DepId.class)
public class Department {
    @Id
    @Column(name="NUM")
    private int number;
    @Id
    @Column(name="COUNTRY")
    private String country;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
