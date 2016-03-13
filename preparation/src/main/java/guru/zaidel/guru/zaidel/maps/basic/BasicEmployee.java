package guru.zaidel.guru.zaidel.maps.basic;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by alexanderz on 12.03.16.
 */
@Entity
public class BasicEmployee {
    @Id
    private long id;

    @ElementCollection
    @CollectionTable(name = "basic_map")
    @Column(name="basic_value")
    @MapKeyColumn(name = "basic_key")
    private Map<Integer, Integer> basicBasicMap;


    @ElementCollection
    @AttributeOverrides(value = {
            //@AttributeOverride(name = "value.firstColumn", column = @Column(name = "first_value")),
            @AttributeOverride(name = "firstColumn", column = @Column(name = "first_value")),
            //@AttributeOverride(name = "value.secondColumn", column = @Column(name = "second_value"))
            @AttributeOverride(name = "secondColumn", column = @Column(name = "second_value"))
    })
    private Map<Integer, BasicEmbeddable> basicEmbeddableMap;


    @OneToMany(mappedBy = "basicEmployee")
    @MapKey
    private Map<Integer, BasicEntity> basicEntityMap;
}
