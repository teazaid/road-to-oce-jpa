import guru.zaidel.BaseRunner;
import guru.zaidel.model.EmployeeOnVacation;
import guru.zaidel.model.VacationEntry;

import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

/**
 * Created by Alexander on 24.01.2016.
 */
public class Runner extends BaseRunner {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.baseFlow();
    }

    @Override
    public void doTheJob() {
        EmployeeOnVacation employeeOnVacation = new EmployeeOnVacation();

        VacationEntry vacationEntry = new VacationEntry();
        vacationEntry.setDaysTaken(4);
        vacationEntry.setStartDate(Calendar.getInstance());

        employeeOnVacation.setId(1l);
        employeeOnVacation.setNickNames(new HashSet<>(Arrays.asList("firstNickName", "secondNickName")));
        employeeOnVacation.setVacationBooking(Arrays.asList(vacationEntry));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employeeOnVacation);
        transaction.commit();


    }
}
