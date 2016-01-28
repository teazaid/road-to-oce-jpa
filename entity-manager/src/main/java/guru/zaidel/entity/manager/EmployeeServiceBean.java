package guru.zaidel.entity.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alexander on 25.01.2016.
 */
@Stateless
public class EmployeeServiceBean {
    @PersistenceContext
    private EntityManager em;

    @EJB
    private AuditService service;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createEmployee(String employee) {
        em.persist(employee);
        service.logTransaction(1, "action");
    }
}
