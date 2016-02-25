package derived.id;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by alexanderz on 24.02.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("advanced-orm-unit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        DerEmployee derEmployee = new DerEmployee();
        derEmployee.setName("1");
        derEmployee.setId(1l);
        DerEmployeeHistory derEmployeeHistory = new DerEmployeeHistory();
        derEmployeeHistory.setDerEmployee(derEmployee);
        derEmployee.setDerEmployeeHistory(derEmployeeHistory);

        DerEmployeeTwo derEmployeeTwo = new DerEmployeeTwo();
        derEmployee.setName("1");

        DerHistoryAnother derHistoryAnother = new DerHistoryAnother();
        derHistoryAnother.setDerEmployeeTwo(derEmployeeTwo);


        em.persist(derEmployeeHistory);
        em.persist(derEmployee);
        em.persist(derEmployeeTwo);
        em.persist(derHistoryAnother);

        transaction.commit();

        em.close();
        emf.close();
    }
}
