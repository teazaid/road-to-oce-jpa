package onetomany.advanced;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by alexanderz on 25.02.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("advanced-orm-unit");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}
