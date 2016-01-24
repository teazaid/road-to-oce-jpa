package guru.zaidel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.List;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class PrintQueue {
    @Id
    private Long id;

    @OrderColumn(name = "NON_DEF_JOBS")
    //DOTO @OrderColumn default is jobs_ORDER
    @OneToMany(mappedBy = "printQueue")
    private List<PrintJob> jobs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PrintJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<PrintJob> jobs) {
        this.jobs = jobs;
    }
}
