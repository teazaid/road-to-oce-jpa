package idclass;

import java.io.Serializable;

/**
 * Created by alexanderz on 23.02.16.
 */
public class EmployeeIdClass implements Serializable {
    private Long id;
    private String name;

    public EmployeeIdClass() {

    }

    public EmployeeIdClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
