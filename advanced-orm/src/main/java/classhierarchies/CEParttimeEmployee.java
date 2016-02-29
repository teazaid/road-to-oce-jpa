package classhierarchies;

import javax.persistence.Entity;

/**
 * Created by alexanderz on 29.02.16.
 */
@Entity
public class CEParttimeEmployee extends CECompanyEmployee {
    private float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
