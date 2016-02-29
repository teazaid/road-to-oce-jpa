package classhierarchies;

import javax.persistence.Entity;

/**
 * Created by alexanderz on 29.02.16.
 */
@Entity
public class CEFulltimeEmployee extends CECompanyEmployee {
    private long salary;
    private long pension;

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getPension() {
        return pension;
    }

    public void setPension(long pension) {
        this.pension = pension;
    }
}
