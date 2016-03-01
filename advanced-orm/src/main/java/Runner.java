import guru.zaidel.model.Customer;
import guru.zaidel.model.Employee;
import guru.zaidel.model.EmployeeType;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

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

        StoredProcedureQuery q = em.createStoredProcedureQuery("hello");
        q.registerStoredProcedureParameter("name", String.class, ParameterMode.INOUT);
        q.execute();
        q.getOutputParameterValue("name");

        StoredProcedureQuery fetch_emp = em.createStoredProcedureQuery("fetch_emp");
        fetch_emp.registerStoredProcedureParameter("empList", void.class, ParameterMode.REF_CURSOR);
        if(q.execute()) {
            java.util.List<Employee> empList = (java.util.List<Employee>) fetch_emp.getOutputParameterValue("empList");
        }

        EntityGraph<Employee> entityGraph = em.createEntityGraph(Employee.class);
        entityGraph.addAttributeNodes("id");
        Subgraph<Customer> project = entityGraph.addSubgraph("project", Customer.class);

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("javax.persistence.fetchgraph", em.getEntityGraph("entityGraph"));

        em.find(Employee.class, 1l, props);

        em.close();
        emf.close();
    }
}
