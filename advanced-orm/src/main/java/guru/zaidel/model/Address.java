package guru.zaidel.model;

import javax.persistence.Embeddable;

/**
 * Created by alexanderz on 22.02.16.
 */
@Embeddable
public class Address {

    private String street;

    private String city;

    private String state;

    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
