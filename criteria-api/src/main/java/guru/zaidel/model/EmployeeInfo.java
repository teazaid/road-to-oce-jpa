package guru.zaidel.model;

/**
 * Created by alexanderz on 17.02.16.
 */
public class EmployeeInfo {
    private Long id;
    private String name;

    public EmployeeInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
