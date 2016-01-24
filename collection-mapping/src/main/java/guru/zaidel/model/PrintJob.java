package guru.zaidel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class PrintJob {
    @Id
    private Long id;

    @ManyToOne
    private PrintQueue printQueue;

    public PrintJob() {
    }

    public PrintJob(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PrintQueue getPrintQueue() {
        return printQueue;
    }

    public void setPrintQueue(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }
}
