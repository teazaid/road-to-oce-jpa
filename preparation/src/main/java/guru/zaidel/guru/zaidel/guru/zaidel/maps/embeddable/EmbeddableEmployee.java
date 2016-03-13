package guru.zaidel.guru.zaidel.guru.zaidel.maps.embeddable;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import java.util.Map;

/**
 * Created by alexanderz on 12.03.16.
 */
@Entity
public class EmbeddableEmployee {
    @Id
    private long id;

    @ElementCollection
    @AttributeOverrides(value = {
            @AttributeOverride(name = "key.firstField", column = @Column(name="f_column")),
    })
    @CollectionTable(name="embeddable_table")
    @Column(name = "sds")
    @MapKeyColumn
    private Map<EmbeddableEmbeddable, Integer> EmbeddableEmployeeMap;
}
