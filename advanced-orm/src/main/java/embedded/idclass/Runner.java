package embedded.idclass;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alexanderz on 23.02.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("advanced-orm-unit");
        EntityManager em = emf.createEntityManager();

        EployeeEntity eployeeEntity = new EployeeEntity();
        EployeeId sda = new EployeeId(1l, "sda");
        eployeeEntity.setId(sda);
        eployeeEntity.setField("fff");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(eployeeEntity);
        transaction.commit();

        TypedQuery<EployeeEntity> query = em.createQuery("select ee from EployeeEntity ee where ee.id.id = ?1  and ee.id.name = ?2", EployeeEntity.class);
        query.setParameter(1, 1l);
        query.setParameter(2, "sda");

        List<EployeeEntity> resultList = query.getResultList();
        for(EployeeEntity ee: resultList) {
            System.out.println(ee.getField());
        }


        EployeeEntity eployeeEntity1 = em.find(EployeeEntity.class, sda);

        System.out.println(eployeeEntity1.getField());

        em.close();
        emf.close();
    }
}
