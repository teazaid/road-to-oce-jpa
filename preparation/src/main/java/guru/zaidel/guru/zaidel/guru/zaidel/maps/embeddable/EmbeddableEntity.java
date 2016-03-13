package guru.zaidel.guru.zaidel.guru.zaidel.maps.embeddable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by alexanderz on 12.03.16.
 */
@Entity
public class EmbeddableEntity {
    @Id
    private long id;

    private String name;
}
