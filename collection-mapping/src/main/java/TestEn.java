import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class TestEn {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
