import guru.zaidel.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 * Created by alexanderz on 20.02.16.
 */
public class Runner2 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("criteria-api-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> from = query.from(Employee.class);
        Join<Object, Object> department = from.join("department");

        cb.in(from.get("department").get("name")).value("DEP1").value("DEP2");
        from.get("department").get("name").in("DEP1", "DEP2");


        CriteriaBuilder cb2 = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query1 = cb2.createQuery(Employee.class);
        Root<Employee> root = query1.from(Employee.class);

        query1.multiselect(cb2.selectCase(root.get("name"))
                .when(String.class, cb2.equal(root.get("name"),"1"))
                .when(String.class, cb2.equal(root.get("name"),"2"))
                .otherwise("3"),
                cb2.coalesce()
                        .value(root.get("name"))
                        .value(root.get("id")),
                cb2.coalesce(root.get("name"), root.get("id"))

        ).where(cb2.equal(root.get("department").get("name"), "_") );

        entityManager.close();
        entityManagerFactory.close();
    }
}
