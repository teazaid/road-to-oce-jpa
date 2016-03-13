package guru.zaidel;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alexanderz on 07.03.16.
 */
public class Runner {
    @PersistenceContext
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("preparation-unit");
        EntityManager em = emf.createEntityManager();

        /*Employee employee = new Employee();
        employee.setAttributes(Arrays.asList(new Attributes("as"), new Attributes("as11")));

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(employee);

        transaction.commit();

        em.clear();

        transaction = em.getTransaction();
        transaction.begin();
        Employee employee1 = em.find(Employee.class, 1l);

        employee1.getAttributes().size();


        transaction.commit();*/
        em.close();
        emf.close();
    }
}
