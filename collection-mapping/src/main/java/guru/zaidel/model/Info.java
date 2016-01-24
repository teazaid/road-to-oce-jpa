package guru.zaidel.model;

import javax.persistence.Embeddable;

/**
 * Created by Alexander on 24.01.2016.
 */
@Embeddable
public class Info {
    private String infoStr;
    private int infoInt;

    public Info() {
    }

    public Info(String infoStr, int infoInt) {
        this.infoStr = infoStr;
        this.infoInt = infoInt;
    }

    public String getInfoStr() {
        return infoStr;
    }

    public void setInfoStr(String infoStr) {
        this.infoStr = infoStr;
    }

    public int getInfoInt() {
        return infoInt;
    }

    public void setInfoInt(int infoInt) {
        this.infoInt = infoInt;
    }
}
