package guru.zaidel;

import guru.zaidel.model.PrintJob;
import guru.zaidel.model.PrintQueue;

import javax.persistence.EntityTransaction;
import java.util.Arrays;

/**
 * Created by Alexander on 24.01.2016.
 */
public class OrderColumnRunner extends BaseRunner {
    public static void main(String[] args) {
        OrderColumnRunner runner = new OrderColumnRunner();
        runner.baseFlow();
    }

    @Override
    public void doTheJob() {
        PrintQueue queue = new PrintQueue();
        queue.setJobs(Arrays.asList(new PrintJob(1l), new PrintJob(2l)));
        queue.setId(1l);


        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(queue);
        transaction.commit();

        entityManager.clear();

        transaction = entityManager.getTransaction();
        transaction.begin();
        PrintQueue queue1 = entityManager.find(PrintQueue.class, 1l);
        for(PrintJob job: queue1.getJobs()) {
            System.out.println(job.getId());
        }
        transaction.commit();
    }
}
