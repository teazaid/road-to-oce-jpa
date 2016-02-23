package idclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by alexanderz on 23.02.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("advanced-orm-unit");
        EntityManager em = emf.createEntityManager();

        EmployeeWithIdClass employeeWithIdClass = new EmployeeWithIdClass();
        employeeWithIdClass.setField("field");
        employeeWithIdClass.setId(1l);
        employeeWithIdClass.setName("name");

        em.persist(employeeWithIdClass);

        EmployeeIdClass id = new EmployeeIdClass(1l, "name");

        EmployeeWithIdClass employeeWithIdClass1 = em.find(EmployeeWithIdClass.class, id);
        System.out.println(employeeWithIdClass1.getField());

        em.close();
        emf.close();
    }
}
