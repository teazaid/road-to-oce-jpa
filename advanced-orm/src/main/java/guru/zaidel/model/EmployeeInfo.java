package guru.zaidel.model;

import javax.persistence.Embeddable;

/**
 * Created by alexanderz on 21.02.16.
 */

@Embeddable
public class EmployeeInfo {
    public EmployeeInfo() {
    }

    private String content;
    private Long number;

    public EmployeeInfo(String content, Long number) {
        this.content = content;
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
