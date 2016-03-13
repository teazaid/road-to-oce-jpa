package guru.zaidel.guru.zaidel.maps.basic;

import javax.persistence.Embeddable;

/**
 * Created by alexanderz on 12.03.16.
 */
@Embeddable
public class BasicEmbeddable {
    private String firstColumn;
    private String secondColumn;

    public String getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(String firstColumn) {
        this.firstColumn = firstColumn;
    }

    public String getSecondColumn() {
        return secondColumn;
    }

    public void setSecondColumn(String secondColumn) {
        this.secondColumn = secondColumn;
    }
}
