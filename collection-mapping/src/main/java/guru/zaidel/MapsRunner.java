package guru.zaidel;

import javax.persistence.EntityTransaction;

/**
 * Created by Alexander on 24.01.2016.
 */
public class MapsRunner extends BaseRunner {
    public static void main(String[] args) {
        MapsRunner mapsRunner = new MapsRunner();
        mapsRunner.baseFlow();
    }

    @Override
    public void doTheJob() {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        transaction.commit();
    }
}
