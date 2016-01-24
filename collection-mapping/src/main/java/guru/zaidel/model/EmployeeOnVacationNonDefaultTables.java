package guru.zaidel.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class EmployeeOnVacationNonDefaultTables {
    @Id
    private Long nonDefId;
    private String name;

    @AttributeOverride(name="daysTaken", column = @Column(name="days_given"))
    @ElementCollection(targetClass = VacationEntry.class)
    private Collection vacationBooking;

    @Column(name="not_his_nick_names")
    @ElementCollection
    @CollectionTable(name="NICK_NAMES_NON_DEF", joinColumns = @JoinColumn(name="his_nick_names_id"))
    private Set<String> nickNames;

    public Long getNonDefId() {
        return nonDefId;
    }

    public void setNonDefId(Long nonDefId) {
        this.nonDefId = nonDefId;
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
