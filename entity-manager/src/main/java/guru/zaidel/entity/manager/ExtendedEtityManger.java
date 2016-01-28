package guru.zaidel.entity.manager;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by Alexander on 25.01.2016.
 */
@Stateful
public class ExtendedEtityManger {
    @PersistenceContext(unitName = "", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
}
