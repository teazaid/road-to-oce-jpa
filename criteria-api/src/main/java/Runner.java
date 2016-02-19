import guru.zaidel.model.Department;
import guru.zaidel.model.Employee;
import guru.zaidel.model.EmployeeInfo;

import javax.persistence.*;
import javax.persistence.criteria.*;
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


        CriteriaBuilder myCriteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> myQuery = myCriteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = myQuery.from(Employee.class);
        myQuery.select(from.get("name"));

        CriteriaQuery<Tuple> myQueryTuple = myCriteriaBuilder.createTupleQuery();
        Root<Employee> tupleRoot = myQueryTuple.from(Employee.class);


        myQueryTuple.select(myCriteriaBuilder.tuple(tupleRoot.get("name"), tupleRoot.get("id")));
        myQueryTuple.multiselect(tupleRoot.get("name"), tupleRoot.get("id"));

        myQuery.select(from).where(myCriteriaBuilder.equal(from.get("department").get("name"), "New York"));
        /*
        * select distinct d from department d, employee e where d = e.department
        * */

        CriteriaQuery<Object[]> query2 = criteriaBuilder.createQuery(Object[].class);
        Root<Employee> from1 = query2.from(Employee.class);
        query2.multiselect(from1.get("id"), from1.get("name"));
        query2.multiselect(cb.construct(EmployeeInfo.class, from1.get("id"), from1.get("name")) );

        CriteriaQuery<EmployeeInfo> query3 = cb.createQuery(EmployeeInfo.class);
        Root<Employee> from2 = query3.from(Employee.class);
        query3.select(cb.construct(EmployeeInfo.class, from2.get("name"), from2.get("id")));

        CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
        Root<Employee> e = tupleQuery.from(Employee.class);
        tupleQuery.multiselect(e.get("id").alias("id"), e.get("name").alias("fullName"));

        Join<Employee, Department> department = e.join("department", JoinType.INNER);
        Fetch<Object, Object> department1 = e.fetch("department", JoinType.INNER);

        tupleQuery.multiselect(e);

        TypedQuery<Tuple> query4 = entityManager.createQuery(tupleQuery);
        List<Tuple> resultList1 = query4.getResultList();
        for(Tuple t: resultList1) {
            System.out.println(t.get("id") + " " + t.get("fullName"));
        }

        CriteriaBuilder criteriaBuilder1 = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query5 = criteriaBuilder1.createQuery(Employee.class);

        Root<Employee> from3 = query5.from(Employee.class);
        from3.fetch("department", JoinType.LEFT);
        query5.select(from3).distinct(true);


        entityManager.close();
        entityManagerFactory.close();
    }
}
