import guru.zaidel.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by alexanderz on 16.02.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("criteria-api-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        employee.setName("Tester");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);

        transaction.commit();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> emp = query.from(Employee.class);

        query.select(emp).where(criteriaBuilder.equal(emp.get("name"), "Tester"));

//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        cb.createQuery();
//        cb.createQuery(Class.class);
//        cb.createTupleQuery()

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        cb.createQuery().

        entityManager.close();
        entityManagerFactory.close();
    }
}
