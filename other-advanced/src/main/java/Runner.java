import guru.zaidel.model.Employee;

import javax.persistence.*;

/**
 * Created by alexanderz on 02.03.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("other-advanced-orm-unit");
        EntityManager em = emf.createEntityManager();

        Employee employee = new Employee();
        employee.setId(1l);


        /*ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory.getValidator().validate();*/

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(employee);
        transaction.commit();
        em.clear();

        Persistence.getPersistenceUtil().isLoaded(employee);

        transaction = em.getTransaction();
        transaction.begin();
        Employee employee1 = em.find(Employee.class, 1l, LockModeType.PESSIMISTIC_WRITE);
        employee1.setName("name");

        transaction.commit();
        em.clear();;

        em.close();
        emf.close();
    }
}
