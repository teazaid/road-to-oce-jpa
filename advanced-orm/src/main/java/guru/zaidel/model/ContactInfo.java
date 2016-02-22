package guru.zaidel.model;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by alexanderz on 22.02.16.
 */
@Embeddable
public class ContactInfo {
    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRI_NUM")
    private Phone primaryPhone;

    @ManyToMany
    @MapKey(name = "type")
    @JoinTable(name = "EMP_PHONES")
    private Map<String, Phone> phones;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(Phone primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public Map<String, Phone> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, Phone> phones) {
        this.phones = phones;
    }
}
