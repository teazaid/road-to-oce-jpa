package guru.zaidel.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Alexander on 24.01.2016.
 */
@Embeddable
public class VacationEntry {
    @Temporal(value = TemporalType.DATE)
    private Calendar startDate;

    @Basic
    @Column(name = "DAYS")
    private int daysTaken;

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public int getDaysTaken() {
        return daysTaken;
    }

    public void setDaysTaken(int daysTaken) {
        this.daysTaken = daysTaken;
    }
}
