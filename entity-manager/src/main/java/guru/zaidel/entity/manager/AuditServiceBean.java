package guru.zaidel.entity.manager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alexander on 25.01.2016.
 */
@Stateless
public class AuditServiceBean implements AuditService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void logTransaction(int empId, String action) {
        if(em.find(String.class, empId) == null) {
            throw new IllegalArgumentException("");
        }

    }
}
