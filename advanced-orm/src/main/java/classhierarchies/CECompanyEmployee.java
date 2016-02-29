package classhierarchies;

import javax.persistence.MappedSuperclass;

/**
 * Created by alexanderz on 29.02.16.
 */
@MappedSuperclass
public abstract class CECompanyEmployee extends CEEmployee {
    private int vacation;

    public int getVacation() {
        return vacation;
    }

    public void setVacation(int vacation) {
        this.vacation = vacation;
    }
}
