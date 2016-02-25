package multiple.mapped.attributes;

import java.io.Serializable;

/**
 * Created by alexanderz on 24.02.16.
 */
public class DepId implements Serializable {
    private int number;
    private String country;

    public DepId() {
    }

    public DepId(int number, String country) {
        this.number = number;
        this.country = country;
    }

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
