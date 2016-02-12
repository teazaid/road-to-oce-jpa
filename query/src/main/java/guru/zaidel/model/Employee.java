package guru.zaidel.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexanderz on 11.02.16.
 */
@Entity
public class Employee {
    @Id
    private Long id;

    private String name;

    /*
    * employee_number
    * Employee_id
    * number_id
    * numbers_key
    * */

    @ElementCollection
    @MapKeyColumn(name = "map_key_column")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<NumberType, Number> numbers = new HashMap<>();

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

    public Map<NumberType, Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(Map<NumberType, Number> numbers) {
        this.numbers = numbers;
    }
}
