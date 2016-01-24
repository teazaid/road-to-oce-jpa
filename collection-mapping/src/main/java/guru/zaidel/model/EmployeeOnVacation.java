package guru.zaidel.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Alexander on 24.01.2016.
 */
@Table(name = "nonEmployeeOnVacation")
@Entity
public class EmployeeOnVacation {
    @Id
    private Long nonId;
    private String name;

    @ElementCollection(targetClass = VacationEntry.class)
    private Collection vacationBooking;

    @ElementCollection
    private Set<String> nickNames;

    public Long getId() {
        return nonId;
    }

    public void setId(Long id) {
        this.nonId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getVacationBooking() {
        return vacationBooking;
    }

    public void setVacationBooking(Collection vacationBooking) {
        this.vacationBooking = vacationBooking;
    }

    public Set<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Set<String> nickNames) {
        this.nickNames = nickNames;
    }
}
