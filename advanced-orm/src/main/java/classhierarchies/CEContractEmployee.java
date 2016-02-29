package classhierarchies;

import javax.persistence.Entity;

/**
 * Created by alexanderz on 29.02.16.
 */
@Entity
public class CEContractEmployee extends CEEmployee {
    private int dailyRate;
    private int term;

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
