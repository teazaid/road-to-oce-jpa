import guru.zaidel.model.Employee;
import guru.zaidel.model.EmployeeType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by alexanderz on 21.02.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("advanced-orm-unit");
        EntityManager em = emf.createEntityManager();

        Employee e = new Employee();
        e.setBounded(true);

        e.setEmployeeType(EmployeeType.ASSISTANT);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();

        em.close();
        emf.close();
    }
}
