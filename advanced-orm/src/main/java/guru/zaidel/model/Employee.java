package guru.zaidel.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Created by alexanderz on 21.02.16.
 */
@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Embedded
    private ContactInfo contactInfo;

    @Convert(converter = BooleanToIntConverter.class)
    private boolean bounded;

    @Embedded
    @Convert(converter = StringToIntConverter.class, attributeName = "content")
    private EmployeeInfo employeeInfo;

    @Convert(converter = BooleanToIntConverter.class)
    @ElementCollection
    private java.util.List<Boolean> booleans;

    @ElementCollection
    @Convert(converter = StringToIntConverter.class, attributeName = "key.content")
    private Map<EmployeeInfo, Integer> typeCount;

    @Enumerated
    @Convert(converter = EmployeeTypeConverter.class)
    private EmployeeType employeeType;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Map<EmployeeInfo, Integer> getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(Map<EmployeeInfo, Integer> typeCount) {
        this.typeCount = typeCount;
    }

    public List<Boolean> getBooleans() {
        return booleans;
    }

    public void setBooleans(List<Boolean> booleans) {
        this.booleans = booleans;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBounded() {
        return bounded;
    }

    public void setBounded(boolean bounded) {
        this.bounded = bounded;
    }
}
