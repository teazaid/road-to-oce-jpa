package guru.zaidel.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class EmployeeOrderBy {
    @Id
    private Long id;

//    @OrderBy("infoStr DESC")
    @OrderBy("infor DESC")
    @ElementCollection
    List<Info> infos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }
}
