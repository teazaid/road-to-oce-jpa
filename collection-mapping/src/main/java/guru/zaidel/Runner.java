package guru.zaidel;

import guru.zaidel.model.*;

import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
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
        EmployeeOnVacationNonDefaultId employeeOnVacationNonDefaultId = new EmployeeOnVacationNonDefaultId();
        EmployeeOnVacationNonDefaultTables employeeOnVacationNonDefaultTables = new EmployeeOnVacationNonDefaultTables();

        VacationEntry vacationEntry = new VacationEntry();
        vacationEntry.setDaysTaken(4);
        vacationEntry.setStartDate(Calendar.getInstance());

        employeeOnVacation.setId(1l);
        employeeOnVacation.setNickNames(new HashSet<>(Arrays.asList("firstNickName", "secondNickName")));
        employeeOnVacation.setVacationBooking(Arrays.asList(vacationEntry));

        employeeOnVacationNonDefaultId.setNonDefId(1l);
        employeeOnVacationNonDefaultId.setNickNames(new HashSet<>(Arrays.asList("firstNickName")));
        employeeOnVacationNonDefaultId.setVacationBooking(Arrays.asList(vacationEntry));

        employeeOnVacationNonDefaultTables.setNonDefId(1l);
        employeeOnVacationNonDefaultTables.setVacationBooking(Arrays.asList(vacationEntry));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employeeOnVacation);
        transaction.commit();


        EmployeeOrderBy employeeOrderBy = new EmployeeOrderBy();
        employeeOrderBy.setId(1l);
        employeeOrderBy.setInfos(Arrays.asList(new Info("str1", 1), new Info("str2", 2)));

        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employeeOrderBy);
        transaction.commit();

        //TDODO dont throw exception, because the values were cached
        //entityManager.clear();

        transaction = entityManager.getTransaction();
        transaction.begin();
        EmployeeOrderBy employeeOrderBy1 = entityManager.find(EmployeeOrderBy.class, 1l);

        for(Info i: employeeOrderBy1.getInfos()) {
            System.out.println(i.getInfoStr());
        }

        transaction.commit();

        EmployeeSimpleMap employeeSimpleMap = new EmployeeSimpleMap(1l);
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        HashMap<PhoneType, String> stringStringHashMapEnum = new HashMap<PhoneType, String>();
        employeeSimpleMap.setPhoneNumbers(stringStringHashMap);
        employeeSimpleMap.setPhoneNumbersEnum(stringStringHashMapEnum);

        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employeeSimpleMap);
        transaction.commit();


    }
}
