package guru.zaidel;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;

/**
 * Created by alexanderz on 07.03.16.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idField;

    @ElementCollection
    @OrderBy(value = "name ASC")
    //@OrderColumn
    private Collection<Attributes> attributes;

    @ManyToOne
    private Department department;

    @ElementCollection(targetClass = String.class)
    private Collection names;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "e_last_names",
            joinColumns = {@JoinColumn(name="join_column")})
    @Column(name = "not_last_names")
    private Collection lastNames;

    @ElementCollection
    @MapKeyColumn(name = "mk_column")
    private Map<String, String> phoneNumbers;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Collection getNames() {
        return names;
    }

    public void setNames(Collection names) {
        this.names = names;
    }

    public long getIdField() {
        return idField;
    }

    public void setIdField(long idField) {
        this.idField = idField;
    }

    public Collection<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<Attributes> attributes) {
        this.attributes = attributes;
    }

    public Collection getLastNames() {
        return lastNames;
    }

    public void setLastNames(Collection lastNames) {
        this.lastNames = lastNames;
    }
}
