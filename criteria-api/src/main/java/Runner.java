import guru.zaidel.model.Department;
import guru.zaidel.model.Employee;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
        CriteriaQuery<Department> departmentCriteriaQuery = cb.createQuery(Department.class);
        Root<Department> fromDepartment = departmentCriteriaQuery.from(Department.class);
        Root<Employee> fromEmployee = departmentCriteriaQuery.from(Employee.class);

        departmentCriteriaQuery.select(fromDepartment).distinct(true).where(cb.equal(fromDepartment, fromEmployee.get("department")));

        TypedQuery<Department> query1 = entityManager.createQuery(departmentCriteriaQuery);
        List<Department> resultList = query1.getResultList();

        /*
        * select distinct d from department d, employee e where d = e.department
        * */

        entityManager.close();
        entityManagerFactory.close();
    }
}
