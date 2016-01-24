package guru.zaidel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Alexander on 24.01.2016.
 */
public abstract class BaseRunner {
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    public void baseFlow() {
        init();
        try{
            doTheJob();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void doTheJob() {

    }

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-preparation");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void close() {
        if(entityManager != null) entityManager.close();
        if(entityManagerFactory != null) entityManagerFactory.close();
    }

}
